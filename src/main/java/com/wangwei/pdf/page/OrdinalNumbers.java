package com.wangwei.pdf.page;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 4:50 下午
 * @Version 1.0
 */
public class OrdinalNumbers {
    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/pages/ordinal_numbers.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new OrdinalNumbers().createPdf(DEST);
    }
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        Font small = new Font(FontFamily.HELVETICA, 6);
        Chunk st = new Chunk("st", small);
        st.setTextRise(7);
        Chunk nd = new Chunk("nd", small);
        nd.setTextRise(7);
        Chunk rd = new Chunk("rd", small);
        rd.setTextRise(7);
        Chunk th = new Chunk("th", small);
        th.setTextRise(7);
        Paragraph first = new Paragraph();
        first.add("The 1");
        first.add(st);
        first.add(" of May");
        document.add(first);
        Paragraph second = new Paragraph();
        second.add("The 2");
        second.add(nd);
        second.add(" and the 3");
        second.add(rd);
        second.add(" of June");
        document.add(second);
        Paragraph fourth = new Paragraph();
        fourth.add("The 4");
        fourth.add(rd);
        fourth.add(" of July");
        document.add(fourth);
        document.close();
    }
}
