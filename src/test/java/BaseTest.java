import driver.DriverFactory;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import pages.functionBar.MailBarPage;
import pages.functionBar.SendMailBarPage;

import static utils.PropertyLoader.returnConfigValue;

public class BaseTest {
    @Getter
    private static WebDriver driver;

    public BasePage basePage;
    public WelcomePage welcomePage;
    public LoginPage loginPage;
    public MailBarPage mailBarPage;
    public SendMailPage sendMailPage;
    public SendMailBarPage sendMailBarPage;
    public InboxPage inboxPage;
    public OpenedEmailPage openedEmailPage;
    public DocumentPopupPage documentPopupPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get(returnConfigValue("url.base"));
        initPages(driver);
    }

    private void initPages(WebDriver driver) {
        basePage = new BasePage(driver);
        welcomePage = new WelcomePage(driver);
        loginPage = new LoginPage(driver);
        mailBarPage = new MailBarPage(driver);
        sendMailPage = new SendMailPage(driver);
        sendMailBarPage = new SendMailBarPage(driver);
        inboxPage = new InboxPage(driver);
        openedEmailPage = new OpenedEmailPage(driver);
        documentPopupPage = new DocumentPopupPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.resetDriver();
    }

}