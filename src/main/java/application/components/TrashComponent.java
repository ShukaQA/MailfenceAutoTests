package application.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import application.pages.BasePage;

public class TrashComponent extends BasePage {
    public TrashComponent(WebDriver driver) {
        super(driver);
    }

    private final By selectAllButtonPath = By.xpath("//div[@title='Select all']");
    private final By deleteButtonPath = By.xpath("//div[@title='Delete']");
    private final By yesButtonPath = By.xpath("//div[@id='dialBtn_YES']");
    private final By noDocLeftTextPath = By.xpath("//div[text()='There are no documents in this folder yet']");

    public TrashComponent clickSelectAllButton() {
        driver.findElement(selectAllButtonPath).click();
        return this;
    }

    public TrashComponent clickDeleteButton() {
        driver.findElement(deleteButtonPath).click();
        return this;
    }

    public TrashComponent clickYesButton() {
        driver.findElement(yesButtonPath).click();
        return this;
    }

    public TrashComponent checkNoDocTextExistence(String text) {
        Assert.assertEquals(driver.findElement(noDocLeftTextPath).getText(), text, "Could Not Delete Documents In Trash");
        return this;
    }

}
