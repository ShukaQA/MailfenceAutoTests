package application.components;

import application.elements.ButtonElement;
import application.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMailBarComponent extends BasePage {

    private ButtonElement sendEmailButton;

    public SendMailBarComponent(WebDriver driver) {
        super(driver);

        sendEmailButton = new ButtonElement(driver, By.xpath("//div[text()='Send']/.."), "Send Email Button");
    }

    public SendMailBarComponent clickSendMailButton() {
        sendEmailButton.click();
        return this;
    }
}
