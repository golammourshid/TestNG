package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
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

    public static void main(String[] args) {
        System.out.println(generateRandomId(10, 15));
    }
}
