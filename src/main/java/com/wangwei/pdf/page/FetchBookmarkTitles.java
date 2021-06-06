package com.wangwei.pdf.page;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.SimpleBookmark;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @Author wangwei
 * @Date 2020/5/12 4:12 下午
 * @Version 1.0
 */

public class FetchBookmarkTitles {
    public static final String SRC = "/Users/wangwei/opt/test/pdf/demo/background_image.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        new FetchBookmarkTitles().inspectPdf(SRC);
    }

    public void inspectPdf(String filename) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(filename);
        List<HashMap<String,Object>> bookmarks = SimpleBookmark.getBookmark(reader);
        for (int i = 0; i < bookmarks.size(); i++){
            showTitle(bookmarks.get(i));
        }
        reader.close();
    }

    public void showTitle(HashMap<String, Object> bm) {
        System.out.println((String)bm.get("Title"));
        List<HashMap<String,Object>> kids = (List<HashMap<String,Object>>)bm.get("Kids");
        if (kids != null) {
            for (int i = 0; i < kids.size(); i++) {
                showTitle(kids.get(i));
            }
        }
    }
}

