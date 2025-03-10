package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocumentPopupPage extends BasePage {
    public DocumentPopupPage(WebDriver driver) {
        super(driver);
    }

    private final By mailImagesButtonPath = By.xpath("//div[text()='Mail images']");
    private final By saveButtonPath = By.xpath("//div[text()='Save']");
    private final By saveButtonStatusPath = By.xpath("//div[@id='dialBtn_OK']");

    public DocumentPopupPage clickMailImagesButton() {
        driver.findElement(mailImagesButtonPath).click();
        return this;
    }

    private DocumentPopupPage loadSaveButtonBlueColor() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(saveButtonStatusPath, "class", "btn GCSDBRWBO defaultBtn"));
        return this;
    }

    public DocumentPopupPage clickSaveButton() throws InterruptedException {
        loadSaveButtonBlueColor();
        driver.findElement(saveButtonPath).click();
        return this;
    }
}
