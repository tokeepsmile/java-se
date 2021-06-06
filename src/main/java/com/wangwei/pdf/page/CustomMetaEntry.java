package com.wangwei.pdf.page;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Header;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CustomMetaEntry {

    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/custom_meta.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new CustomMetaEntry().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.addTitle("Some example");
        document.add(new Header("Test", "test"));
        document.open();
        Paragraph p = new Paragraph("Hello World");
        document.add(p);
        document.close();
    }

}

