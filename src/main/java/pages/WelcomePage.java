package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    private final By loginButtonPath = By.xpath("//button[@id='signin']");

    public void clickLoginButton() {
        driver.findElement(loginButtonPath).click();
    }

}