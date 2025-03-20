package application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

//TODO use abstract class
public class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private By getUploadedFilePathByText(String text) {
        return By.xpath(String.format("//a[contains(text(), '%s')]", text));
    }

    public BasePage validateUploadedFileByFileName(String fileName) {
        Assert.assertTrue(driver.findElement(getUploadedFilePathByText(fileName)).getText().contains(fileName),
                "Uploaded file name does not match. " +
                        "Expected to contain: " + fileName);
        return this;
    }

    public BasePage hoverUploadedFile(String fileName) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(getUploadedFilePathByText(fileName))).perform();
        return this;
    }
}
