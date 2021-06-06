package com.wangwei.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: wangwei
 * @date: 2019-07-07 00:45
 * PDF中设置样式/格式化输出，输出中文内容，必须引入itext-asian.jar
 */
public class Demo5 {
    public static void main(String[] args) throws DocumentException, IOException {
        //创建文件
        Document document = new Document();
        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/H__D/Desktop/test6.pdf"));
        //打开文件
        document.open();

        //中文字体,解决中文不能显示问题
        BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);

        //蓝色字体
        Font blueFont = new Font(bfChinese);
        blueFont.setColor(BaseColor.BLUE);
        //段落文本
        Paragraph paragraphBlue = new Paragraph("paragraphOne blue front", blueFont);
        document.add(paragraphBlue);

        //绿色字体
        Font greenFont = new Font(bfChinese);
        greenFont.setColor(BaseColor.GREEN);
        //创建章节
        Paragraph chapterTitle = new Paragraph("段落标题xxxx", greenFont);
        Chapter chapter1 = new Chapter(chapterTitle, 1);
        chapter1.setNumberDepth(0);

        Paragraph sectionTitle = new Paragraph("部分标题", greenFont);
        Section section1 = chapter1.addSection(sectionTitle);

        Paragraph sectionContent = new Paragraph("部分内容", blueFont);
        section1.add(sectionContent);

        //将章节添加到文章中
        document.add(chapter1);

        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }
}
