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
 * @Date 2020/5/12 4:34 下午
 * @Version 1.0
 */
public class ColoredBorder {
    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/colored_border.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ColoredBorder().createPdf(DEST);
    }
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table;
        table = new PdfPTable(2);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Cell 1"));
        cell.setUseVariableBorders(true);
        cell.setBorderColorTop(BaseColor.RED);
        cell.setBorderColorBottom(BaseColor.BLUE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cell 2"));
        cell.setBorderWidthLeft(5);
        cell.setBorderColorLeft(BaseColor.GREEN);
        cell.setBorderWidthTop(8);
        cell.setBorderColorTop(BaseColor.YELLOW);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cell 3"));
        cell.setUseVariableBorders(true);
        cell.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
        cell.setBorderColorLeft(BaseColor.RED);
        cell.setBorderColorBottom(BaseColor.BLUE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Cell 4"));
        cell.setBorder(Rectangle.LEFT | Rectangle.TOP);
        cell.setUseBorderPadding(true);
        cell.setBorderWidthLeft(5);
        cell.setBorderColorLeft(BaseColor.GREEN);
        cell.setBorderWidthTop(8);
        cell.setBorderColorTop(BaseColor.YELLOW);
        table.addCell(cell);
        document.add(table);
        document.close();
    }

}

