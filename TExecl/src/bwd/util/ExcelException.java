package bwd.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2811721416762274650L;

	public ExcelException(String msg) {
		super(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " : \r\n" + msg);
	}
	
}
