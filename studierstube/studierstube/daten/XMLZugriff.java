package studierstube.daten;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLZugriff {
  protected Node sucheChildNode(Node node, String name) {
    NodeList nl = node.getChildNodes();
    for (int i = 0; i < nl.getLength(); i++) {
      if (nl.item(i).getNodeName().equals(name)) {
        return nl.item(i);
      }
    }
    return null;
  }
	  
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
	  
  protected String zeigeAttribut(Node node, String attr) {
    return node.getAttributes().getNamedItem(attr).getNodeValue();
  }
}
