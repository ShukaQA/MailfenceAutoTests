package core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverManager {

    private static volatile DriverManager instance;
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    private DriverManager() {}

    private static DriverManager getInstance(String browser) {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null) {
                    instance = new DriverManager();
                }
            }
        }
        if (tlDriver.get() == null) {
            instance.initDriver(browser);
        }
        return instance;
    }

    private void initDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("lang=en-US");
                tlDriver.set(new ChromeDriver(chromeOptions));
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--width=1920");
                firefoxOptions.addArguments("--height=1080");
                tlDriver.set(new FirefoxDriver(firefoxOptions));
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                tlDriver.set(new EdgeDriver(edgeOptions));
            }
            default -> throw new IllegalArgumentException("Invalid browser type: " + browser);
        }
        tlDriver.get().manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        getInstance("chrome");
        return tlDriver.get();
    }

    public static void quitBrowser() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
