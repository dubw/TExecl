package bwd.sheet1;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import bwd.dest.sheet2.OutSheet2;
import bwd.dest.sheet2.OutSheet2Item;
import bwd.src.sheet1.PayEnum;
import bwd.src.sheet1.ServiceItem;
import bwd.src.sheet1.SubCompanyEnum;
import bwd.util.ExcelException;

public class SrcSheet1ToDestSheet2 extends SrcSheet1ToReport{

	public SrcSheet1ToDestSheet2(Sheet srcSheet) throws ExcelException {
		super(srcSheet);
	}

	@Override
	public void fillOutSheet(Sheet destSheet) {
		int rownum = 0;
		// 添加主列表标题
		Row row = destSheet.createRow(rownum++);
		setFormTitle(row);
		// 添加数据
		OutSheet2 out2 = parseReport2OutSheet2();
		// 1.南京分公司
		row = destSheet.createRow(rownum++);
		row.createCell(1).setCellValue("南京地区");
		row.getSheet().addMergedRegion(new CellRangeAddress(1, 8, 1, 1));
		row.createCell(9).setCellFormula("SUM(I1:I8)");
		Cell cellsum1 = row.createCell(9);
		cellsum1.setCellValue(0.0);
		fillCommons(row, out2.getNjSubCompany());
		row.getSheet().addMergedRegion(new CellRangeAddress(1, 8, 9, 9));
		// 备注
		row.getSheet().addMergedRegion(new CellRangeAddress(1, 18, 10, 10));
		// 2.南京江宁公司
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getNjjnCompany());
		// 3.南京浦口公司
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getNjpkCompany());
		// 4.南京溧水公司
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getNjlsCompany());
		// 5.南京雨花广电
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getNjyhgd());
		// 6.南京六合公司
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getNjlhCompany());
		// 7.南京高淳公司
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getNjgcCompany());
		// 8.南京红花站
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getNjhhz());
		//--------------------------------//
		// 9.泰州分公司
		row = destSheet.createRow(rownum++);
		row.createCell(1).setCellValue("地市公司");
		row.getSheet().addMergedRegion(new CellRangeAddress(9, 17, 1, 1));
		row.createCell(9).setCellFormula("SUM(I9:I17)");
		fillCommons(row, out2.getNjpkCompany());
		row.getSheet().addMergedRegion(new CellRangeAddress(9, 17, 9, 9));
		// 10.南通
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getNtSubCompany());
		// 11.徐州
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getXzSubCompany());
		// 12.宿迁
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getSqSubCompany());
		// 13.淮安
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getHaSubCompany());
		// 14.连云港
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getLygCompanyubCompany());
		// 15.盐城
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getYcSubCompany());
		// 16.镇江
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getZjSubCompany());
		// 17.常州
		row = destSheet.createRow(rownum++);
		fillCommons(row, out2.getCzSubCompany());
		
		// 添加表格底部总和
		row = destSheet.createRow(rownum++);
		setFormFooter(row);
	}
	private void setFormFooter(Row row) {
		row.createCell(1).setCellValue("总计");
		row.createCell(4).setCellFormula("SUM(E1:E17)");
		row.createCell(5).setCellFormula("SUM(F1:F17)");
		row.createCell(6).setCellFormula("SUM(G1:G17)");
		row.createCell(7).setCellFormula("SUM(H1:H17)");
		row.createCell(8).setCellFormula("SUM(I1:I17)");
		row.createCell(9).setCellFormula("SUM(J1:J17)");
	}

	private void fillCommons(Row row, OutSheet2Item item) {		
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

	private OutSheet2 parseReport2OutSheet2() {
		OutSheet2 out2 = new OutSheet2();
		
		for (ServiceItem item : getReport().getItems()) {
			parseItem(out2, item);			
		}
		
		return out2;
	}	
	private void parseItem(OutSheet2 out2, ServiceItem item) {
		if (SubCompanyEnum.Nanjing == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjSubCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setNjSubCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjSubCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setNjSubCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.NanjingJiangning == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjjnCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setNjjnCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjjnCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setNjjnCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.NanjingPukou == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjpkCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setNjpkCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjpkCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setNjpkCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.NanjingLishui == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjlsCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setNjlsCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjlsCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setNjlsCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.NanjingYuhua == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjyhgd();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setNjyhgd(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjyhgd();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setNjyhgd(out2Item);
			}
		}
		else if (SubCompanyEnum.NanjingLuhe == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjlhCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setNjlhCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjlhCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setNjlhCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.NanjingGaochun == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjgcCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setNjgcCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjgcCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setNjgcCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.NanjingHonghuazhan == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjhhz();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setNjhhz(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getNjhhz();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setNjhhz(out2Item);
			}
		}
		else if (SubCompanyEnum.Taizhou == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getTzSubCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setTzSubCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getTzSubCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setTzSubCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.NantongZhongguang == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getNtSubCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setNtSubCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getNtSubCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setNtSubCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.XuzhouZhongguang == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getXzSubCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setXzSubCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getXzSubCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setXzSubCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.Suqian == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getSqSubCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setSqSubCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getSqSubCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setSqSubCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.Huaian == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getHaSubCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setHaSubCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getHaSubCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setHaSubCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.Lianyungang == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getLygCompanyubCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setLygCompanyubCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getLygCompanyubCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setLygCompanyubCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.Yanchen == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getYcSubCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setYcSubCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getYcSubCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setYcSubCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.Zhenjiang == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getZjSubCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setZjSubCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getZjSubCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setZjSubCompany(out2Item);
			}
		}
		else if (SubCompanyEnum.Changzhou == item.getSubcompany()) {
			if (PayEnum.Yewudinggou == item.getPay()) {
				OutSheet2Item out2Item = out2.getCzSubCompany();
				out2Item.setSubscribeNum(out2Item.getSubscribeNum() + item.getSubscribeNum());
				out2Item.setDeleteNum(out2Item.getDeleteNum() + item.getDeleteNum());
				out2Item.setIncreaseTerminalNum(out2Item.getIncreaseTerminalNum() + item.getIncreaseTerminalNum());
				out2Item.setSubscribeCycleEndNum(out2Item.getSubscribeCycleEndNum() + item.getSubscribeCycleEndNum());
				out2.setCzSubCompany(out2Item);
			}
			else if (PayEnum.Xiaofei == item.getPay()) {
				OutSheet2Item out2Item = out2.getCzSubCompany();
				out2Item.setRevenue(out2Item.getRevenue() + item.getSubscribeNum());
				out2.setCzSubCompany(out2Item);
			}
		}
		else {
			System.out.println("parseYewudinggou method error! should not be here!");
		}

	}
	
}

