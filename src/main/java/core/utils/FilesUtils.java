package core.utils;

import application.enums.FileFormatEnum;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class FilesUtils {
    public static String generateUniqueFilePath(String baseName) {
        String uniqueName = baseName + "." + FileFormatEnum.PDF.getFormat();
        System.out.println(uniqueName);
        String tempDir = System.getProperty("java.io.tmpdir");
        return Paths.get(tempDir, uniqueName).toString();
    }

    public static void createPdf(String content, String filePath) {
        PdfWriter writer;
        PdfDocument pdfDocument;
        try {
            writer = new PdfWriter(filePath);
            pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);
            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            document.add(new Paragraph(content).setFont(font).setFontSize(12).setFontColor(ColorConstants.BLACK));
            document.close();
            System.out.println("File created successfully at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean delete(String... filePaths) {
        boolean allDeleted = true;
        for (String filePath : filePaths) {
            File file = new File(filePath);
            if (file.exists()) {
                boolean isDeleted = file.delete();
                if (isDeleted) {
                    System.out.println("File deleted successfully: " + filePath);
                } else {
                    System.out.println("Failed to delete the file: " + filePath);
                    allDeleted = false;
                }
            } else {
                System.out.println("File does not exist: " + filePath);
                allDeleted = false;
            }
        }

        return allDeleted;
    }

}
