package com.mycompany.camel.entity;

import java.io.File;
import java.io.StringReader;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.mycompany.camel.util.Constants;
import com.mycompany.camel.xmlsave.ROOT;
import com.mycompany.camel.xmlsave.TESTATA;
import com.mycompany.camel.xmlsaveesito.DOCUMENTIESITO;
import com.mycompany.camel.xmlsaveesito.ROOTESITO;
import com.mycompany.camel.xmlsaveesito.TESTATAESITO;

public class ZipInfo {

	// private Map<String,File> pdfList = new HashMap<String,File>();
	private List<String> pdfList = new ArrayList<String>();
	private String xmlName;
	private String zipName;
	private String xmlContentString;
	private ROOT xmlContent;
	private ROOTESITO esito;
	private int numPdfInXml = -1;
	private boolean fatturaAttiva = false;
	

	public ZipInfo(String zipName) {
		this.zipName = zipName;
		// Inizializzo anche il messagio di risposta il messaggio di risposta
		ROOTESITO esito = new ROOTESITO();
		TESTATAESITO testataEsito = new TESTATAESITO();
		DOCUMENTIESITO documentiEsito = new DOCUMENTIESITO();
		esito.setTESTATAESITO(testataEsito);
		esito.setDOCUMENTIESITO(documentiEsito);
		this.esito = esito;
	}

	public List<String> getPdfList() {
		return pdfList;
	}

	public void setPdfList(List<String> pdfList) {
		this.pdfList = pdfList;
	}

	public String getXmlName() {
		return xmlName;
	}

	public void setXmlName(String xmlName) {
		this.xmlName = xmlName;
	}

	public String getZipName() {
		return zipName;
	}

	public void setZipName(String zipName) {
		this.zipName = zipName;
	}

	public ROOT getXmlContent() {
		return xmlContent;
	}

	public ROOTESITO getEsito() {
		return esito;
	}

	public String getXmlContentString() {
		return xmlContentString;
	}
	
	public int getNumPdfInXml(){
		return numPdfInXml;
	}
	
	public void setNumPdfInXml(){
		int numPdfInXml = -1;
		try{
			numPdfInXml = Integer.parseInt(getXmlContent().getTESTATA().getTOTDOCS());
		} catch (NumberFormatException e) {
			System.out.println("ZipZinfo.isNumPdfOK errore conversione TOTDOCS: "+ e.getMessage());
			e.printStackTrace();
		}
		this.numPdfInXml = numPdfInXml;
	}

	// creo l'oggetto xml
	public void setXmlContentString(String xmlContentString) {
		this.xmlContentString = xmlContentString;
		System.out.println("ZipZinfo.setXmlContentString:" + xmlContentString);
		try {
			JAXBContext context = JAXBContext.newInstance(ROOT.class);
			Unmarshaller unMarshaller = context.createUnmarshaller();
			System.out.println("ZipZinfo.setXmlContentString BEFORE" + xmlContentString);
			this.xmlContent = (ROOT) unMarshaller.unmarshal(new StringReader(xmlContentString));
			System.out.println("ZipZinfo.setXmlContentString POST");
			
			//creo la testata dell'esito XML (avviene dopo la validazione dell'xml)
			TESTATAESITO testataEsito = esito.getTESTATAESITO();
			TESTATA testata = xmlContent.getTESTATA();
		    //setto i dati di esito
		    testataEsito.setLOTID(testata.getLOTID());
		    testataEsito.setSERIES(testata.getSERIES());
		    testataEsito.setSOCIETA(testata.getSOCIETA());
		    testataEsito.setTIPOCONS(testata.getTIPOCONS());
		    
		    //setto il numero di pdf indicati nell'xml
		    setNumPdfInXml();
		    
		    //setto il messaggio ad ok di default
		    setEsitoOK();
		    
		    //setto il tipo di fattura
		    System.out.println("Tipo fattura :"+ testata.getTIPOCONS());
			setFatturaAttiva(testata.getTIPOCONS().equalsIgnoreCase(Constants.CODE_FATTURA_ATTIVA));
			
		} catch (JAXBException e) {
			System.out.println("ZipZinfo.setXmlContentString ERRORE creazione OGGETTO ROOT XML:"+ e.getMessage());
			e.printStackTrace();
		}
	}
	

	
	public void setEsitoOK() {
		setEsito(Constants.OK_MESSAGE, "");
	}
	
	public void setEsitoKO(String description) {
		setEsito(Constants.KO_MESSAGE, description);
	}
	
	//setta l'errore generale dell'esito e appende la descrizione generale a quelle gia' presenti
	public void setEsito(String message, String description) {
		esito.getTESTATAESITO().setESITO(message);
		esito.getTESTATAESITO().setDESCRIZIONEESITO(
				(esito.getTESTATAESITO().getDESCRIZIONEESITO()!=null
						&& !esito.getTESTATAESITO().getDESCRIZIONEESITO().equals("")
						)?esito.getTESTATAESITO().getDESCRIZIONEESITO()+"--":""
				+description);
	}
	
	//Scrivo l'xml di esito su file system 
	public void writeEsito() {
		writeEsito(Constants.STR_BASE_DIR  + Constants.FOLDER_SEPARATOR + Constants.STR_ESITI_DIR + Constants.FOLDER_SEPARATOR);
	}

	// Scrivo l'xml di esito su file system 
	public void writeEsito(String folder) {
		
		try {
			String pathXmlEsito = folder + zipName.substring(0,zipName.indexOf(Constants.ZIP_EXTENTION)) + Constants.XML_EXTENTION;
			File file = new File(pathXmlEsito);
			JAXBContext contextMarshall = JAXBContext.newInstance(ROOTESITO.class);

			Marshaller marshaller = contextMarshall.createMarshaller();

			// output pretty printed
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(esito, System.out);

			marshaller.marshal(esito, file);
			System.out.println("ZipZinfo.writeEsito Scrittura Esito completata:" + pathXmlEsito);
		} catch (JAXBException e) {
			System.out
			.println("ZipZinfo.writeEsito ERRORE creazione FILE di esito XML," 
					+zipName+":"
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {

		return "ZIPINFO:{" + "zipName=" + zipName + ";xmlName=" + xmlName
				+ ";pdfList=" + pdfList.size() + ";xmlContentString="
				+ xmlContentString + ";xmlContent=" + xmlContent + ";esito="
				+ esito + "}";

	}

	public boolean isFatturaAttiva() {
		return fatturaAttiva;
	}

	public void setFatturaAttiva(boolean fatturaAttiva) {
		this.fatturaAttiva = fatturaAttiva;
	}
}
