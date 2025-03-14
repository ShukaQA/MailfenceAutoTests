import application.pages.*;
import org.testng.annotations.Test;
import core.utils.FakerUtils;

import static core.utils.PropertyLoader.returnConfigValue;

public class RegisterTest extends BaseTest {

    @Test()
    public void registrationTest() {
        String emailTitle = FakerUtils.generateRandomEmailTitle();
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage
                .clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .setLoginInput(returnConfigValue("userEmail", "secret.properties"))
                .setPasswordInput(returnConfigValue("password", "secret.properties"))
                .clickEnterButton();

        InboxPage inboxPage = new InboxPage(driver);
        inboxPage.mailBarComponent()
                .clickNewMailButton();
        inboxPage.sendMailComponent()
                .setSendToAddressInput(returnConfigValue("userEmail", "secret.properties"))
                .setSubjectInput(emailTitle)
                .clickAttachmentButton()
                .setAttachmentFile(returnConfigValue("filePath", "config.properties"))
                .validateUploadedFileByFileName(returnConfigValue("fileName", "config.properties"));
        inboxPage.sendMailBarComponent()
                .clickSendMailButton();
        inboxPage
                .validateNewEmailFromInboxByTitle(emailTitle)
                .clickOnEmailFromInboxByTitle(emailTitle);

        BasePage basePage = new BasePage(driver);
        basePage
                .hoverUploadedFile();
        inboxPage.openedEmailComponent()
                .clickArrowDownButton()
                .clickOnSaveInDocsButton();
        inboxPage.documentPopupComponent()
                .clickMailImagesButton()
                .clickSaveButton();
        inboxPage.taskBarComponent()
                .clickOnNavDocButton();

        DocumentPage documentPage = new DocumentPage(driver);
        documentPage
                .clickMailImagesButton()
                .dragAndDropTheFile()
                .clickTrashFolderButton()
                .checkNewFileExistenceByFileName("»" + returnConfigValue("fileName", "config.properties"));
        documentPage.trashComponent()
                .clickSelectAllButton()
                .clickDeleteButton()
                .clickYesButton()
                .checkNoDocTextExistence("There are no documents in this folder yet");
    }

}