package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
    private static Workbook workbook;
    private static Sheet sheet;

    // Load Excel file and sheet
    public static void loadExcel(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException("Sheet '" + sheetName + "' not found in " + filePath);
        }
    }

    // Get data from specific cell
    public static String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            return "";
        }
        Cell cell = row.getCell(colNum);
        return (cell == null) ? "" : cell.toString();
    }

    // Get number of rows
    public static int getRowCount() {
        if (sheet == null) {
            throw new RuntimeException("Sheet not loaded! Please call loadExcel() first.");
        }
        return sheet.getPhysicalNumberOfRows();
    }
}
