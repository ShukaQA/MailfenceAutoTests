import driver.DriverFactory;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import static utils.PropertyLoader.returnConfigValue;

public class BaseTest {
    @Getter
    private static WebDriver driver;

    public WelcomePage welcomePage;
    public LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get(returnConfigValue("url.base"));
        initPages();
    }

    private void initPages() {
        welcomePage = new WelcomePage();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}