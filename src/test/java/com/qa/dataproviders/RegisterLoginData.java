package com.qa.dataproviders;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class RegisterLoginData {


    private FileInputStream fs = new FileInputStream("./src/test/resources/TestData/TestData.xlsx");
   XSSFWorkbook workbook;


    public RegisterLoginData() throws IOException {

    }

    public static void main(String[] args) throws IOException {
        RegisterLoginData obj = new RegisterLoginData();
        obj.getTestData();

    }

    @DataProvider(name="RegisterDataLogin")
    public Object[][] getTestData() throws IOException {
        workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("data");
        int rowCount = sheet.getPhysicalNumberOfRows();
        int cellCount = sheet.getRow(1).getLastCellNum();
        System.out.println("Row Count:" + rowCount);
        System.out.println("Cell Count:" + cellCount);

        Object[][] objData = new Object[rowCount-1][cellCount];
        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < cellCount; j++) {
                objData[i-1][j] = sheet.getRow(i).getCell(j).toString();
                //  System.out.println(objData[i][j]);
                //  }
            }
        }
        return objData;
    }

}
