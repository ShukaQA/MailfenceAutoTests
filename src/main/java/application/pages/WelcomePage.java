package application.pages;

import application.elements.ButtonElement;
import org.openqa.selenium.By;

public class WelcomePage {
    private ButtonElement loginButton;

    public WelcomePage() {
        loginButton = new ButtonElement(By.xpath("//button[@id='signin']"), "Login Button");
    }

    public WelcomePage clickLoginButton() {
        loginButton.click();
        return this;
    }
}
