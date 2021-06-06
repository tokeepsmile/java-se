package com.wangwei.pdf.page;


import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 4:55 下午
 * @Version 1.0
 */
public class StandardDeviation {

    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/pages/standard_deviation.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new StandardDeviation().createPdf(DEST);
    }
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        document.add(new Paragraph("The standard deviation symbol doesn't exist in Helvetica."));
        Font symbol = new Font(FontFamily.SYMBOL);
        Paragraph p = new Paragraph("So we use the Symbol font: ");
        p.add(new Chunk("s", symbol));
        document.add(p);
        document.close();
    }

}
