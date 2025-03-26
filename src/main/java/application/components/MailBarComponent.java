package application.components;

import application.elements.ButtonElement;
import application.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MailBarComponent extends BasePage {

    private ButtonElement newMailButton;

    public MailBarComponent(WebDriver driver) {
        super(driver);

        newMailButton = new ButtonElement(driver, By.xpath("//div[@id='mailNewBtn']"), "New Mail Button");
    }

    public void clickNewMailButton() {
        newMailButton.waitForAndClick(Duration.ofSeconds(30));
    }
}
