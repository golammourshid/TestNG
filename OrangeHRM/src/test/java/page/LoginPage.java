package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//    Declaring class properties
    @FindBy(name = "username")
    WebElement txtUsername;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(css = "button")
    public WebElement btnLogin;

    @FindBy(xpath = "//p[contains(@class, \'oxd-text oxd-text--p oxd-alert-content-text\')]")
    WebElement lblErrorMessage;

//    Creating constructor
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public String doLoginWithWrongCred(String userName, String password) {
        txtUsername.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLogin.click();
        return lblErrorMessage.getText();
    }

    public void doLogin(String userName, String password) {
        txtUsername.sendKeys(userName);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }
}
