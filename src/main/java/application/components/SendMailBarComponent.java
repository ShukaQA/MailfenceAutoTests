package application.components;

import application.elements.ButtonElement;
import org.openqa.selenium.By;

public class SendMailBarComponent {

    private ButtonElement sendEmailButton;

    public SendMailBarComponent() {
        sendEmailButton = new ButtonElement(By.xpath("//div[text()='Send']/.."), "Send Email Button");
    }

    public void clickSendMailButton() {
        sendEmailButton.click();
    }
}
