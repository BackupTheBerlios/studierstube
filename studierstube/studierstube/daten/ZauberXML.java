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
 * Import Zauber data from XML
 * 
 * Diese Klasse verwaltet das Im-/Exportieren der Zauberliste.
 */
public class ZauberXML {

 /*
  * Läd die Zauberliste in den Speicher
  */
  public void loadZauberliste() {
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
      readZauber(zauberNodes.item(i));
    }    
  }
  
 /*
  * reads in a single Zauber element
  */
  private void readZauber(Node zauberNode) {
    if (zauberNode.getNodeName() == "Zauber") {
      
      String id = getAttribut(zauberNode, "ID");
      
      Node kompNode = sucheChildNode(zauberNode, "Komplexität");
      String komp = kompNode.getChildNodes().item(0).getNodeValue();
      
      Node probeNode = sucheChildNode(zauberNode, "Probe");
      String probe = probeNode.getChildNodes().item(0).getNodeValue();
      String probe0 = probe.substring(0,2);
      String probe1 = probe.substring(3,5);
      String probe2 = probe.substring(6,8);  // StringIndexOutOfBoundsException abfangen
      
      Node merkmaleNode = sucheChildNode(zauberNode, "Merkmale");
      String[] merkmale = getListe(merkmaleNode, "Merkmal");
      
      Node variantenNode = sucheChildNode(zauberNode, "Varianten");
      String[] varianten;
      if (variantenNode == null) {
      	varianten = null;
      }
      else {
      	varianten = getListe(variantenNode, "Variante");
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
  
  private Node sucheChildNode(Node node, String name) {
    NodeList nl = node.getChildNodes();
    for (int i = 0; i < nl.getLength(); i++) {
      if (nl.item(i).getNodeName().equals(name)) {
      	return nl.item(i);
      }
    }
    return null;
  }
  
  private String[] getListe(Node node, String children) {
    NodeList nl = node.getChildNodes();
    if (nl.getLength() == 0) return null;
    String[] merkmale = new String[nl.getLength()];
    int counter = 0;
    for (int i = 0; i < nl.getLength(); i++) {
      if (nl.item(i).getNodeName().equals(children)) {
        merkmale[counter] = nl.item(i).getChildNodes().item(0).getNodeValue();
        counter++;
      }
    }
    return merkmale;
  }
  
  private String getAttribut(Node node, String attr) {
    return node.getAttributes().getNamedItem(attr).getNodeValue();
  }

}
