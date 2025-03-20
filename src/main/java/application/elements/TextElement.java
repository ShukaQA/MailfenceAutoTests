package application.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextElement extends BaseElement {

    public TextElement(WebDriver driver, By locator, String name) {
        super(driver, locator, name);
    }
}
