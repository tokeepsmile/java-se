package com.wangwei.pdf.color;


import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author wangwei
 * @Date 2020/5/12 4:57 下午
 * @Version 1.0
 */

public class ColoredLetters {

    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/color/colored_letters.pdf";

    public static final Font RED_NORMAL = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, BaseColor.RED);
    public static final Font BLUE_BOLD = new Font(FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLUE);
    public static final Font GREEN_ITALIC = new Font(FontFamily.HELVETICA, 12, Font.ITALIC, BaseColor.GREEN);
    public static final Chunk B = new Chunk("b", BLUE_BOLD);
    public static final Chunk G = new Chunk("g", GREEN_ITALIC);

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ColoredLetters().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        Paragraph p = new Paragraph();
        String s = "all text is written in red, except the letters b and g; they are written in blue and green.";
        for (int i = 0; i < s.length(); i++) {
            p.add(returnCorrectColor(s.charAt(i)));
        }
        document.add(p);
        document.close();
    }

    private Chunk returnCorrectColor(char letter) {
        if (letter == 'b'){
            return B;
        }
        else if(letter == 'g'){
            return G;
        }
        return new Chunk(String.valueOf(letter), RED_NORMAL);
    }
}

