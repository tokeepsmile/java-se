package com.wangwei.pdf;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @Author wangwei
 * @Date 2020/5/12 4:23 下午
 * @Version 1.0
 */

public class ColumnWidthExampleDemo {

    public static final String DEST = "/Users/wangwei/opt/test/pdf/demo/test/column_width_example_demo.pdf";
    public static final String RESOURCE = "/Users/wangwei/Desktop/logo.png";
    public static void main(String[] args) throws Exception{
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ColumnWidthExampleDemo().createPdf(DEST);
    }

    public void createPdf(String dest) throws Exception {
        Document document = new Document(PageSize.A4, 30, 30, 30, 30);
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        Image img = Image.getInstance(RESOURCE);
        img.setAlignment(Element.ALIGN_LEFT);
        document.add(img);
        Paragraph p = new Paragraph("索赔清单", new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED), 22));
        p.setAlignment(Element.ALIGN_CENTER);
        p.setSpacingAfter(5);
        p.setSpacingBefore(5);
        document.add(p);
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss"));
        Paragraph pTime = new Paragraph("Time:" + date, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
        pTime.setAlignment(Element.ALIGN_RIGHT);
        pTime.setSpacingAfter(5);
        document.add(pTime);
        p.setAlignment(Element.ALIGN_CENTER);
        // 索赔清单
        String[] claimHeader = { "保单号", "借款人姓名", "身份证号", "手机号码",
                "贷款合同号", "本金投放比例", "贷款发放日", "贷款到期日", "贷款期限", "逾期天数", "索赔本金",
                "索赔罚息", "索赔利息", "索赔金额合计"};

        for (int i = 0; i < 10; i++) {
            Font f = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
            PdfPTable table = createTable();
            addTableHeader(table, ArrayUtils.subarray(claimHeader, 0, 4), null);
            for (int i1 = 0; i1 < 4; i1++) {
                PdfPCell cell;
                switch (i1){
                    case 0:
                        customCell(table, f, "poicc1292572957295259575957");
                        break;
                    case 1:
                        customCell(table,null, "王伟");
                        break;
                    case 2:
                        customCell(table,f, "341225199988888818");
                        break;
                    case 3:
                        customCell(table,f, "18701608711");
                        break;
                    default:
                        break;
                }
            }
            for (String s : ArrayUtils.subarray(claimHeader, 4, 6)) {
                PdfPCell cell = new PdfPCell(new Phrase(s, f));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setColspan(2);
                cell.setFixedHeight(30);
                table.addCell(cell);
            }
            for (int i1 = 0; i1 < 2; i1++) {
                PdfPCell cell = new PdfPCell(new Phrase("dxm028505026868206868268062088", f));
                cell.setColspan(2);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setFixedHeight(30);
                table.addCell(cell);
            }
            addTableHeader(table, ArrayUtils.subarray(claimHeader, 6, 10), null);
            for (int i1 = 0; i1 < 4; i1++) {
                PdfPCell cell = new PdfPCell(new Phrase("20200521", f));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setFixedHeight(30);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);
            }
           addTableHeader(table, ArrayUtils.subarray(claimHeader, 10, claimHeader.length), null);
            for (int i1 = 0; i1 < 4; i1++) {
                PdfPCell cell = new PdfPCell(new Phrase("20200521", f));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setFixedHeight(30);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);
            }

            PdfPCell cell = new PdfPCell();
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setColspan(4);
            cell.setFixedHeight(30);
            table.addCell(cell);
            table.setSpacingAfter(30);
            document.add(table);
        }
        document.newPage();
        Paragraph loanP = new Paragraph("附件一:放款流水", new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED), 18));
        p.setAlignment(Element.ALIGN_LEFT);
        //loanP.setSpacingAfter(30);
        //loanP.setSpacingBefore(30);
        document.add(loanP);
        String[] loanRowHeaders = {"借据号", "姓名", "身份证号", "手机号码", "放款日期", "放款时间", "起息日", "到期日", "贷款期限"};
        PdfPTable loanTable = new PdfPTable(loanRowHeaders.length);
        loanTable.setWidthPercentage(100);
        loanTable.getDefaultCell().setUseAscender(true);
        loanTable.getDefaultCell().setUseDescender(true);
        Font f = new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED), 11);
        for (String s : loanRowHeaders) {
            PdfPCell cell = new PdfPCell(new Phrase(s, f));
            cell.setBackgroundColor(new GrayColor(0.75f));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(1);
            loanTable.addCell(cell);
        }
        loanTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        for (int i = 0; i < 1000; i++) {
            loanTable.addCell(String.valueOf(i));
            loanTable.addCell(String.valueOf(i));
            loanTable.addCell(String.valueOf(i));
            loanTable.addCell(String.valueOf(i));
            loanTable.addCell(String.valueOf(i));
            loanTable.addCell(String.valueOf(i));
            loanTable.addCell(String.valueOf(i));
            loanTable.addCell(String.valueOf(i));
            loanTable.addCell(String.valueOf(i));
        }
        document.add(loanTable);
        document.close();
        addWaterMark(dest);
    }

    public void addWaterMark(String src) throws Exception {
        PdfReader reader = new PdfReader(src);
        int pages = reader.getNumberOfPages();
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("/Users/wangwei/opt/test/pdf/demo/waterMark/spqd.pdf"));
        stamper.setRotateContents(false);
        Font font = customFont(108);
        Phrase phrase = new Phrase("昆 仑 银 行", font);
        PdfGState gs1 = new PdfGState();
        gs1.setFillOpacity(0.075f);
        PdfContentByte over;
        Rectangle pagesize;
        float x, y;
        for (int i = 1; i <= pages; i++) {
            pagesize = reader.getPageSize(i);
            x = (pagesize.getLeft() + pagesize.getRight()) / 2;
            y = (pagesize.getTop() + pagesize.getBottom()) / 2;
            //over = stamper.getOverContent(i);
            over = stamper.getUnderContent(i);
            over.saveState();
            over.setGState(gs1);
            ColumnText.showTextAligned(over, Element.ALIGN_CENTER, phrase, x, y, 30);
            over.restoreState();
        }
        stamper.close();
        reader.close();
    }

    private Font customFont(float size) throws Exception {
        return new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED), size);
    }

    private void addTableHeader(PdfPTable table, String[] header, Font font) throws Exception {
        if (Objects.isNull(font)) {
            font = new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED), 11);
        }
        for (String s : header) {
            PdfPCell cell = new PdfPCell(new Phrase(s, font));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setFixedHeight(30);
            table.addCell(cell);
        }
    }

    private PdfPTable createTable() throws Exception{
        float[] columnWidths = {5, 5, 5, 5};
        PdfPTable table = new PdfPTable(columnWidths);
        table.setWidthPercentage(100);
        table.getDefaultCell().setUseAscender(true);
        table.getDefaultCell().setUseDescender(true);
        Font f = new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED), 11);
        f.setColor(BaseColor.WHITE);
        f.setStyle(Font.BOLDITALIC);
        PdfPCell headerCell = new PdfPCell(new Phrase("信息概要", f));
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        headerCell.setColspan(columnWidths.length);
        headerCell.setFixedHeight(30);
        headerCell.setBackgroundColor(BaseColor.LIGHT_GRAY );
        table.addCell(headerCell);
        return table;
    }

    private void customCell(PdfPTable table, Font font, String content) throws IOException, DocumentException {
        if (Objects.isNull(font)) {
            font = new Font(BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED), 11);
        }
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setFixedHeight(30);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
    }
}
