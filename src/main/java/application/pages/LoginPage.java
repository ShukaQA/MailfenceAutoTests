package application.pages;

import application.elements.ButtonElement;
import application.elements.InputElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private InputElement loginInput;
    private InputElement passwordInput;
    private ButtonElement enterButton;

    public LoginPage(WebDriver driver) {
        super(driver);

        loginInput = new InputElement(driver, By.xpath("//input[@id='UserID']"), "Login Input");
        passwordInput = new InputElement(driver, By.xpath("//input[@id='Password']"), "Password Input");
        enterButton = new ButtonElement(driver, By.xpath("//input[@type='submit']"), "Enter Button");
    }

    public LoginPage setLoginInput(String text) {
        loginInput.setText(text);
        return this;
    }

    public LoginPage setPasswordInput(String text) {
        passwordInput.setText(text);
        return this;
    }

    public LoginPage clickEnterButton() {
        enterButton.click();
        return this;
    }
}
