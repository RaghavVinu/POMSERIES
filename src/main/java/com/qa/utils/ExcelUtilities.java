package com.qa.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtilities {


    private FileInputStream fs = new FileInputStream("./src/test/resources/TestData/TestData.xlsx");
   XSSFWorkbook workbook;


    public ExcelUtilities() throws IOException {

    }

    public static void main(String[] args) throws IOException {
        ExcelUtilities obj = new ExcelUtilities();
        obj.getTestData();

    }

    public void getTestData() throws IOException {
        workbook  = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("data");
        int rowCount = sheet.getLastRowNum();
        int cellCount = sheet.getRow(1).getLastCellNum();
        Object[][] objData = new Object[rowCount+1][cellCount+1];
        for(int i=0;i<=rowCount;i++){
            for(int j=0;j<cellCount;j++){
                objData[i][j] = sheet.getRow(i).getCell(j).toString();
                System.out.println(objData[i][j]);}
        }
    }



}
