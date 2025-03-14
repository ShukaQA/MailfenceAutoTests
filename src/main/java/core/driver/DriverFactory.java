package core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(new ChromeOptionsFactory().build());
            //Set global wait for 10 sec
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
