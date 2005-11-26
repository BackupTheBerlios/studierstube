/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.container;

import java.util.ArrayList;

/**
 * In dieser Klasse werden alle Objekte der Klasse Zauber gespeichert.
 * Sie dient zur Verwaltung der Zauber.
 */
public class Zauberliste {
  private static ArrayList liste = new ArrayList(270);
  
  /**
   * Fügt einen neuen Zauber an die Zauberliste an.
   * 
   * @param z Zauber
   */
  public void add(Zauber z) {
    liste.add(z);
  }
  
  /**
   * Gibt die Anzahl der gespeicherten Zauber zurück.
   */
  private int getAnzahlZauber() {
    return liste.size();
  }
}
