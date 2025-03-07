import org.testng.annotations.Test;

import static utils.PropertyLoader.returnConfigValue;

public class RegisterTest extends BaseTest {

    @Test()
    public void registrationTest() {
        welcomePage.clickLoginButton();
        loginPage
                .setLoginInput(returnConfigValue("userEmail"))
                .setPasswordInput(returnConfigValue("password"))
                .clickEnterButton();
        mailBarPage.clickNewMailButton();
        sendMailPage
                .setSendToAddressInput(returnConfigValue(("userEmail")))
                .setSubjectInput("Test Automation Subject")
                .clickAttachmentButton()
                .setAttachmentFile("C:\\Users\\Giorgi.Shukakidze\\IdeaProjects\\VentionTestProject\\src\\test\\resources\\ExampleForTest.pdf");
        sendMailBarPage.clickSendMailButton();
        getDriver().navigate().refresh();

    }

}