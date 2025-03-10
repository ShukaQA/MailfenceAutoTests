package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenedEmailPage extends BasePage {
    public OpenedEmailPage(WebDriver driver) {
        super(driver);
    }

    private final By saveInDocumentsButtonPath = By.xpath("//span[text()='Save in Documents']//..");
    private final By arrowDownButtonPath = By.xpath("//b[@class='icon-Arrow-down']");

    public OpenedEmailPage clickOnSaveInDocsButton() {
        driver.findElement(saveInDocumentsButtonPath).click();
        return this;
    }

    public OpenedEmailPage clickArrowDownButton() {
        driver.findElement(arrowDownButtonPath).click();
        return this;
    }
}
