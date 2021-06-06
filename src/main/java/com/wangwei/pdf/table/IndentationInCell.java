package com.wangwei.pdf.table;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 3:41 下午
 * @Version 1.0
 */
public class IndentationInCell {
    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/indentation_in_cell.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new IndentationInCell().createPdf(DEST);
    }
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("TO:\n\n   name"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("TO:\n\n\u00a0\u00a0\u00a0name"));
        table.addCell(cell);
        cell = new PdfPCell();
        cell.addElement(new Paragraph("TO:"));
        Paragraph p = new Paragraph("name");
        p.setIndentationLeft(10);
        cell.addElement(p);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.addElement(new Paragraph("TO:"));
        p = new Paragraph("name");
        p.setAlignment(Element.ALIGN_RIGHT);
        cell.addElement(p);
        table.addCell(cell);
        document.add(table);
        document.close();
    }

}

