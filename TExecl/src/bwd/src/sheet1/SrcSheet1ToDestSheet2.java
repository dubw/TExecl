package bwd.src.sheet1;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import bwd.action.ISrcSheet2DestSheet;
import bwd.dest.sheet.OutSheet2;
import bwd.dest.sheet.OutSheet2Item;
import bwd.dest.sheet.OutSheet2SubCompanyEnum;
import bwd.util.ExcelException;

public class SrcSheet1ToDestSheet2 implements ISrcSheet2DestSheet{

	SrcSheet1ToReport src2report;

	public SrcSheet1ToDestSheet2(Sheet srcSheet) throws ExcelException {
		src2report = new SrcSheet1ToReport(srcSheet);
	}

	@Override
	public void fillOutSheet(Sheet destSheet) throws ExcelException {
		int rownum = 0;
		// 添加主列表标题
		Row row = destSheet.createRow(rownum++);
		setFormTitle(row);
		// 添加数据
		OutSheet2 out2 = parseReport2OutSheet2();
		for (OutSheet2SubCompanyEnum e : OutSheet2SubCompanyEnum.values()) {
			row = destSheet.createRow(rownum++);
			if ("南京分公司".equals(e.toString())) {
				row.createCell(1).setCellValue("南京地区");
				row.getSheet().addMergedRegion(new CellRangeAddress(1, 8, 1, 1));
				row.createCell(9).setCellFormula("SUM(I2:I9)");
				row.getSheet().addMergedRegion(new CellRangeAddress(1, 8, 9, 9));
				// 备注
				row.getSheet().addMergedRegion(new CellRangeAddress(1, 18, 10, 10));
			}
			else if ("泰州分公司".equals(e.toString())) {
				row.createCell(1).setCellValue("地市公司");
				row.getSheet().addMergedRegion(new CellRangeAddress(9, 17, 1, 1));
				row.createCell(9).setCellFormula("SUM(I10:I18)");
				row.getSheet().addMergedRegion(new CellRangeAddress(9, 17, 9, 9));
			}
			OutSheet2Item item = out2.getOutSheet2Item(e);
			fillRow(row, item);
		}	
		// 添加表格底部总和
		row = destSheet.createRow(rownum++);
		setFormFooter(row);
	}
	private void setFormFooter(Row row) {
		row.createCell(1).setCellValue("总计");
		row.createCell(4).setCellFormula("SUM(E2:E18)");
		row.createCell(5).setCellFormula("SUM(F2:F18)");
		row.createCell(6).setCellFormula("SUM(G2:G18)");
		row.createCell(7).setCellFormula("SUM(H2:H18)");
		row.createCell(8).setCellFormula("SUM(I2:I18)");
		row.createCell(9).setCellFormula("SUM(J2:J18)");
	}

	private void fillRow(Row row, OutSheet2Item item) {		
		row.createCell(2).setCellValue(item.getSubCompany().toString());
		row.createCell(3).setCellValue(item.getPayEnum().toString());
		row.createCell(4).setCellValue(item.getSubscribeNum());
		row.createCell(5).setCellValue(item.getDeleteNum());
		row.createCell(6).setCellValue(item.getIncreaseTerminalNum());
		row.createCell(7).setCellValue(item.getSubscribeCycleEndNum());
		row.createCell(8).setCellValue(item.getRevenue());
	}

	/**
	 * 设置标题
	 * @param row
	 */
	private void setFormTitle(Row row) {
		row.createCell(1).setCellValue("地域");
		row.createCell(2).setCellValue("分公司");
		row.createCell(3).setCellValue("付费形式");
		row.createCell(4).setCellValue("订购次数");
		row.createCell(5).setCellValue("退订次数");
		row.createCell(6).setCellValue("净增终端数");
		row.createCell(7).setCellValue("在订用户");
		row.createCell(8).setCellValue("应收收入（元）");
		row.createCell(9).setCellValue("区域合计（元）");
		row.createCell(10).setCellValue("备注");
	}

	private OutSheet2 parseReport2OutSheet2() throws ExcelException {
		OutSheet2 out2 = new OutSheet2();
		
		for (ServiceItem item : src2report.getReport().getItems()) {
			OutSheet2SubCompanyEnum e = OutSheet2SubCompanyEnum.getEnum(item.getSubcompany().toString());
			if (PayEnum.Yewudinggou == item.getPay()) {
				out2.addOutSheet2ItemSubscribeNum(e, item.getSubscribeNum());
				out2.addOutSheet2ItemDeleteNum(e, item.getDeleteNum());
				out2.addOutSheet2ItemIncreaseTerminalNum(e, item.getIncreaseTerminalNum());
				out2.addOutSheet2ItemSubscribeCycleEndNum(e, item.getSubscribeCycleEndNum());
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				out2.addOutSheet2ItemRevenue(e, item.getSubscribeNum() + item.getDeleteNum());
			}
		}
		
		return out2;
	}
	
}

