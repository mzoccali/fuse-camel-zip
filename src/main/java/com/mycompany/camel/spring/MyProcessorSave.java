package com.mycompany.camel.spring;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xml.sax.helpers.DefaultHandler;

import com.mycompany.camel.entity.ZipContent;
import com.mycompany.camel.xml.savefatture.DOCUMENTI;
import com.mycompany.camel.xml.savefatture.DOCUMENTO;
import com.mycompany.camel.xml.savefatture.ROOT;
import com.mycompany.camel.xml.savefatture.TESTATA;
import com.mycompany.camel.xml.savefattureesito.DOCUMENTIESITO;
import com.mycompany.camel.xml.savefattureesito.DOCUMENTOESITO;
import com.mycompany.camel.xml.savefattureesito.ROOTESITO;
import com.mycompany.camel.xml.savefattureesito.TESTATAESITO;


public class MyProcessorSave implements Processor {
	
public final String strBaseDir = "P:\\Fuse\\FuseIDE-6.0.0\\workspace\\camel-spring\\src\\data\\";
public final String strInputDir = strBaseDir + "Input";
public final String strElaboratiDir = strBaseDir + "Elaborati\\";
public final String strErrariDir = strBaseDir + "Errati\\";
public final String strUnzipDir = strBaseDir + "Unzip";
public final String strEsitiDir = strBaseDir + "Esiti\\";
public final String strXsdDir = strBaseDir + "xsd\\";
public final String xsdFatture = "save-fatture.xsd";

public final String fileNameSeparator = "_";

public final String OK_MESSAGE = "OK";
public final String KO_MESSAGE = "non OK";


protected AbstractApplicationContext createApplicationContext() {
	return new ClassPathXmlApplicationContext(
			"META-INF/spring/camel-context.xml");
}


public void process(Exchange exchange) throws Exception {
		File dirInput = new File(strInputDir);
		File dirUnzip = new File(strUnzipDir);

		ZipContent zipContent = new ZipContent();
		
		//FIXME: qua va preso il nome del file zip dall'exchange in qualche modo
		File filesInput[]=dirInput.listFiles();
		File zipFile = filesInput[0]; 
		//rimuovo l'estensione
		zipContent.setZipName(zipFile.getName().substring(0, zipFile.getName().indexOf('.')));
		System.out.println("zipFileName: "+zipContent.getZipName());
		
		
		//FIXME: l'elaborazione deve avvenire in una sottocartella nominata come il file zip
		File filesUnzip[]=dirUnzip.listFiles();	
		
		for( File f : filesUnzip ){
			System.out.println("nomeFile: " + f.getName());
			if (f.getName().toLowerCase().endsWith("xml"))
				zipContent.setXmlFile(f);
			if (f.getName().toLowerCase().endsWith("pdf"))
				zipContent.addPdf(f.getName(),f);
			
		}
		
		
		//preparo il file di esito
	    ROOTESITO esito = new ROOTESITO();
	    TESTATAESITO testataEsito = new TESTATAESITO();
	    DOCUMENTIESITO documentiEsito = new DOCUMENTIESITO();
	    esito.setTESTATAESITO(testataEsito);
	    esito.setDOCUMENTIESITO(documentiEsito);
		
		
		//leggo e valido xml
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schemaFatture = schemaFactory.newSchema(new File(strXsdDir+xsdFatture)); 
		JAXBContext context = JAXBContext.newInstance(ROOT.class);
	    Unmarshaller unMarshaller = context.createUnmarshaller();
	    unMarshaller.setSchema(schemaFatture);
	    ROOT root = null;
	    TESTATA testata = null;
	    DOCUMENTI documenti = null;
	    try{
	    	root = (ROOT) unMarshaller.unmarshal(zipContent.getXmlFile());
		    testata = root.getTESTATA();
		    documenti = root.getDOCUMENTI();
	    
	    
	   
	    
		    //setto i dati di esito
		    testataEsito.setLOTID(testata.getLOTID());
		    testataEsito.setSERIES(testata.getSERIES());
		    testataEsito.setSOCIETA(testata.getSOCIETA());
		    testataEsito.setTIPOCONS(testata.getTIPOCONS());
		    //inizio settandolo ad ok
		    testataEsito.setESITO(OK_MESSAGE);
		    
		    
		    
		    
		    //VERIFICA nome zip
		    String nomeFileDaXml =
		    		root.getTESTATA().getTIPOCONS()+
		    		fileNameSeparator+
		    		root.getTESTATA().getSOCIETA()+
		    		fileNameSeparator+
		    		((root.getTESTATA().getSERIES() == null || root.getTESTATA().getSERIES().equals(""))?"xx":root.getTESTATA().getSERIES())+
		    		fileNameSeparator+
		    		root.getTESTATA().getLOTID();
			
		    
		    System.out.println("nomeFileDaXml: " + nomeFileDaXml);
			System.out.println("nomeFile: " + zipContent.getZipName());
		    if (nomeFileDaXml.equals(zipContent.getZipName())){
		    	System.out.println("CHECK NOME ZIP OK");
		    }else{
		    	System.out.println("CHECK NOME ZIP KO");
			    testataEsito.setESITO(KO_MESSAGE);
			    testataEsito.setDESCRIZIONEESITO("Nome Zip non corretto");
		    	
		    }
		  
		    
		    
		    //VERIFICA numero documenti
		    System.out.println("Numero di file nello zip : " + zipContent.getPdfList().size());
		    System.out.println("Numero di file dichiarati nell'xml: " + testata.getTOTDOCS());
		    int numDoc = 0;
		    try{
		    	numDoc = new Integer(testata.getTOTDOCS()).intValue();
		    }catch(NumberFormatException nfe){
		    	System.out.println("Numero di file dichiarato errato" + testata.getTOTDOCS());
		    }
		    if (numDoc == zipContent.getPdfList().size()){
		    	System.out.println("CHECK NUMERO DOCUMENTI OK");
		    }else{
		    	System.out.println("CHECK NUMERO DOCUMENTI KO");
			    testataEsito.setESITO(KO_MESSAGE);
			    testataEsito.setDESCRIZIONEESITO("Numero di documenti dichiarato non corrisponde, dichiarati:" +
			    	numDoc +
			    	"zip:"+zipContent.getPdfList().size());
		    	
		    }
		    
		    
		    
		    //VERIFICA hash pdf
		    //TODO: ora sempre errato
		    for (DOCUMENTO documento : documenti.getDOCUMENTO()) {
				File f = zipContent.getPdfList().get(documento.getFILENAME());
				//verifica hash PDF
				System.out.println("CHECK PDF "+f.getName());
				if (false){
					DOCUMENTOESITO documentoEsito = new DOCUMENTOESITO();
					documentoEsito.setLOTID(documento.getLOTID());
					documentoEsito.setDESCRIZIONEERRORE("Hash pdf errat");
					testataEsito.setESITO(KO_MESSAGE);
					documentiEsito.getDOCUMENTOESITO().add(documentoEsito);
				}
			}
	    
	    }catch (UnmarshalException e) {
	    	System.out.println("Errore di validazione xml: "+ zipContent.getXmlFile().getName());
	    	System.out.println("Errore di validazione xml errore: "+ e.getMessage());
	    	e.printStackTrace();
	    	testataEsito.setESITO(KO_MESSAGE);
		    testataEsito.setDESCRIZIONEESITO("Errore nello zip: " + zipContent.getZipName() +" - Errore di validazione xml: "+ zipContent.getXmlFile().getName()+" message: "+e.getMessage());
		}
	    
	    
	    
	    //Scrivo l'esito
	    File file = new File(strEsitiDir+zipContent.getZipName()+".xml");
	    JAXBContext contextMarshall = JAXBContext.newInstance(ROOTESITO.class);
	    Marshaller marshaller = contextMarshall.createMarshaller();
		
		// output pretty printed
	    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    marshaller.marshal(esito, System.out);
	    
	    marshaller.marshal(esito, file);
	    
		//cancello i fiel unzippati
	    System.out.println("Eliminazione file unzippati");
	    //FIXME
	    zipContent.getXmlFile().delete();
	    //zipContent.getXmlFile().deleteOnExit();
		for (String key : zipContent.getPdfList().keySet()) {
			zipContent.getPdfList().get(key).delete();
		}
	    
	    //se tutto ok il file zip viene spostato nella cartella degli elaborati 
		if (testataEsito.getESITO().equals(OK_MESSAGE)){
			System.out.println("Esito OK sposto lo zip in elaborati");
			Files.move(Paths.get(zipFile.getAbsolutePath()), Paths.get(strElaboratiDir+zipFile.getName()));
			
		}else{
			System.out.println("Esito KO sposto lo zip in errati");
			Files.move(Paths.get(zipFile.getAbsolutePath()), Paths.get(strErrariDir+zipFile.getName()));
		}
		
		
	}
}