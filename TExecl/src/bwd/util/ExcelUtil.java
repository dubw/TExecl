package bwd.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bwd.param.Sheet1Param;

/**
 * 包含所有使用的Excel工具
 * @author dbw
 *
 */
public class ExcelUtil {

	/**
	 * 只用于创建Excel表格
	 * @param pathname 全路径名,应该以'.xls'或者'.xlsx'结尾
	 * @return 返回创建的Excel对象wb
	 * @throws ExcelException
	 */
	public static Workbook createExcel(String pathname) throws ExcelException {
		if (null == pathname) {
			throw new ExcelException("请输入待创建Excel表格的路径名！");
		}
		Workbook wb = null;
		
		if (pathname.endsWith("xls")) {
			wb = new HSSFWorkbook();
		}
		else if (pathname.endsWith("xlsx")) {
			wb = new XSSFWorkbook();
		}
		else {
			throw new ExcelException("路径后缀名错误，必须以'.xls'或者'.xlsx'结尾！");
		}
		
	    return wb;
	}
	
	/**
	 * 用于打开一个已经存在且可读的文件
	 * @param pathname 全路径名,应该以'.xls'或者'.xlsx'结尾
	 * @return 返回已读取的Excel对象wb
	 * @throws InvalidFormatException
	 * @throws IOException
	 * @throws ExcelException 
	 * @throws FileNotFoundException
	 */
	public static Workbook openExcel(String pathname) throws InvalidFormatException, IOException, ExcelException {
		if (null == pathname) {
			throw new ExcelException("没有输入文件路径名！");
		}

		return WorkbookFactory.create(new File(pathname));
	}
	
	/**
	 * 读取sheet页面中从 firstrow 行到  lastrow 行的数据
	 * @param sheet 读取数据的sheet页面句柄
	 * @param firstrow 起始读取行
	 * @param lastrow 最后读取行
	 * @return 返回读取的所有行的数据
	 * @throws ExcelException
	 */
	public static ArrayList<Row> readRows(Sheet sheet, int firstrow, int lastrow) throws ExcelException {
		if (null == sheet) {
			return null;
		}
		if ((firstrow < 0) || (firstrow > lastrow)) {
			throw new ExcelException("读取sheet:"+sheet.getSheetName()+" 页面行数错误!\n"
										+ "第一行:" + firstrow + "\n"
										+ "最后一行:" + lastrow);
		}
		
		ArrayList<Row> rows = new ArrayList<Row>(1);
		for (int i=firstrow; i<=lastrow; i++) {
			rows.add(sheet.getRow(i));
		}

		return rows;
	}
	
	public static Object getCellValue(Row row, int column) throws ExcelException {
		if (null == row) {
			return null;
		}
		
		if ((column<Sheet1Param.getFirstcolumn()) || (column>Sheet1Param.getLastcolumn())) {
			throw new ExcelException("列数出错!\n第一列:" + Sheet1Param.getFirstcolumn()+1 
										+ "\n最后一列:" + Sheet1Param.getLastcolumn() + "\n");
		}
		Object o = null;
		
		Cell cell = row.getCell(column);
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING: {
				String s = cell.getRichStringCellValue().getString();
				if (s.equals("/")) {
					o = (Double)0.0;
				}
				else {
					o = s;
				}
				break;
			}
			case Cell.CELL_TYPE_NUMERIC: {
				if (DateUtil.isCellDateFormatted(cell)) {
	                o = cell.getDateCellValue();
	            } else {
	                o = cell.getNumericCellValue();
	            }
	            break;
			}
			case Cell.CELL_TYPE_BOOLEAN: {
				o = cell.getBooleanCellValue();
				break;
			}
			case Cell.CELL_TYPE_FORMULA: {
				o = cell.getCellFormula();
				break;
			}
			case Cell.CELL_TYPE_BLANK: {
				o = "";
				break;
			}
			default: {
				return null;
			}
		}
		
		return o;
	}

}
