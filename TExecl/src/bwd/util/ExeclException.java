package bwd.util;

public class ExeclException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2811721416762274650L;

//	private StringBuilder message = new StringBuilder("");
	private String message = null;
	
	public ExeclException(String msg) {
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
