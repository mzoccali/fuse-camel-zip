//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.11 at 04:36:45 PM CEST 
//


package com.mycompany.camel.xml.savefattureesito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}LOT_ID"/>
 *         &lt;element ref="{}DESCRIZIONE_ERRORE"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "lotid",
    "descrizioneerrore"
})
@XmlRootElement(name = "DOCUMENTOESITO")
public class DOCUMENTOESITO {

    @XmlElement(name = "LOT_ID", required = true)
    protected String lotid;
    @XmlElement(name = "DESCRIZIONE_ERRORE", required = true)
    protected String descrizioneerrore;

    /**
     * Gets the value of the lotid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOTID() {
        return lotid;
    }

    /**
     * Sets the value of the lotid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOTID(String value) {
        this.lotid = value;
    }

    /**
     * Gets the value of the descrizioneerrore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESCRIZIONEERRORE() {
        return descrizioneerrore;
    }

    /**
     * Sets the value of the descrizioneerrore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESCRIZIONEERRORE(String value) {
        this.descrizioneerrore = value;
    }

}
