package bwd.src.sheet1;


public enum SubCompanyEnum {
	
	Nanjing("南京分公司"),
	// 南京地区
	NanjingGaochun("南京高淳公司"),
	NanjingJiangning("南京江宁公司"),
	NanjingLishui("南京溧水公司"),
	NanjingLuhe("南京六合公司"),
	NanjingPukou("南京浦口公司"),
	NanjingYuhua("南京雨花广电"),
	NanjingHonghuazhan("南京红花站"),
	// 其他地市
	Changzhou("常州分公司"),
	Huaian("淮安分公司"),
	Lianyungang("连云港分公司"),
	Taizhou("泰州分公司"),
	Suqian("宿迁分公司"),
	Yanchen("盐城分公司"),
	Zhenjiang("镇江分公司"),
	NantongZhongguang("中广有线南通分公司"),
	XuzhouZhongguang("中广有线徐州分公司");	
	
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
		if("南京分公司".equals(value)) {
			return SubCompanyEnum.Nanjing;
		}
		else if("南京高淳公司".equals(value)) {
			return SubCompanyEnum.NanjingGaochun;
		}
		else if("南京江宁公司".equals(value)) {
			return SubCompanyEnum.NanjingJiangning;
		}
		else if("南京溧水公司".equals(value)) {
			return SubCompanyEnum.NanjingLishui;
		}
		else if("南京六合公司".equals(value)) {
			return SubCompanyEnum.NanjingLuhe;
		}
		else if("南京浦口公司".equals(value)) {
			return SubCompanyEnum.NanjingPukou;
		}
		else if("南京雨花广电".equals(value)) {
			return SubCompanyEnum.NanjingYuhua;
		}
		else if ("常州分公司".equals(value)) {
			return SubCompanyEnum.Changzhou;
		}
		else if("淮安分公司".equals(value)) {
			return SubCompanyEnum.Huaian;
		}
		else if("连云港分公司".equals(value)) {
			return SubCompanyEnum.Lianyungang;
		}
		else if("泰州分公司".equals(value)) {
			return SubCompanyEnum.Taizhou;
		}
		else if("宿迁分公司".equals(value)) {
			return SubCompanyEnum.Suqian;
		}
		else if("盐城分公司".equals(value)) {
			return SubCompanyEnum.Yanchen;
		}
		else if("镇江分公司".equals(value)) {
			return SubCompanyEnum.Zhenjiang;
		}
		else if("中广有线南通分公司".equals(value)) {
			return SubCompanyEnum.NantongZhongguang;
		}
		else if("中广有线徐州分公司".equals(value)) {
			return SubCompanyEnum.XuzhouZhongguang;
		}
		return null;
	}
	@Override
	public String toString() {
		return this.value;
	}
}
