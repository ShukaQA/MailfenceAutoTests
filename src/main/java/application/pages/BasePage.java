package application.pages;

import org.openqa.selenium.WebDriver;

//TODO use abstract class
public class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

}
