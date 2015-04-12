package bwd.sheet1;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import bwd.dest.sheet1.OutServiceTypeEnum;
import bwd.dest.sheet1.OutSheet1;
import bwd.util.ExcelException;

public class SrcSheet1ToDestSheet1 extends SrcSheet1ToReport {

	public SrcSheet1ToDestSheet1(Sheet srcSheet) throws ExcelException {
		super(srcSheet);
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
	
	public void fillOutSheet(Sheet destSheet) {

		int rownum = 0;
		// 添加主列表标题
		Row rowTitle = destSheet.createRow(rownum++);
		setMainTitle(rowTitle);
		// 添加子列表标题
		Row rowSubTitle = destSheet.createRow(rownum++);
		setSubTitle(rowSubTitle);
		// 添加数据
		OutSheet1 out = new OutSheet1();
		out.parseServiceItem2Out(getReport());
		for (OutServiceTypeEnum serviceType : OutServiceTypeEnum.values()) {
			Row row = destSheet.createRow(rownum++);
			setLineData(row, out, serviceType);
		}

	}

}
