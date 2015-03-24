package bwd.src.sheet1;

public enum PayEnum {

	Dinggou("1.订购"),
	Yewudinggou("2.业务订购"),
	Dianbo("3.点播"),
	Xiaofei("4.消费");
	
	private String value;
	
	private PayEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public static PayEnum getEnum(String value) {
		if (null == value) {
			return null;
		}
		if ("1.订购".equals(value)) {
			return PayEnum.Dinggou;
		}
		else if ("2.业务订购".equals(value)) {
			return PayEnum.Yewudinggou;
		}
		else if ("3.点播".equals(value)) {
			return PayEnum.Dianbo;
		}
		else if ("4.消费".equals(value)) {
			return PayEnum.Xiaofei;
		}
		
		return null;
	}
}
