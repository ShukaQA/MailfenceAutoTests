package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxPage {
    private final WebDriver driver;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }

    //TODO show example for dynamic values in xpath
    private By getReceivedEmailPathByText(String text) {
        return By.xpath(String.format("//div[@title='%s']", text));
    }

    public String getNameOfNewMailFromInbox(String text) {
        return driver.findElement(getReceivedEmailPathByText(text)).getText();
    }

}
