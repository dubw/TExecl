package bwd.dest.sheet1;


public enum OutServiceTypeEnum {

	// 视频
	HLWSPBY("互联网视频-包月"),
	BKXY("百科学苑"),
	// 教育
	GGLY("果果乐园-包月"),
	YFJY("义方教育"),
	ZXYQ("自学引擎"),
	// 娱乐
	CHYYBY("彩虹音乐-包月"),
	YYXBY("云游戏-包月"),
	YLY("1+云乐园"),
	RWGC("热舞广场"),
	// 阅读
	XYTS("喜阅童书"),
	YSTSBY("有声听书-包月"),
	QZHBBY("启智绘本-包月"),
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
		if("百科学苑".equals(value)) {
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
			return OutServiceTypeEnum.CHYYBY;
		}
		else if("云游戏-包月".equals(value)) {
			return OutServiceTypeEnum.YYXBY;
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
			return OutServiceTypeEnum.YSTSBY;
		}
		else if("启智绘本-包月".equals(value)) {
			return OutServiceTypeEnum.QZHBBY;
		}
		else if("云中书城".equals(value)) {
			return OutServiceTypeEnum.YZSC;
		}
		else if("天气资讯".equals(value)) {
			return OutServiceTypeEnum.TQZX;
		}
		else if ("互联网视频-包月".equals(value)) {
			return OutServiceTypeEnum.HLWSPBY;
		}
		
		return null;	
	}
	
	
	
}
