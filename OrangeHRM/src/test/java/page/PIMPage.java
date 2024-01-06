package page;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;
import java.util.List;

public class PIMPage {
    @FindBy(css = "a[href = '/web/index.php/pim/viewPimModule']")
    WebElement menuPIM;
    @FindBy(css = "i[class='oxd-icon bi-plus oxd-button-icon']")
    WebElement addBtnElem;
    //    @FindBy(className = "oxd-input--active")
//    List<WebElement> inputField;
    @FindBy(name = "firstName")
    WebElement fName;
    @FindBy(name = "middleName")
    WebElement mName;
    @FindBy(name = "lastName")
    WebElement lName;
    @FindBy(xpath = "//input[@class = 'oxd-input oxd-input--active']")
    List<WebElement> userCred;
    @FindBy(css = "[type=password]")
    List<WebElement> password;
    @FindBy(className = "oxd-switch-input")
    WebElement loginDetailsSwitch;
    @FindBy(css = "[type=submit]")
    WebElement btnSave;

    public PIMPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createEmployee() throws InterruptedException {
        Faker faker = new Faker();
        menuPIM.click();
        addBtnElem.click();

//        First Name
        fName.sendKeys(faker.name().firstName());
//        Last Name
        lName.sendKeys(faker.name().lastName());
        Thread.sleep(3000);

        loginDetailsSwitch.click();

//        User Name
        userCred.get(2).sendKeys(faker.name().username() + Utils.generateRandomId(100, 999));
//        Password
        password.get(0).sendKeys("antor1234");
//        Confirm Password
        password.get(1).sendKeys("antor1234");
        Thread.sleep(3000);
        btnSave.click();

    }
}
