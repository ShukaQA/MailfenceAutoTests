package application.elements;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonElement {

    private WebDriver driver;
    @Getter
    private By locator;
    @Getter
    private String name;

    public ButtonElement(WebDriver driver, By locator, String name) {
        this.driver = driver;
        this.locator = locator;
        this.name = name;
    }

    public void click() {
        WebElement button = driver.findElement(locator);
        button.click();
    }

    public void waitForAndClick(Duration waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public String getText() {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

}
