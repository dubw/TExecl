package bwd.src.sheet1;

import java.util.ArrayList;

public class Report {
	
	private ArrayList<ServiceItem> items = null;
	
	public ArrayList<ServiceItem> getItems() {
		return this.items;
	}
	
	public boolean addItem(ServiceItem item) {
		if (null == item) {
			return false;
		}
		if (null == this.items) {
			this.items = new ArrayList<ServiceItem>(1);
		}
		
		return this.items.add(item);
	}
	

}
