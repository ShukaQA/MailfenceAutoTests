package application.pages;

import application.components.*;
import application.elements.ButtonElement;
import core.driver.DriverWrapper;
import core.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MessagesPage {

    private WebDriver driver;

    public MessagesPage() {
        driver = DriverWrapper.getDriver();
    }

    public DocumentPopupComponent getDocumentPopupComponent() {
        return new DocumentPopupComponent();
    }

    public TaskBarComponent getTaskBarComponent() {
        return new TaskBarComponent();
    }

    public OpenedEmailComponent getOpenedEmailComponent() {
        return new OpenedEmailComponent();
    }

    public MailBarComponent getMailBarComponent() {
        return new MailBarComponent();
    }

    public SendMailBarComponent getSendMailBarComponent() {
        return new SendMailBarComponent();
    }

    public SendMailComponent getSendMailComponent() {
        return new SendMailComponent();
    }

    private ButtonElement getReceivedEmailButton(String emailTitle) {
        By emailLocator = By.xpath(String.format("//div[@title='%s']", emailTitle));
        return new ButtonElement(emailLocator, "Email: " + emailTitle);
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
