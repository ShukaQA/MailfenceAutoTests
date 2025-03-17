import core.driver.DriverFactory;
import core.utils.PdfUtils;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static core.utils.PropertyLoader.returnConfigValue;

public class BaseTest {
    @Getter
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        PdfUtils.createPdf(returnConfigValue("filePath", "config.properties"), "Some Text");
        PdfUtils.createPdf(returnConfigValue("filePath2", "config.properties"), "Some Text 2");
        driver = DriverFactory.getDriver();
        driver.get(returnConfigValue("url.base", "config.properties"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.resetDriver();
    }
}
