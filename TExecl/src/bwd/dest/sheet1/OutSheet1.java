package bwd.dest.sheet1;

import java.util.EnumMap;

import bwd.src.sheet1.PayEnum;
import bwd.src.sheet1.Report;
import bwd.src.sheet1.ServiceItem;
import bwd.src.sheet1.SubCompanyEnum;

public class OutSheet1 {

//	private static OutServiceItem out = null;
	// 订购次数
	private EnumMap<OutSheet1TypeEnum, Double> njMap = new EnumMap<OutSheet1TypeEnum, Double>(OutSheet1TypeEnum.class); 
	private EnumMap<OutSheet1TypeEnum, Double> njExMap = new EnumMap<OutSheet1TypeEnum, Double>(OutSheet1TypeEnum.class);
	private EnumMap<OutSheet1TypeEnum, Double> otherMap = new EnumMap<OutSheet1TypeEnum, Double>(OutSheet1TypeEnum.class);
	// 净增量
	private EnumMap<OutSheet1TypeEnum, Double> njTerminalMap = new EnumMap<OutSheet1TypeEnum, Double>(OutSheet1TypeEnum.class); 
	private EnumMap<OutSheet1TypeEnum, Double> njExTerminalMap = new EnumMap<OutSheet1TypeEnum, Double>(OutSheet1TypeEnum.class);
	private EnumMap<OutSheet1TypeEnum, Double> otherTerminalMap = new EnumMap<OutSheet1TypeEnum, Double>(OutSheet1TypeEnum.class);
	// 在订用户
	private EnumMap<OutSheet1TypeEnum, Double> njUserMap = new EnumMap<OutSheet1TypeEnum, Double>(OutSheet1TypeEnum.class); 
	private EnumMap<OutSheet1TypeEnum, Double> njExUserMap = new EnumMap<OutSheet1TypeEnum, Double>(OutSheet1TypeEnum.class);
	private EnumMap<OutSheet1TypeEnum, Double> otherUserMap = new EnumMap<OutSheet1TypeEnum, Double>(OutSheet1TypeEnum.class);
	// 应收收入
	private EnumMap<OutSheet1TypeEnum, Double> njIncomeMap = new EnumMap<OutSheet1TypeEnum, Double>(OutSheet1TypeEnum.class); 
	private EnumMap<OutSheet1TypeEnum, Double> njExIncomeMap = new EnumMap<OutSheet1TypeEnum, Double>(OutSheet1TypeEnum.class);
	private EnumMap<OutSheet1TypeEnum, Double> otherIncomeMap = new EnumMap<OutSheet1TypeEnum, Double>(OutSheet1TypeEnum.class);


	/**
	 * @return the njMap
	 */
	public EnumMap<OutSheet1TypeEnum, Double> getNjMap() {
		return njMap;
	}

	/**
	 * @return the njExMap
	 */
	public EnumMap<OutSheet1TypeEnum, Double> getNjExMap() {
		return njExMap;
	}

	/**
	 * @return the otherMap
	 */
	public EnumMap<OutSheet1TypeEnum, Double> getOtherMap() {
		return otherMap;
	}

	/**
	 * @return the njTerminalMap
	 */
	public EnumMap<OutSheet1TypeEnum, Double> getNjTerminalMap() {
		return njTerminalMap;
	}

	/**
	 * @return the njExTerminalMap
	 */
	public EnumMap<OutSheet1TypeEnum, Double> getNjExTerminalMap() {
		return njExTerminalMap;
	}

	/**
	 * @return the otherTerminalMap
	 */
	public EnumMap<OutSheet1TypeEnum, Double> getOtherTerminalMap() {
		return otherTerminalMap;
	}

	/**
	 * @return the njUserMap
	 */
	public EnumMap<OutSheet1TypeEnum, Double> getNjUserMap() {
		return njUserMap;
	}

	/**
	 * @return the njExUserMap
	 */
	public EnumMap<OutSheet1TypeEnum, Double> getNjExUserMap() {
		return njExUserMap;
	}

	/**
	 * @return the otherUserMap
	 */
	public EnumMap<OutSheet1TypeEnum, Double> getOtherUserMap() {
		return otherUserMap;
	}

	/**
	 * @return the njIncomeMap
	 */
	public EnumMap<OutSheet1TypeEnum, Double> getNjIncomeMap() {
		return njIncomeMap;
	}

	/**
	 * @return the njExIncomeMap
	 */
	public EnumMap<OutSheet1TypeEnum, Double> getNjExIncomeMap() {
		return njExIncomeMap;
	}

	/**
	 * @return the otherIncomeMap
	 */
	public EnumMap<OutSheet1TypeEnum, Double> getOtherIncomeMap() {
		return otherIncomeMap;
	}
	
}
