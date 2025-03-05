package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Duration EXPLICIT_WAIT = Duration.ofSeconds(10);

    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(this.driver, EXPLICIT_WAIT);
    }

    private final By registerButtonPath = By.xpath("//a[@class='btn btn-orange animate-btn']");

    public void clickRegisterButton() {
        WebElement registerButton = driver.findElement(registerButtonPath);
        try {
            wait.until(ExpectedConditions.textToBe(registerButtonPath, "Create my account"));
            wait.until(ExpectedConditions.elementToBeClickable(registerButtonPath));
            registerButton.click();
        } catch (Exception e) {
            if (!registerButton.getText().equals("Register Now")) {
                wait.until(ExpectedConditions.textToBe(registerButtonPath, "Open trading account"));
            }
            wait.until(ExpectedConditions.elementToBeClickable(registerButtonPath));
            registerButton.click();
        }
    }

}