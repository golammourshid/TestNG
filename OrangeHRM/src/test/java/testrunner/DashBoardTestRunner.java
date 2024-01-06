package testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.DashBoardPage;
import page.LoginPage;
import setup.SetUp;

public class DashBoardTestRunner extends SetUp {
    DashBoardPage dashBoard;
    LoginPage loginPage;
    @Test
    public void doLogout(){
        dashBoard = new DashBoardPage(driver);
        dashBoard.doLogout();
        Assert.assertTrue(loginPage.btnLogin.isDisplayed());
    }
}
