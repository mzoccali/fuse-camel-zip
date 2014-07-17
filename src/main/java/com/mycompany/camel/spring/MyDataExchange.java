package com.mycompany.camel.spring;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Headers;

import com.mycompany.camel.entity.ZipInfo;
import com.mycompany.camel.util.Constants;
import com.mycompany.camel.xmlsave.TESTATA;
import com.mycompany.camel.xmlsaveesito.TESTATAESITO;

public class MyDataExchange {

	public static Map<String, ZipInfo> files = new HashMap<String, ZipInfo>();

	public void addZip(@Headers Map headers) throws Exception {

		System.out.println("MyExchangeData.addZip headers:" + headers);
		String zipName = (String) headers.get("CamelFileName");
		ZipInfo zipInfo = new ZipInfo(zipName);
		files.put(zipName, zipInfo);
		System.out.println("MyExchangeData.addZip zipInfo: " +zipInfo);

	}

	public void addFileXml(@Headers Map headers, Exchange exchange)
			throws Exception {
		
		System.out.println("MyExchangeData.addFileXml headers:" + headers);
		
		String xmlName = (String) headers.get("CamelFileName");
		String xmlContentString = exchange.getIn().getBody(String.class);
		ZipInfo zipInfo = getZipInfo(headers);
		System.out.println("MyExchangeData.addZip data:" + xmlName + "--"+ xmlContentString + "--"+ zipInfo);
		
		if (zipInfo != null) {
			zipInfo.setXmlName(xmlName);
			zipInfo.setXmlContentString(xmlContentString);
			System.out.println("MyExchangeData.addFileXml zipInfo2: " +zipInfo);
		}
	}

	public void addFilePdf(@Headers Map headers){
		System.out.println("MyExchangeData.addFilePdf headers:" + headers);
		ZipInfo zipInfo = getZipInfo(headers);
		System.out.println("MyExchangeData.addFilePdf zipInfo: " +zipInfo);
		zipInfo.getPdfList().add((String) headers.get("CamelFileName"));

	}
	
	public void checkNumPdf(@Headers Map headers){
		System.out.println("MyExchangeData.checkNumPdf headers:" + headers);
		ZipInfo zipInfo = getZipInfo(headers);
		System.out.println("MyExchangeData.checkNumPdf numero pdf:"+ zipInfo.getPdfList().size()+ "-numero pdf in XML="+zipInfo.getNumPdfInXml());
		if (zipInfo.getPdfList().size() != zipInfo.getNumPdfInXml())
			zipInfo.setEsitoKO("Errore nel numero di pdf indicati nell'xml, numero pdf:"+ zipInfo.getPdfList().size()+ "-numero pdf in XML="+zipInfo.getNumPdfInXml());

	}
	
	
	public void setEsitoKOXmlValidation(@Headers Map headers) {
		ZipInfo zipInfo = getZipInfo(headers);
		zipInfo.setEsitoKO("Errore nello zip: " + zipInfo.getZipName() +" - Errore di validazione xml: "+ zipInfo.getXmlName());
	}
	
	public void setEsitoKOPdfValidation(@Headers Map headers) {
		ZipInfo zipInfo = getZipInfo(headers);
		zipInfo.setEsitoKO("Errore nello zip: " + zipInfo.getZipName() +" - Errore di validazione pdf: "+ (String) headers.get("CamelFileName"));
	}
	
	public void setEsitoKOZipNameValidation(@Headers Map headers) {
		ZipInfo zipInfo = getZipInfo(headers);
		zipInfo.setEsitoKO("Nome Zip non corretto nome atteso : " + headers.get("fileZipDynamicName") + ",nome attuale:" + zipInfo.getZipName());
	}
	
	//Scrivo l'xml di esito su file system 
	public void writeEsito(@Headers Map headers) {
		ZipInfo zipInfo = getZipInfo(headers);
		zipInfo.writeEsito();
	}
	
	
	
	
	private ZipInfo getZipInfo(Map headers){
		//TODO: verificare se e' necessario rialzare eccezione se lo ZipInfo cerca non esiste nella mappa
		return files.get(getZipName(headers));
		
	}
	
	private String getZipName(Map headers){
		return getZipName((String) headers.get("CamelFileRelativePath"));
	}
	
	private String getZipName(String relativePath){
		System.out.println("MyExchangeData.relativePath relativePath: " +relativePath);
		return relativePath.substring(0,relativePath.indexOf(Constants.ZIP_EXTENTION))+Constants.ZIP_EXTENTION;
		
	}
}