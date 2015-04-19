package bwd.action;

import org.apache.poi.ss.usermodel.Sheet;

import bwd.util.ExcelException;

public interface ISrcSheet2DestSheet {
	
	public void fillOutSheet(Sheet destSheet) throws ExcelException;
	
}
