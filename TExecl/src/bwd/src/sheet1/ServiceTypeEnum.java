package bwd.src.sheet1;

public enum ServiceTypeEnum {

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
	
	// other
	JSYX("极速院线"),
	MGTV("芒果TV"),	
	CHYYYCH("彩虹音乐-演唱会"),
	HLWSPDB("互联网视频-点播"),
	QZHBDB("启智绘本-点播"),
	YSTSDB("有声听书-点播"),
	YYXDB("云游戏-点播"),
	;
	
	private String value;
	
	private ServiceTypeEnum(String value) {
		this.value = value;
	}
	
	public String getServiceName() {
		return this.value;
	}
	
	public static ServiceTypeEnum getEnum(String value) {
		if (null == value) {
			return null;
		}
		if("百科学苑".equals(value)) {
			return ServiceTypeEnum.BKXY;
		}
		else if("果果乐园-包月".equals(value)) {
			return ServiceTypeEnum.GGLY;
		}
		else if("义方教育".equals(value)) {
			return ServiceTypeEnum.YFJY;
		}
		else if("自学引擎".equals(value)) {
			return ServiceTypeEnum.ZXYQ;
		}
		else if("彩虹音乐-包月".equals(value)) {
			return ServiceTypeEnum.CHYYBY;
		}
		else if("彩虹音乐-演唱会".equals(value)) {
			return ServiceTypeEnum.CHYYYCH;
		}
		else if("云游戏-包月".equals(value)) {
			return ServiceTypeEnum.YYXBY;
		}
		else if("云游戏-点播".equals(value)) {
			return ServiceTypeEnum.YYXDB;
		}
		else if("1+云乐园".equals(value)) {
			return ServiceTypeEnum.YLY;
		}
		else if("热舞广场".equals(value)) {
			return ServiceTypeEnum.RWGC;
		}
		else if("喜阅童书".equals(value)) {
			return ServiceTypeEnum.XYTS;
		}
		else if("有声听书-包月".equals(value)) {
			return ServiceTypeEnum.YSTSBY;
		}
		else if("有声听书-点播".equals(value)) {
			return ServiceTypeEnum.YSTSDB;
		}
		else if("启智绘本-包月".equals(value)) {
			return ServiceTypeEnum.QZHBBY;
		}
		else if("启智绘本-点播".equals(value)) {
			return ServiceTypeEnum.QZHBDB;
		}
		else if("云中书城".equals(value)) {
			return ServiceTypeEnum.YZSC;
		}
		else if("天气资讯".equals(value)) {
			return ServiceTypeEnum.TQZX;
		}
		else if("极速院线".equals(value)) {
			return ServiceTypeEnum.JSYX;
		}
		else if("芒果TV".equals(value)) {
			return ServiceTypeEnum.MGTV;
		}
		else if ("互联网视频-包月".equals(value)) {
			return ServiceTypeEnum.HLWSPBY;
		}
		else if ("互联网视频-点播".equals(value)) {
			return ServiceTypeEnum.HLWSPDB;
		}
		
		return null;	
	}
	
	
	
}
