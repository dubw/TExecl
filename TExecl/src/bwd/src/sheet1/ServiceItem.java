package bwd.src.sheet1;

public class ServiceItem {
	/**
	 * 分公司
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
	 * 退订次数
	 */
	private Double deleteNum;
	/**
	 * 净增数
	 */
	private Double increaseNum;
	// 订购终端
	/**
	 * 订购终端数
	 */
	private Double subscribeTerminalNum;
	/**
	 * 退订终端数
	 */
	private Double deleteTerminalNum;
	/**
	 * 净增终端数
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
	 * 上周期末订购数
	 */
	private Double subscribeLastCycleEndNum;
	/**
	 * 本周期末订购数
	 */
	private Double subscribeCycleEndNum;
	/**
	 * 本周期新增
	 */
	private Double increaseCycleNum;
	
	public ServiceItem() {
		
	}

	/**
	 * @return the subcompany
	 */
	public SubCompanyEnum getSubcompany() {
		return subcompany;
	}

	/**
	 * @param subcompany the subcompany to set
	 */
	public void setSubcompany(SubCompanyEnum subcompany) {
		this.subcompany = subcompany;
	}

	/**
	 * @return the serviceType
	 */
	public ServiceTypeEnum getServiceType() {
		return serviceType;
	}

	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(ServiceTypeEnum serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * @return the pay
	 */
	public PayEnum getPay() {
		return pay;
	}

	/**
	 * @param pay the pay to set
	 */
	public void setPay(PayEnum pay) {
		this.pay = pay;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
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
	 * @return the increaseNum
	 */
	public Double getIncreaseNum() {
		return increaseNum;
	}

	/**
	 * @param increaseNum the increaseNum to set
	 */
	public void setIncreaseNum(Double increaseNum) {
		this.increaseNum = increaseNum;
	}

	/**
	 * @return the subscribeTerminalNum
	 */
	public Double getSubscribeTerminalNum() {
		return subscribeTerminalNum;
	}

	/**
	 * @param subscribeTerminalNum the subscribeTerminalNum to set
	 */
	public void setSubscribeTerminalNum(Double subscribeTerminalNum) {
		this.subscribeTerminalNum = subscribeTerminalNum;
	}

	/**
	 * @return the deleteTerminalNum
	 */
	public Double getDeleteTerminalNum() {
		return deleteTerminalNum;
	}

	/**
	 * @param deleteTerminalNum the deleteTerminalNum to set
	 */
	public void setDeleteTerminalNum(Double deleteTerminalNum) {
		this.deleteTerminalNum = deleteTerminalNum;
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
	 * @return the increaseCycleTerminalNum
	 */
	public Double getIncreaseCycleTerminalNum() {
		return increaseCycleTerminalNum;
	}

	/**
	 * @param increaseCycleTerminalNum the increaseCycleTerminalNum to set
	 */
	public void setIncreaseCycleTerminalNum(Double increaseCycleTerminalNum) {
		this.increaseCycleTerminalNum = increaseCycleTerminalNum;
	}

	/**
	 * @return the requestNum
	 */
	public Double getRequestNum() {
		return requestNum;
	}

	/**
	 * @param requestNum the requestNum to set
	 */
	public void setRequestNum(Double requestNum) {
		this.requestNum = requestNum;
	}

	/**
	 * @return the requestTerminalNum
	 */
	public Double getRequestTerminalNum() {
		return requestTerminalNum;
	}

	/**
	 * @param requestTerminalNum the requestTerminalNum to set
	 */
	public void setRequestTerminalNum(Double requestTerminalNum) {
		this.requestTerminalNum = requestTerminalNum;
	}

	/**
	 * @return the subscribeLastCycleEndNum
	 */
	public Double getSubscribeLastCycleEndNum() {
		return subscribeLastCycleEndNum;
	}

	/**
	 * @param subscribeLastCycleEndNum the subscribeLastCycleEndNum to set
	 */
	public void setSubscribeLastCycleEndNum(Double subscribeLastCycleEndNum) {
		this.subscribeLastCycleEndNum = subscribeLastCycleEndNum;
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
	 * @return the increaseCycleNum
	 */
	public Double getIncreaseCycleNum() {
		return increaseCycleNum;
	}

	/**
	 * @param increaseCycleNum the increaseCycleNum to set
	 */
	public void setIncreaseCycleNum(Double increaseCycleNum) {
		this.increaseCycleNum = increaseCycleNum;
	}

	
}
