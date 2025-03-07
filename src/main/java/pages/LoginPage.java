package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginInputPath = By.xpath("//input[@id='UserID']");
    private final By passwordInputPath = By.xpath("//input[@id='Password']");
    private final By enterButtonPath = By.xpath("//input[@type='submit']");

    public LoginPage setLoginInput(String text) {
        driver.findElement(loginInputPath).sendKeys(text);
        return this;
    }

    public LoginPage setPasswordInput(String text) {
        driver.findElement(passwordInputPath).sendKeys(text);
        return this;
    }

    public LoginPage clickEnterButton() {
        driver.findElement(enterButtonPath).click();
        return this;
    }

}
