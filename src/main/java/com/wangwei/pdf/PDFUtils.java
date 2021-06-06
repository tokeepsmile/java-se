package com.wangwei.pdf;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: wangwei
 * @date: 2019-07-05 09:58
 */
public class PDFUtils {
    public static void main(String[] args) {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);

        try {
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("/Users/wangwei/opt/pdf/calimForm.pdf"));

            FileInputStream fis = new FileInputStream("/Users/wangwei/Pictures/WechatIMG76.jpeg");


            document.open();


            document.addTitle("索赔申请书");

            Anchor anchorTarget = new Anchor("First page of the document.");

            anchorTarget.setName("BackToTop");
            Paragraph paragraph1 = new Paragraph();


            paragraph1.setSpacingBefore(50);

            paragraph1.add(anchorTarget);
            document.add(paragraph1);

            document.add(new Paragraph("Some more text on the first page with different color and font type.",

                    FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0))));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
