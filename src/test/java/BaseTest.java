import driver.DriverFactory;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;
import pages.InboxPage;
import pages.LoginPage;
import pages.WelcomePage;

import static utils.PropertyLoader.returnConfigValue;

public class BaseTest {
    @Getter
    private static WebDriver driver;

    // Page objects are lazily initialized
    private BasePage basePage;
    private WelcomePage welcomePage;
    private LoginPage loginPage;
    private InboxPage inboxPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get(returnConfigValue("url.base"));
    }

    public BasePage getBasePage() {
        if (basePage == null) {
            basePage = new BasePage(driver);
        }
        return basePage;
    }

    public WelcomePage getWelcomePage() {
        if (welcomePage == null) {
            welcomePage = new WelcomePage(driver);
        }
        return welcomePage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public InboxPage getInboxPage() {
        if (inboxPage == null) {
            inboxPage = new InboxPage(driver);
        }
        return inboxPage;
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.resetDriver();
    }
}
