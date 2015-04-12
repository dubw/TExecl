package bwd.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import bwd.interfaces.Sheet1Param;
import bwd.sheet1.SrcSheet1ToDestSheet1;
import bwd.util.ExcelException;
import bwd.util.ExcelUtil;

/**
 * 所有转换数据的入口类
 * @author 杜宝伟
 *
 */
public class Action {

	/**
	 * 所有转换数据的入口方法
	 * @return
	 * @throws ExcelException
	 */
	public void action() throws ExcelException {
		Workbook srcWb = null;
		Sheet srcSheet = null;
		Workbook destWb = null;
		FileOutputStream fileOut = null;
		
		try {
			try {
				srcWb = ExcelUtil.openExcel(Sheet1Param.getSrcPathname());
			} catch (InvalidFormatException | IOException e) {
				throw new ExcelException("打开Excel文件失败！路径为:" + Sheet1Param.getSrcPathname());
			}
			srcSheet = srcWb.getSheet(Sheet1Param.getSheetname());
			if (null == srcSheet) {
				throw new ExcelException("打开sheet页面失败！页面名为:" + Sheet1Param.getSheetname());
			}
			// 创建生成的wb
			destWb = ExcelUtil.createExcel(Sheet1Param.getDestPathname());
			if (null == destWb) {
				throw new ExcelException("创建Excel文件失败！路径为:" + Sheet1Param.getDestPathname());
			}
			
			// 生成第一个sheet页
			generateDestSheet1(destWb, srcSheet);
			
			// 生成第二个sheet页
			// TODO
			
			// 输出excel文件
			File file = new File(Sheet1Param.getDestPathname());
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			fileOut = new FileOutputStream(file);
			destWb.write(fileOut);
			fileOut.close();
			System.out.println(Sheet1Param.getDestPathname());	
		}
		catch (IOException e) {
			throw new ExcelException("读写文件I/O出问题！");
		}
		finally {
			try {
				if (null != fileOut) {
					fileOut.close();
				}
				if (null != srcWb) {
					srcWb.close();
				}
				if (null != destWb) {
					destWb.close();
				}
			}catch (IOException e1) {
			}
		}
		
	}
	
	/**
	 * 创建第一个sheet页面
	 * @param destwb
	 * @throws ExcelException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws InvalidFormatException 
	 */
	private void generateDestSheet1(Workbook destwb, Sheet srcSheet) throws ExcelException {
		// 创建生成Excel的sheet1页面
		Sheet destsheet = destwb.createSheet(Sheet1Param.getDestSheetname());
		if (null == destsheet) {
			throw new ExcelException("创建sheet页面失败！页面名为:" + Sheet1Param.getDestSheetname());
		}
		SrcSheet1ToDestSheet1 srcSheet1Adaptor = new SrcSheet1ToDestSheet1(srcSheet);
		srcSheet1Adaptor.fillOutSheet(destsheet);
	}
	
	public static void main(String[] args) {
		String pathname = "C:\\Users\\Administrator\\Desktop\\3.171.xls";
		String sheetname = "Report";
		String destpathname = "C:\\Users\\Administrator\\Desktop\\3.xls";
		Sheet1Param.setSrcPathname(pathname);
		Sheet1Param.setSheetname(sheetname);
		Sheet1Param.setDestPathname(destpathname);
		Action a = new Action();
		try {
			a.action();
		} catch (ExcelException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
