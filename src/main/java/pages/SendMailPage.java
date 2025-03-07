package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMailPage {
    private final WebDriver driver;

    public SendMailPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By sendToAddressInputPath = By.xpath("//div[@id='mailTo']/input");
    private final By sendSubjectInputPath = By.xpath("//input[@id='mailSubject']");
    private final By attachmentButtonPath = By.xpath("//a[text()='Attachment']");
    private final By attachmentInputPath = By.xpath("//form[@id='new_email_attach']/input");

    public SendMailPage setSendToAddressInput(String text) {
        driver.findElement(sendToAddressInputPath).sendKeys(text);
        return this;
    }

    public SendMailPage setSubjectInput(String text) {
        driver.findElement(sendSubjectInputPath).sendKeys(text);
        return this;
    }

    public SendMailPage clickAttachmentButton() {
        driver.findElement(attachmentButtonPath).click();
        return this;
    }

    public SendMailPage setAttachmentFile(String filePath) {
        driver.findElement(attachmentInputPath).sendKeys(filePath);
        return this;
    }

}
