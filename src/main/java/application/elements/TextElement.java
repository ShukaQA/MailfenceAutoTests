package application.elements;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextElement {

    private WebDriver driver;
    @Getter
    private By locator;
    @Getter
    private String name;

    public TextElement(WebDriver driver, By locator, String name) {
        this.driver = driver;
        this.locator = locator;
        this.name = name;
    }

    public String getText() {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

}
