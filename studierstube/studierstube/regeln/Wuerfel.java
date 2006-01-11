/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details.   *
**************************************************************/

package studierstube.regeln;

import studierstube.Global;

public class Wuerfel {

 /**
  * Gibt das Ergebnis eines Wurfs mit einem beliebigen Würfel zurück.
  * 
  * @param seiten	Anzahl der Seiten des Würfels
  * @return			Zufallszahl
  */
  protected int Wx(int seiten) {
    return Global.getRandom().nextInt(seiten) + 1;
  }
  
  /**
   * Gibt das Ergebnis eines Wurfs mit einem 6-seitigen Würfel zurück.
   * 
   * @return		Zufallszahl 1-6
   */
  protected int W6() {
    return Wx(6);
  }
  
  /**
   * Gibt das Ergebnis eines Wurfs mit einem 20-seitigen Würfel zurück.
   * 
   * @return		Zufallszahl 1-20
   */
  protected int W20() {
    return Wx(20);
  }
  
  /**
   * Gibt die Summe einer beliebigen Zahl von W6-Würfen zurück.
   * 
   * @param anzahl	Anzahl der W6
   * @return		Summe der Würfe
   */
  protected int xW6(int anzahl) {
    int sum = 0;
    for (int i = 0; i < anzahl; i++) {
      sum += Wx(6);
    }
    return sum;
  }
  
  /**
   * Gibt die Summe einer beliebigen Zahl von W20-Würfen zurück.
   * 
   * @param anzahl	Anzahl der W20
   * @return		Summe der Würfe
   */
  protected int xW20(int anzahl) {
    int sum = 0;
    for (int i = 0; i < anzahl; i++) {
      sum += Wx(20);
    }
    return sum;
  }
}
