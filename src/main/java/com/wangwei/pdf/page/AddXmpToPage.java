package com.wangwei.pdf.page;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.xml.xmp.XmpWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 3:49 下午
 * @Version 1.0
 */
public class AddXmpToPage {

    public static final String SRC = "/Users/wangwei/opt/test/pdf/demo/table_with_tab.pdf";
    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/hello_with_page_xmp.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new AddXmpToPage().manipulatePdf(SRC, DEST);
    }

    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PdfDictionary page = reader.getPageN(1);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XmpWriter xmp = new XmpWriter(baos, new PdfDictionary());
        xmp.close();
        PdfIndirectObject ref = stamper.getWriter().addToBody(new PdfStream(baos.toByteArray()));
        page.put(PdfName.METADATA, ref.getIndirectReference());
        stamper.close();
        reader.close();
    }
}
