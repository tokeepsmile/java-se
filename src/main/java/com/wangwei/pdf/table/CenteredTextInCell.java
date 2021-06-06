package com.wangwei.pdf.table;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 3:34 下午
 * @Version 1.0
 */

public class CenteredTextInCell {

    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/centered_text.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new CenteredTextInCell().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        Font font = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
        Paragraph para = new Paragraph("Test", font);
        para.setLeading(0, 1);
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        PdfPCell cell = new PdfPCell();
        cell.setMinimumHeight(50);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.addElement(para);
        table.addCell(cell);
        document.add(table);
        document.close();
    }
}

