package application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonElement extends BaseElement {

    public ButtonElement(WebDriver driver, By locator, String name) {
        super(driver, locator, name);
    }

    public void click() {
        WebElement button = driver.findElement(getLocator());
        button.click();
    }

    public void waitForAndClick(Duration waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(getLocator()));
        element.click();
    }
}
