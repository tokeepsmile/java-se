package com.wangwei.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangwei
 * @date: 2019-07-07 00:56
 */
public class PDFUtils2 {
    // 利用模板生成pdf
    public static void pdfout(Map<String,Object> o) {
        // 模板路径
        String templatePath = "/Users/wangwei/opt/test/pdf/template/collectionDesc.pdf";
        // 生成的新文件路径
        String newPDFPath = "/Users/wangwei/opt/test/pdf/collectionDesc.pdf";

        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {

            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();

            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                    BaseFont.NOT_EMBEDDED);
            Font FontChinese = new Font(bf, 10, Font.NORMAL);

            Map<String,String> datemap = (Map<String,String>)o.get("datemap");

            for(String key : datemap.keySet()){
                String value = datemap.get(key);
                form.setFieldProperty(key, "textfont", bf, null);
                form.setField(key,value);
            }
            stamper.setFormFlattening(true);// 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
            stamper.close();
            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();

        } catch (IOException e) {
            System.out.println(e);
        } catch (DocumentException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap();

        LocalDate localDate = LocalDate.now();

        int year = localDate.getYear();

        int month = localDate.getMonth().getValue();

        int dayOfMonth = localDate.getDayOfMonth();

        String date = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

//        map.put("name","张三");
//        map.put("mobile","18701608711");
//        map.put("perNum","晴朗");
//        map.put("loseAmt","100.00");
//        map.put("applyAmt", "188000.00");
//        map.put("startDate", date);
//        map.put("endDate", date);
//        map.put("date", date);
        map.put("year", year+"");
        map.put("month", month+"");
        map.put("day", dayOfMonth+"");

        Map<String,Object> o=new HashMap();
        o.put("datemap",map);
        pdfout(o);
    }
}

