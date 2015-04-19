package bwd.util;

public class ExcelException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2811721416762274650L;

	private String message = null;
	
	public ExcelException(String msg) {
		addMessage(msg);
	}
	
	public String getMessage() {
		return message;
	}
	
	public void addMessage(String msg) {
		//this.message.append(msg + "\n");
		this.message = msg;
	}

	
	public static void main(String[] args) {
		
	}

}
