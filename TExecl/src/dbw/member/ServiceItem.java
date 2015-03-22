package dbw.member;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

public class ServiceItem {
	/**
	 * 分公�?
	 */
	private SubCompanyEnum subcompany;
	/**
	 * 业务类别
	 */
	private ServiceTypeEnum serviceType;
	/**
	 * 付费形式
	 */
	private PayEnum pay;
	/**
	 * 产品名称
	 */
	private String productName;
	// 订购次数
	/**
	 * 订购次数
	 */
	private Double subscribeNum;
	/**
	 * �?订次�?
	 */
	private Double deleteNum;
	/**
	 * 订购�?增数
	 */
	private Double increaseNum;
	// 订购终端
	/**
	 * 订购终端�?
	 */
	private Double subscribeTerminalNum;
	/**
	 * �?订终端数
	 */
	private Double deleteTerminalNum;
	/**
	 * �?增终端数
	 */
	private Double increaseTerminalNum;
	/**
	 * 本周期新增订购终端数
	 */
	private Double increaseCycleTerminalNum;
	// 点播情况
	/**
	 * 点播次数
	 */
	private Double requestNum;
	/**
	 * 点播终端
	 */
	private Double requestTerminalNum;
	// 在订情况
	/**
	 * 上周期末订购�?
	 */
	private Double subscribeLastCycleEndNum;
	/**
	 * 本周期末订购�?
	 */
	private Double subscribeCycleEndNum;
	/**
	 * 本周期新�?
	 */
	private Double increaseCycleNum;
	
	private ServiceItem(Row row) {
//		this.subcompany = SubCompanyEnum.valueOf(row.getCell(0).getRichStringCellValue().getString());
//		this.serviceType = ServiceTypeEnum.valueOf(row.getCell(1).getRichStringCellValue().getString());
//		this.pay = PayEnum.valueOf(row.getCell(2).getRichStringCellValue().getString());
//		this.productName = row.getCell(3).getRichStringCellValue().getString();
		//订购次数
//		this.subscribeNum = row.getCell(4).getRichStringCellValue().getString().equals("/")?
//								null:(int)row.getCell(4).getNumericCellValue();

		this.subcompany = SubCompanyEnum.getEnum((String)parse(row, 0));
		this.serviceType = ServiceTypeEnum.getEnum((String)parse(row, 1));
		this.pay = PayEnum.getEnum((String)parse(row, 2));
		this.productName = String.valueOf(parse(row, 3));
		// 订购次数
		this.subscribeNum = (Double)parse(row, 4);
		this.deleteNum = (Double)parse(row, 5);
		this.increaseNum = (Double)parse(row, 6);
		// 订购终端
		this.subscribeTerminalNum = (Double)parse(row, 7);
		this.deleteTerminalNum = (Double)parse(row, 8);
		this.increaseTerminalNum = (Double)parse(row, 9);
		this.increaseCycleTerminalNum = (Double)parse(row, 10);
		// 点播情况
		this.requestNum = (Double)parse(row, 11);
		this.requestTerminalNum = (Double)parse(row, 12);
		// 在订情况
		this.subscribeLastCycleEndNum = (Double)parse(row, 13);
		this.subscribeCycleEndNum = (Double)parse(row, 14);
		this.increaseCycleNum = (Double)parse(row, 15);
		
	}
	
	public static ServiceItem newInstance(Row row) {
		if (null == row) {
			return null;
		}

		return new ServiceItem(row);
	}
	public Object parse(Row row, int column) {
		if ((null == row) || (column<0) || (column>15)) {
			return null;
		}
		
		Object o = null;
		Cell cell = row.getCell(column);
		
		switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING: {
				String s = cell.getRichStringCellValue().getString();
				if (s.equals("/")) {
					o = (double)0;//cell.getNumericCellValue();
				}
				else {
					o = s;
				}
				break;
			}
			case Cell.CELL_TYPE_NUMERIC: {
				if (DateUtil.isCellDateFormatted(cell)) {
	                o = cell.getDateCellValue();
	            } else {
	                o = cell.getNumericCellValue();
	            }
	            break;
			}
			case Cell.CELL_TYPE_BOOLEAN: {
				o = cell.getBooleanCellValue();
				break;
			}
			case Cell.CELL_TYPE_FORMULA: {
				o = cell.getCellFormula();
				break;
			}
			case Cell.CELL_TYPE_BLANK: {
				o = "";
				break;
			}
			default: {
				System.out.println("parse cell[" + row.getRowNum() + "," + column + "] error");
			}
		}
		
		return o;		
	}

	/**
	 * @return 分公�? {@linkplain dbw.member.SubCompanyEnum}
	 */
	public SubCompanyEnum getSubcompany() {
		return subcompany;
	}

	/**
	 * @param subcompany 分公�?
	 */
	public void setSubcompany(SubCompanyEnum subcompany) {
		this.subcompany = subcompany;
	}

	/**
	 * @return 业务类别
	 */
	public ServiceTypeEnum getServiceType() {
		return serviceType;
	}

	/**
	 * @param serviceType 业务类别
	 */
	public void setServiceType(ServiceTypeEnum serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * @return 付费形式
	 */
	public PayEnum getPay() {
		return pay;
	}

	/**
	 * @param pay 付费形式
	 */
	public void setPay(PayEnum pay) {
		this.pay = pay;
	}

	/**
	 * @return 产品名称
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName 产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return 订购次数
	 */
	public Double getSubscribeNum() {
		if (null == this.subscribeNum) {
			return (double) 0;
		}
		return subscribeNum;
	}

	/**
	 * @param subscribeNum 订购次数
	 */
	public void setSubscribeNum(Double subscribeNum) {
		this.subscribeNum = subscribeNum;
	}

	/**
	 * @return �?订次�?
	 */
	public Double getDeleteNum() {
		return deleteNum;
	}

	/**
	 * @param deleteNum �?订次�?
	 */
	public void setDeleteNum(Double deleteNum) {
		this.deleteNum = deleteNum;
	}

	/**
	 * @return 订购�?增数
	 */
	public Double getIncreaseNum() {
		return increaseNum;
	}

	/**
	 * @param increaseNum 订购�?增数
	 */
	public void setIncreaseNum(Double increaseNum) {
		this.increaseNum = increaseNum;
	}

	/**
	 * @return the 订购终端�?
	 */
	public Double getSubscribeTerminalNum() {
		return subscribeTerminalNum;
	}

	/**
	 * @param subscribeTerminalNum 订购终端�?
	 */
	public void setSubscribeTerminalNum(Double subscribeTerminalNum) {
		this.subscribeTerminalNum = subscribeTerminalNum;
	}

	/**
	 * @return �?订终端数
	 */
	public Double getDeleteTerminalNum() {
		return deleteTerminalNum;
	}

	/**
	 * @param deleteTerminalNum �?订终端数
	 */
	public void setDeleteTerminalNum(Double deleteTerminalNum) {
		this.deleteTerminalNum = deleteTerminalNum;
	}

	/**
	 * @return �?增终端数
	 */
	public Double getIncreaseTerminalNum() {
		return increaseTerminalNum;
	}

	/**
	 * @param increaseTerminalNum �?增终端数
	 */
	public void setIncreaseTerminalNum(Double increaseTerminalNum) {
		this.increaseTerminalNum = increaseTerminalNum;
	}

	/**
	 * @return 本周期新增订购终端数
	 */
	public Double getIncreaseCycleTerminalNum() {
		return increaseCycleTerminalNum;
	}

	/**
	 * @param increaseCycleTerminalNum 本周期新增订购终端数
	 */
	public void setIncreaseCycleTerminalNum(Double increaseCycleTerminalNum) {
		this.increaseCycleTerminalNum = increaseCycleTerminalNum;
	}

	/**
	 * @return 点播次数
	 */
	public Double getRequestNum() {
		return requestNum;
	}

	/**
	 * @param requestNum 点播次数
	 */
	public void setRequestNum(Double requestNum) {
		this.requestNum = requestNum;
	}

	/**
	 * @return 点播终端
	 */
	public Double getRequestTerminalNum() {
		return requestTerminalNum;
	}

	/**
	 * @param requestTerminalNum 点播终端
	 */
	public void setRequestTerminalNum(Double requestTerminalNum) {
		this.requestTerminalNum = requestTerminalNum;
	}

	/**
	 * @return 上周期末订购�?
	 */
	public Double getSubscribeLastCycleEndNum() {
		return subscribeLastCycleEndNum;
	}

	/**
	 * @param subscribeLastCycleEndNum 上周期末订购�?
	 */
	public void setSubscribeLastCycleEndNum(Double subscribeLastCycleEndNum) {
		this.subscribeLastCycleEndNum = subscribeLastCycleEndNum;
	}

	/**
	 * @return 本周期末订购�?
	 */
	public Double getSubscribeCycleEndNum() {
		return subscribeCycleEndNum;
	}

	/**
	 * @param subscribeCycleEndNum 本周期末订购�?
	 */
	public void setSubscribeCycleEndNum(Double subscribeCycleEndNum) {
		this.subscribeCycleEndNum = subscribeCycleEndNum;
	}

	/**
	 * @return 本周期新�?
	 */
	public Double getIncreaseCycleNum() {
		return increaseCycleNum;
	}

	/**
	 * @param increaseCycleNum 本周期新�?
	 */
	public void setIncreaseCycleNum(Double increaseCycleNum) {
		this.increaseCycleNum = increaseCycleNum;
	}

	
}
