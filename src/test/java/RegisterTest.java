import org.testng.annotations.Test;
import utils.FakerUtils;

import static utils.PropertyLoader.returnConfigValue;

public class RegisterTest extends BaseTest {

    @Test()
    public void registrationTest() {
        String emailTitle = FakerUtils.generateRandomEmailTitle();
        getWelcomePage().clickLoginButton();
        getLoginPage()
                .setLoginInput(returnConfigValue("userEmail"))
                .setPasswordInput(returnConfigValue("password"))
                .clickEnterButton();
        getMailBarPage().clickNewMailButton();
        getSendMailPage()
                .setSendToAddressInput(returnConfigValue(("userEmail")))
                .setSubjectInput(emailTitle)
                .clickAttachmentButton()
                .setAttachmentFile("src/test/resources/ExampleForTest.pdf")
                .validateUploadedFileByFileName("ExampleForTest.pdf");
        getSendMailBarPage().clickSendMailButton();
        getInboxPage().validateNewEmailFromInboxByTitle(emailTitle)
                .clickOnEmailFromInboxByTitle(emailTitle);
        getBasePage().hoverUploadedFile();
        getOpenedEmailPage().clickArrowDownButton()
                .clickOnSaveInDocsButton();
        getDocumentPopupPage().clickMailImagesButton()
                .clickSaveButton();
    }

}