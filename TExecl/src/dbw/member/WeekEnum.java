package dbw.member;

public enum WeekEnum {
	
	Monday("周一"),
	Tuesday("周二"),
	Wednesday("周三"),
	Thurday("周四"),
	Friday("周五"),
	Saturday("周六"),
	Sunday("周日");
	
	private String value;
	
	private WeekEnum(String value) {
		this.value = value;
	}
	
	public String getWeekName() {
		return this.value;
	}

}
