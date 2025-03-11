package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.components.*;
import utils.Utils;

public class InboxPage extends BasePage {

    private DocumentPopupComponent documentPopupComponent;
    private OpenedEmailComponent openedEmailComponent;
    private MailBarComponent mailBarComponent;
    private SendMailBarComponent sendMailBarComponent;
    private SendMailComponent sendMailComponent;

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public DocumentPopupComponent documentPopupComponent() {
        if (documentPopupComponent == null) {
            documentPopupComponent = new DocumentPopupComponent(driver);
        }
        return documentPopupComponent;
    }

    public OpenedEmailComponent openedEmailComponent() {
        if (openedEmailComponent == null) {
            openedEmailComponent = new OpenedEmailComponent(driver);
        }
        return openedEmailComponent;
    }

    public MailBarComponent mailBarComponent() {
        if (mailBarComponent == null) {
            mailBarComponent = new MailBarComponent(driver);
        }
        return mailBarComponent;
    }

    public SendMailBarComponent sendMailBarComponent() {
        if (sendMailBarComponent == null) {
            sendMailBarComponent = new SendMailBarComponent(driver);
        }
        return sendMailBarComponent;
    }

    public SendMailComponent sendMailComponent() {
        if (sendMailComponent == null) {
            sendMailComponent = new SendMailComponent(driver);
        }
        return sendMailComponent;
    }

    private By getReceivedEmailPathByText(String text) {
        return By.xpath(String.format("//div[@title='%s']", text));
    }

    private String getNameOfNewMailFromInbox(String text) {
        return driver.findElement(getReceivedEmailPathByText(text)).getText();
    }

    public InboxPage validateNewEmailFromInboxByTitle(String emailTitle) {
        driver.navigate().refresh();
        try {
            Assert.assertEquals(new Utils().getTextFromString(getNameOfNewMailFromInbox(emailTitle)), emailTitle);
        } catch (Exception e) {
            driver.navigate().refresh();
            Assert.assertEquals(new Utils().getTextFromString(getNameOfNewMailFromInbox(emailTitle)), emailTitle);
        }
        return this;
    }

    public InboxPage clickOnEmailFromInboxByTitle(String emailTitle) {
        driver.findElement(getReceivedEmailPathByText(emailTitle)).click();
        return this;
    }
}
