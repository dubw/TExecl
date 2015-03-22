package dbw.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import dbw.member.OutServiceItem;
import dbw.member.ServiceItem;
import dbw.member.ServiceTypeEnum;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import dbw.util.ExeclUtil;

public class Action {

	private String sourcePathname = null;
	private String sheetName = null;
	
	/**
	 * @return the sourcePathname
	 */
	public String getSourcePathname() {
		return sourcePathname;
	}

	/**
	 * @param sourcePathname the sourcePathname to set
	 */
	public void setSourcePathname(String sourcePathname) {
		this.sourcePathname = sourcePathname;
	}

	/**
	 * @return the sheetName
	 */
	public String getSheetName() {
		return sheetName;
	}

	/**
	 * @param sheetName the sheetName to set
	 */
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public boolean action() {
		Workbook wb = null;
		ArrayList<Row> rows = null;
		ArrayList<ServiceItem> items = null;
		try {
			wb = ExeclUtil.openExecl(sourcePathname);
			if (null == wb) {
				return false;
			}
			rows = ExeclUtil.readExeclRows(wb, sheetName, 4-1);// 4为起始行，结尾行在方法内部实现，这里为定制化服务
			if (null == rows) {
				return true;
			}
			for (Row row : rows) {
				if (null == items) {
					items = new ArrayList<ServiceItem>(1);
				}
				items.add(ServiceItem.newInstance(row));
			}
			// calculate
			OutServiceItem out = calculate(items);
			if (null == out) {
				System.out.println("calculate error!");
				return false;
			}
			
			// TODO write data to new ".xls[x]"
			if (!writeExecl(out)) {
				System.out.println("calculate error!");
				return false;
			}
			
		} catch (InvalidFormatException | IOException e) {
			if (null != wb) {
				try {
					wb.close();
				} catch (IOException e1) {
					return false;
				}
			}
			return false;
		}
		
		return true;
	}
	
	public boolean writeExecl(OutServiceItem out) throws InvalidFormatException, IOException {
		String destPathname = this.sourcePathname.substring(0, this.sourcePathname.lastIndexOf('\\')) + "\\abc.xls"; 
		
		Workbook wb = ExeclUtil.createExecl(destPathname);
		if (null == wb) {
			return false;
		}
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("out");
		if (null == sheet) {
			return false;
		}
		sheet.setAutobreaks(true);

		/*
		 *  单元格格�?,居中
		 */
		CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        
        
		ArrayList<Row> rows = new ArrayList<Row>(1);
		// 添加主列表说�?
		Row rowTitle = sheet.createRow(0);
		wb.createCellStyle().setAlignment(CellStyle.ALIGN_CENTER);
		rowTitle.createCell(1).setCellValue(createHelper.createRichTextString("订购次数（个�?"));
		rowTitle.getCell(1).setCellStyle(cellStyle);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 3));
		rowTitle.createCell(4).setCellValue(createHelper.createRichTextString("�?增量（终端）"));
		rowTitle.getCell(4).setCellStyle(cellStyle);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 4, 6));
		rowTitle.createCell(7).setCellValue(createHelper.createRichTextString("在订用户（终端）"));
		rowTitle.getCell(7).setCellStyle(cellStyle);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 7, 9));
		rowTitle.createCell(10).setCellValue(createHelper.createRichTextString("应收收入（元�?"));
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 10, 12));
		rowTitle.getCell(10).setCellStyle(cellStyle);
		rows.add(rowTitle);
		// 添加子列表说�?
		Row rowSubTitle = sheet.createRow(1);
		rowSubTitle.createCell(1).setCellValue(createHelper.createRichTextString("南京�?"));
		rowSubTitle.createCell(2).setCellValue(createHelper.createRichTextString("南京区县"));
		rowSubTitle.createCell(3).setCellValue(createHelper.createRichTextString("地市公司"));
		rowSubTitle.createCell(4).setCellValue(createHelper.createRichTextString("南京�?"));
		rowSubTitle.createCell(5).setCellValue(createHelper.createRichTextString("南京区县"));
		rowSubTitle.createCell(6).setCellValue(createHelper.createRichTextString("地市公司"));
		rowSubTitle.createCell(7).setCellValue(createHelper.createRichTextString("南京�?"));
		rowSubTitle.createCell(8).setCellValue(createHelper.createRichTextString("南京区县"));
		rowSubTitle.createCell(9).setCellValue(createHelper.createRichTextString("地市公司"));
		rowSubTitle.createCell(10).setCellValue(createHelper.createRichTextString("南京�?"));
		rowSubTitle.createCell(11).setCellValue(createHelper.createRichTextString("南京区县"));
		rowSubTitle.createCell(12).setCellValue(createHelper.createRichTextString("地市公司"));
		rows.add(rowSubTitle);
		
		int i=2;
		for (ServiceTypeEnum en : ServiceTypeEnum.values()) {
			Row row = sheet.createRow(i++);
			
			ServiceTypeEnum type = en;//ServiceTypeEnum.ICNTV;
			// 名称
			row.createCell(0).setCellValue(createHelper.createRichTextString(type.getServiceName()));
			// 订购次数：南�?
			row.createCell(1).setCellValue(out.getNjMap().get(type)==null?0.0:out.getNjMap().get(type));
			// 订购次数：南京县�?
			row.createCell(2).setCellValue(out.getNjExMap().get(type)==null?0.0:out.getNjExMap().get(type));
			// 订购次数：地市公�?
			row.createCell(3).setCellValue(out.getOtherMap().get(type)==null?0.0:out.getOtherMap().get(type));
			// �?增量
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
			
			rows.add(row);
		}
		
		File file = new File(destPathname);
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();		
		FileOutputStream fileOut = new FileOutputStream(file);

		wb.write(fileOut);
		fileOut.close();
		System.out.println("create execl ok:" + destPathname);
		
		return true;
	}
	
	public OutServiceItem calculate(ArrayList<ServiceItem> items) {
		if (null == items) {
			return null;
		}

		OutServiceItem out = new OutServiceItem();
		//for (ServiceItem item : items) {
		for (int i=0; i<items.size(); i++) {
			out.parse(items.get(i));
		}
		
		return out;
	}
	
	
	public static void main(String[] args) {
		Action action = new Action();
		action.setSourcePathname("C:\\Users\\Administrator\\Desktop\\3.171.xls");
		action.setSheetName("Report");;
		action.action();
	}
	
	
}
