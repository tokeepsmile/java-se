package com.wangwei.pdf.table;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 2:39 下午
 * @Version 1.0
 * 生成带表格的pdf
 */
public class PdfForTable {
    private static final String DEST = "/Users/wangwei/opt/test/pdf/demo/simple_table.pdf";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new PdfForTable().createPdf(DEST);
        System.out.println("credate success!");
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(8);
        for(int aw = 0; aw < 16; aw++){
            table.addCell("hi");
        }
        document.add(table);
        document.close();
    }
}
