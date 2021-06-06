package com.wangwei.pdf.table;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFormInTable {

    class MyCellField implements PdfPCellEvent {
        protected String fieldname;
        public MyCellField(String fieldname) {
            this.fieldname = fieldname;
        }
        public void cellLayout(PdfPCell cell, Rectangle rectangle, PdfContentByte[] canvases) {
            final PdfWriter writer = canvases[0].getPdfWriter();
            final TextField textField = new TextField(writer, rectangle, fieldname);
            try {
                final PdfFormField field = textField.getTextField();
                writer.addAnnotation(field);
            } catch (final IOException ioe) {
                throw new ExceptionConverter(ioe);
            } catch (final DocumentException de) {
                throw new ExceptionConverter(de);
            }
        }
    }

    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/form_in_table.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new CreateFormInTable().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Name:"));
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setCellEvent(new MyCellField("name"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Address"));
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setCellEvent(new MyCellField("address"));
        table.addCell(cell);
        document.add(table);
        document.close();
    }

}
