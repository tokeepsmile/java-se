package com.wangwei.pdf.watermark;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/13 10:20 上午
 * @Version 1.0
 */

public class TransparentWatermark3 {

    public static final String SRC = "/Users/wangwei/opt/test/pdf/demo/column_width_example.pdf";
    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/waterMark/pages_watermarked3.pdf";
    public static final String IMG = "/Users/wangwei/opt/test/pdf/demo/1.JPG";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new TransparentWatermark3().manipulatePdf(SRC, DEST);
    }

    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        int n = reader.getNumberOfPages();
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.setRotateContents(false);
        // text watermark
        BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        //Font f = new Font(FontFamily.HELVETICA, 30);
        //Font f = new Font(bf, 70);
        //Phrase p = new Phrase("", f);
        PdfGState gs1 = new PdfGState();
        gs1.setFillOpacity(0.1f);
        // properties
        JLabel jLabel = new JLabel();
        jLabel.setText("昆仑银行");
        FontMetrics fontMetrics = jLabel.getFontMetrics(jLabel.getFont());
        int textH = fontMetrics.getHeight();
        int textW = fontMetrics.stringWidth(jLabel.getText());
        PdfContentByte over;
        Rectangle pagesize;
        Rectangle pageRect = null;
        float x, y;
        for (int i = 1; i <= n; i++) {
            //pagesize = reader.getPageSize(i);
            pageRect = reader.getPageSizeWithRotation(i);
            //x = (pagesize.getLeft() + pagesize.getRight()) / 2;
            //y = (pagesize.getTop() + pagesize.getBottom()) / 2;
            over = stamper.getOverContent(i);
            // 在内容下方添加水印
            //over = stamper.getUnderContent(i);
            over.saveState();
            over.setGState(gs1);
            over.setFontAndSize(bf, 20);
            //ColumnText.showTextAligned(over, Element.ALIGN_CENTER, p, x, y, 45);
            //for (int height = textH; height < pageRect.getHeight()*2; height = height + textH * 20){
            //    for (int )
            //}
            over.restoreState();
        }
        stamper.close();
        reader.close();
    }
}

