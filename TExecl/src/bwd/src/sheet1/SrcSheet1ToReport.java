package bwd.src.sheet1;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import bwd.param.Param;
import bwd.util.ExcelException;
import bwd.util.ExcelUtil;

public class SrcSheet1ToReport {

	private Report report = null;
	
	public SrcSheet1ToReport(Sheet srcSheet) throws ExcelException {
		if (null == report) {
			this.report = this.parseSrcSheet1(srcSheet);
		}
	}
	
	/**
	 * @return the report
	 */
	public Report getReport() {
		return report;
	}

	/**
	 * @param report the report to set
	 */
	public void setReport(Report report) {
		this.report = report;
	}

	private Report parseSrcSheet1(Sheet srcSheet) throws ExcelException {
		
		ArrayList<Row> rows = ExcelUtil.readRows(srcSheet, Param.FIRSTROW, 
													srcSheet.getLastRowNum()+Param.LASTROW);
		if (null == rows) {
			return null;
		}
		
		Report sheet1 = new Report();
		for (Row row : rows) {
			sheet1.addItem(parseRow(row));
		}
		
		return sheet1;
	}
	private ServiceItem parseRow(Row row) throws ExcelException {
		if (null == row) {
			throw new NullPointerException();
		}
		ServiceItem item = new ServiceItem();
		
		item.setSubcompany(SubCompanyEnum.getEnum((String)ExcelUtil.getCellValue(row, 0)));
		item.setServiceType(ServiceTypeEnum.getEnum((String)ExcelUtil.getCellValue(row, 1)));
		item.setPay(PayEnum.getEnum((String)ExcelUtil.getCellValue(row, 2)));
		item.setProductName(String.valueOf(ExcelUtil.getCellValue(row, 3)));
		// 订购次数
		item.setSubscribeNum((Double)ExcelUtil.getCellValue(row, 4));
		item.setDeleteNum((Double)ExcelUtil.getCellValue(row, 5));
		item.setIncreaseNum((Double)ExcelUtil.getCellValue(row, 6));
		// 订购终端
		item.setSubscribeTerminalNum((Double)ExcelUtil.getCellValue(row, 7));
		item.setDeleteTerminalNum((Double)ExcelUtil.getCellValue(row, 8));
		item.setIncreaseTerminalNum((Double)ExcelUtil.getCellValue(row, 9));
		item.setIncreaseCycleTerminalNum((Double)ExcelUtil.getCellValue(row, 10));
		// 点播情况
		item.setRequestNum((Double)ExcelUtil.getCellValue(row, 11));
		item.setRequestTerminalNum((Double)ExcelUtil.getCellValue(row, 12));
		// 在订情况
		item.setSubscribeLastCycleEndNum((Double)ExcelUtil.getCellValue(row, 13));
		item.setSubscribeCycleEndNum((Double)ExcelUtil.getCellValue(row, 14));
		item.setIncreaseCycleNum((Double)ExcelUtil.getCellValue(row, 15));
		
		return item;
	}

}