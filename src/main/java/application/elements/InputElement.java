package application.elements;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputElement {

    private WebDriver driver;
    @Getter
    private By locator;
    @Getter
    private String name;

    public InputElement(WebDriver driver, By locator, String name) {
        this.driver = driver;
        this.locator = locator;
        this.name = name;
    }

    public void setText(String text) {
        WebElement input = driver.findElement(locator);
        input.sendKeys(text);
    }

    public void clearText() {
        WebElement input = driver.findElement(locator);
        input.clear();
    }

}
