package pages;

import components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Utils;

public class InboxPage extends BasePage {

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public DocumentPopupComponent documentPopupComponent() {
        return new DocumentPopupComponent(driver);
    }

    public TaskBarComponent taskBarComponent() {
        return new TaskBarComponent(driver);
    }

    public OpenedEmailComponent openedEmailComponent() {
        return new OpenedEmailComponent(driver);
    }

    public MailBarComponent mailBarComponent() {
        return new MailBarComponent(driver);
    }

    public SendMailBarComponent sendMailBarComponent() {
        return new SendMailBarComponent(driver);
    }

    public SendMailComponent sendMailComponent() {
        return new SendMailComponent(driver);
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
