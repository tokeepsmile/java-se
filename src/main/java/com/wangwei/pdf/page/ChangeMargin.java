package com.wangwei.pdf.page;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 10:22 下午
 * @Version 1.0
 */

public class ChangeMargin {

    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/pages/change_margin.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ChangeMargin().createPdf(DEST);
    }



    public void createPdf(String dest) throws IOException, DocumentException {
        float left = 30;
        float right = 30;
        float top = 60;
        float bottom = 0;
        Document document = new Document(PageSize.A4, left, right, top, bottom);
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        document.setMargins(left, right, 0, bottom);
        for (int i = 0; i < 60; i++) {
            document.add(new Paragraph("This is a test"));
        }
        document.close();
    }
}

