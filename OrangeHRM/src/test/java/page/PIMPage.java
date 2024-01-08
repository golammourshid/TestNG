package page;

import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.io.IOException;
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
    List<WebElement> passwordElem;
    @FindBy(className = "oxd-switch-input")
    WebElement loginDetailsSwitch;
    @FindBy(css = "[type=submit]")
    WebElement btnSave;

    public PIMPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createEmployee() throws InterruptedException, IOException, ParseException {
        Faker faker = new Faker();
        menuPIM.click();
        addBtnElem.click();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userName = faker.name().username() + Utils.generateRandomId(100, 999);
        String password = "antor1234";

//        First Name
        fName.sendKeys(firstName);
//        Last Name
        lName.sendKeys(lastName);
        Thread.sleep(3000);

        loginDetailsSwitch.click();

//        User Name
        userCred.get(2).sendKeys(userName);
//        Password
        passwordElem.get(0).sendKeys(password);
//        Confirm Password
        passwordElem.get(1).sendKeys(password);
        Thread.sleep(3000);
        btnSave.click();

        Utils.saveInfo(firstName, lastName, userName, password);
    }
}
