package com.wangwei.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangwei
 * @date: 2019-07-01 15:59
 */
public class CsvFileWriter {

    private static final String NEW_LINE_SEPARATOR = "\n";

    public static void writeCsvFile(String fileName, Object[] fileHeader, List<LpqdSum> list) {

        //Create new students objects
//        Student student1 = new Student(18, "laka", "女");
//        Student student2 = new Student(3, "lisi", "男");
//        Student student3 = new Student(21, "xiaobing", "女");
//        Student student4 = new Student(32, "feila", "男");
//        Student student5 = new Student(28, "aifei", "女");
//        Student student6 = new Student(16, "Ahmed", "女");


        //Create a new list of student objects
//        List<Student> students = new ArrayList();
//        students.add(student1);
//        students.add(student2);
//        students.add(student3);
//        students.add(student4);
//        students.add(student5);
//        students.add(student6);

        FileWriter fileWriter = null;

        CSVPrinter csvFilePrinter = null;

        //Create the CSVFormat object with "\n" as a record delimiter
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

        try {

            //initialize FileWriter object
            fileWriter = new FileWriter(fileName);

            //initialize CSVPrinter object
            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);

            //Create CSV file header
            csvFilePrinter.printRecord(fileHeader);

            //Write a new student object list to the CSV file
            for (LpqdSum lpqdSum : list) {
                List<String> lpqdSumDataRecord = new ArrayList<>();
                lpqdSumDataRecord.add(lpqdSum.getClaimDate());
                lpqdSumDataRecord.add(lpqdSum.getClaimAmount());
                lpqdSumDataRecord.add(lpqdSum.getClaimPaymentDate());
                lpqdSumDataRecord.add(lpqdSum.getClaimSum());
                lpqdSumDataRecord.add(lpqdSum.getDeductionAmount());
                lpqdSumDataRecord.add(lpqdSum.getBalanceClaimAmount());
                csvFilePrinter.printRecord(lpqdSumDataRecord);
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvFilePrinter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                e.printStackTrace();
            }
        }
    }
}
