package application.elements;

import core.driver.DriverWrapper;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;

public class BaseElement {

    protected WebDriver driver;
    @Getter
    private By locator;
    @Getter
    private String name;

    public BaseElement(By locator, String name) {
        this.driver = DriverWrapper.getDriver();
        this.locator = locator;
        this.name = name;
    }

    public BaseElement(WebDriver driver) {
        this.driver = driver;
    }

    public String getText() {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public void dragAndDropFileFromTo(WebElement sourceFileInDocPath, WebElement targetFileInDocPath, WebDriver driver) {
        try {
            Robot robot = new Robot();
            Actions actions = new Actions(driver);
            actions.dragAndDrop(sourceFileInDocPath, targetFileInDocPath).build().perform();

            org.openqa.selenium.Point sourceLocation = sourceFileInDocPath.getLocation();
            Point targetLocation = targetFileInDocPath.getLocation();

            robot.mouseMove(sourceLocation.getX(), sourceLocation.getY() + 150);
            Thread.sleep(500);
            robot.mouseMove(targetLocation.getX(), targetLocation.getY() + 150);
            Thread.sleep(500);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return String.format("Element[name='%s', locator='%s']", name, locator);
    }
}
