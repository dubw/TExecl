package bwd.dest.sheet;

import java.util.LinkedHashMap;
import java.util.Map;

import bwd.util.ExcelInnerException;

public class OutSheet2 {

	private Map<OutSheet2SubCompanyEnum, OutSheet2Item> outSheet2Items = new LinkedHashMap<OutSheet2SubCompanyEnum, OutSheet2Item>();

	public OutSheet2() {
		for (OutSheet2SubCompanyEnum e : OutSheet2SubCompanyEnum.values()) {
			addOutSheet2Item(e, new OutSheet2Item(e));
		}
	}
	
	public Map<OutSheet2SubCompanyEnum, OutSheet2Item> getOutSheet2Items() {
		return outSheet2Items;
	}
	
	public OutSheet2Item getOutSheet2Item(OutSheet2SubCompanyEnum subcompany) throws ExcelInnerException {
		if (!outSheet2Items.containsKey(subcompany)) {
			throw new ExcelInnerException("outsheet2 getOutSheet2Item() doesn't contain the subcompany name: " + subcompany.toString());
		}
		return outSheet2Items.get(subcompany);
	}

	public void addOutSheet2Item(OutSheet2SubCompanyEnum subcompany, OutSheet2Item item) {
		outSheet2Items.put(subcompany, item);
	}
	
	public void addOutSheet2ItemSubscribeNum(OutSheet2SubCompanyEnum subcompany, Double subscribeNum) throws ExcelInnerException {
		if (!outSheet2Items.containsKey(subcompany)) {
			throw new ExcelInnerException("outsheet2 addOutSheet2Item() doesn't contain the subcompany name: " + subcompany.toString());
		}
		OutSheet2Item item = outSheet2Items.get(subcompany);
		item.setSubscribeNum(item.getSubscribeNum() + subscribeNum);
	}
	public void addOutSheet2ItemDeleteNum(OutSheet2SubCompanyEnum subcompany, Double deleteNum) throws ExcelInnerException {
		if (!outSheet2Items.containsKey(subcompany)) {
			throw new ExcelInnerException("outsheet2 addOutSheet2ItemDeleteNum() doesn't contain the subcompany name: " + subcompany.toString());
		}
		OutSheet2Item item = outSheet2Items.get(subcompany);
		item.setDeleteNum(item.getDeleteNum() + deleteNum);
	}
	public void addOutSheet2ItemIncreaseTerminalNum(OutSheet2SubCompanyEnum subcompany, Double increaseTerminalNum) throws ExcelInnerException {
		if (!outSheet2Items.containsKey(subcompany)) {
			throw new ExcelInnerException("outsheet2 addOutSheet2ItemIncreaseTerminalNum() doesn't contain the subcompany name: " + subcompany.toString());
		}
		OutSheet2Item item = outSheet2Items.get(subcompany);
		item.setIncreaseTerminalNum(item.getIncreaseTerminalNum() + increaseTerminalNum);
	}
	public void addOutSheet2ItemSubscribeCycleEndNum(OutSheet2SubCompanyEnum subcompany, Double subscribeCycleEndNum) throws ExcelInnerException {
		if (!outSheet2Items.containsKey(subcompany)) {
			throw new ExcelInnerException("outsheet2 addOutSheet2ItemSubscribeCycleEndNum() doesn't contain the subcompany name: " + subcompany.toString());
		}
		OutSheet2Item item = outSheet2Items.get(subcompany);
		item.setSubscribeCycleEndNum(item.getSubscribeCycleEndNum() + subscribeCycleEndNum);
	}
	public void addOutSheet2ItemRevenue(OutSheet2SubCompanyEnum subcompany, Double revenue) throws ExcelInnerException {
		if (!outSheet2Items.containsKey(subcompany)) {
			throw new ExcelInnerException("outsheet2 addOutSheet2ItemRevenue() doesn't contain the subcompany name: " + subcompany.toString());
		}
		OutSheet2Item item = outSheet2Items.get(subcompany);
		item.setRevenue(item.getRevenue() + revenue);
	}

	
	
}
