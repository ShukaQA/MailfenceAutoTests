import org.testng.annotations.Test;
import utils.FakerUtils;

import static utils.PropertyLoader.returnConfigValue;

public class RegisterTest extends BaseTest {

    @Test()
    public void registrationTest() {
        String emailTitle = FakerUtils.generateRandomEmailTitle();
        welcomePage.clickLoginButton();
        loginPage
                .setLoginInput(returnConfigValue("userEmail"))
                .setPasswordInput(returnConfigValue("password"))
                .clickEnterButton();
        mailBarPage.clickNewMailButton();
        sendMailPage
                .setSendToAddressInput(returnConfigValue(("userEmail")))
                .setSubjectInput(emailTitle)
                .clickAttachmentButton()
                .setAttachmentFile("C:\\Users\\Giorgi.Shukakidze\\IdeaProjects\\VentionTestProject\\src\\test\\resources\\ExampleForTest.pdf");
        sendMailBarPage.clickSendMailButton();
        getDriver().navigate().refresh();
        try {
            System.out.println(inboxPage.getNameOfNewMailFromInbox(emailTitle));
        } catch (Exception e) {
            getDriver().navigate().refresh();
            System.out.println(inboxPage.getNameOfNewMailFromInbox(emailTitle));
        }
    }

}