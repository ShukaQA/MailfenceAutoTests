package application.components;

import application.elements.ButtonElement;
import application.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskBarComponent extends BasePage {

    private ButtonElement navDocButton;

    public TaskBarComponent(WebDriver driver) {
        super(driver);

        navDocButton = new ButtonElement(driver, By.xpath("//div[@id='nav-docs']"), "Nav Docs Button");
    }

    public TaskBarComponent clickOnNavDocButton() {
        navDocButton.click();
        return this;
    }
}
