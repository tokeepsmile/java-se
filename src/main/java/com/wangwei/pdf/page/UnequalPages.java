package com.wangwei.pdf.page;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 10:19 下午
 * @Version 1.0
 */

public class UnequalPages {

    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/pages/unequal_pages.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new UnequalPages().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        Rectangle one = new Rectangle(70,140);
        Rectangle two = new Rectangle(700,400);
        document.setPageSize(one);
        document.setMargins(2, 2, 2, 2);
        document.open();
        Paragraph p = new Paragraph("Hi");
        document.add(p);
        document.setPageSize(two);
        document.setMargins(20, 20, 20, 20);
        document.newPage();
        document.add(p);
        document.close();
    }
}

