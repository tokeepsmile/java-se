package com.wangwei.pdf.table;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TiledBackground {

    class TiledImageBackground implements PdfPCellEvent {

        protected Image image;

        public TiledImageBackground(Image image) {
            this.image = image;
        }

        public void cellLayout(PdfPCell cell, Rectangle position,
                               PdfContentByte[] canvases) {
            try {
                PdfContentByte cb = canvases[PdfPTable.BACKGROUNDCANVAS];
                PdfPatternPainter patternPainter = cb.createPattern(image.getScaledWidth(), image.getScaledHeight());
                image.setAbsolutePosition(0, 0);
                patternPainter.addImage(image);
                cb.saveState();
                cb.setPatternFill(patternPainter);
                cb.rectangle(position.getLeft(), position.getBottom(), position.getWidth(), position.getHeight());
                cb.fill();
                cb.restoreState();
            } catch (DocumentException e) {
                throw new ExceptionConverter(e);
            }
        }

    }

    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/tiled_pattern.pdf";
    public static final String IMG1 = "/Users/wangwei/opt/test/pdf/demo/1.JPG";
    public static final String IMG2 = "/Users/wangwei/opt/test/pdf/demo/1.JPG";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new TiledBackground().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell = new PdfPCell();
        Image image = Image.getInstance(IMG1);
        cell.setCellEvent(new TiledImageBackground(image));
        cell.setFixedHeight(770);
        table.addCell(cell);
        cell = new PdfPCell();
        image = Image.getInstance(IMG2);
        cell.setCellEvent(new TiledImageBackground(image));
        cell.setFixedHeight(770);
        table.addCell(cell);
        document.add(table);
        document.close();
    }
}
