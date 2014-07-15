package com.mycompany.camel.entity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ZipContent {

	private Map<String,File> pdfList = new HashMap<String,File>(); 
	private File xmlFile;
	private String zipName;
	
	
	public Map<String,File> getPdfList() {
		return pdfList;
	}
	public void setPdfList(Map<String,File> pdfList) {
		this.pdfList = pdfList;
	}
	public void addPdf(String name,File file) {
		this.pdfList.put(name, file);
	}
	
	public File getXmlFile() {
		return xmlFile;
	}
	public void setXmlFile(File xmlFile) {
		this.xmlFile = xmlFile;
	}
	public String getZipName() {
		return zipName;
	}
	public void setZipName(String zipName) {
		this.zipName = zipName;
	}
	
}
