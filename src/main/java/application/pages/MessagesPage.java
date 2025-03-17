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

    public MessagesPage clickOnEmailFromInboxByTitle(String emailTitle) {
        getReceivedEmailButton(emailTitle).click();
        return this;
    }
}
