package tests;

import Util.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import Util.ConfigReader;
import Util.Log4j;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    static Properties properties;
    protected WebDriver driver;

    @BeforeSuite
    public void setup() throws Exception {
        if (Utils.getConnectionListForRemove().size() > 0) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("–disable-notifications");
            chromeOptions.addArguments("--incognito");
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("--allow-insecure-localhost");
            chromeOptions.addArguments("--acceptInsecureCerts");
            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
            properties = ConfigReader.initialize_Properties();
            driver.get("https://www.linkedin.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15));
            Log4j.startLog("Test  is Starting");
        } else {
            Log4j.info("No links were found that met the specified requirements. The tests are ending.");
            throw new Exception();
        }
    }

    @AfterSuite
    public void tearDown() {
        Log4j.endLog("Test is finishing");
        driver.quit();
    }
}
