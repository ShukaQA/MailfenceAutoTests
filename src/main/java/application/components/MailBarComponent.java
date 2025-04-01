package application.components;

import application.elements.ButtonElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MailBarComponent {

    private ButtonElement newMailButton;

    public MailBarComponent(WebDriver driver) {
        newMailButton = new ButtonElement(driver, By.xpath("//div[@id='mailNewBtn']"), "New Mail Button");
    }

    public void clickNewMailButton() {
        newMailButton.waitForAndClick(Duration.ofSeconds(30));
    }
}
