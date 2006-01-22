/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzm�ller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.container;

import java.util.ArrayList;

import studierstube.Dialoge;

/**
 * In dieser Klasse werden alle Objekte der Klasse Zauber gespeichert.
 * Sie dient zur Verwaltung der Zauber.
 */
public class Zauberliste {
  private ArrayList liste = new ArrayList(270);
  private ArrayList zauberNamen = new ArrayList(270);
  private boolean gespeichert = true;
  
  /**
   * F�gt einen neuen Zauber in die Zauberliste ein.
   * 
   * Der Zauber wird alphabetisch in die vorhandene Liste einsortiert.
   * 
   * @param z Zauber
   * @return Position, die der neue Zauber in der Liste bekommen hat.
   */
  public int add(Zauber z) {
    if (liste.size() == 0) {
      liste.add(z);
      zauberNamen.clear();
      zauberNamen.add(z.getName());
      return 0;
    }
    
    String neuerZauberName = z.getName();
    String neuerZauberNameOhneUmlaute = ohneUmlaute(neuerZauberName);
    String untersuchterZauberName;

    int i;
    for (i = 0; i < zauberNamen.size(); i++) {
      untersuchterZauberName = (String)zauberNamen.get(i);
      int vergleich = neuerZauberNameOhneUmlaute.compareToIgnoreCase( 
    		  ohneUmlaute(untersuchterZauberName));
      if (vergleich < 0) { // neuer Name kommt alphabetisch vor dem untersuchten Namen
        break;
      }
      else if (vergleich == 0) {
        if (neuerZauberName.equalsIgnoreCase(untersuchterZauberName)) {
          Dialoge.zeigeHinweis("Ein Zauber mit dem selben Namen existiert bereits!");
          // TODO
          return -1;
        }
      }
    }
	zauberNamen.add(i, z.getName());
    liste.add(i, z);
    return i;
    
/*
    int a = 0;
    int b = zauberNamen.size() - 1;
    int m;
    do {
      m = (a+b)/2;
      int vergleich = ohneUmlaute((String)zauberNamen.get(m)).compareToIgnoreCase(neuerZauberNameOhneUmlaute);
      if (vergleich > 0) {
        // neuer Name kommt alphabetisch vor dem untersuchten Namen
    	b = m;
      }
      else if (vergleich < 0) {
        // neuer Name kommt alphabetisch nach dem untersuchten Namen
        a = m;
      }
      else {
        // TODO Zauber schon vorhanden?? vergleichen und entweder ersetzen oder abbrechen
        System.out.println("Zauber schon vorhanden??");
      }
    }
    while (a < b);
    
    return m;
*/
  }
  
  private String ohneUmlaute(String string) {
	String stringOhneUmlaute = string;
	stringOhneUmlaute = stringOhneUmlaute.replace('�', 'a');
	stringOhneUmlaute = stringOhneUmlaute.replace('�', 'o');
	stringOhneUmlaute = stringOhneUmlaute.replace('�', 'u');
	stringOhneUmlaute = stringOhneUmlaute.replace('�', 'A');
	stringOhneUmlaute = stringOhneUmlaute.replace('�', 'O');
	stringOhneUmlaute = stringOhneUmlaute.replace('�', 'U');
	stringOhneUmlaute = stringOhneUmlaute.replace('�', 's');
	return stringOhneUmlaute;
  }
  
  /**
   * Gibt die Anzahl der gespeicherten Zauber zur�ck.
   * 
   * @return Anzahl der Zauber
   */
  public int getAnzahlZauber() {
    return liste.size();
  }
  
  public Zauber getZauber(int index) {
	return (Zauber) liste.get(index);
  }
  
  public Zauberliste getClone() {
    return (Zauberliste) clone();
  }
  
  protected Object clone() {
    Zauberliste neu = new Zauberliste();
    for (int i = 0; i < this.getAnzahlZauber(); i++) {
      neu.add(this.getZauber(i).getClone());
    }
    neu.zauberNamen = this.zauberNamen;
    return neu;
  }
}
