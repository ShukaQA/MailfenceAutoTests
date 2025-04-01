package application.components;

import application.elements.ButtonElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMailBarComponent {

    private ButtonElement sendEmailButton;

    public SendMailBarComponent(WebDriver driver) {
        sendEmailButton = new ButtonElement(driver, By.xpath("//div[text()='Send']/.."), "Send Email Button");
    }

    public void clickSendMailButton() {
        sendEmailButton.click();
    }
}
