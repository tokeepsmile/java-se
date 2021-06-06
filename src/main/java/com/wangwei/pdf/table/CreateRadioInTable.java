package com.wangwei.pdf.table;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateRadioInTable {

    class MyCellField implements PdfPCellEvent {
        protected PdfFormField radiogroup;
        protected String value;
        public MyCellField(PdfFormField radiogroup, String value) {
            this.radiogroup = radiogroup;
            this.value = value;
        }
        public void cellLayout(PdfPCell cell, Rectangle rectangle, PdfContentByte[] canvases) {
            final PdfWriter writer = canvases[0].getPdfWriter();
            RadioCheckField radio = new RadioCheckField(writer, rectangle, null, value);
            try {
                radiogroup.addKid(radio.getRadioField());
            } catch (final IOException ioe) {
                throw new ExceptionConverter(ioe);
            } catch (final DocumentException de) {
                throw new ExceptionConverter(de);
            }
        }
    }

    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/radio_in_table.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new CreateRadioInTable().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfFormField radiogroup = PdfFormField.createRadioButton(writer, true);
        radiogroup.setFieldName("Language");
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("English:"));
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setCellEvent(new MyCellField(radiogroup, "english"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("French:"));
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setCellEvent(new MyCellField(radiogroup, "french"));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("Dutch:"));
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setCellEvent(new MyCellField(radiogroup, "dutch"));
        table.addCell(cell);
        document.add(table);
        writer.addAnnotation(radiogroup);
        document.close();
    }

}
