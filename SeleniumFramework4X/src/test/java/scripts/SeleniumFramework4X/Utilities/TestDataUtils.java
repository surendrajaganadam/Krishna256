package scripts.SeleniumFramework4X.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import scripts.SeleniumFramework4X.Constants.Constants;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;

public class TestDataUtils {

	static String baseProfilePath=System.getProperty(Constants.USER_DIR);

//	static XSSFWorkbook workbook;

	

	public static String getCellData(String fileName,String sheetName, String colName, int rowNum) throws Exception
	{
		 FileInputStream fileInput = new FileInputStream(new File(fileName));
		 Workbook wb = WorkbookFactory.create(fileInput);
		 wb.getCreationHelper().createFormulaEvaluator().evaluateAll();
		 Sheet sheet = wb.getSheet(sheetName);
		 Row row = sheet.getRow(0);
		 short lastcolumnused = row.getLastCellNum();

		 int columnNumber = 0;
		 for (int i = 0; i < lastcolumnused; i++) {
		  if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
		 columnNumber = i;
		 break;
		  }
		 }

		 row = sheet.getRow(rowNum);
		 Cell column = row.getCell(columnNumber);
		 column.setCellType(Cell.CELL_TYPE_STRING);
		 
		 String CellValue = column.getStringCellValue();
		 fileInput.close();

		 return CellValue;	
	}
	
	
	
	
	private static XSSFSheet getSheetByName(String excelFilePath, String sheetName) throws Exception {
		XSSFSheet sheet = (XSSFSheet) getWorkBook(excelFilePath).getSheet(sheetName);
		return sheet;
		
	}
	
	private static Workbook getWorkBook(String excelFilePath) throws Exception {
		return WorkbookFactory.create(new File(excelFilePath));	
	}
	
	
	public static String getCellData(String fileName,String sheetName, int rowNum, String colName ) throws Exception{
		 FileInputStream fileInput = new FileInputStream(new File(fileName));
		 Workbook wb = WorkbookFactory.create(fileInput);
		 wb.getCreationHelper().createFormulaEvaluator().evaluateAll();
		 Sheet sheet = wb.getSheet(sheetName);
		 Row row = sheet.getRow(22);
		 short lastcolumnused = row.getLastCellNum();

		 int columnNumber = 0;
		 for (int i = 0; i < lastcolumnused; i++) {
		  if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
		columnNumber = i;
		 break;
		  }
		 }

		 row = sheet.getRow(rowNum);
		 Cell column = row.getCell(columnNumber);
		 String CellValue;
		 try {
		 column.setCellType(Cell.CELL_TYPE_STRING);
		 
		  CellValue = column.getStringCellValue();
			}catch(Throwable e) {
				double vl=column.getNumericCellValue();
				CellValue=Double.toString(vl);
			}

		 return CellValue;
		 	
	}

	public static boolean setCellData(String filePath, String sheetName, String colName, int rowNumber,String value) throws Exception, IOException {

		FileInputStream fileInput = new FileInputStream(new File(filePath));
		Workbook wb = WorkbookFactory.create(fileInput);
		Sheet sheet = wb.getSheet(sheetName);
		try {
			 Row row = sheet.getRow(0);
			 short lastcolumnused = row.getLastCellNum();

 int columnNumber = 0;
 for (int i = 0; i < lastcolumnused; i++) {
  if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
		 columnNumber = i;
  break;
  }
 }

			 
 row = sheet.getRow(rowNumber);
			 
 Cell cell = row.getCell(columnNumber);
			cell.setCellValue(value);

			FileOutputStream fos = new FileOutputStream(filePath);
				wb.write(fos);
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Override Method
	public static boolean setCellData(String filePath, String sheetName, int columnNumber, int rowNumber,Double value) throws Exception, IOException {

FileInputStream fileInput = new FileInputStream(new File(filePath));
 Workbook wb = WorkbookFactory.create(fileInput);
 Sheet sheet = wb.getSheet(sheetName);
		try {
			Row row = sheet.getRow(0);
			 short lastcolumnused = row.getLastCellNum();

			 
row = sheet.getRow(rowNumber);
			 
Cell cell = row.getCell(columnNumber);
			cell.setCellValue(value);

			FileOutputStream fos = new FileOutputStream(filePath);
				wb.write(fos);
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public static void createXLSFile(String filePath) {
		File excel = new File(filePath);
		if (!excel.exists()) {
			try {
				excel.createNewFile();
			} catch (IOException e) {
				System.out.println("Failed to create new file, \n" + e.getMessage());
			}
		}
	}
	
	public static int getLastRowNumber(String filePath, String sheetName) throws Exception, InvalidFormatException, IOException {
		 FileInputStream fileInput = new FileInputStream(new File(filePath));
Workbook wb = WorkbookFactory.create(fileInput);
Sheet sheet = wb.getSheet(sheetName);
return sheet.getLastRowNum();
	}
	
	public static int getFirstRowNumber(String filePath, String sheetName) throws Exception, InvalidFormatException, IOException {
		 FileInputStream fileInput = new FileInputStream(new File(filePath));
Workbook wb = WorkbookFactory.create(fileInput);
Sheet sheet = wb.getSheet(sheetName);
return sheet.getFirstRowNum();
	}


}