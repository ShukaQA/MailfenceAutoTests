package core.utils;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;

public class PdfUtils {
    public static void createPdf(String fileName, String content) {
        String dest = fileName;
        PdfWriter writer;
        PdfDocument pdfDocument;
        try {
            writer = new PdfWriter(dest);
            pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);
            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            document.add(new Paragraph(content).setFont(font).setFontSize(12).setFontColor(ColorConstants.BLACK));
            document.close();
            System.out.println("PDF created successfully at: " + dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
