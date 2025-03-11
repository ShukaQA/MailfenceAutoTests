package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

public class MailBarComponent extends BasePage {

    public MailBarComponent(WebDriver driver) {
        super(driver);
    }

    private final By newMailButtonPath = By.xpath("//div[@id='mailNewBtn']");

    public MailBarComponent clickNewMailButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement newMailButton = wait.until(ExpectedConditions.elementToBeClickable(newMailButtonPath));
        newMailButton.click();
        return this;
    }
}
