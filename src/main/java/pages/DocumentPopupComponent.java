package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocumentPopupComponent extends BasePage {
    public DocumentPopupComponent(WebDriver driver) {
        super(driver);
    }

    private final By mailImagesButtonPath = By.xpath("//div[text()='Mail images']");
    private final By saveButtonPath = By.xpath("//div[text()='Save']");
    private final By saveButtonStatusPath = By.xpath("//div[@id='dialBtn_OK']");

    public DocumentPopupComponent clickMailImagesButton() {
        driver.findElement(mailImagesButtonPath).click();
        return this;
    }

    private DocumentPopupComponent loadSaveButtonBlueColor() {
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(saveButtonStatusPath, "class", "btn GCSDBRWBO defaultBtn"));
        return this;
    }

    public DocumentPopupComponent clickSaveButton() {
        loadSaveButtonBlueColor();
        driver.findElement(saveButtonPath).click();
        return this;
    }
}
