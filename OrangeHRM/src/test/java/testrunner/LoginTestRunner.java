package testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.DashBoardPage;
import page.LoginPage;
import setup.SetUp;

public class LoginTestRunner extends SetUp {
    LoginPage loginPage;
    DashBoardPage dashBoard;

    @Test(priority = 1, description = "User should not login with wrong credentials")
    public void doLoginWithWrongCred() {
        loginPage = new LoginPage(driver);
        String errorMessage = loginPage.doLoginWithWrongCred("admin", "admin");
        Assert.assertTrue(errorMessage.contains("Invalid credentials"));
    }

    @Test(priority = 2, description = "User should login with valid credentials")
    public void doLogin() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
        dashBoard = new DashBoardPage(driver);

//        SoftAssert will execute aLL assertion even if one assertion  is failed.
//        Need to create an object to access its method.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(dashBoard.imgProfile.isDisplayed());

        Thread.sleep(4000);
        String urlActual = driver.getCurrentUrl();
        String urlExpected = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        softAssert.assertTrue(urlActual.contains(urlExpected));
        softAssert.assertAll();
    }

    @Test(priority = 3, description = "User should logout")
    public void doLogout() {
        dashBoard = new DashBoardPage(driver);
        dashBoard.doLogout();
        Assert.assertTrue(loginPage.btnLogin.isDisplayed());
    }
}
