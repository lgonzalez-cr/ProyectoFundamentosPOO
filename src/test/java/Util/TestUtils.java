package Util;

import Util.Commons;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestUtils {
    public static void takeScreenshot(ITestResult testResult, WebDriver driver) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File("src/test/resources/screenshots/" + testResult.getName() + " - Failure - " + Commons.now() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
