package application.components;

import application.elements.ButtonElement;
import application.elements.InputElement;
import application.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Paths;

public class SendMailComponent extends BasePage {

    private InputElement sendToAddressInput;
    private InputElement sendSubjectInput;
    private ButtonElement attachmentButton;
    private InputElement attachmentInput;

    public SendMailComponent(WebDriver driver) {
        super(driver);

        sendToAddressInput = new InputElement(driver, By.xpath("//div[@id='mailTo']/input"), "Send To Address Input");
        sendSubjectInput = new InputElement(driver, By.xpath("//input[@id='mailSubject']"), "Send Subject Input");
        attachmentButton = new ButtonElement(driver, By.xpath("//a[text()='Attachment']"), "Attachment Button");
        attachmentInput = new InputElement(driver, By.xpath("//form[@id='new_email_attach']/input"), "Attachment Input");
    }

    private By getUploadedFilePathByText(String text) {
        return By.xpath(String.format("//a[contains(text(), '%s')]", text));
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

    public void validateUploadedFileByFilesName(String... filenames) {
        try {
            for (String filename : filenames)
                Assert.assertTrue(driver.findElement(getUploadedFilePathByText(filename)).getText().contains(filename),
                        "Uploaded file name does not match. " +
                                "Expected to contain: " + filename);
        } catch (Exception e) {
            Assert.fail("Uploaded file is not found");
        }
    }

    public void hoverUploadedFile(String fileName) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(getUploadedFilePathByText(fileName))).perform();
    }
}
