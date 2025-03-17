package application.components;

import application.elements.ButtonElement;
import application.elements.InputElement;
import application.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Paths;

public class SendMailComponent extends BasePage {

    private InputElement sendToAddressInput;
    private InputElement sendSubjectInput;
    private ButtonElement attachmentButton;
    private InputElement attachmentInput;

    public SendMailComponent(WebDriver driver) {
        super(driver);

        // Initialize elements with their locators and names
        sendToAddressInput = new InputElement(driver, By.xpath("//div[@id='mailTo']/input"), "Send To Address Input");
        sendSubjectInput = new InputElement(driver, By.xpath("//input[@id='mailSubject']"), "Send Subject Input");
        attachmentButton = new ButtonElement(driver, By.xpath("//a[text()='Attachment']"), "Attachment Button");
        attachmentInput = new InputElement(driver, By.xpath("//form[@id='new_email_attach']/input"), "Attachment Input");
    }

    public SendMailComponent setSendToAddressInput(String text) {
        sendToAddressInput.setText(text);
        return this;
    }

    public SendMailComponent setSubjectInput(String text) {
        sendSubjectInput.setText(text);
        return this;
    }

    public SendMailComponent clickAttachmentButton() {
        attachmentButton.click();
        return this;
    }

    public SendMailComponent setAttachmentFile(String filePath) {
        String absoluteFilePath = Paths.get(filePath).toAbsolutePath().toString();
        File file = new File(absoluteFilePath);
        if (file.exists() && file.isFile()) {
            attachmentInput.setText(absoluteFilePath);
        } else {
            throw new RuntimeException("File not found: " + absoluteFilePath);
        }
        return this;
    }
}
