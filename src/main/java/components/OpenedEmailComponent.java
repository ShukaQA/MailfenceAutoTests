package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class OpenedEmailComponent extends BasePage {
    public OpenedEmailComponent(WebDriver driver) {
        super(driver);
    }

    private final By saveInDocumentsButtonPath = By.xpath("//span[text()='Save in Documents']//..");
    private final By arrowDownButtonPath = By.xpath("//b[@class='icon-Arrow-down']");

    public OpenedEmailComponent clickOnSaveInDocsButton() {
        driver.findElement(saveInDocumentsButtonPath).click();
        return this;
    }

    public OpenedEmailComponent clickArrowDownButton() {
        driver.findElement(arrowDownButtonPath).click();
        return this;
    }
}
