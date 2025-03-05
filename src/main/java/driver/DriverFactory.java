package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static volatile WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptionsFactory().build();
            driver = new ChromeDriver(chromeOptions);
        }
        return driver;
    }

    public static void resetDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
