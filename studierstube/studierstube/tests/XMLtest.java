/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.tests;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import studierstube.Fehler;

public class XMLtest {
	DocumentBuilderFactory factory;
	Document document;
	
	public XMLtest() {
	    try {
	        this.speichereXML();
	       }
	       catch (Exception e) {
	         Fehler.displayException(e);
	         e.printStackTrace();
	       }
	}
	
    public void speichereXML() 
    throws ParserConfigurationException, TransformerException {
    factory = DocumentBuilderFactory.newInstance();
    document = factory.newDocumentBuilder().newDocument();
    
    Element eArtefakte = document.createElement("Artefakte");
    document.appendChild(eArtefakte);
    Element eArtefakt = neuesArtefakt("Beispielsartefakt");
    eArtefakte.appendChild(eArtefakt);
    Element eAusloeser = neuerAusloeser("am Ring drehen", 3);
    eArtefakt.appendChild(eAusloeser);
    Element eAusloeser2 = neuerAusloeser("Fingerschnippen", 4);
    eArtefakt.appendChild(eAusloeser2);
    Element eSpruch = neuerSpruch("Aeolitus", "aufladbar", 3, 1, 7, 3, "SpoMod verdoppelte Reichweite");
    eAusloeser.appendChild(eSpruch);
    Element eSpruch2 = neuerSpruch("Vocolimbo", "semipermanent (monatlich)", 1, 2, 12, 11, "MUAHAHAHA");
    eAusloeser.appendChild(eSpruch2);
    Element eSpruch3 = neuerSpruch("Balsam", "Matrixgeber (labil)", 1, 1, 2, 2, "7 LeP");
    eAusloeser2.appendChild(eSpruch3);
    Element eGegenstand = document.createElement("Gegenstand");
    eGegenstand.setAttribute("Beschreibung", "blablabla");
    eGegenstand.setAttribute("Material", "Gold");
    eArtefakt.appendChild(eGegenstand);

    TransformerFactory tFactory = TransformerFactory.newInstance();
    Transformer transformer = tFactory.newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
    DOMSource source = new DOMSource(document);
    File datei = new File("test.xml");
    StreamResult result = new StreamResult(datei);
    transformer.transform(source, result);
  }

  public Element neuesArtefakt(String name) {
    Element e = document.createElement("Artefakt");
    e.setAttribute("name", name);
    return e;
  }
  
  public Element neuerAusloeser(String name, int zuschlag) {
    Element e = document.createElement("Ausloeser");
    e.setAttribute("Name", name);
    e.setAttribute("Zuschlag", "" + zuschlag);
    return e;
  }
  
  public Element neuerSpruch(String name, String praeservanz,
  int ladungen, int stapelungen, int zfw, int zfp, String wirkung) {
    Element e = document.createElement("Spruch");
    e.setAttribute("Name", name);
    e.setAttribute("Praeservanz", praeservanz);
    e.setAttribute("Ladungen", "" + ladungen);
    e.setAttribute("Stapelungen", "" + stapelungen);
    e.setAttribute("ZfW", "" + zfw);
    e.setAttribute("ZfP", "" + zfp);
    e.setAttribute("Wirkung", wirkung);
    return e;
  }
}
