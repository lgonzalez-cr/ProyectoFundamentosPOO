package Tests;

import Util.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        setDriver("chrome");
        driver.get("https://demo.opencart.com");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    private void setDriver(String browser) {
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.edgedriver().setup();
            driver = new FirefoxDriver();
        }
    }

    @AfterMethod
    public void takeScreenshot(ITestResult testResult) {
        TestUtils.takeScreenshot(testResult, driver);
    }
}
