package com.wangwei.pdf.table;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 3:33 下午
 * @Version 1.0
 */
public class LeadingInCell {

    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/leading_in_cell.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new LeadingInCell().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell();
        Paragraph p;
        p = new Paragraph(16, "paragraph 1: leading 16");
        cell.addElement(p);
        p = new Paragraph(32, "paragraph 2: leading 32");
        cell.addElement(p);
        p = new Paragraph(10, "paragraph 3: leading 10");
        cell.addElement(p);
        p = new Paragraph(18, "paragraph 4: leading 18");
        cell.addElement(p);
        p = new Paragraph(40, "paragraph 5: leading 40");
        cell.addElement(p);
        table.addCell(cell);
        document.add(table);
        document.close();
    }
}
