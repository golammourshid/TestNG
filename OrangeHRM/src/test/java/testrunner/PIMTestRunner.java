package testrunner;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.LoginPage;
import page.PIMPage;
import setup.SetUp;

import java.io.IOException;
import java.time.Duration;

public class PIMTestRunner extends SetUp {
    PIMPage pimPage;

    LoginPage loginPage;

    @BeforeTest(groups = "smoke")
    public void doLogin() {
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
    }

    @Test(priority = 1, description = "Apply for leave", groups = "smoke")
    public void getLeave() throws InterruptedException {
        driver.findElements(By.className("oxd-main-menu-item--name")).get(2).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[type='reset']")));
        String txtActual = driver.findElement(By.cssSelector("[type='reset']")).getText();
        System.out.println(txtActual);
        String txtExpected = "Reset";
        Assert.assertTrue(txtActual.contains(txtExpected));
    }

    @Test(priority = 2, description = "Create Employee")
    public void createEmployee() throws InterruptedException, IOException, ParseException {
        pimPage = new PIMPage(driver);
        pimPage.createEmployee();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class = 'oxd-text oxd-text--h6 --strong']")));
        String titleActual = driver.findElements(By.xpath("//h6[@class = 'oxd-text oxd-text--h6 orangehrm-main-title']")).get(0).getText();
        String titleExpected = "Personal Details";
        Assert.assertEquals(titleExpected, titleActual);
    }
}
