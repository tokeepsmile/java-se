package com.wangwei.pdf.table;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 4:40 下午
 * @Version 1.0
 */

public class FitTableOnPage {
    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/fit_table_on_page.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new FitTableOnPage().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        PdfPTable table = new PdfPTable(1);
        table.setTotalWidth(550);
        table.setLockedWidth(true);
        for (int i = 0; i < 10; i++) {
            PdfPCell cell;
            if (i == 9) {
                cell = new PdfPCell(new Phrase("Two\nLines"));
            }
            else {
                cell = new PdfPCell(new Phrase(Integer.toString(i)));
            }
            table.addCell(cell);
        }
        Document document = new Document(new Rectangle(612, table.getTotalHeight() + 72));
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        document.add(table);
        document.close();
    }
}
