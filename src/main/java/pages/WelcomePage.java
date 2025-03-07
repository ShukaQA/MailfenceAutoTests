package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
    private final WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginButtonPath = By.xpath("//button[@id='signin']");

    //TODO show this example of dynamic xpath
    private By getInputPathByText(String text) {
        return By.xpath(String.format("//input[text()='%s']", text));
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonPath).click();
    }

}