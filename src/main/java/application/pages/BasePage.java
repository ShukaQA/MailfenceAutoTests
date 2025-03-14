package application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO change logic for many file uploads
    private final By uploadedFileTextPath = By.xpath("//a[@_type='att']");

    public BasePage validateUploadedFileByFileName(String fileName) {
        Assert.assertTrue(driver.findElement(uploadedFileTextPath).getText().contains(fileName),
                "Uploaded file name does not match. " +
                        "Expected to contain: " + fileName);
        return this;
    }

    public BasePage hoverUploadedFile() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(uploadedFileTextPath)).perform();
        return this;
    }
}
