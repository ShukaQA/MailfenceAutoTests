import org.testng.annotations.Test;
import utils.FakerUtils;

import static utils.PropertyLoader.returnConfigValue;

public class RegisterTest extends BaseTest {

    @Test()
    public void registrationTest() throws InterruptedException {
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
                .setAttachmentFile("src/test/resources/ExampleForTest.pdf")
                .validateUploadedFileByFileName("ExampleForTest.pdf");
        sendMailBarPage.clickSendMailButton();
        inboxPage.validateNewEmailFromInboxByTitle(emailTitle)
                .clickOnEmailFromInboxByTitle(emailTitle);
        basePage.hoverUploadedFile();
        openedEmailPage.clickArrowDownButton()
                .clickOnSaveInDocsButton();
        documentPopupPage.clickMailImagesButton()
                .clickSaveButton();
    }

}