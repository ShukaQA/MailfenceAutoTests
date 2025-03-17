package application.components;

import application.elements.ButtonElement;
import application.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DocumentPopupComponent extends BasePage {

    private ButtonElement mailImagesButton;
    private ButtonElement saveButton;

    private final By saveButtonStatusPath = By.xpath("//div[@id='dialBtn_OK']");

    public DocumentPopupComponent(WebDriver driver) {
        super(driver);

        mailImagesButton = new ButtonElement(driver, By.xpath("//div[text()='Mail images']"), "Mail Images Button");
        saveButton = new ButtonElement(driver, By.xpath("//div[text()='Save']"), "Save Button");
    }

    public DocumentPopupComponent clickMailImagesButton() {
        mailImagesButton.click();
        return this;
    }

    private DocumentPopupComponent waitForSaveButtonToBeActive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(saveButtonStatusPath, "class", "btn GCSDBRWBO defaultBtn"));
        return this;
    }

    public DocumentPopupComponent clickSaveButton() {
        waitForSaveButtonToBeActive();
        saveButton.click();
        return this;
    }
}
