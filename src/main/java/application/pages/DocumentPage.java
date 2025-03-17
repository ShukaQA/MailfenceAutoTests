package application.pages;

import application.components.TrashComponent;
import application.elements.ButtonElement;
import application.elements.TextElement;
import core.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DocumentPage extends BasePage {

    private ButtonElement mailImagesButton;
    private TextElement sourceFileInDoc;
    private ButtonElement trashFolderButton;

    public DocumentPage(WebDriver driver) {
        super(driver);

        mailImagesButton = new ButtonElement(driver, By.xpath("//div[text()='Mail images']"), "Mail Images Button");
        sourceFileInDoc = new TextElement(driver, By.xpath("//div[text()='ExampleForTest.pdf']"), "Source File In Document");
        trashFolderButton = new ButtonElement(driver, By.xpath("//div[text()='Trash']"), "Trash Folder Button");
    }

    public TrashComponent trashComponent() {
        return new TrashComponent(driver);
    }

    public DocumentPage clickMailImagesButton() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(mailImagesButton.getLocator())).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(mailImagesButton.getLocator())).click();
        }
        return this;
    }

    public DocumentPage dragAndDropTheFile() {
        new Utils().dragAndDropFileFromTo(
                driver.findElement(sourceFileInDoc.getLocator()),
                driver.findElement(trashFolderButton.getLocator()),
                driver);
        return this;
    }

    public DocumentPage clickTrashFolderButton() {
        trashFolderButton.click();
        return this;
    }

    public DocumentPage checkNewFileExistenceByFileName(String fileName) {
        String fileText = sourceFileInDoc.getText();
        Assert.assertEquals(fileText, fileName, "The file name does not match");
        return this;
    }
}
