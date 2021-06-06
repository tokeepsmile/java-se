package com.wangwei.pdf.positions;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 5:49 下午
 * @Version 1.0
 */

public class FestivalOpening {

    /** The resulting PDF. */
    public static final String RESULT
            = "/Users/wangwei/opt/test/pdf/demo/festival_opening.pdf";
    /** The movie poster. */
    public static final String RESOURCE = "/Users/wangwei/opt/test/pdf/demo/1.JPG";

    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException
     * @throws IOException
     */
    public static void main(String[] args)
            throws IOException, DocumentException {
        // step 1
        Document document = new Document(PageSize.A2, 30, 30, 30, 30);
        // step 2
        PdfWriter writer
                = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        // step 3
        document.open();
        // step 4
        // Create and add a Paragraph
        Paragraph p
                = new Paragraph("索赔清单", new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED), 22));
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        // Create and add an Image
        Image img = Image.getInstance(RESOURCE);
        img.setAbsolutePosition(
                (PageSize.POSTCARD.getWidth() - img.getScaledWidth()) / 2,
                (PageSize.POSTCARD.getHeight() - img.getScaledHeight()) / 2);
        document.add(img);
        // Now we go to the next page
        document.newPage();
        document.add(p);
        document.add(img);
        // Add text on top of the image
        PdfContentByte over = writer.getDirectContent();
        over.saveState();
        float sinus = (float)Math.sin(Math.PI / 60);
        float cosinus = (float)Math.cos(Math.PI / 60);
        BaseFont bf = BaseFont.createFont();
        over.beginText();
        over.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE);
        over.setLineWidth(1.5f);
        over.setRGBColorStroke(0xFF, 0x00, 0x00);
        over.setRGBColorFill(0xFF, 0xFF, 0xFF);
        over.setFontAndSize(bf, 36);
        over.setTextMatrix(cosinus, sinus, -sinus, cosinus, 50, 324);
        over.showText("SOLD OUT");
        over.endText();
        over.restoreState();
        // Add a rectangle under the image
        PdfContentByte under = writer.getDirectContentUnder();
        under.saveState();
        under.setRGBColorFill(0xFF, 0xD7, 0x00);
        under.rectangle(5, 5,
                PageSize.POSTCARD.getWidth() - 10, PageSize.POSTCARD.getHeight() - 10);
        under.fill();
        under.restoreState();
        // step 5
        document.close();
    }
}
