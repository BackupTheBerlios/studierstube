/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.regeln;

/**
 * Diese Klasse berechnet Wahrscheinlichkeiten rund um die Talentprobe.
 * 
 * Der Code stammt vom Programm Probenprophet und wurde ohne große
 * Änderungen von C++ nach Java portiert.
 */
public class Zauberprobe extends Wuerfel {

  private int es1, es2, es3, wert, mod = 0;
  private boolean tollpatsch = false, festematrix = false, spruchhemmung = false, minimaleffekt = true;
  private boolean berechnet = false;
  private int erfolg, qualitaet, summeGelungene, summeUebrige;
  private double wsk, punkteUebrigAlleProben, punkteUebrigGelungeneProben;

  /**
   * Initialisierung der Zauberprobe.
   * 
   * @param a	erste Eigenschaft
   * @param b	zweite Eigenschaft
   * @param c	dritte Eigenschaft
   * @param w	Zauberfertigkeitswert (ZfW)
   * @param m	Modifikation (Erschwernis bzw. Erleichterung)
   * @param fm	Vorteil Feste Matrix
   * @param sh	Nachteil Spruchhemmung
   * @param tp	Nachteil Tollpatsch
   * @param me	Minimaleffekt-Regelung
   */
  public Zauberprobe(int a, int b, int c, int w, int m, boolean fm, boolean sh, boolean tp, boolean me) {
    es1 = a;
    es2 = b;
    es3 = c;
    wert = w;
    mod = m;
    festematrix = fm;
    spruchhemmung = sh;
    tollpatsch = tp;
    minimaleffekt = me;
  }
  
  /**
   * Die Zauberprobe wird mit neuen Werten initialisiert.
   * 
   * @param a	erste Eigenschaft
   * @param b	zweite Eigenschaft
   * @param c	dritte Eigenschaft
   * @param w	Zauberfertigkeitswert (ZfW)
   * @param m	Modifikation (Erschwernis bzw. Erleichterung)
   * @param fm	Vorteil Feste Matrix
   * @param sh	Nachteil Spruchhemmung
   * @param tp	Nachteil Tollpatsch
   * @param me	Minimaleffekt-Regelung
   */
  public void setzeWerte(int a, int b, int c, int w, int m, boolean fm, boolean sh, boolean tp, boolean me) {
    es1 = a;
    es2 = b;
    es3 = c;
    wert = w;
    mod = m;
    festematrix = fm;
    spruchhemmung = sh;
    tollpatsch = tp;
    minimaleffekt = me;
    
    berechnet = false;
  }

  /**
   * Berechnet die Wahrscheinlichkeit für das Gelingen sowie die
   * durchschnittlich übrig behaltenen Punkte.
   */
  private void berechne() {
    if (!berechnet) {
      summeGelungene = 0;
      summeUebrige = 0;

      for (int w1 = 1; w1 < 21; w1++) {
        for (int w2 = 1; w2 < 21; w2++) {
          for (int w3 = 1; w3 < 21; w3++) {
            if (getErfolg(w1, w2, w3) > 0) {
              summeGelungene++;
              summeUebrige += qualitaet;
            }
          }
        }
      }
      wsk = (float) summeGelungene/80;
      punkteUebrigAlleProben = (float) summeUebrige/8000;
      punkteUebrigGelungeneProben = (float) summeUebrige/summeGelungene;
      
      berechnet = true;
    }
  }
  
  /**
   * Berechnet und liefert die Wahrscheinlichkeit, dass die Probe gelingt.
   * @return Wahrscheinlichkeit
   */
  public double getWahrscheinlichkeit() {
    berechne();
    return wsk;
  }
  
  /**
   * Berechnet und liefert die übrigen Punkte von allen gelungenen Proben.
   * @return durchschnittlich übrige Talentpunkte
   */
  public double getUebrigGelungen() {
    berechne();
    return punkteUebrigGelungeneProben;
  }

  /**
   * Berechnet und liefert die übrigen TaP* von allen Proben.
   * @return durchschnittlich übrige Talentpunkte
   */
  public double getUebrigAlle() {
    berechne();
    return punkteUebrigAlleProben;
  }
  
  /**
   * Bestimmt das Ergebnis einer Talentprobe mit gegebenen Würfelwürfen.
   * 
   * @param ww1	erster Würfel
   * @param ww2	zweiter Würfel
   * @param ww3	dritter Würfel
   */
  private void bestimme(int ww1, int ww2, int ww3) {
    erfolg = 0;
    qualitaet = 0;
    
    if (ww1 + ww2 + ww3 == 3) {
      erfolg = 3;  // spektakulärer Erfolg
      if (wert <= 0) {
        if (minimaleffekt) qualitaet = 1;
        else qualitaet = 0;
      }
      else qualitaet = wert;
      return;
    }
    if ((ww1 + ww2 == 2) || (ww1 + ww3 == 2) || (ww2 + ww3 == 2)) {
      erfolg = 2;  // glückliche Probe
      if (wert <= 0) {
        if (minimaleffekt) qualitaet = 1;
        else qualitaet = 0;
      }
      else qualitaet = wert;
      return;
    }
    if (ww1 + ww2 + ww3 == 60) {
      erfolg = -3;  // spektakulärer Patzer
      return;
    }
    if (istPatzer(ww1, ww2, ww3)) {
      erfolg = -2;  // Patzer
      return;
    }
    if (istSpruchhemmung(ww1, ww2, ww3)) {
      erfolg = -4;  // Spruchhemmung
      return;
    }
    
    if (wert < 0) {
      mod -= wert;
      wert = 0;
    }
    int punkte = wert - mod;
    if (punkte <= 0) {
      if ((ww1 <= es1 + punkte) && (ww2 <= es2 + punkte) && (ww3 <= es3 + punkte)) {
        if (erfolg == 0) erfolg = 1;
        if (minimaleffekt) qualitaet = 1;
        else qualitaet = 0;
      }
      else {
        int summe = 0;
        if (ww1 > es1 + punkte) summe -= ww1 - es1 - punkte;
        if (ww2 > es2 + punkte) summe -= ww2 - es2 - punkte;
        if (ww3 > es3 + punkte) summe -= ww3 - es3 - punkte;
        if (erfolg == 0) erfolg = -1;
        qualitaet = summe;
      }
    }
    else {
      int summe = 0;
      if (ww1 > es1 + punkte) {  // beim 1. Wurf misslungen
        summe -= ww1 - es1 - punkte;
        if (ww2 > es2) summe -= ww2 - es2;
        if (ww3 > es3) summe -= ww3 - es3;
        if (erfolg == 0) erfolg = -1;
        qualitaet = summe;
      }
      else {
        if (ww1 > es1) punkte -= ww1 - es1;
        if (ww2 > es2 + punkte) {  // beim 2. Wurf misslungen
          summe -= ww2 - es2 - punkte;
          if (ww3 > es3) summe -= ww3 - es3;
          if (erfolg == 0) erfolg = -1;
          qualitaet = summe;
        }
        else {
          if (ww2 > es2) punkte -= ww2 - es2;
          if (ww3 > es3 + punkte) {  // beim 3. Wurf misslungen
            summe -= ww3 - es3 - punkte;
            if (erfolg == 0) erfolg = -1;
            qualitaet = summe;
          }
          else {  // gelungen
            if (ww3 > es3) punkte -= ww3 - es3;
            if (punkte > wert) punkte = wert;
            if (erfolg == 0) erfolg = 1;
            if ((punkte == 0) && minimaleffekt) qualitaet = 1;
            else qualitaet = punkte;
          }
        }
      }
    }
  }
  
  /**
   * Bestimmt und liefert den Erfolg einer Probe mit gegebenen Würfelwürfen.
   *
   * <br>Erfolgs-Code:<br>
   * -4 = Spruchhemmung<br>
   * -3 = schlimmer Patzer (20/20/20)<br>
   * -2 = Patzer<br>
   * -1	= misslungen<br>
   *  1 = gelungen<br>
   *  2 = glücklich<br>
   *  3 = spektakulärer Erfolg (1/1/1)
   *
   * @param ww1	erster Würfel
   * @param ww2	zweiter Würfel
   * @param ww3	dritter Würfel
   * @return  Erfolgs-Code
   */
  public int getErfolg(int ww1, int ww2, int ww3) {
    bestimme(ww1, ww2, ww3);
    return erfolg;
  }

  /**
   * Bestimmt und liefert die Qualität der gewürfelten Probe.
   * Die Qualität sind die übrigen TaP für diese Probe.
   * Wenn die Option Minimaleffekt aktiviert ist, so ist die
   * Qualität einer gelungenen Probe immer mindestens 1.
   * 
   * @param ww1	erster Würfel
   * @param ww2	zweiter Würfel
   * @param ww3	dritter Würfel
   * @return Qualität
   */
  public int getQualitaet(int ww1, int ww2, int ww3) {
    bestimme(ww1, ww2, ww3);
    return qualitaet;
  }
  
  /**
   * Bestimmt, ob es sich bei den gegebenen Würfelwürfen um einen
   * Patzer handelt.
   * 
   * @param ww1	erster Würfel
   * @param ww2	zweiter Würfel
   * @param ww3	dritter Würfel
   * @return ob es ein Patzer ist oder nicht
   */
  boolean istPatzer(int ww1, int ww2, int ww3) {
	if (festematrix && istPatzerFesteMatrix(ww1, ww2, ww3)) return true;
    if (tollpatsch && istPatzerTollpatsch(ww1, ww2, ww3)) return true;
    if ((ww1 + ww2 == 40) || (ww1 + ww3 == 40) || (ww2 + ww3 == 40)) return true;
    return false;
  }

  /**
   * Bestimmt, ob es sich bei den gegebenen Würfelwürfen um einen
   * Patzer handelt, wenn die Option Feste Matrix aktiviert ist.
   * 
   * @param ww1	erster Würfel
   * @param ww2	zweiter Würfel
   * @param ww3	dritter Würfel
   * @return ob es ein Patzer ist oder nicht
   */
  boolean istPatzerFesteMatrix(int ww1, int ww2, int ww3) {
    if (((ww1 + ww2 == 40) || (ww1 + ww3 == 40) || (ww2 + ww3 == 40)) && ((ww1 + ww2 + ww3) >= 58)) return true;
    return false;
  }

  /**
   * Bestimmt, ob es sich bei den gegebenen Würfelwürfen um einen
   * Patzer handelt, wenn die Option Tollpatsch aktiviert ist.
   * 
   * @param ww1	erster Würfel
   * @param ww2	zweiter Würfel
   * @param ww3	dritter Würfel
   * @return ob es ein Patzer ist oder nicht
   */
  boolean istPatzerTollpatsch(int ww1, int ww2, int ww3) {
    if (((ww1 >= 19) && (ww2 >= 19)) || ((ww1 >= 19) && (ww3 >= 19)) || ((ww2 >= 19) && (ww3 >= 19))) return true;
    return false;
  }

  /**
   * Bestimmt, ob die gegebenen Würfelwürfe eine Spruchhemmung auslösen.
   * 
   * @param ww1	erster Würfel
   * @param ww2	zweiter Würfel
   * @param ww3	dritter Würfel
   * @return ob es eine Spruchhemmung ist oder nicht
   */
  boolean istSpruchhemmung(int ww1, int ww2, int ww3) {
    if (spruchhemmung && ((ww1 == ww2) || (ww2 == ww3) || (ww1 == ww3))) return true;
    return false;
  }
  
  /**
   * Bestimmt den Ausgang der Probe.
   * 
   * Für eine simple ja/nein-Entscheidung einfacher als getErfolg().
   * 
   * @param ww1	erster Würfel
   * @param ww2	zweiter Würfel
   * @param ww3	dritter Würfel
   * @return ob die Probe gelungen ist oder nicht
   */
  boolean istGelungen(int ww1, int ww2, int ww3) {
    if (getErfolg(ww1, ww2, ww3) > 0) return true;
    return false;
  }
}
