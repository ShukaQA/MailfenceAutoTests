import application.enums.FileFormatEnum;
import application.pages.*;
import core.utils.FakerUtils;
import core.utils.PdfUtils;
import org.testng.annotations.Test;

import static core.utils.PropertyLoader.returnConfigValue;

public class RegisterTest extends BaseTest {
    String emailTitle = FakerUtils.generateRandomEmailTitle();
    String generatedPdfPath1;
    String generatedPdfPath2;
    String fileFormat = FileFormatEnum.PDF.toString();
    String filename1 = "testPdf1";
    String filename2 = "testPdf2";

    @Test()
    public void registrationTest() {
        generatedPdfPath1 = PdfUtils.generateUniquePdfFilePath(filename1);
        generatedPdfPath2 = PdfUtils.generateUniquePdfFilePath(filename2);
        PdfUtils.createPdf("Some Text", generatedPdfPath1);
        PdfUtils.createPdf("Some Text 2", generatedPdfPath2);

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
                .setAttachmentFile(generatedPdfPath1)
                .clickAttachmentButton()
                .setAttachmentFile(generatedPdfPath2)
                .validateUploadedFileByFileName(filename1)
                .validateUploadedFileByFileName(filename2);
        messagesPage.sendMailBarComponent()
                .clickSendMailButton();
        messagesPage
                .validateNewEmailFromInboxByTitle(emailTitle)
                .clickOnEmailFromInboxByTitle(emailTitle);

        BasePage basePage = new BasePage(driver);
        basePage
                .hoverUploadedFile(filename1);

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
                .dragAndDropTheFile(filename1, fileFormat)
                .clickTrashFolderButton()
                .checkNewFileExistenceByFileName(filename1, fileFormat);
        documentPage.trashComponent()
                .clickSelectAllButton()
                .clickDeleteButton()
                .clickYesButton()
                .checkNoDocTextExistence("There are no documents in this folder yet");

        PdfUtils.deletePdf(generatedPdfPath1);
        PdfUtils.deletePdf(generatedPdfPath2);

    }

}