package dbw.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExeclUtil {

	public static Workbook createExecl(String pathname) throws IOException {
		if (null == pathname) {
			return null;
		}
		Workbook wb = null;
		if (pathname.endsWith("xls")) {
			wb = new HSSFWorkbook();
		}
		else if (pathname.endsWith("xlsx")) {
			wb = new XSSFWorkbook();
		}
		else {
			System.out.println("create execl error: name error:" + pathname);
			return null;
		}
	    return wb;
	}
	
	public static Workbook openExecl(String pathname) throws InvalidFormatException, IOException {
		if (null == pathname) {
			return null;
		}
		return WorkbookFactory.create(new File(pathname));
	}
	
	public static ArrayList<Row> readExeclRows(Workbook wb, String sheetName, int firstRow) {
		if ((null == wb) || (null == sheetName)) {
			return null;
		}
		if (firstRow < 0) {
			return null;
		}
		
		ArrayList<Row> rows = null;
		Sheet sheet = wb.getSheet(sheetName);
		if (null == sheet) {
			return null;
		}
		int row1 = firstRow;//>sheet.getFirstRowNum()?firstRow:sheet.getFirstRowNum();
		int row2 = sheet.getLastRowNum()-2;
		for (int i=row1; i<row2; i++) {
			if (null == rows) {
				rows = new ArrayList<Row>(1);
			}
			rows.add(sheet.getRow(i));
		}
		
		return rows;		
	}
	
	public static Row readExeclRow(Workbook wb, String sheetName, int rownum) {
		if (null == wb) {
			return null;
		}
		Sheet sheet = wb.getSheet(sheetName);
		if (null == sheet) {
			return null;
		}
		return sheet.getRow(rownum);
	}
	
	public static Cell readExeclCell(Sheet sheet, int rownum, int column) {
		if (null == sheet) {
			return null;
		}
		return (null == sheet.getRow(rownum)?null:sheet.getRow(rownum).getCell(column));
	}
	public static Cell readExeclCell(Workbook wb, String sheetName, int rownum, int column) {
		if (null == wb) {
			return null;
		}

		Sheet sheet = wb.getSheet(sheetName);
		if (null == sheet) {
			return null;
		}
		return readExeclCell(sheet, rownum, column);
	}
	
	
	public static boolean writeExeclCell(Workbook wb, String sheetName, int rownum, int column, String value) {
		if ((null == wb) || (null == sheetName)) {
			return false;
		}
		
		Sheet sheet = null;
		Row row = null;
		Cell cell = null;
		
		if (null == wb.getSheet(WorkbookUtil.createSafeSheetName(sheetName))) {
			sheet = wb.createSheet(WorkbookUtil.createSafeSheetName(sheetName));			
		}
		if (null == sheet.getRow(rownum)) {
			row = sheet.createRow(rownum);
		}
		if (null == row.getCell(column)) {
			cell = row.createCell(column);
		}
		cell.setCellValue(value);
		
		return true;
	}
	
	
	public static void main(String[] arg0) {
		String pathname = "C:\\Users\\Administrator\\Desktop\\test.xlsx";
		try {
			Workbook wb = ExeclUtil.openExecl(pathname);
			Cell c = ExeclUtil.readExeclCell(wb, "sheet1", 0, 1);
			if (null != c) {
				System.out.println(c.getStringCellValue());
			}
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
