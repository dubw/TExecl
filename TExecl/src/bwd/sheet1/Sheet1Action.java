package bwd.sheet1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import bwd.dest.sheet1.OutServiceTypeEnum;
import bwd.dest.sheet1.OutSheet1;
import bwd.interfaces.IfSheet1;
import bwd.src.sheet1.PayEnum;
import bwd.src.sheet1.ServiceTypeEnum;
import bwd.src.sheet1.ServiceItem;
import bwd.src.sheet1.Report;
import bwd.src.sheet1.SubCompanyEnum;
import bwd.util.ExeclException;
import bwd.util.ExeclUtil;

public class Sheet1Action {

	public Report parseSheet1(Sheet sheet) throws InvalidFormatException, FileNotFoundException, IOException, ExeclException {
		if (null == sheet) {
			return null;
		}
		
		ArrayList<Row> rows = ExeclUtil.readRows(sheet, IfSheet1.getFirstrow(), 
							IfSheet1.getLastrow()<=0?sheet.getLastRowNum()+IfSheet1.getLastrow():IfSheet1.getLastrow());
		if (null == rows) {
			return null;
		}
		
		Report sheet1 = new Report();
		for (Row row : rows) {
			sheet1.addItem(parseRow(row));
		}
		
		return sheet1;
	}
	
	public ServiceItem parseRow(Row row) throws ExeclException {
		if (null == row) {
			return null;
		}
		ServiceItem item = new ServiceItem();
		
		item.setSubcompany(SubCompanyEnum.getEnum((String)ExeclUtil.getCellValue(row, 0)));
		item.setServiceType(ServiceTypeEnum.getEnum((String)ExeclUtil.getCellValue(row, 1)));
		item.setPay(PayEnum.getEnum((String)ExeclUtil.getCellValue(row, 2)));
		item.setProductName(String.valueOf(ExeclUtil.getCellValue(row, 3)));
		// 订购次数
		item.setSubscribeNum((Double)ExeclUtil.getCellValue(row, 4));
		item.setDeleteNum((Double)ExeclUtil.getCellValue(row, 5));
		item.setIncreaseNum((Double)ExeclUtil.getCellValue(row, 6));
		// 订购终端
		item.setSubscribeTerminalNum((Double)ExeclUtil.getCellValue(row, 7));
		item.setDeleteTerminalNum((Double)ExeclUtil.getCellValue(row, 8));
		item.setIncreaseTerminalNum((Double)ExeclUtil.getCellValue(row, 9));
		item.setIncreaseCycleTerminalNum((Double)ExeclUtil.getCellValue(row, 10));
		// 点播情况
		item.setRequestNum((Double)ExeclUtil.getCellValue(row, 11));
		item.setRequestTerminalNum((Double)ExeclUtil.getCellValue(row, 12));
		// 在订情况
		item.setSubscribeLastCycleEndNum((Double)ExeclUtil.getCellValue(row, 13));
		item.setSubscribeCycleEndNum((Double)ExeclUtil.getCellValue(row, 14));
		item.setIncreaseCycleNum((Double)ExeclUtil.getCellValue(row, 15));
		
		return item;
	}
	
	private void setMainTitle(Row row) {
		row.createCell(1).setCellValue("订购次数（个)");
//		row.getCell(1).setCellType(CellStyle.ALIGN_CENTER);
		row.getSheet().addMergedRegion(new CellRangeAddress(0, 0, 1, 3));
		row.createCell(4).setCellValue("净增量（终端）");
//		row.getCell(4).setCellType(CellStyle.ALIGN_CENTER);
		row.getSheet().addMergedRegion(new CellRangeAddress(0, 0, 4, 6));
		row.createCell(7).setCellValue("在订用户（终端）");
//		row.getCell(7).setCellType(CellStyle.ALIGN_CENTER);
		row.getSheet().addMergedRegion(new CellRangeAddress(0, 0, 7, 9));
		row.createCell(10).setCellValue("应收收入（元）");
		row.getSheet().addMergedRegion(new CellRangeAddress(0, 0, 10, 12));
//		row.getCell(10).setCellType(CellStyle.ALIGN_CENTER);
	}
	private void setSubTitle(Row row) {
		row.createCell(1).setCellValue("南京市");
		row.createCell(2).setCellValue("南京区县");
		row.createCell(3).setCellValue("地市公司");
		row.createCell(4).setCellValue("南京市");
		row.createCell(5).setCellValue("南京区县");
		row.createCell(6).setCellValue("地市公司");
		row.createCell(7).setCellValue("南京市");
		row.createCell(8).setCellValue("南京区县");
		row.createCell(9).setCellValue("地市公司");
		row.createCell(10).setCellValue("南京市");
		row.createCell(11).setCellValue("南京区县");
		row.createCell(12).setCellValue("地市公司");		
	}
	private void setLineData(Row row, OutSheet1 out, OutServiceTypeEnum type) {
		// 名称
		row.createCell(0).setCellValue(type.getServiceName());
		// 订购次数：南京
		row.createCell(1).setCellValue(out.getNjMap().get(type)==null?0.0:out.getNjMap().get(type));
		// 订购次数：南京县区
		row.createCell(2).setCellValue(out.getNjExMap().get(type)==null?0.0:out.getNjExMap().get(type));
		// 订购次数：地市公司
		row.createCell(3).setCellValue(out.getOtherMap().get(type)==null?0.0:out.getOtherMap().get(type));
		// 净增量
		row.createCell(4).setCellValue(out.getNjTerminalMap().get(type)==null?0.0:out.getNjTerminalMap().get(type));
		row.createCell(5).setCellValue(out.getNjExTerminalMap().get(type)==null?0.0:out.getNjExTerminalMap().get(type));
		row.createCell(6).setCellValue(out.getOtherTerminalMap().get(type)==null?0.0:out.getOtherTerminalMap().get(type));
		// 在订用户（终端）
		row.createCell(7).setCellValue(out.getNjUserMap().get(type)==null?0.0:out.getNjUserMap().get(type));
		row.createCell(8).setCellValue(out.getNjExUserMap().get(type)==null?0.0:out.getNjExUserMap().get(type));
		row.createCell(9).setCellValue(out.getOtherUserMap().get(type)==null?0.0:out.getOtherUserMap().get(type));
		// 应收收入
		row.createCell(10).setCellValue(out.getNjIncomeMap().get(type)==null?0.0:out.getNjIncomeMap().get(type));
		row.createCell(11).setCellValue(out.getNjExIncomeMap().get(type)==null?0.0:out.getNjExIncomeMap().get(type));
		row.createCell(12).setCellValue(out.getOtherIncomeMap().get(type)==null?0.0:out.getOtherIncomeMap().get(type));
	}
	
	public boolean createOutSheet(Sheet sheet, Report srcSheet) {
		if ((null == sheet) || (null == srcSheet) || (null == srcSheet.getItems())) {
			return false;
		}
		int rownum = 0;
		// 添加主列表标题
		Row rowTitle = sheet.createRow(rownum++);
		setMainTitle(rowTitle);
		// 添加子列表标题
		Row rowSubTitle = sheet.createRow(rownum++);
		setSubTitle(rowSubTitle);
		// 添加数据
		OutSheet1 out = new OutSheet1();
		out.parseServiceItem2Out(srcSheet);
		for (OutServiceTypeEnum serviceType : OutServiceTypeEnum.values()) {
			Row row = sheet.createRow(rownum++);
			setLineData(row, out, serviceType);
		}

		return true;
	}

//	public Sheet action(Sheet srcSheet, Sheet destSheet) throws InvalidFormatException, FileNotFoundException, IOException, ExeclException {
//		if (null == srcSheet) {
//			return null;
//		}
//		Report src = parseSheet1(srcSheet);
//		if (null == src.getItems()) {
//			return null;
//		}
//		
//		createOutSheet(destSheet, src);
//		
//		return destSheet;
//	}


	
}
