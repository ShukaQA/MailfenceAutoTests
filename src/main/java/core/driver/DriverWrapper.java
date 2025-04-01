package core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverWrapper {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions optionsChrome = new ChromeOptions();
            optionsChrome.addArguments("start-maximized");
            optionsChrome.addArguments("--ignore-certificate-errors");
            optionsChrome.addArguments("lang=en-US");
            driver = new ChromeDriver(optionsChrome);
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void resetDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
