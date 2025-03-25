package core.utils;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;
//TODO move to baseElement class
public class FileActions {
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
}

