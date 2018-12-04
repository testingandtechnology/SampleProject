package utils.Excel;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import static com.esvconnect.qa.base.TestBase.testDataExcelFileName;

/**
 * C
 */
public class ExcelUtil {
    //Main Directory of the project
    public static final String currentDir = System.getProperty("user.dir");

    //Location of Test data excel file
    public static String testDataExcelPath = null;

    //Excel WorkBook
    private static XSSFWorkbook excelWBook;
    //Excel Sheet
    private static XSSFSheet excelWSheet;
    //Excel cell
    private static XSSFCell cell;
    //Excel row
    private static XSSFRow row;
    //Row Number
    public static int rowNumber;
    //Column Number
    public static int columnNumber;

    //Setter and Getters of row and columns
    public static void setRowNumber(int pRowNumber) {
        rowNumber = pRowNumber;
    }

    public static int getRowNumber() {
        return rowNumber;
    }

    public static void setColumnNumber(int pColumnNumber) {
        columnNumber = pColumnNumber;
    }

    public static int getColumnNumber() {
        return columnNumber;
    }

    // This method has two parameters: "Test data excel file name" and "Excel sheet name"
    // It creates FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.

    public static void setExcelFileSheet(String sheetName) {

        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(testDataExcelFileName);
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //This method reads the test data from the Excel cell.
    //We are passing row number and column number as parameters.

    public static String getCellData(int RowNum, int ColNum) {

        String cellData = new String();
        try {
             cell = excelWSheet.getRow(RowNum).getCell(ColNum);
             DataFormatter formatter = new DataFormatter();
             cellData = formatter.formatCellValue(cell);

        }catch (Exception e) {
             e.printStackTrace();
         }

         return cellData;
        }


    //This method takes row number as a parameter and returns the data of given row number.
    public static XSSFRow getRowData(int RowNum) {
        row = excelWSheet.getRow(RowNum);
        return row;
    }

    //This method gets excel file, row and column number and set a value to the that cell.
    public static void setCellData(String value, int RowNum, int ColNum) {
        try {
            row = excelWSheet.getRow(RowNum);
            cell = row.getCell(ColNum);
            if (cell == null) {
                cell = row.createCell(ColNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
            excelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}