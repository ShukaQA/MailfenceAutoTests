package application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InputElement extends BaseElement {

    public InputElement(By locator, String name) {
        super(locator, name);
    }

    public void setText(String text) {
        WebElement input = driver.findElement(getLocator());
        input.sendKeys(text);
    }

    public void clearText() {
        WebElement input = driver.findElement(getLocator());
        input.clear();
    }
}
