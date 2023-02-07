package com.meli.qa.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static Object[][] readFile(String fileName, String sheetName) throws IOException {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheet(sheetName);
        int lastRowNum = sheet.getLastRowNum();
        int lastCellNum = sheet.getRow(0).getLastCellNum();

        Object[][] a = new Object[lastRowNum][lastCellNum];

        for (int i = 1; i <= lastRowNum; i++) {
            for (int j = 0; j < lastCellNum; j++) {
                a[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }

        return a;
    }
}
