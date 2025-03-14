package pages;

import components.TrashComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Utils;

public class DocumentPage extends BasePage {
    public DocumentPage(WebDriver driver) {
        super(driver);
    }

    public TrashComponent trashComponent() {
        return new TrashComponent(driver);
    }

    private final By mailImagesButtonPath = By.xpath("//div[text()='Mail images']");
    private final By sourceFileInDocPath = By.xpath("//div[text()='ExampleForTest.pdf']");
    private final By trashFolderButtonPath = By.xpath("//div[text()='Trash']");

    public DocumentPage clickMailImagesButton() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(mailImagesButtonPath)).click();
        } catch (Exception e) {
            wait.until(ExpectedConditions.elementToBeClickable(mailImagesButtonPath)).click();
        }
        return this;
    }

    public DocumentPage dragAndDropTheFile() {
        new Utils().dragAndDropFileFromTo(
                driver.findElement(sourceFileInDocPath),
                driver.findElement(trashFolderButtonPath),
                driver);
        return this;
    }

    public DocumentPage clickTrashFolderButton() {
        driver.findElement(trashFolderButtonPath).click();
        return this;
    }

    public DocumentPage checkNewFileExistenceByFileName(String fileName) {
        Assert.assertEquals(driver.findElement(sourceFileInDocPath).getText(), fileName);
        return this;
    }
}
