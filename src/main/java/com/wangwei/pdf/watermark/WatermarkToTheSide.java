package com.wangwei.pdf.watermark;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/13 3:12 下午
 * @Version 1.0
 */

public class WatermarkToTheSide {

    public static final String SRC = "/Users/wangwei/opt/test/pdf/demo/column_width_example.pdf";
    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/waterMark/side_watermark.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new WatermarkToTheSide().manipulatePdf(SRC, DEST);
    }

    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        int n = reader.getNumberOfPages();
        PdfContentByte canvas;
        Rectangle pageSize;
        float x, y;
        for (int p = 1; p <= n; p++) {
            pageSize = reader.getPageSizeWithRotation(p);
            // left of the page
            x = pageSize.getLeft();
            // middle of the height
            y = (pageSize.getTop() + pageSize.getBottom()) / 2;
            // getting the canvas covering the existing content
            canvas = stamper.getOverContent(p);
            // adding some lines to the left
            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER,
                    new Phrase("This is some extra text added to the left of the page"),
                    x + 18, y, 90);
            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER,
                    new Phrase("This is some more text added to the left of the page"),
                    x + 34, y, 90);
        }
        stamper.close();
    }

}

