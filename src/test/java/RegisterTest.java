import org.testng.annotations.Test;
import utils.FakerUtils;

import static utils.PropertyLoader.returnConfigValue;

public class RegisterTest extends BaseTest {

    @Test()
    public void registrationTest() {
        String emailTitle = FakerUtils.generateRandomEmailTitle();
        getWelcomePage()
                .clickLoginButton();
        getLoginPage()
                .setLoginInput(returnConfigValue("userEmail", "secret.properties"))
                .setPasswordInput(returnConfigValue("password", "secret.properties"))
                .clickEnterButton();
        getInboxPage().mailBarComponent()
                .clickNewMailButton();
        getInboxPage().sendMailComponent()
                .setSendToAddressInput(returnConfigValue("userEmail", "config.properties"))
                .setSubjectInput(emailTitle)
                .clickAttachmentButton()
                .setAttachmentFile(returnConfigValue("filePath", "config.properties"))
                .validateUploadedFileByFileName(returnConfigValue("fileName", "config.properties"));
        getInboxPage().sendMailBarComponent()
                .clickSendMailButton();
        getInboxPage()
                .validateNewEmailFromInboxByTitle(emailTitle)
                .clickOnEmailFromInboxByTitle(emailTitle);
        getBasePage()
                .hoverUploadedFile();
        getInboxPage().openedEmailComponent()
                .clickArrowDownButton()
                .clickOnSaveInDocsButton();
        getInboxPage().documentPopupComponent()
                .clickMailImagesButton()
                .clickSaveButton();
        getInboxPage().taskBarComponent()
                .clickOnNavDocButton();
        getInboxPage().documentPage()
                .clickMailImagesButton()
                .dragAndDropTheFile()
                .clickTrashFolderButton()
                .checkNewFileExistenceByFileName("»" + returnConfigValue("fileName", "config.properties"));
    }

}