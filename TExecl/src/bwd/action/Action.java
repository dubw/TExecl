package bwd.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import bwd.param.Param;
import bwd.src.sheet1.SrcSheet1ToDestSheet1;
import bwd.src.sheet1.SrcSheet1ToDestSheet2;
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
		Sheet srcSheet1 = null;
		Workbook destWb = null;
		FileOutputStream fileOut = null;
		
		try {
			try {
				srcWb = ExcelUtil.openExcel(Param.getSrcPathname());
			} catch (InvalidFormatException | IOException e) {
				throw new ExcelException("打开Excel文件失败！路径为:" + Param.getSrcPathname());
			}
			srcSheet1 = srcWb.getSheet(Param.getSrcSheet1Name());
			if (null == srcSheet1) {
				throw new ExcelException("打开sheet页面失败！页面名为:" + Param.getSrcSheet1Name());
			}
			// 创建生成的wb
			destWb = ExcelUtil.createExcel(Param.getDestPathname());
			if (null == destWb) {
				throw new ExcelException("创建Excel文件失败！路径为:" + Param.getDestPathname());
			}
			
			// 生成第一个sheet页
			generateDestSheet1(destWb, srcSheet1);
			
			// 生成第二个sheet页
			generateDestSheet2(destWb, srcSheet1);
			
			// 输出excel文件
			File file = new File(Param.getDestPathname());
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			fileOut = new FileOutputStream(file);
			destWb.write(fileOut);
			fileOut.close();
			System.out.println(Param.getDestPathname());	
		}
		catch (IOException e) {
			throw new ExcelException("读写文件I/O出问题，请查看是否有文件已经被打开！");
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
	 * @param destwb 目标workbook
	 * @param srcSheet 源数据存放的sheet
	 * @throws ExcelException
	 */
	private void generateDestSheet1(Workbook destwb, Sheet srcSheet) throws ExcelException {
		// 创建生成Excel的sheet1页面
		Sheet destsheet = destwb.createSheet(Param.getDestSheet1Name());
		if (null == destsheet) {
			throw new ExcelException("创建sheet页面失败！页面名为:" + Param.getDestSheet1Name());
		}
		ISrcSheet2DestSheet srcSheet1Adaptor = new SrcSheet1ToDestSheet1(srcSheet);
		srcSheet1Adaptor.fillOutSheet(destsheet);
	}

	/**
	 * 创建第一个sheet页面
	 * @param destwb 目标workbook
	 * @param srcSheet 源数据存放的sheet
	 * @throws ExcelException
	 */
	private void generateDestSheet2(Workbook destwb, Sheet srcSheet) throws ExcelException {
		// 创建生成Excel的sheet2页面
		Sheet destsheet = destwb.createSheet(Param.getDestSheet2Name());
		if (null == destsheet) {
			throw new ExcelException("创建sheet页面失败！页面名为:" + Param.getDestSheet2Name());
		}
		ISrcSheet2DestSheet srcSheet1Adaptor = new SrcSheet1ToDestSheet2(srcSheet);
		srcSheet1Adaptor.fillOutSheet(destsheet);
	}

}
