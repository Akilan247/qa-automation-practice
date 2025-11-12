package ExcelHandling;

import org.apache.poi.xssf.usermodel.*;
import java.io.*;
import java.util.Arrays;

public class ExcelTablePrinter {
    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream("D:\\Automation-testing\\test-data\\data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("sheet1");

        int totalRows = sheet.getLastRowNum();
        int totalCols = sheet.getRow(0).getLastCellNum();

        int[] colWidths = new int[totalCols];
        for (int i = 0; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                XSSFCell cell = sheet.getRow(i).getCell(j);
                String value = (cell == null) ? "" : cell.toString();
                colWidths[j] = Math.max(colWidths[j], value.length());
            }
        }

        System.out.println(Arrays.toString(colWidths));

        StringBuilder border = new StringBuilder();
        for (int width : colWidths) {
            border.append("+").append("-".repeat(width + 2));
        }
        border.append("+");


        System.out.println(border);
        for (int j = 0; j < totalCols; j++) {
            String value = sheet.getRow(0).getCell(j).toString();
            System.out.printf("| %-"+colWidths[j]+"s ", value);
        }
        System.out.println("|");
        System.out.println(border);

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                XSSFCell cell = sheet.getRow(i).getCell(j);
                String value = (cell == null) ? "" : cell.toString();
                System.out.printf("| %-"+colWidths[j]+"s ", value);
            }
            System.out.println("|");
            System.out.println(border);
        }

        workbook.close();
        file.close();
    }
}
