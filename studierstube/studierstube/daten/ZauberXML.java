/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.daten;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import studierstube.Global;
import studierstube.container.Zauber;

/*
 * Zauberliste in XML
 * 
 * Diese Klasse verwaltet das Im-/Exportieren der Zauberliste.
 */
public class ZauberXML extends XMLZugriff {

 /*
  * Läd die Zauberliste in den Speicher
  */
  public void ladeZauberliste() {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Document document = null;
    try {
      DocumentBuilder builder = factory.newDocumentBuilder();
      Class c = this.getClass();
      InputStream is = c.getResourceAsStream("zauber.xml");
      document = builder.parse(is);
    } catch (Exception e) {
      e.printStackTrace();
    }
    Node xdimlNode = sucheChildNode(document, "XDIML");
    Node inhaltNode = sucheChildNode(xdimlNode, "Inhalt");
    Node zauberspruecheNode = sucheChildNode(inhaltNode, "Zaubersprüche");
    NodeList zauberNodes = zauberspruecheNode.getChildNodes();
    for (int i = 0; i < zauberNodes.getLength(); i++) {
      ladeZauber(zauberNodes.item(i));
    }    
  }
  
 /*
  * Läd einen einzelnen Zauber
  */
  private void ladeZauber(Node zauberNode) {
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
      Global.zauberListe.add(zauber);
    }
  }
  
}
