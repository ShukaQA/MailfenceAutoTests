package application.components;

import application.elements.ButtonElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenedEmailComponent {

    private ButtonElement saveInDocumentsButton;
    private ButtonElement arrowDownButton;

    public OpenedEmailComponent(WebDriver driver) {
        saveInDocumentsButton = new ButtonElement(driver, By.xpath("//span[text()='Save in Documents']//.."), "Save in Documents Button");
        arrowDownButton = new ButtonElement(driver, By.xpath("//b[@class='icon-Arrow-down']"), "Arrow Down Button");
    }

    public OpenedEmailComponent clickOnSaveInDocsButton() {
        saveInDocumentsButton.click();
        return this;
    }

    public OpenedEmailComponent clickArrowDownButton() {
        arrowDownButton.click();
        return this;
    }
}
