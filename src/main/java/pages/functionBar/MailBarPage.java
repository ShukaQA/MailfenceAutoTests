package pages.functionBar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailBarPage {
    private final WebDriver driver;

    public MailBarPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By newMailButtonPath = By.xpath("//div[@id='mailNewBtn']");

    public MailBarPage clickNewMailButton() {
        driver.findElement(newMailButtonPath).click();
        return this;
    }

}
