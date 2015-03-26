package bwd.dest.sheet1;


public enum OutServiceTypeEnum {

	// 视频
	HLWSP("ICNTV"),
//	HLWSPBY("互联网视频-包月"),
//	HLWSPDB("互联网视频-点播"),
	JSYX("极速院线"),
	MGTV("芒果TV"),
	BKXY("百科学苑"),
	// 教育
	GGLY("果果乐园"),//("果果乐园-包月"),
	YFJY("义方教育"),
	ZXYQ("自学引擎"),
	// 娱乐
	CHYY("彩虹音乐"),
//	CHYYBY("彩虹音乐-包月"),
//	CHYYYCH("彩虹音乐-演唱会"),
	YYX("云游戏"),
//	YYXBY("云游戏-包月"),
//	YYXDB("云游戏-点播"),
	YLY("1+云乐园"),
	RWGC("热舞广场"),
	// 阅读
	XYTS("喜阅童书"),
	YSTS("有声听书"),
//	YSTSBY("有声听书-包月"),
//	YSTSDB("有声听书-点播"),
	QZHB("启智绘本"),
//	QZHBBY("启智绘本-包月"),
//	QZHBDB("启智绘本-点播"),
	YZSC("云中书城"),
	// 资讯
	TQZX("天气资讯"),
	;
	
	private String value;
	
	private OutServiceTypeEnum(String value) {
		this.value = value;
	}
	
	public String getServiceName() {
		return this.value;
	}
	
	public static OutServiceTypeEnum getEnum(String value) {
		if (null == value) {
			return null;
		}
		
		if ("互联网视频-包月".equals(value)) {
			return OutServiceTypeEnum.HLWSP;
		}
		else if ("互联网视频-点播".equals(value)) {
			return OutServiceTypeEnum.HLWSP;
		}
		else if("极速院线".equals(value)) {
			return OutServiceTypeEnum.JSYX;
		}
		else if ("芒果TV".equals(value)) {
			return OutServiceTypeEnum.MGTV;
		}
		else if("百科学苑".equals(value)) {
			return OutServiceTypeEnum.BKXY;
		}
		else if("果果乐园-包月".equals(value)) {
			return OutServiceTypeEnum.GGLY;
		}
		else if("义方教育".equals(value)) {
			return OutServiceTypeEnum.YFJY;
		}
		else if("自学引擎".equals(value)) {
			return OutServiceTypeEnum.ZXYQ;
		}
		else if("彩虹音乐-包月".equals(value)) {
			return OutServiceTypeEnum.CHYY;
		}
		else if ("彩虹音乐-演唱会".equals(value)) {
			return OutServiceTypeEnum.CHYY;
		}
		else if("云游戏-包月".equals(value)) {
			return OutServiceTypeEnum.YYX;
		}
		else if ("云游戏-点播".equals(value)) {
			return OutServiceTypeEnum.YYX;
		}
		else if("1+云乐园".equals(value)) {
			return OutServiceTypeEnum.YLY;
		}
		else if("热舞广场".equals(value)) {
			return OutServiceTypeEnum.RWGC;
		}
		else if("喜阅童书".equals(value)) {
			return OutServiceTypeEnum.XYTS;
		}
		else if("有声听书-包月".equals(value)) {
			return OutServiceTypeEnum.YSTS;
		}
		else if ("有声听书-点播".equals(value)) {
			return OutServiceTypeEnum.YSTS;
		}
		else if("启智绘本-包月".equals(value)) {
			return OutServiceTypeEnum.QZHB;
		}
		else if ("启智绘本-点播".equals(value)) {
			return OutServiceTypeEnum.QZHB;
		}
		else if("云中书城".equals(value)) {
			return OutServiceTypeEnum.YZSC;
		}
		else if("天气资讯".equals(value)) {
			return OutServiceTypeEnum.TQZX;
		}
		
		return null;	
	}
	
	
	
}
