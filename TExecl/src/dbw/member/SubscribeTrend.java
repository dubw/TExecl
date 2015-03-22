package dbw.member;

import java.util.EnumMap;
import java.util.Map;

public class SubscribeTrend {

	private String date; // "2/11" 2æœ?11æ—?
	private WeekEnum week;// å‘¨ä¸‰
	private EnumMap<ServiceTypeEnum, Integer> subscribeMap = new EnumMap<ServiceTypeEnum, Integer>(ServiceTypeEnum.class); 
	private int total;
	
	public SubscribeTrend() {
		
	}
	public SubscribeTrend(String date, WeekEnum week,
			EnumMap<ServiceTypeEnum, Integer> subscribeMap) {
		this(date, week, subscribeMap, 0);
	}
	public SubscribeTrend(String date, WeekEnum week, EnumMap<ServiceTypeEnum, Integer> subscribeMap, Integer total) {
		this.date = date;
		this.week = week;
		this.subscribeMap.putAll(subscribeMap);
		this.total = total;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public WeekEnum getWeek() {
		return week;
	}

	public void setWeek(WeekEnum week) {
		this.week = week;
	}

	public int getTotal() {
		if (this.subscribeMap.isEmpty()) {
			return 0;
		}
		for (Map.Entry<ServiceTypeEnum, Integer> map : this.subscribeMap.entrySet()) {
			this.total += map.getValue();
		}
		return total;
	}

	public Integer put(ServiceTypeEnum e, Integer i) {
		return this.subscribeMap.put(e, i);
	}
	public Integer remove(ServiceTypeEnum e) {
		return this.subscribeMap.remove(e);
	}
	
	
	public static void main(String[] args) {
		SubscribeTrend trend = new SubscribeTrend();
		trend.put(ServiceTypeEnum.BKXY, 3);
		trend.put(ServiceTypeEnum.BKXY, 4);
		for (Map.Entry<ServiceTypeEnum, Integer> map : trend.subscribeMap.entrySet()) {
			System.out.println(map.getKey().getServiceName() + ":" + map.getValue());
		}
	}
	
}
