package bwd.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import bwd.interfaces.IfSheet1;
import bwd.sheet1.Sheet1Action;
import bwd.src.sheet1.Report;
import bwd.util.ExeclException;
import bwd.util.ExeclUtil;

public class Action {

	public boolean action() throws ExeclException {
		Workbook srcwb = null;
		Workbook destwb = null;
		Sheet srcsheet = null;
		Sheet destsheet = null;
		try {
			srcwb = ExeclUtil.openExecl(IfSheet1.getSrcPathname());
			if (null == srcwb) {
				throw new ExeclException("打开execl文件失败！路径为:" + IfSheet1.getSrcPathname());
			}
			srcsheet = srcwb.getSheet(IfSheet1.getSheetname());
			if (null == srcsheet) {
				throw new ExeclException("打开sheet页面失败！页面名为:" + IfSheet1.getSheetname());
			}
			destwb = ExeclUtil.createExecl(IfSheet1.getDestPathname());
			if (null == destwb) {
				throw new ExeclException("创建execl文件失败！路径为:" + IfSheet1.getDestPathname());
			}
			destsheet = destwb.createSheet(IfSheet1.getDestSheetname());
			if (null == destsheet) {
				throw new ExeclException("创建sheet页面失败！页面名为:" + IfSheet1.getDestSheetname());
			}
			// 读取sheet页面，并生成对应的sheet页面
			Sheet1Action action = new Sheet1Action();
			Report report = action.parseSheet1(srcsheet);
			
			action.createOutSheet(destsheet, report);
			
			// 输出execl文件
			File file = new File(IfSheet1.getDestPathname());
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();		
			FileOutputStream fileOut = new FileOutputStream(file);

			destwb.write(fileOut);
			fileOut.close();
			System.out.println(IfSheet1.getDestPathname());
			
		} catch (InvalidFormatException | IOException e) {
			try {
				if (null != srcwb) {
					srcwb.close();
				}
				if (null != destwb) {
					destwb.close();
				} 
				return false;
			}catch (IOException e1) {
				return false;
			}
		}
		finally {
			try {
				if (null != srcwb) {
					srcwb.close();
				}
				if (null != destwb) {
					destwb.close();
				}
			}catch (IOException e1) {
				return true;
			}
		}
		
		return true;
	}	
	
	public static void main(String[] args) {
		String pathname = "C:\\Users\\Administrator\\Desktop\\3.171.xls";
		String sheetname = "Report";
		String destpathname = "C:\\Users\\Administrator\\Desktop\\3.xls";
		IfSheet1.setSrcPathname(pathname);
		IfSheet1.setSheetname(sheetname);
		IfSheet1.setDestPathname(destpathname);
		Action a = new Action();
		try {
			a.action();
		} catch (ExeclException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
