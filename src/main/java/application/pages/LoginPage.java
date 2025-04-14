package application.pages;

import application.elements.ButtonElement;
import application.elements.InputElement;
import org.openqa.selenium.By;

public class LoginPage {
    private InputElement loginInput;
    private InputElement passwordInput;
    private ButtonElement enterButton;

    public LoginPage() {

        loginInput = new InputElement(By.xpath("//input[@id='UserID']"), "Login Input");
        passwordInput = new InputElement(By.xpath("//input[@id='Password']"), "Password Input");
        enterButton = new ButtonElement(By.xpath("//input[@type='submit']"), "Enter Button");
    }

    public LoginPage setLoginInput(String text) {
        loginInput.setText(text);
        return this;
    }

    public LoginPage setPasswordInput(String text) {
        passwordInput.setText(text);
        return this;
    }

    public void clickEnterButton() {
        enterButton.click();
    }
}
