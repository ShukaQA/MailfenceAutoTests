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

    // Page objects are now lazily initialized
    private BasePage basePage;
    private WelcomePage welcomePage;
    private LoginPage loginPage;
    private MailBarPage mailBarPage;
    private SendMailPage sendMailPage;
    private SendMailBarPage sendMailBarPage;
    private InboxPage inboxPage;
    private OpenedEmailPage openedEmailPage;
    private DocumentPopupPage documentPopupPage;

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

    public MailBarPage getMailBarPage() {
        if (mailBarPage == null) {
            mailBarPage = new MailBarPage(driver);
        }
        return mailBarPage;
    }

    public SendMailPage getSendMailPage() {
        if (sendMailPage == null) {
            sendMailPage = new SendMailPage(driver);
        }
        return sendMailPage;
    }

    public SendMailBarPage getSendMailBarPage() {
        if (sendMailBarPage == null) {
            sendMailBarPage = new SendMailBarPage(driver);
        }
        return sendMailBarPage;
    }

    public InboxPage getInboxPage() {
        if (inboxPage == null) {
            inboxPage = new InboxPage(driver);
        }
        return inboxPage;
    }

    public OpenedEmailPage getOpenedEmailPage() {
        if (openedEmailPage == null) {
            openedEmailPage = new OpenedEmailPage(driver);
        }
        return openedEmailPage;
    }

    public DocumentPopupPage getDocumentPopupPage() {
        if (documentPopupPage == null) {
            documentPopupPage = new DocumentPopupPage(driver);
        }
        return documentPopupPage;
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.resetDriver();
    }
}
