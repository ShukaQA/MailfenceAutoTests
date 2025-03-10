package pages.functionBar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class SendMailBarPage extends BasePage {
    public SendMailBarPage(WebDriver driver) {
        super(driver);
    }

    private final By sendEmailButton = By.xpath("//div[text()='Send']/..");

    public SendMailBarPage clickSendMailButton() {
        driver.findElement(sendEmailButton).click();
        return this;
    }

}
