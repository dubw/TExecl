package bwd.src.sheet1;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import bwd.action.ISrcSheet2DestSheet;
import bwd.dest.sheet.OutSheet1;
import bwd.dest.sheet.OutSheet1TypeEnum;
import bwd.util.ExcelException;

public class SrcSheet1ToDestSheet1 implements ISrcSheet2DestSheet {

	SrcSheet1ToReport src2report;
	
	public SrcSheet1ToDestSheet1(Sheet srcSheet) throws ExcelException {
		src2report = new SrcSheet1ToReport(srcSheet);
	}
	
	@Override
	public void fillOutSheet(Sheet destSheet) throws ExcelException {

		int rownum = 0;
		// 添加主列表标题
		Row rowTitle = destSheet.createRow(rownum++);
		setMainTitle(rowTitle);
		// 添加子列表标题
		Row rowSubTitle = destSheet.createRow(rownum++);
		setSubTitle(rowSubTitle);
		// 添加数据
		OutSheet1 out = parseReport2OutSheet1();
		for (OutSheet1TypeEnum serviceType : OutSheet1TypeEnum.values()) {
			Row row = destSheet.createRow(rownum++);
			setLineData(row, out, serviceType);
		}

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
	
	private OutSheet1 parseReport2OutSheet1() throws ExcelException {
		OutSheet1 out = new OutSheet1();
		
		for (ServiceItem item : src2report.getReport().getItems()) {
			OutSheet1TypeEnum outItem = OutSheet1TypeEnum.getEnum(item.getServiceType().getServiceName());
			if (null == outItem) {
				continue;
			}

			if (SubCompanyEnum.Nanjing == item.getSubcompany()) {
				if (PayEnum.Dinggou == item.getPay()) {
					out.getNjMap().put(outItem, item.getSubscribeNum() + (out.getNjMap().get(outItem)==null?0.0:out.getNjMap().get(outItem)));
				}
				else if (PayEnum.Yewudinggou == item.getPay()) {
					out.getNjTerminalMap().put(outItem, item.getIncreaseTerminalNum() + (out.getNjTerminalMap().get(outItem)==null?0.0:out.getNjTerminalMap().get(outItem)));
					out.getNjUserMap().put(outItem, item.getSubscribeCycleEndNum() + (out.getNjUserMap().get(outItem)==null?0.0:out.getNjUserMap().get(outItem)));
				}
				else if (PayEnum.Xiaofei == item.getPay()) {
					out.getNjIncomeMap().put(outItem, item.getSubscribeNum() + (out.getNjIncomeMap().get(outItem)==null?0.0:out.getNjIncomeMap().get(outItem)));
				}
			}
			else if ((SubCompanyEnum.NanjingGaochun == item.getSubcompany())
						|| (SubCompanyEnum.NanjingJiangning == item.getSubcompany())
						|| (SubCompanyEnum.NanjingLishui == item.getSubcompany())
						|| (SubCompanyEnum.NanjingLuhe == item.getSubcompany())
						|| (SubCompanyEnum.NanjingPukou == item.getSubcompany())
						|| (SubCompanyEnum.NanjingYuhua == item.getSubcompany())) {
				if (PayEnum.Dinggou == item.getPay()) {
					out.getNjExMap().put(outItem, item.getSubscribeNum() + (out.getNjExMap().get(outItem)==null?0.0:out.getNjExMap().get(outItem)));
				}
				else if (PayEnum.Yewudinggou == item.getPay()) {
					out.getNjExTerminalMap().put(outItem, item.getIncreaseTerminalNum() + (out.getNjExTerminalMap().get(outItem)==null?0.0:out.getNjExTerminalMap().get(outItem)));
					out.getNjExUserMap().put(outItem, item.getSubscribeCycleEndNum() + (out.getNjExUserMap().get(outItem)==null?0.0:out.getNjExUserMap().get(outItem)));
				}
				else if (PayEnum.Xiaofei == item.getPay()) {
					out.getNjExIncomeMap().put(outItem, item.getSubscribeNum() + (out.getNjExIncomeMap().get(outItem)==null?0.0:out.getNjExIncomeMap().get(outItem)));
				}
			}
			else {
				if (PayEnum.Dinggou == item.getPay()) {
					out.getOtherMap().put(outItem, item.getSubscribeNum() + (out.getOtherMap().get(outItem)==null?0.0:out.getOtherMap().get(outItem)));
				}
				else if (PayEnum.Yewudinggou == item.getPay()) {
					out.getOtherTerminalMap().put(outItem, item.getIncreaseTerminalNum() + (out.getOtherTerminalMap().get(outItem)==null?0.0:out.getOtherTerminalMap().get(outItem)));
					out.getOtherUserMap().put(outItem, item.getSubscribeCycleEndNum() + (out.getOtherUserMap().get(outItem)==null?0.0:out.getOtherUserMap().get(outItem)));
				}
				else if (PayEnum.Xiaofei == item.getPay()) {
					out.getOtherIncomeMap().put(outItem, item.getSubscribeNum() + (out.getOtherIncomeMap().get(outItem)==null?0.0:out.getOtherIncomeMap().get(outItem)));
				}
			}
		}
		
		return out;
	}

	private void setLineData(Row row, OutSheet1 out, OutSheet1TypeEnum type) {
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
	

}
