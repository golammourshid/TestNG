package testrunner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import page.LoginPage;
import setup.SetUp;
import utils.Utils;

import java.io.IOException;

public class UserTestRunner extends SetUp {
    @Test
    public void doLogin() throws ParseException, IOException {
        LoginPage loginPage = new LoginPage(driver);
        JSONArray empArray = Utils.readJSONArray("./src/test/resources/employees.json");
        JSONObject empObj = (JSONObject) empArray.get(empArray.size()-1);
        String userName = empObj.get("userName").toString();
        String password = empObj.get("password").toString();
        loginPage.doLogin(userName, password);
    }
}
