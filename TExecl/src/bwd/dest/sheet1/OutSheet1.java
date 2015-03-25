package bwd.dest.sheet1;

import java.util.EnumMap;

import bwd.src.sheet1.PayEnum;
import bwd.src.sheet1.Report;
import bwd.src.sheet1.ServiceItem;
import bwd.src.sheet1.SubCompanyEnum;

public class OutSheet1 {

//	private static OutServiceItem out = null;
	// 订购次数
	private EnumMap<OutServiceTypeEnum, Double> njMap = new EnumMap<OutServiceTypeEnum, Double>(OutServiceTypeEnum.class); 
	private EnumMap<OutServiceTypeEnum, Double> njExMap = new EnumMap<OutServiceTypeEnum, Double>(OutServiceTypeEnum.class);
	private EnumMap<OutServiceTypeEnum, Double> otherMap = new EnumMap<OutServiceTypeEnum, Double>(OutServiceTypeEnum.class);
	// 净增量
	private EnumMap<OutServiceTypeEnum, Double> njTerminalMap = new EnumMap<OutServiceTypeEnum, Double>(OutServiceTypeEnum.class); 
	private EnumMap<OutServiceTypeEnum, Double> njExTerminalMap = new EnumMap<OutServiceTypeEnum, Double>(OutServiceTypeEnum.class);
	private EnumMap<OutServiceTypeEnum, Double> otherTerminalMap = new EnumMap<OutServiceTypeEnum, Double>(OutServiceTypeEnum.class);
	// 在订用户
	private EnumMap<OutServiceTypeEnum, Double> njUserMap = new EnumMap<OutServiceTypeEnum, Double>(OutServiceTypeEnum.class); 
	private EnumMap<OutServiceTypeEnum, Double> njExUserMap = new EnumMap<OutServiceTypeEnum, Double>(OutServiceTypeEnum.class);
	private EnumMap<OutServiceTypeEnum, Double> otherUserMap = new EnumMap<OutServiceTypeEnum, Double>(OutServiceTypeEnum.class);
	// 应收收入
	private EnumMap<OutServiceTypeEnum, Double> njIncomeMap = new EnumMap<OutServiceTypeEnum, Double>(OutServiceTypeEnum.class); 
	private EnumMap<OutServiceTypeEnum, Double> njExIncomeMap = new EnumMap<OutServiceTypeEnum, Double>(OutServiceTypeEnum.class);
	private EnumMap<OutServiceTypeEnum, Double> otherIncomeMap = new EnumMap<OutServiceTypeEnum, Double>(OutServiceTypeEnum.class);

	public void parseServiceItem2Out(Report srcSheet) {
		if ((null == srcSheet) || (null == srcSheet.getItems())) {
			return ;
		}
		
		for (ServiceItem item : srcSheet.getItems()) {
			OutServiceTypeEnum outItem = OutServiceTypeEnum.getEnum(item.getServiceType().getServiceName());
			if (null == outItem) {
				continue;
			}

			if (SubCompanyEnum.Nanjing == item.getSubcompany()) {
				if (PayEnum.Dinggou == item.getPay()) {
					this.njMap.put(outItem, item.getSubscribeNum() + (this.njMap.get(outItem)==null?0.0:this.njMap.get(outItem)));
					this.njTerminalMap.put(outItem, item.getIncreaseNum() + (this.njTerminalMap.get(outItem)==null?0.0:this.njTerminalMap.get(outItem)));
					this.njUserMap.put(outItem, item.getSubscribeCycleEndNum() + (this.njUserMap.get(outItem)==null?0.0:this.njUserMap.get(outItem)));
				}
				else if (PayEnum.Xiaofei == item.getPay()) {
					this.njIncomeMap.put(outItem, item.getSubscribeNum() + (this.njIncomeMap.get(outItem)==null?0.0:this.njIncomeMap.get(outItem)));
				}
			}
			else if ((SubCompanyEnum.NanjingGaochun == item.getSubcompany())
						|| (SubCompanyEnum.NanjingJiangning == item.getSubcompany())
						|| (SubCompanyEnum.NanjingLishui == item.getSubcompany())
						|| (SubCompanyEnum.NanjingLuhe == item.getSubcompany())
						|| (SubCompanyEnum.NanjingPukou == item.getSubcompany())
						|| (SubCompanyEnum.NanjingYuhua == item.getSubcompany())) {
				if (PayEnum.Dinggou == item.getPay()) {
					this.njExMap.put(outItem, item.getSubscribeNum() + (this.njExMap.get(outItem)==null?0.0:this.njExMap.get(outItem)));
					this.njExTerminalMap.put(outItem, item.getIncreaseNum() + (this.njExTerminalMap.get(outItem)==null?0.0:this.njExTerminalMap.get(outItem)));
					this.njExUserMap.put(outItem, item.getSubscribeCycleEndNum() + (this.njExUserMap.get(outItem)==null?0.0:this.njExUserMap.get(outItem)));
				}
				else if (PayEnum.Xiaofei == item.getPay()) {
					this.njExIncomeMap.put(outItem, item.getSubscribeNum() + (this.njExIncomeMap.get(outItem)==null?0.0:this.njExIncomeMap.get(outItem)));
				}
			}
			else {
				if (PayEnum.Dinggou == item.getPay()) {
					this.otherMap.put(outItem, item.getSubscribeNum() + (this.otherMap.get(outItem)==null?0.0:this.otherMap.get(outItem)));
					this.otherTerminalMap.put(outItem, item.getIncreaseNum() + (this.otherTerminalMap.get(outItem)==null?0.0:this.otherTerminalMap.get(outItem)));
					this.otherUserMap.put(outItem, item.getSubscribeCycleEndNum() + (this.otherUserMap.get(outItem)==null?0.0:this.otherUserMap.get(outItem)));
				}
				else if (PayEnum.Xiaofei == item.getPay()) {
					this.otherIncomeMap.put(outItem, item.getSubscribeNum() + (this.otherIncomeMap.get(outItem)==null?0.0:this.otherIncomeMap.get(outItem)));
				}
			}
		}
		
		return;
	}

	/**
	 * @return the njMap
	 */
	public EnumMap<OutServiceTypeEnum, Double> getNjMap() {
		return njMap;
	}

	/**
	 * @return the njExMap
	 */
	public EnumMap<OutServiceTypeEnum, Double> getNjExMap() {
		return njExMap;
	}

	/**
	 * @return the otherMap
	 */
	public EnumMap<OutServiceTypeEnum, Double> getOtherMap() {
		return otherMap;
	}

	/**
	 * @return the njTerminalMap
	 */
	public EnumMap<OutServiceTypeEnum, Double> getNjTerminalMap() {
		return njTerminalMap;
	}

	/**
	 * @return the njExTerminalMap
	 */
	public EnumMap<OutServiceTypeEnum, Double> getNjExTerminalMap() {
		return njExTerminalMap;
	}

	/**
	 * @return the otherTerminalMap
	 */
	public EnumMap<OutServiceTypeEnum, Double> getOtherTerminalMap() {
		return otherTerminalMap;
	}

	/**
	 * @return the njUserMap
	 */
	public EnumMap<OutServiceTypeEnum, Double> getNjUserMap() {
		return njUserMap;
	}

	/**
	 * @return the njExUserMap
	 */
	public EnumMap<OutServiceTypeEnum, Double> getNjExUserMap() {
		return njExUserMap;
	}

	/**
	 * @return the otherUserMap
	 */
	public EnumMap<OutServiceTypeEnum, Double> getOtherUserMap() {
		return otherUserMap;
	}

	/**
	 * @return the njIncomeMap
	 */
	public EnumMap<OutServiceTypeEnum, Double> getNjIncomeMap() {
		return njIncomeMap;
	}

	/**
	 * @return the njExIncomeMap
	 */
	public EnumMap<OutServiceTypeEnum, Double> getNjExIncomeMap() {
		return njExIncomeMap;
	}

	/**
	 * @return the otherIncomeMap
	 */
	public EnumMap<OutServiceTypeEnum, Double> getOtherIncomeMap() {
		return otherIncomeMap;
	}
	
}
