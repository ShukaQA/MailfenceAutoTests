import application.pages.*;
import core.utils.FakerUtils;
import org.testng.annotations.Test;

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

        MessagesPage messagesPage = new MessagesPage(driver);
        messagesPage.mailBarComponent()
                .clickNewMailButton();
        messagesPage.sendMailComponent()
                .setSendToAddressInput(returnConfigValue("userEmail", "secret.properties"))
                .setSubjectInput(emailTitle)
                .clickAttachmentButton()
                .setAttachmentFile(returnConfigValue("filePath", "config.properties"))
                .validateUploadedFileByFileName(returnConfigValue("fileName", "config.properties"));
        messagesPage.sendMailBarComponent()
                .clickSendMailButton();
        messagesPage
                .validateNewEmailFromInboxByTitle(emailTitle)
                .clickOnEmailFromInboxByTitle(emailTitle);

        BasePage basePage = new BasePage(driver);
        basePage
                .hoverUploadedFile();
        messagesPage.openedEmailComponent()
                .clickArrowDownButton()
                .clickOnSaveInDocsButton();
        messagesPage.documentPopupComponent()
                .clickMailImagesButton()
                .clickSaveButton();
        messagesPage.taskBarComponent()
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