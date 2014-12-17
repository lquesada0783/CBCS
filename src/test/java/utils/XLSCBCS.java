package utils;

import java.util.ArrayList;

public class XLSCBCS {
	
	protected String xlsName;
	protected ArrayList<String> columsHeader;	
	protected String directoryName;
	String project;
	
	public XLSCBCS(String xlsName){
		this.setXlsName(xlsName);
		project = "CBCS";		
	}
	
	public ArrayList<String> getColumsHeader() {
		return columsHeader;
	}

	public void setColumsHeader(ArrayList<String> columsHeader) {
		this.columsHeader = columsHeader;
	}
	
	public String getXlsName() {
		return xlsName;
	}

	public String getDirectoryName() {
		return directoryName;
	}

	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}

	public void setXlsName(String xlsName) {
		this.xlsName = xlsName;
	}		
}