package application.pages;

import application.components.*;
import application.elements.ButtonElement;
import core.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MessagesPage extends BasePage {

    public MessagesPage(WebDriver driver) {
        super(driver);
    }

    public DocumentPopupComponent getDocumentPopupComponent() {
        return new DocumentPopupComponent(driver);
    }

    public TaskBarComponent getTaskBarComponent() {
        return new TaskBarComponent(driver);
    }

    public OpenedEmailComponent getOpenedEmailComponent() {
        return new OpenedEmailComponent(driver);
    }

    public MailBarComponent getMailBarComponent() {
        return new MailBarComponent(driver);
    }

    public SendMailBarComponent getSendMailBarComponent() {
        return new SendMailBarComponent(driver);
    }

    public SendMailComponent getSendMailComponent() {
        return new SendMailComponent(driver);
    }

    private ButtonElement getReceivedEmailButton(String emailTitle) {
        By emailLocator = By.xpath(String.format("//div[@title='%s']", emailTitle));
        return new ButtonElement(driver, emailLocator, "Email: " + emailTitle);
    }

    private String getNameOfNewMailFromInbox(String emailTitle) {
        return getReceivedEmailButton(emailTitle).getText();
    }

    public MessagesPage validateNewEmailFromInboxByTitle(String emailTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            ButtonElement emailButton = getReceivedEmailButton(emailTitle);
            WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailButton.getLocator()));
            Assert.assertEquals(new Utils().getTextFromString(emailElement.getText()), emailTitle);
        } catch (Exception e) {
            // Retry on failure
            driver.navigate().refresh();
            ButtonElement emailButton = getReceivedEmailButton(emailTitle);
            WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailButton.getLocator()));
            Assert.assertEquals(new Utils().getTextFromString(emailElement.getText()), emailTitle);
        }
        return this;
    }

    public void clickOnEmailFromInboxByTitle(String emailTitle) {
        getReceivedEmailButton(emailTitle).click();
    }
}
