package pages.functionBar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMailBarPage {
    private final WebDriver driver;

    public SendMailBarPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By sendEmailButton = By.xpath("//div[text()='Send']/..");

    public SendMailBarPage clickSendMailButton() {
        driver.findElement(sendEmailButton).click();
        return this;
    }

}
