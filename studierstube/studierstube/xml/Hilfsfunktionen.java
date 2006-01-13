/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import studierstube.Fehler;

/**
 * Oberklasse für die XML-Manipulation mit einigen Hilfsmethoden.
 */
public class Hilfsfunktionen {
	
  protected DocumentBuilderFactory factory = null;
  protected Document document = null;
  protected DocumentBuilder builder = null;

  /**
   * Gibt ein DOM-Document einer XML-Datei zurück.
   * 
   * @param dateiname Die XML-Datei, die geladen werden soll.
   * @return Document
   */
  public Document ladeDokument(String dateiname) {
    factory = DocumentBuilderFactory.newInstance();
    try {
      builder = factory.newDocumentBuilder();
    } catch (Exception e) {
      Fehler.zeigeException(e);
      e.printStackTrace();
    }
    
    File file = new File(dateiname);
    if (file.canRead()) {
      try {
        document = builder.parse(file);
      } catch (Exception e) {
        Fehler.zeigeFehlermeldung("Fehler beim Einlesen der XML-Daten!");
        Fehler.zeigeException(e);
        e.printStackTrace();
      }
    }
	
    return document;
  }
  
  /**
   * Schreibt ein DOM-Document in eine XML-Datei.
   * 
   * @param document	Das Document
   * @param dateiname	Die XML-Datei, die geschrieben werden soll.
   */
  public void schreibeDatei(Document document, String dateiname) {
    TransformerFactory tFactory = TransformerFactory.newInstance();
    Transformer transformer = null;
    try {
      transformer = tFactory.newTransformer();
    }
    catch (Exception e) {
      Fehler.zeigeException(e);
      e.printStackTrace();
    }
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
    DOMSource source = new DOMSource(document);
    File datei = new File(dateiname);
    StreamResult result = new StreamResult(datei);
    try {
      transformer.transform(source, result);
    }
    catch (Exception e) {
      Fehler.zeigeFehlermeldung("Fehler beim Schreiben der XML-Datei!");
      Fehler.zeigeException(e);
      e.printStackTrace();
    }
  }
  
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
   * @return			String-Array mit den gefundenen Ergebnissen
   */
  protected String[] sucheChildValues(Node node, String children) {
    NodeList nl = node.getChildNodes();
    int counter = 0;
    for (int i = 0; i < nl.getLength(); i++) {
      if (nl.item(i).getNodeName().equals(children)) counter++;
    }
    if (counter == 0) return null;
    String[] elemente = new String[counter];
    counter = 0;
    for (int i = 0; i < nl.getLength(); i++) {
      if (nl.item(i).getNodeName().equals(children)) {
        elemente[counter] = nl.item(i).getChildNodes().item(0).getNodeValue();
        counter++;
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
