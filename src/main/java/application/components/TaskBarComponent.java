package application.components;

import application.elements.ButtonElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskBarComponent {

    private ButtonElement navDocButton;

    public TaskBarComponent(WebDriver driver) {
        navDocButton = new ButtonElement(driver, By.xpath("//div[@id='nav-docs']"), "Nav Docs Button");
    }

    public void clickOnNavDocButton() {
        navDocButton.click();
    }
}
