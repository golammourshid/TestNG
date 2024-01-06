package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashBoardPage {
    @FindBy(className = "oxd-userdropdown-img")
    public WebElement imgProfile;
    @FindBy(className = "oxd-userdropdown-link")
    List<WebElement> logOutBtn;
    @FindBy(className = "oxd-userdropdown-icon")
    WebElement dropDownIcon;
     public DashBoardPage(WebDriver driver){
         PageFactory.initElements(driver,this);
     }

     public void doLogout(){
        dropDownIcon.click();
        logOutBtn.get(3).click();
     }
}
