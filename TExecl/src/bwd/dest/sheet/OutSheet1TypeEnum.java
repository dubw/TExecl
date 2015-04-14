package bwd.dest.sheet;


public enum OutSheet1TypeEnum {

	// 视频
	HLWSP("ICNTV"),
	JSYX("极速院线"),
	MGTV("芒果TV"),
	BKXY("百科学苑"),
	// 教育
	GGLY("果果乐园"),//("果果乐园-包月"),
	YFJY("义方教育"),
	ZXYQ("自学引擎"),
	// 娱乐
	CHYY("彩虹音乐"),
	YYX("云游戏"),
	YLY("1+云乐园"),
	RWGC("热舞广场"),
	// 阅读
	XYTS("喜阅童书"),
	YSTS("有声听书"),
	QZHB("启智绘本"),
	YZSC("云中书城"),
	// 资讯
	TQZX("天气资讯"),
	;
	
	private String value;
	
	private OutSheet1TypeEnum(String value) {
		this.value = value;
	}
	
	public String getServiceName() {
		return this.value;
	}
	
	public static OutSheet1TypeEnum getEnum(String value) {
		if (null == value) {
			return null;
		}
		
		if ("互联网视频-包月".equals(value)) {
			return OutSheet1TypeEnum.HLWSP;
		}
		else if ("互联网视频-点播".equals(value)) {
			return OutSheet1TypeEnum.HLWSP;
		}
		else if("极速院线".equals(value)) {
			return OutSheet1TypeEnum.JSYX;
		}
		else if ("芒果TV".equals(value)) {
			return OutSheet1TypeEnum.MGTV;
		}
		else if("百科学苑".equals(value)) {
			return OutSheet1TypeEnum.BKXY;
		}
		else if("果果乐园-包月".equals(value)) {
			return OutSheet1TypeEnum.GGLY;
		}
		else if("义方教育".equals(value)) {
			return OutSheet1TypeEnum.YFJY;
		}
		else if("自学引擎".equals(value)) {
			return OutSheet1TypeEnum.ZXYQ;
		}
		else if("彩虹音乐-包月".equals(value)) {
			return OutSheet1TypeEnum.CHYY;
		}
		else if ("彩虹音乐-演唱会".equals(value)) {
			return OutSheet1TypeEnum.CHYY;
		}
		else if("云游戏-包月".equals(value)) {
			return OutSheet1TypeEnum.YYX;
		}
		else if ("云游戏-点播".equals(value)) {
			return OutSheet1TypeEnum.YYX;
		}
		else if("1+云乐园".equals(value)) {
			return OutSheet1TypeEnum.YLY;
		}
		else if("热舞广场".equals(value)) {
			return OutSheet1TypeEnum.RWGC;
		}
		else if("喜阅童书".equals(value)) {
			return OutSheet1TypeEnum.XYTS;
		}
		else if("有声听书-包月".equals(value)) {
			return OutSheet1TypeEnum.YSTS;
		}
		else if ("有声听书-点播".equals(value)) {
			return OutSheet1TypeEnum.YSTS;
		}
		else if("启智绘本-包月".equals(value)) {
			return OutSheet1TypeEnum.QZHB;
		}
		else if ("启智绘本-点播".equals(value)) {
			return OutSheet1TypeEnum.QZHB;
		}
		else if("云中书城".equals(value)) {
			return OutSheet1TypeEnum.YZSC;
		}
		else if("天气资讯".equals(value)) {
			return OutSheet1TypeEnum.TQZX;
		}
		
		return null;	
	}
	
	
	
}
