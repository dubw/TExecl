package bwd.sheet1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import bwd.interfaces.IfSheet1;
import bwd.src.sheet1.PayEnum;
import bwd.src.sheet1.Report;
import bwd.src.sheet1.ServiceItem;
import bwd.src.sheet1.ServiceTypeEnum;
import bwd.src.sheet1.SubCompanyEnum;
import bwd.util.ExeclException;
import bwd.util.ExeclUtil;

public class SrcSheet1ToReport {

	private Report report = null;
	
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

	public SrcSheet1ToReport(Sheet srcSheet) throws ExeclException {
		if (null == this.report) {
			this.report = this.parseSrcSheet1(srcSheet);
		}
	}
	
	private Report parseSrcSheet1(Sheet srcSheet) throws ExeclException {
		if (null == srcSheet) {
			return null;
		}
		
		ArrayList<Row> rows = ExeclUtil.readRows(srcSheet, IfSheet1.getFirstrow(), 
							IfSheet1.getLastrow()<=0?srcSheet.getLastRowNum()+IfSheet1.getLastrow():IfSheet1.getLastrow());
		if (null == rows) {
			return null;
		}
		
		Report sheet1 = new Report();
		for (Row row : rows) {
			sheet1.addItem(parseRow(row));
		}
		
		return sheet1;
	}
	private ServiceItem parseRow(Row row) throws ExeclException {
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

}