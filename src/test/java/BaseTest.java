import driver.DriverFactory;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.SendMailPage;
import pages.WelcomePage;
import pages.functionBar.MailBarPage;
import pages.functionBar.SendMailBarPage;

import static utils.PropertyLoader.returnConfigValue;

public class BaseTest {
    @Getter
    private static WebDriver driver;

    public WelcomePage welcomePage;
    public LoginPage loginPage;
    public MailBarPage mailBarPage;
    public SendMailPage sendMailPage;
    public SendMailBarPage sendMailBarPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get(returnConfigValue("url.base"));
        initPages(driver);
    }

    private void initPages(WebDriver driver) {
        welcomePage = new WelcomePage(driver);
        loginPage = new LoginPage(driver);
        mailBarPage = new MailBarPage(driver);
        sendMailPage = new SendMailPage(driver);
        sendMailBarPage = new SendMailBarPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.resetDriver();
    }

}