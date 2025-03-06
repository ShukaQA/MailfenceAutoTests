package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
    private final WebDriver driver;

    public WelcomePage() {
        this.driver = DriverFactory.getDriver();
    }

    private final By loginButtonPath = By.xpath("//button[@id='signin']");

    public void clickLoginButton() {
        driver.findElement(loginButtonPath).click();
    }

}