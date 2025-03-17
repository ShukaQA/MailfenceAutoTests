package application.components;

import application.elements.ButtonElement;
import application.elements.TextElement;
import application.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TrashComponent extends BasePage {
    private ButtonElement selectAllButtonPath;
    private ButtonElement deleteButtonPath;
    private ButtonElement yesButtonPath;
    private TextElement noDocLeftTextPath;

    public TrashComponent(WebDriver driver) {
        super(driver);

        selectAllButtonPath = new ButtonElement(driver, By.xpath("//div[@title='Select all']"), "Select All Button");
        deleteButtonPath = new ButtonElement(driver, By.xpath("//div[@title='Delete']"), "Delete Button");
        yesButtonPath = new ButtonElement(driver, By.xpath("//div[@id='dialBtn_YES']"), "Popup Yes Button");
        noDocLeftTextPath = new TextElement(driver, By.xpath("//div[text()='There are no documents in this folder yet']"), "No Documents Left Text");
    }

    public TrashComponent clickSelectAllButton() {
        selectAllButtonPath.click();
        return this;
    }

    public TrashComponent clickDeleteButton() {
        deleteButtonPath.click();
        return this;
    }

    public TrashComponent clickYesButton() {
        yesButtonPath.click();
        return this;
    }

    public TrashComponent checkNoDocTextExistence(String text) {
        Assert.assertEquals(noDocLeftTextPath.getText(), text, "Could Not Delete Documents In Trash");
        return this;
    }

}
