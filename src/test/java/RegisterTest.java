import application.enums.FileFormatEnum;
import application.pages.DocumentPage;
import application.pages.LoginPage;
import application.pages.MessagesPage;
import application.pages.WelcomePage;
import com.itextpdf.kernel.pdf.PdfDocument;
import core.utils.FakerUtils;
import core.utils.FilesUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static core.utils.PropertyLoader.returnConfigValue;

public class RegisterTest extends BaseTest {
    String emailTitle;
    String generatedPdfPath1;
    String generatedPdfPath2;
    String fileFormat;
    String filename1;
    String filename2;
    PdfDocument pdfDoc1;
    PdfDocument pdfDoc2;

    @BeforeTest()
    public void generateTestData() {
        emailTitle = FakerUtils.generateRandomEmailTitle();
        fileFormat = FileFormatEnum.PDF.toString();
        filename1 = "testPdf1";
        filename2 = "testPdf2";
        generatedPdfPath1 = FilesUtils.generateUniqueFilePath(filename1);
        generatedPdfPath2 = FilesUtils.generateUniqueFilePath(filename2);

        pdfDoc1 = FilesUtils.createPdf("Some Text", generatedPdfPath1);
        pdfDoc2 = FilesUtils.createPdf("Some Text 2", generatedPdfPath2);
    }

    @Test()
    public void registrationTest() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .setLoginInput(returnConfigValue("userEmail", "secret.properties"))
                .setPasswordInput(returnConfigValue("password", "secret.properties"))
                .clickEnterButton();

        MessagesPage messagesPage = new MessagesPage(driver);
        messagesPage.getMailBarComponent()
                .clickNewMailButton();
        messagesPage.getSendMailComponent()
                .setSendToAddressInput(returnConfigValue("userEmail", "secret.properties"))
                .setSubjectInput(emailTitle)
                .clickAttachmentButton()
                .setAttachmentFile(generatedPdfPath1)
                .clickAttachmentButton()
                .setAttachmentFile(generatedPdfPath2);
        messagesPage.getSendMailComponent()
                .validateUploadedFileByFilesName(filename1, filename2);

        messagesPage.getSendMailBarComponent()
                .clickSendMailButton();
        messagesPage
                .validateNewEmailFromInboxByTitle(emailTitle)
                .clickOnEmailFromInboxByTitle(emailTitle);

        messagesPage.getSendMailComponent()
                .hoverUploadedFile(filename1);

        messagesPage.getOpenedEmailComponent()
                .clickArrowDownButton()
                .clickOnSaveInDocsButton();
        messagesPage.getDocumentPopupComponent()
                .clickMailImagesButton()
                .clickSaveButton();
        messagesPage.getTaskBarComponent()
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

        FilesUtils.delete(generatedPdfPath1, generatedPdfPath2);
    }
}
