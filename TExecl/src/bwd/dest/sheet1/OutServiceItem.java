package bwd.dest.sheet1;

import java.util.EnumMap;

import bwd.src.sheet1.PayEnum;
import bwd.src.sheet1.Report;
import bwd.src.sheet1.ServiceItem;
import bwd.src.sheet1.ServiceTypeEnum;
import bwd.src.sheet1.SubCompanyEnum;

public class OutServiceItem {

//	private static OutServiceItem out = null;
	// 订购次数
	private EnumMap<ServiceTypeEnum, Double> njMap = new EnumMap<ServiceTypeEnum, Double>(ServiceTypeEnum.class); 
	private EnumMap<ServiceTypeEnum, Double> njExMap = new EnumMap<ServiceTypeEnum, Double>(ServiceTypeEnum.class);
	private EnumMap<ServiceTypeEnum, Double> otherMap = new EnumMap<ServiceTypeEnum, Double>(ServiceTypeEnum.class);
	// �?增量
	private EnumMap<ServiceTypeEnum, Double> njTerminalMap = new EnumMap<ServiceTypeEnum, Double>(ServiceTypeEnum.class); 
	private EnumMap<ServiceTypeEnum, Double> njExTerminalMap = new EnumMap<ServiceTypeEnum, Double>(ServiceTypeEnum.class);
	private EnumMap<ServiceTypeEnum, Double> otherTerminalMap = new EnumMap<ServiceTypeEnum, Double>(ServiceTypeEnum.class);
	// 在订用户
	private EnumMap<ServiceTypeEnum, Double> njUserMap = new EnumMap<ServiceTypeEnum, Double>(ServiceTypeEnum.class); 
	private EnumMap<ServiceTypeEnum, Double> njExUserMap = new EnumMap<ServiceTypeEnum, Double>(ServiceTypeEnum.class);
	private EnumMap<ServiceTypeEnum, Double> otherUserMap = new EnumMap<ServiceTypeEnum, Double>(ServiceTypeEnum.class);
	// 应收收入
	private EnumMap<ServiceTypeEnum, Double> njIncomeMap = new EnumMap<ServiceTypeEnum, Double>(ServiceTypeEnum.class); 
	private EnumMap<ServiceTypeEnum, Double> njExIncomeMap = new EnumMap<ServiceTypeEnum, Double>(ServiceTypeEnum.class);
	private EnumMap<ServiceTypeEnum, Double> otherIncomeMap = new EnumMap<ServiceTypeEnum, Double>(ServiceTypeEnum.class);

	public void parseServiceItem2Out(Report srcSheet) {
		if ((null == srcSheet) || (null == srcSheet.getItems())) {
			return ;
		}
		
		for (ServiceItem item : srcSheet.getItems()) {
			if (SubCompanyEnum.Nanjing == item.getSubcompany()) {
				if (PayEnum.Dinggou == item.getPay()) {
					this.njMap.put(item.getServiceType(), item.getSubscribeNum() + (this.njMap.get(item.getServiceType())==null?0:this.njMap.get(item.getServiceType())));
					this.njTerminalMap.put(item.getServiceType(), item.getIncreaseNum() + (this.njTerminalMap.get(item.getServiceType())==null?0:this.njTerminalMap.get(item.getServiceType())));
					this.njUserMap.put(item.getServiceType(), item.getSubscribeCycleEndNum() + (this.njUserMap.get(item.getServiceType())==null?0:this.njUserMap.get(item.getServiceType())));
				}
				else if (PayEnum.Xiaofei == item.getPay()) {
					this.njIncomeMap.put(item.getServiceType(), item.getSubscribeNum() + (this.njIncomeMap.get(item.getServiceType())==null?0:this.njIncomeMap.get(item.getServiceType())));
				}
			}
			else if ((SubCompanyEnum.NanjingGaochun == item.getSubcompany())
						|| (SubCompanyEnum.NanjingJiangning == item.getSubcompany())
						|| (SubCompanyEnum.NanjingLishui == item.getSubcompany())
						|| (SubCompanyEnum.NanjingLuhe == item.getSubcompany())
						|| (SubCompanyEnum.NanjingPukou == item.getSubcompany())
						|| (SubCompanyEnum.NanjingYuhua == item.getSubcompany())) {
				if (PayEnum.Dinggou == item.getPay()) {
					this.njExMap.put(item.getServiceType(), item.getSubscribeNum() + (this.njExMap.get(item.getServiceType())==null?0:this.njExMap.get(item.getServiceType())));
					this.njExTerminalMap.put(item.getServiceType(), item.getIncreaseNum() + (this.njExTerminalMap.get(item.getServiceType())==null?0:this.njExTerminalMap.get(item.getServiceType())));
					this.njExUserMap.put(item.getServiceType(), item.getSubscribeCycleEndNum() + (this.njExUserMap.get(item.getServiceType())==null?0:this.njExUserMap.get(item.getServiceType())));
				}
				else if (PayEnum.Xiaofei == item.getPay()) {
					this.njExIncomeMap.put(item.getServiceType(), item.getSubscribeNum() + (this.njExIncomeMap.get(item.getServiceType())==null?0:this.njExIncomeMap.get(item.getServiceType())));
				}
			}
			else {
				if (PayEnum.Dinggou == item.getPay()) {
					this.otherMap.put(item.getServiceType(), item.getSubscribeNum() + (this.otherMap.get(item.getServiceType())==null?0:this.otherMap.get(item.getServiceType())));
					this.otherTerminalMap.put(item.getServiceType(), item.getIncreaseNum() + (this.otherTerminalMap.get(item.getServiceType())==null?0:this.otherTerminalMap.get(item.getServiceType())));
					this.otherUserMap.put(item.getServiceType(), item.getSubscribeCycleEndNum() + (this.otherUserMap.get(item.getServiceType())==null?0:this.otherUserMap.get(item.getServiceType())));
				}
				else if (PayEnum.Xiaofei == item.getPay()) {
					this.otherIncomeMap.put(item.getServiceType(), item.getSubscribeNum() + (this.otherIncomeMap.get(item.getServiceType())==null?0:this.otherIncomeMap.get(item.getServiceType())));
				}
			}
		}
		
		return;
	}

	/**
	 * @return the njMap
	 */
	public EnumMap<ServiceTypeEnum, Double> getNjMap() {
		return njMap;
	}

	/**
	 * @return the njExMap
	 */
	public EnumMap<ServiceTypeEnum, Double> getNjExMap() {
		return njExMap;
	}

	/**
	 * @return the otherMap
	 */
	public EnumMap<ServiceTypeEnum, Double> getOtherMap() {
		return otherMap;
	}

	/**
	 * @return the njTerminalMap
	 */
	public EnumMap<ServiceTypeEnum, Double> getNjTerminalMap() {
		return njTerminalMap;
	}

	/**
	 * @return the njExTerminalMap
	 */
	public EnumMap<ServiceTypeEnum, Double> getNjExTerminalMap() {
		return njExTerminalMap;
	}

	/**
	 * @return the otherTerminalMap
	 */
	public EnumMap<ServiceTypeEnum, Double> getOtherTerminalMap() {
		return otherTerminalMap;
	}

	/**
	 * @return the njUserMap
	 */
	public EnumMap<ServiceTypeEnum, Double> getNjUserMap() {
		return njUserMap;
	}

	/**
	 * @return the njExUserMap
	 */
	public EnumMap<ServiceTypeEnum, Double> getNjExUserMap() {
		return njExUserMap;
	}

	/**
	 * @return the otherUserMap
	 */
	public EnumMap<ServiceTypeEnum, Double> getOtherUserMap() {
		return otherUserMap;
	}

	/**
	 * @return the njIncomeMap
	 */
	public EnumMap<ServiceTypeEnum, Double> getNjIncomeMap() {
		return njIncomeMap;
	}

	/**
	 * @return the njExIncomeMap
	 */
	public EnumMap<ServiceTypeEnum, Double> getNjExIncomeMap() {
		return njExIncomeMap;
	}

	/**
	 * @return the otherIncomeMap
	 */
	public EnumMap<ServiceTypeEnum, Double> getOtherIncomeMap() {
		return otherIncomeMap;
	}
	
}
