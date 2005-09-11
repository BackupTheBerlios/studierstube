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

public class Import {
  public void leseZaubernamen() {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Document document = null;
    try {
      DocumentBuilder builder = factory.newDocumentBuilder();
      document = builder.parse(new File("zauber.xml"));
    } catch (Exception e) {
      e.getMessage();
      e.printStackTrace();
    }
    Node xdimlNode = sucheChildNode(document, "XDIML");
    Node inhaltNode = sucheChildNode(xdimlNode, "Inhalt");
    Node zauberspruecheNode = sucheChildNode(inhaltNode, "Zaubersprüche");
    NodeList zauberNodes = zauberspruecheNode.getChildNodes();
    for (int i = 0; i < zauberNodes.getLength(); i++) {
      Node zauberNode = zauberNodes.item(i);
      leseZauber(zauberNode);
    }    
  }
  
  public void leseZauber(Node node) {
    if (node.getNodeName() == "Zauber") {
      String id = node.getAttributes().getNamedItem("ID").getNodeValue();
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
}
