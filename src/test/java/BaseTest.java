import core.driver.DriverWrapper;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static core.utils.PropertyLoader.returnConfigValue;

public class BaseTest {
    @Getter
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverWrapper.getDriver();
        driver.get(returnConfigValue("url.base", "config.properties"));
    }

    @AfterMethod
    public void tearDown() {
        DriverWrapper.resetDriver();
    }
}
