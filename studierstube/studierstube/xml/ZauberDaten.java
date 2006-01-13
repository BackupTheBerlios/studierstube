/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import studierstube.Fehler;
import studierstube.Global;
import studierstube.container.Zauber;

/**
 * Diese Klasse verwaltet das Im- und Exportieren von Zaubern.
 */
public class ZauberDaten extends Hilfsfunktionen {

 /**
  * Läd die Zauber in den Speicher. Die Zauber aus der Datei 'zauber.xml'
  * werden in der globalen Zauberliste abgelegt. Ist die Datei nicht
  * vorhanden, so wird die mitgelieferte Resource verwendet.
  */
  public void ladeZauberliste() {
	document = ladeDokument("zauber.xml");
	if (document == null) {
	  Global.log("   * Die Datei 'zauber.xml' wurde nicht gefunden.");
	  Global.log("   * Lade Zauberliste aus mitgelieferter Resource ...");
	  
      factory = DocumentBuilderFactory.newInstance();
      try {
        builder = factory.newDocumentBuilder();
      } catch (Exception e) {
    	Fehler.zeigeException(e);
        e.printStackTrace();
      }
      Class c = this.getClass();
      InputStream is = c.getResourceAsStream("zauber.xml");
      try {
        document = builder.parse(is);
      } catch (Exception e) {
        Fehler.zeigeFehlermeldung("Fehler beim Einlesen der mitgelieferten Zauber!");
    	Fehler.zeigeException(e);
        e.printStackTrace();
      }
	}
	
    Node xdimlNode = sucheChildNode(document, "XDIML");
    Node inhaltNode = sucheChildNode(xdimlNode, "Inhalt");
    Node zauberspruecheNode = sucheChildNode(inhaltNode, "Zaubersprüche");
    NodeList zauberNodes = zauberspruecheNode.getChildNodes();
    for (int i = 0; i < zauberNodes.getLength(); i++) {
      leseZauber(zauberNodes.item(i));
    }
  }
  
 /**
  * Läd einen einzelnen Zauber.
  * 
  * @param zauberNode Node des Zaubers
  */
  private void leseZauber(Node zauberNode) {
    if (zauberNode.getNodeName() == "Zauber") {
      
      String id = zeigeAttribut(zauberNode, "ID");
      
      Node kompNode = sucheChildNode(zauberNode, "Komplexität");
      String komp = kompNode.getChildNodes().item(0).getNodeValue();
      
      Node probeNode = sucheChildNode(zauberNode, "Probe");
      String probe = probeNode.getChildNodes().item(0).getNodeValue();
      String probe0 = probe.substring(0,2);
      String probe1 = probe.substring(3,5);
      String probe2 = probe.substring(6,8);  // StringIndexOutOfBoundsException abfangen
      
      Node merkmaleNode = sucheChildNode(zauberNode, "Merkmale");
      String[] merkmale = sucheChildValues(merkmaleNode, "Merkmal");
      
      Node variantenNode = sucheChildNode(zauberNode, "Varianten");
      String[] varianten;
      if (variantenNode == null) {
      	varianten = null;
      }
      else {
      	varianten = sucheChildValues(variantenNode, "Variante");
      }
      
      Zauber zauber = new Zauber();
      zauber.setName(id);
      zauber.setKomplexitaet(komp);
      zauber.setProbe(probe0, probe1, probe2);
      zauber.setMerkmale(merkmale);
      zauber.setVarianten(varianten);     
      Global.getZauberliste().add(zauber);
      
      Global.log("   + Zauber '" + id + "' geladen.");
    }
  }
  
 /**
  * Speichert die komplette Liste der Zauber in eine Datei.
  * 
  * Wird benutzt um die mitgelieferte zauber.xml zu aktualisieren.
  * 
  * @param dateiname	der Name der XML-Datei
  */
  public void speichereKompletteZauberliste(String dateiname) {
	factory = DocumentBuilderFactory.newInstance();
	try {
	  document = factory.newDocumentBuilder().newDocument();
	}
	catch (Exception e) {
	  Fehler.zeigeException(e);
	  e.printStackTrace();
	}
	
    Element eXDIML = document.createElement("XDIML");
    eXDIML.setAttribute("lang", "de");
    eXDIML.setAttribute("version", "2.0");
    document.appendChild(eXDIML);
    Element eInhalt = document.createElement("Inhalt");
    eXDIML.appendChild(eInhalt);
    Element eZaubersprueche = document.createElement("Zaubersprüche");
    eInhalt.appendChild(eZaubersprueche);
    
    for (int i = 0; i < Global.getZauberliste().getAnzahlZauber(); i++) {
      Element eZauber = erstelleZauberElement(Global.getZauberliste().getZauber(i));
      eZaubersprueche.appendChild(eZauber);
    } // catch, Fehlermeldung?
    
    schreibeDatei(document, dateiname);
  }
  
  private Element erstelleZauberElement(Zauber z) {
	Element eZauber = document.createElement("Zauber");
	eZauber.setAttribute("ID", z.getName());
	
	Element eProbe = document.createElement("Probe");
	eProbe.setTextContent(z.getProbeAlsString());
	eZauber.appendChild(eProbe);
	
	Element eKomplexitaet = document.createElement("Komplexität");
	eKomplexitaet.setTextContent(z.getKomplexitaet());
	eZauber.appendChild(eKomplexitaet);
	
	if (z.getMerkmale() != null) {
	  Element eMerkmale = document.createElement("Merkmale");
	  Element eMerkmal;
	  for (int i = 0; i < z.getMerkmale().length; i++) {
	    eMerkmal = document.createElement("Merkmal");
        eMerkmal.setTextContent(z.getMerkmale()[i]);
	    eMerkmale.appendChild(eMerkmal);
	  }
	  eZauber.appendChild(eMerkmale);
	}
	
	if (z.getVarianten() != null) {
	  Element eVarianten = document.createElement("Varianten");
	  Element eVariante;
	  for (int i = 0; i < z.getVarianten().length; i++) {
	    eVariante = document.createElement("Variante");
	    eVariante.setTextContent(z.getVarianten()[i]);
	    eVarianten.appendChild(eVariante);
	  }
	  eZauber.appendChild(eVarianten);
	}
	
	return eZauber;
  }
}
