package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Paths;

public class SendMailPage extends BasePage {

    public SendMailPage(WebDriver driver) {
        super(driver);
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
        String absoluteFilePath = Paths.get(filePath).toAbsolutePath().toString();
        File file = new File(absoluteFilePath);
        if (file.exists() && file.isFile()) {
            driver.findElement(attachmentInputPath).sendKeys(absoluteFilePath);
        } else {
            throw new RuntimeException("File not found: " + absoluteFilePath);
        }
        return this;
    }

}
