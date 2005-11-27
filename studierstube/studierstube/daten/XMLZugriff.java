/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.daten;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Oberklasse für die XML-Manipulation mit einigen Hilfsmethoden.
 */
public class XMLZugriff {
	
  DocumentBuilderFactory factory;
  Document document;

  /**
   * Sucht einen Node unterhalb des aktuellen mit einem bestimmten Namen.
   * Zurückgegeben wird der gefundene Node oder null, falls er nicht
   * gefunden worden konnte.
   * 
   * @param node	Von welchem Node aus gesucht wird
   * @param name	Name des gesuchten Nodes
   * @return		gefundener Node
   */
  protected Node sucheChildNode(Node node, String name) {
    NodeList nl = node.getChildNodes();
    for (int i = 0; i < nl.getLength(); i++) {
      if (nl.item(i).getNodeName().equals(name)) {
        return nl.item(i);
      }
    }
    return null;
  }
  
  /**
   * Gibt die Werte von einem Unter-Node zurück.
   * Liefert null, wenn der Node keine ChildNodes hat.
   * 
   * @param node		Von welchem Node aus gesucht wird
   * @param children	Name der gesuchten Nodes
   * @return		String-Array mit den gefundenen Ergebnissen
   */
  protected String[] sucheChildValues(Node node, String children) {
    NodeList nl = node.getChildNodes();
    if (nl.getLength() == 0) return null;
    String[] elemente = new String[nl.getLength()];
    for (int i = 0; i < nl.getLength(); i++) {
      if (nl.item(i).getNodeName().equals(children)) {
        elemente[i] = nl.item(i).getChildNodes().item(0).getNodeValue();
      }
    }
    return elemente;
  }
  
  /**
   * Gibt den Inhalt eines Attributs zurück.
   * 
   * @param node	Node des Attributs
   * @param attr	Attribut
   * @return String des Attribut-Werts
   */
  protected String zeigeAttribut(Node node, String attr) {
    return node.getAttributes().getNamedItem(attr).getNodeValue();
  }
}
