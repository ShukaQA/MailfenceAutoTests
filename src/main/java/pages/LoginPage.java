package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    private final By loginInputPath = By.xpath("//input[@id='UserID']");
    private final By passwordInputPath = By.xpath("//input[@id='Password']");
    private final By enterButtonPath = By.xpath("//input[@type='submit']");

    public void setLoginInput(String text) {
        driver.findElement(loginInputPath).sendKeys(text);
    }

    public void setPasswordInput(String text) {
        driver.findElement(passwordInputPath).sendKeys(text);
    }

    public void clickEnterButton() {
        driver.findElement(enterButtonPath).click();
    }

}
