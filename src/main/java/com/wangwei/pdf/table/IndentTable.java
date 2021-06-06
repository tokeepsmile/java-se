package com.wangwei.pdf.table;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 3:39 下午
 * @Version 1.0
 */

public class IndentTable {
    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/indented_table.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new IndentTable().createPdf(DEST);
    }
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfContentByte cb = writer.getDirectContent();
        cb.moveTo(36, 842);
        cb.lineTo(36, 0);
        cb.stroke();
        PdfPTable table = new PdfPTable(8);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.setTotalWidth(150);
        table.setLockedWidth(true);
        for(int aw = 0; aw < 16; aw++){
            table.addCell("hi");
        }
        Paragraph p = new Paragraph();
        p.setIndentationLeft(36);
        p.add(table);
        document.add(p);
        document.close();
    }

}

