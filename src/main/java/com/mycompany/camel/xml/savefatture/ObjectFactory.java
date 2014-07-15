//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.11 at 03:45:14 PM CEST 
//


package com.mycompany.camel.xml.savefatture;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.camel.xml.savefatture package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SERIES_QNAME = new QName("", "__SERIE_S");
    private final static QName _DATAINIZIONUMERAZIONEDT_QNAME = new QName("", "__DATA_INIZIO_NUMERAZIONE_DT");
    private final static QName _ANNOFISCALEI_QNAME = new QName("", "__ANNO_FISCALE_I");
    private final static QName _DOCHASH_QNAME = new QName("", "DOC_HASH");
    private final static QName _FILEID_QNAME = new QName("", "FILE_ID");
    private final static QName _TOTDOCS_QNAME = new QName("", "TOT_DOCS");
    private final static QName _SOCIETA_QNAME = new QName("", "SOCIETA");
    private final static QName _NUMERODOCRIF_QNAME = new QName("", "NUMERO_DOC_RIF");
    private final static QName _DATAREGISTRAZIONE_QNAME = new QName("", "DATA_REGISTRAZIONE");
    private final static QName _DATADOCUMENTODT_QNAME = new QName("", "__DATA_DOCUMENTO_DT");
    private final static QName _LOTID_QNAME = new QName("", "LOT_ID");
    private final static QName _PARTITAIVAS_QNAME = new QName("", "__PARTITA_IVA_S");
    private final static QName _TIPOCONS_QNAME = new QName("", "TIPO_CONS");
    private final static QName _FILENAME_QNAME = new QName("", "FILE_NAME");
    private final static QName _DENOMINAZIONES_QNAME = new QName("", "__DENOMINAZIONE_S");
    private final static QName _TOTALEIMPORTOD_QNAME = new QName("", "TOTALE_IMPORTO_D");
    private final static QName _CODICECLIENTE_QNAME = new QName("", "CODICE_CLIENTE");
    private final static QName _CODICEFISCALES_QNAME = new QName("", "__CODICE_FISCALE_S");
    private final static QName _NUMERODOCUMENTOL_QNAME = new QName("", "__NUMERO_DOCUMENTO_L");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.camel.xml.savefatture
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DOCUMENTO }
     * 
     */
    public DOCUMENTO createDOCUMENTO() {
        return new DOCUMENTO();
    }

    /**
     * Create an instance of {@link DOCUMENTI }
     * 
     */
    public DOCUMENTI createDOCUMENTI() {
        return new DOCUMENTI();
    }

    /**
     * Create an instance of {@link TESTATA }
     * 
     */
    public TESTATA createTESTATA() {
        return new TESTATA();
    }

    /**
     * Create an instance of {@link ROOT }
     * 
     */
    public ROOT createROOT() {
        return new ROOT();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "__SERIE_S")
    public JAXBElement<String> createSERIES(String value) {
        return new JAXBElement<String>(_SERIES_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "__DATA_INIZIO_NUMERAZIONE_DT")
    public JAXBElement<String> createDATAINIZIONUMERAZIONEDT(String value) {
        return new JAXBElement<String>(_DATAINIZIONUMERAZIONEDT_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "__ANNO_FISCALE_I")
    public JAXBElement<String> createANNOFISCALEI(String value) {
        return new JAXBElement<String>(_ANNOFISCALEI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DOC_HASH")
    public JAXBElement<String> createDOCHASH(String value) {
        return new JAXBElement<String>(_DOCHASH_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FILE_ID")
    public JAXBElement<String> createFILEID(String value) {
        return new JAXBElement<String>(_FILEID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TOT_DOCS")
    public JAXBElement<String> createTOTDOCS(String value) {
        return new JAXBElement<String>(_TOTDOCS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SOCIETA")
    public JAXBElement<String> createSOCIETA(String value) {
        return new JAXBElement<String>(_SOCIETA_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "NUMERO_DOC_RIF")
    public JAXBElement<String> createNUMERODOCRIF(String value) {
        return new JAXBElement<String>(_NUMERODOCRIF_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DATA_REGISTRAZIONE")
    public JAXBElement<String> createDATAREGISTRAZIONE(String value) {
        return new JAXBElement<String>(_DATAREGISTRAZIONE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "__DATA_DOCUMENTO_DT")
    public JAXBElement<String> createDATADOCUMENTODT(String value) {
        return new JAXBElement<String>(_DATADOCUMENTODT_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "LOT_ID")
    public JAXBElement<String> createLOTID(String value) {
        return new JAXBElement<String>(_LOTID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "__PARTITA_IVA_S")
    public JAXBElement<String> createPARTITAIVAS(String value) {
        return new JAXBElement<String>(_PARTITAIVAS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TIPO_CONS")
    public JAXBElement<String> createTIPOCONS(String value) {
        return new JAXBElement<String>(_TIPOCONS_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "FILE_NAME")
    public JAXBElement<String> createFILENAME(String value) {
        return new JAXBElement<String>(_FILENAME_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "__DENOMINAZIONE_S")
    public JAXBElement<String> createDENOMINAZIONES(String value) {
        return new JAXBElement<String>(_DENOMINAZIONES_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "TOTALE_IMPORTO_D")
    public JAXBElement<String> createTOTALEIMPORTOD(String value) {
        return new JAXBElement<String>(_TOTALEIMPORTOD_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "CODICE_CLIENTE")
    public JAXBElement<String> createCODICECLIENTE(String value) {
        return new JAXBElement<String>(_CODICECLIENTE_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "__CODICE_FISCALE_S")
    public JAXBElement<String> createCODICEFISCALES(String value) {
        return new JAXBElement<String>(_CODICEFISCALES_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "__NUMERO_DOCUMENTO_L")
    public JAXBElement<String> createNUMERODOCUMENTOL(String value) {
        return new JAXBElement<String>(_NUMERODOCUMENTOL_QNAME, String.class, null, value);
    }

}
