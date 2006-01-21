/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzm�ller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.container;

import java.util.ArrayList;

/**
 * In dieser Klasse werden alle Objekte der Klasse Zauber gespeichert.
 * Sie dient zur Verwaltung der Zauber.
 */
public class Zauberliste {
  private ArrayList liste = new ArrayList(0);
  private String[] zauberNamen;
  private boolean gespeichert = true;
  
  /**
   * F�gt einen neuen Zauber an die Zauberliste an.
   * 
   * @param z Zauber
   */
  public void add(Zauber z) {
    liste.add(z);
    zauberNamen = new String[getAnzahlZauber()];
    for (int i = 0; i < zauberNamen.length; i++) {
      zauberNamen[i] = this.getZauber(i).getName();
    }
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
  
  private Zauberliste copy() {
    Zauberliste neu = new Zauberliste();
    for (int i = 0; i < this.getAnzahlZauber(); i++) {
      neu.add(this.getZauber(i).copy());
    }
    neu.zauberNamen = this.zauberNamen;
    return neu;
  }
}
