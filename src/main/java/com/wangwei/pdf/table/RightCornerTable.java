package com.wangwei.pdf.table;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 4:29 下午
 * @Version 1.0
 */
public class RightCornerTable {
    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/right_corner_table.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new RightCornerTable().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Rectangle pagesize = new Rectangle(300, 300);
        Document document = new Document(pagesize, 0, 0, 0, 0);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(1);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.setWidthPercentage(30);
        Font white = new Font();
        white.setColor(BaseColor.WHITE);
        PdfPCell cell = new PdfPCell(new Phrase(" Date" , white));
        cell.setBackgroundColor(BaseColor.BLACK);
        cell.setBorderColor(BaseColor.GRAY);
        cell.setBorderWidth(2f);
        table.addCell(cell);
        PdfPCell cellTwo = new PdfPCell(new Phrase("10/01/2015"));
        cellTwo.setBorderWidth(2f);
        table.addCell(cellTwo);
        document.add(table);
        document.newPage();
        table.setTotalWidth(90);
        PdfContentByte canvas = writer.getDirectContent();
        table.writeSelectedRows(0, -1, document.right() - 90, document.top(), canvas);
        document.close();
    }

}
