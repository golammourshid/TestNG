package utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static void takeScreenShot(WebDriver driver) throws IOException {
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./src/test/resources/screenshots/" + time + ".png";
        File destFile = new File(fileWithPath);
        FileUtils.copyFile(screenShotFile, destFile);
    }

    public static int generateRandomId(int min, int max) {
        int rand = (int) (Math.random() * (max - min) + min);
        return rand;
    }

    public static void saveInfo(String firstName, String lastName, String userName,String password ) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        String filePath = "./src/test/resources/employees.json";
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filePath));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", firstName);
        jsonObject.put("lastName", lastName);
        jsonObject.put("userName", userName);
        jsonObject.put("password", password);

        jsonArray.add(jsonObject);

        System.out.println(jsonArray);

        FileWriter writer = new FileWriter(filePath);
        writer.write(jsonArray.toJSONString());
        writer.flush();
        writer.close();
    }

//    public static void main(String[] args) throws IOException, ParseException {
//        saveInfo();
//    }
}
