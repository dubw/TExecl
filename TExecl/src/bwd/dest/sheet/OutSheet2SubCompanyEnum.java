package bwd.dest.sheet;

import bwd.param.Param;
import bwd.util.ExcelException;

public enum OutSheet2SubCompanyEnum {
	
	Nanjing("南京分公司"),
	// 南京地区
	NanjingJiangning("南京江宁公司"),
	NanjingPukou("南京浦口公司"),
	NanjingLishui("南京溧水公司"),
	NanjingYuhua("南京雨花广电"),
	NanjingLuhe("南京六合公司"),
	NanjingGaochun("南京高淳公司"),
	NanjingHonghuazhan("南京红花站"),
	// 其他地市
	Taizhou("泰州分公司"),
	NantongZhongguang("南通分公司"),
	XuzhouZhongguang("徐州分公司"),
	Suqian("宿迁分公司"),
	Huaian("淮安分公司"),
	Lianyungang("连云港分公司"),
	Yanchen("盐城分公司"),
	Zhenjiang("镇江分公司"),
	Changzhou("常州分公司"),
	;
	
	private String value;
	
	private OutSheet2SubCompanyEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static OutSheet2SubCompanyEnum getEnum(String value) throws ExcelException {
		if (null == value) {
			throw new NullPointerException();
		}
		if("南京分公司".equals(value)) {
			return OutSheet2SubCompanyEnum.Nanjing;
		}
		else if("南京高淳公司".equals(value)) {
			return OutSheet2SubCompanyEnum.NanjingGaochun;
		}
		else if("南京江宁公司".equals(value)) {
			return OutSheet2SubCompanyEnum.NanjingJiangning;
		}
		else if("南京溧水公司".equals(value)) {
			return OutSheet2SubCompanyEnum.NanjingLishui;
		}
		else if("南京六合公司".equals(value)) {
			return OutSheet2SubCompanyEnum.NanjingLuhe;
		}
		else if("南京浦口公司".equals(value)) {
			return OutSheet2SubCompanyEnum.NanjingPukou;
		}
		else if("南京雨花广电".equals(value)) {
			return OutSheet2SubCompanyEnum.NanjingYuhua;
		}
		else if ("常州分公司".equals(value)) {
			return OutSheet2SubCompanyEnum.Changzhou;
		}
		else if("淮安分公司".equals(value)) {
			return OutSheet2SubCompanyEnum.Huaian;
		}
		else if("连云港分公司".equals(value)) {
			return OutSheet2SubCompanyEnum.Lianyungang;
		}
		else if("泰州分公司".equals(value)) {
			return OutSheet2SubCompanyEnum.Taizhou;
		}
		else if("宿迁分公司".equals(value)) {
			return OutSheet2SubCompanyEnum.Suqian;
		}
		else if("盐城分公司".equals(value)) {
			return OutSheet2SubCompanyEnum.Yanchen;
		}
		else if("镇江分公司".equals(value)) {
			return OutSheet2SubCompanyEnum.Zhenjiang;
		}
		else if("中广有线南通分公司".equals(value)) {
			return OutSheet2SubCompanyEnum.NantongZhongguang;
		}
		else if("中广有线徐州分公司".equals(value)) {
			return OutSheet2SubCompanyEnum.XuzhouZhongguang;
		}
		throw new ExcelException("OutSheet3SubCompanyEnum getEnum() method error! 解析 " + Param.getSrcSheet1Name() + "分公司名称错误！");
	}

	@Override
	public String toString() {
		return this.value;
	}
}


