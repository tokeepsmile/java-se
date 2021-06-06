package com.wangwei.pdf.watermark;


import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 11:02 下午
 * @Version 1.0
 */

public class WatermarkedImages3 {
    public static final String IMAGE1 = "/Users/wangwei/opt/test/pdf/demo/1.JPG";
    public static final Font FONT = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, GrayColor.GRAYWHITE);
    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/waterMark/watermark3.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new WatermarkedImages3().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(1);
        for (int i = 0; i < 50; i++) {
            table.addCell("rahlrokks doesn't listen to what people tell him");
        }
        PdfContentByte cb = writer.getDirectContentUnder();
        table.addCell(getWatermarkedImage(cb, Image.getInstance(IMAGE1), "Bruno"));
        document.add(table);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, new Phrase("Bruno knows best"), 260, 400, 45);
        document.close();
    }

    public Image getWatermarkedImage(PdfContentByte cb, Image img, String watermark) throws DocumentException {
        float width = img.getScaledWidth();
        float height = img.getScaledHeight();
        PdfTemplate template = cb.createTemplate(width, height);
        template.addImage(img, width, 0, 0, height, 0, 0);
        ColumnText.showTextAligned(template, Element.ALIGN_CENTER,
                new Phrase(watermark, FONT), width / 2, height / 2, 30);
        return Image.getInstance(template);
    }
}

