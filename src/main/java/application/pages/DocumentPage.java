package application.pages;

import application.components.TrashComponent;
import application.elements.ButtonElement;
import application.elements.TextElement;
import core.utils.FileActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DocumentPage extends BasePage {

    private ButtonElement mailImagesButton;
    private ButtonElement trashFolderButton;

    public DocumentPage(WebDriver driver) {
        super(driver);

        mailImagesButton = new ButtonElement(driver, By.xpath("//div[text()='Mail images']"), "Mail Images Button");
        trashFolderButton = new ButtonElement(driver, By.xpath("//div[text()='Trash']"), "Trash Folder Button");
    }

    private TextElement getSourceFileInDoc(String fileName, String fileFormat) {
        By sourceFileInDoc = By.xpath(String.format("//div[text()='%s']", fileName + "." + fileFormat));
        return new TextElement(driver, sourceFileInDoc, "fileName: " + sourceFileInDoc);
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

    public DocumentPage dragAndDropTheFile(String fileName, String fileFormat) {
        new FileActions().dragAndDropFileFromTo(
                driver.findElement(getSourceFileInDoc(fileName, fileFormat).getLocator()),
                driver.findElement(trashFolderButton.getLocator()),
                driver);
        return this;
    }

    public DocumentPage clickTrashFolderButton() {
        trashFolderButton.click();
        return this;
    }

    public DocumentPage checkNewFileExistenceByFileName(String fileName, String fileFormat) {
        String fileText = getSourceFileInDoc(fileName, fileFormat).getText();
        Assert.assertEquals(fileText, "»" + fileName + "." + fileFormat, "The file name does not match");
        return this;
    }
}
