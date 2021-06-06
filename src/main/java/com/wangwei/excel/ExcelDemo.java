package com.wangwei.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @Author wangwei
 * @Date 2020/4/21 11:07 上午
 * @Version 1.0
 */
public class ExcelDemo {
    private static final String[] tableHeaders = {"借款人姓名", "身份证号", "手机号码", "借据号码", "保额", "剩余本金", "利息", "罚息", "合同金额", "还款日期"};
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet0");
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < tableHeaders.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(tableHeaders[i]);
        }
        for (int i = 0; i < 100; i++) {
            XSSFRow sheetRow = sheet.createRow(i + 1);
            for (int x = 0; x < tableHeaders.length; x++) {
                sheetRow.createCell(x).setCellValue(i);
            }
        }
        FileOutputStream fos = new FileOutputStream("TBQD_" + LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE) + "_01_" + row.getRowNum() + ".xlsx");
        workbook.write(fos);
        fos.close();
    }
}
