package com.wangwei.pdf.page;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 4:48 下午
 * @Version 1.0
 */

public class ChunkBackground {

    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/pages/chunk_background.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ChunkBackground().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        Font f = new Font(FontFamily.TIMES_ROMAN, 25.0f, Font.BOLD, BaseColor.WHITE);
        Chunk c = new Chunk("White text on red background", f);
        c.setBackground(BaseColor.RED);
        Paragraph p = new Paragraph(c);
        document.add(p);
        document.close();
    }
}
