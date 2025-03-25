package application.elements;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseElement {

    protected WebDriver driver;
    @Getter
    private By locator;
    @Getter
    private String name;

    public BaseElement(WebDriver driver, By locator, String name) {
        this.driver = driver;
        this.locator = locator;
        this.name = name;
    }

    public String getText() {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    @Override
    public String toString() {
        return String.format("Element[name='%s', locator='%s']", name, locator);
    }
}
