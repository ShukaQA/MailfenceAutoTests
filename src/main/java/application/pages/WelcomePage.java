package application.pages;

import application.elements.ButtonElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {

    private ButtonElement loginButton;

    public WelcomePage(WebDriver driver) {
        super(driver);

        loginButton = new ButtonElement(driver, By.xpath("//button[@id='signin']"), "Login Button");
    }

    public WelcomePage clickLoginButton() {
        loginButton.click();
        return this;
    }
}
