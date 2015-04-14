package bwd.dest.sheet;

import bwd.src.sheet1.PayEnum;
import bwd.src.sheet1.SubCompanyEnum;

public class OutSheet2Item {

	private SubCompanyEnum subCompany;
	private final PayEnum payEnum = PayEnum.Yewudinggou;
	private Double subscribeNum = 0.0;
	private Double deleteNum = 0.0;
	private Double increaseTerminalNum = 0.0;
	private Double subscribeCycleEndNum = 0.0;
	private Double revenue = 0.0;
	
	public OutSheet2Item(SubCompanyEnum e) {
		setSubCompany(e);
	}
	/**
	 * @return the subCompany
	 */
	public SubCompanyEnum getSubCompany() {
		return subCompany;
	}
	/**
	 * @param subCompany the subCompany to set
	 */
	public void setSubCompany(SubCompanyEnum subCompany) {
		this.subCompany = subCompany;
	}
	/**
	 * @return the subscribeNum
	 */
	public Double getSubscribeNum() {
		return subscribeNum;
	}
	/**
	 * @param subscribeNum the subscribeNum to set
	 */
	public void setSubscribeNum(Double subscribeNum) {
		this.subscribeNum = subscribeNum;
	}
	/**
	 * @return the deleteNum
	 */
	public Double getDeleteNum() {
		return deleteNum;
	}
	/**
	 * @param deleteNum the deleteNum to set
	 */
	public void setDeleteNum(Double deleteNum) {
		this.deleteNum = deleteNum;
	}
	/**
	 * @return the increaseTerminalNum
	 */
	public Double getIncreaseTerminalNum() {
		return increaseTerminalNum;
	}
	/**
	 * @param increaseTerminalNum the increaseTerminalNum to set
	 */
	public void setIncreaseTerminalNum(Double increaseTerminalNum) {
		this.increaseTerminalNum = increaseTerminalNum;
	}
	/**
	 * @return the subscribeCycleEndNum
	 */
	public Double getSubscribeCycleEndNum() {
		return subscribeCycleEndNum;
	}
	/**
	 * @param subscribeCycleEndNum the subscribeCycleEndNum to set
	 */
	public void setSubscribeCycleEndNum(Double subscribeCycleEndNum) {
		this.subscribeCycleEndNum = subscribeCycleEndNum;
	}
	/**
	 * @return the payEnum
	 */
	public PayEnum getPayEnum() {
		return payEnum;
	}
	
	public Double getRevenue() {
		return revenue;
	}
	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
	
	
}
