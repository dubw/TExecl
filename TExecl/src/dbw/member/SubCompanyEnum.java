package dbw.member;


public enum SubCompanyEnum {
	
	Changzhou("常州分公�?"),
	Huaian("淮安分公�?"),
	Lianyungang("连云港分公司"),
	Nanjing("南京分公�?"),
	NanjingGaochun("南京高淳分公�?"),
	NanjingJiangning("南京江宁分公�?"),
	NanjingLishui("南京溧水分公�?"),
	NanjingLuhe("南京六合分公�?"),
	NanjingPukou("南京浦口分公�?"),
	NanjingYuhua("南京雨花分公�?"),
	Taizhou("泰州分公�?"),
	Suqian("宿迁分公�?"),
	Yanchen("盐城分公�?"),
	Zhenjiang("镇江分公�?"),
	NantongZhongguang("中广有线南�?�分公司"),
	XuzhouZhongguang("中广有线徐州分公�?");	
	
	private String value;
	
	private SubCompanyEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static SubCompanyEnum getEnum(String value) {
		if (null == value) {
			return null;
		}
		if ("常州分公�?".equals(value)) {
			return SubCompanyEnum.Changzhou;
		}
		else if("淮安分公�?".equals(value)) {
			return SubCompanyEnum.Huaian;
		}
		else if("连云港分公司".equals(value)) {
			return SubCompanyEnum.Lianyungang;
		}
		else if("南京分公�?".equals(value)) {
			return SubCompanyEnum.Nanjing;
		}
		else if("南京高淳分公�?".equals(value)) {
			return SubCompanyEnum.NanjingGaochun;
		}
		else if("南京江宁分公�?".equals(value)) {
			return SubCompanyEnum.NanjingJiangning;
		}
		else if("南京溧水分公�?".equals(value)) {
			return SubCompanyEnum.NanjingLishui;
		}
		else if("南京六合分公�?".equals(value)) {
			return SubCompanyEnum.NanjingLuhe;
		}
		else if("南京浦口分公�?".equals(value)) {
			return SubCompanyEnum.NanjingPukou;
		}
		else if("南京雨花分公�?".equals(value)) {
			return SubCompanyEnum.NanjingYuhua;
		}
		else if("泰州分公�?".equals(value)) {
			return SubCompanyEnum.Taizhou;
		}
		else if("宿迁分公�?".equals(value)) {
			return SubCompanyEnum.Suqian;
		}
		else if("盐城分公�?".equals(value)) {
			return SubCompanyEnum.Yanchen;
		}
		else if("镇江分公�?".equals(value)) {
			return SubCompanyEnum.Zhenjiang;
		}
		else if("中广有线南�?�分公司".equals(value)) {
			return SubCompanyEnum.NantongZhongguang;
		}
		else if("中广有线徐州分公�?".equals(value)) {
			return SubCompanyEnum.XuzhouZhongguang;
		}
		return null;
	}
}
