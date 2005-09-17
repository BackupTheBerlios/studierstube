/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.daten;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import studierstube.Global;
import studierstube.container.Zauber;

public class Import {
  public void leseZauberEin() {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Document document = null;
    try {
      DocumentBuilder builder = factory.newDocumentBuilder();
      document = builder.parse(new File("zauber.xml"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    Node xdimlNode = sucheChildNode(document, "XDIML");
    Node inhaltNode = sucheChildNode(xdimlNode, "Inhalt");
    Node zauberspruecheNode = sucheChildNode(inhaltNode, "Zaubersprüche");
    NodeList zauberNodes = zauberspruecheNode.getChildNodes();
    for (int i = 0; i < zauberNodes.getLength(); i++) {
      leseZauber(zauberNodes.item(i));
    }    
  }
  
  public void leseZauber(Node zauberNode) {
    if (zauberNode.getNodeName() == "Zauber") {
      
      String id = gibAttribut(zauberNode, "ID");
      
      Node kompNode = sucheChildNode(zauberNode, "Komplexität");
      String komp = kompNode.getChildNodes().item(0).getNodeValue();
      
      Node probeNode = sucheChildNode(zauberNode, "Probe");
      String probe = probeNode.getChildNodes().item(0).getNodeValue();
      String probe0 = probe.substring(0,2);
      String probe1 = probe.substring(3,5);
      String probe2 = probe.substring(6,8);  // StringIndexOutOfBoundsException abfangen
      
      Node merkmaleNode = sucheChildNode(zauberNode, "Merkmale");
      
      Zauber zauber = new Zauber();
      zauber.name = id;
      zauber.komplexitaet = komp;
      zauber.probe[0] = probe0;
      zauber.probe[1] = probe1;
      zauber.probe[2] = probe2;
      
      Global.zauberListe.add(zauber);
    }
  }
  
  public Node sucheChildNode(Node node, String name) {
    NodeList nl = node.getChildNodes();
    for (int i = 0; i < nl.getLength(); i++) {
      if (nl.item(i).getNodeName().equals(name)) {
      	return nl.item(i);
      }
    }   
    Global.out("ChildNode '" + name + "' nicht gefunden!");
    return null;
  }
  
  String gibAttribut(Node node, String attr) {
    return node.getAttributes().getNamedItem(attr).getNodeValue();
  }

}
