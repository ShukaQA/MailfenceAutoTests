package pages.functionBar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SendMailBarComponent extends BasePage {
    public SendMailBarComponent(WebDriver driver) {
        super(driver);
    }

    private final By sendEmailButton = By.xpath("//div[text()='Send']/..");

    public SendMailBarComponent clickSendMailButton() {
        driver.findElement(sendEmailButton).click();
        return this;
    }

}
