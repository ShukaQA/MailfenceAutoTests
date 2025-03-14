package application.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import application.pages.BasePage;

public class TaskBarComponent extends BasePage {
    public TaskBarComponent(WebDriver driver) {
        super(driver);
    }

    private final By navDocButtonPath = By.xpath("//div[@id='nav-docs']");

    public TaskBarComponent clickOnNavDocButton() {
        driver.findElement(navDocButtonPath).click();
        return this;
    }

}
