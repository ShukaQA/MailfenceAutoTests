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
                .setLoginInput(returnConfigValue("userEmail"))
                .setPasswordInput(returnConfigValue("password"))
                .clickEnterButton();
        getInboxPage().mailBarComponent()
                .clickNewMailButton();
        getInboxPage().sendMailComponent()
                .setSendToAddressInput(returnConfigValue("userEmail"))
                .setSubjectInput(emailTitle)
                .clickAttachmentButton()
                .setAttachmentFile(returnConfigValue("filePath"))
                .validateUploadedFileByFileName(returnConfigValue("fileName"));
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
                .checkNewFileExistenceByFileName("»" + returnConfigValue("fileName"));
    }

}