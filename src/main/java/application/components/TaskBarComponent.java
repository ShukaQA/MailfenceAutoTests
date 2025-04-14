package application.components;

import application.elements.ButtonElement;
import org.openqa.selenium.By;

public class TaskBarComponent {

    private ButtonElement navDocButton;

    public TaskBarComponent() {
        navDocButton = new ButtonElement(By.xpath("//div[@id='nav-docs']"), "Nav Docs Button");
    }

    public void clickOnNavDocButton() {
        navDocButton.click();
    }
}
