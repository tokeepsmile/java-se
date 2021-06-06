package com.wangwei.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: wangwei
 * @date: 2019-07-05 16:20
 */
public class Demo2 {
    public static void main(String[] args) throws DocumentException, IOException {

        //创建文件
        Document document = new Document(PageSize.A4, 50, 50, 79, 50);
        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/Users/wangwei/opt/pdf/test5.pdf"));
        //打开文件
        document.open();
        //添加内容

        //图片1
        Image image1 = Image.getInstance("/Users/wangwei/Pictures/WechatIMG76.jpeg");
        //设置图片位置的x轴和y周
//        image1.setAbsolutePosition(0, 0);
        //设置图片的宽度和高度
        image1.scaleAbsolute(215, 22);
        //将图片1添加到pdf文件中
        document.add(image1);


        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }
}
