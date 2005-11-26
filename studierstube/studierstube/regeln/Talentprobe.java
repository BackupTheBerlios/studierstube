/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.regeln;

/**
 * Diese Klasse berechnet Wahrscheinlichkeiten rund um die Talenprobe.
 * 
 * Der Code stammt vom Programm Probenprophet und wurde ohne große
 * Änderungen von C++ nach Java portiert.
 */
public class Talentprobe {
  int es1, es2, es3, taw, mod = 0;
  boolean minimaleffekt = false, festematrix = false, wildemagie = false, spruchhemmung = false;
  boolean berechnet = false;
  int erfolg, qualitaet, gelungensumme, uebrigsumme;
  double wsk, uebrig_gesamt, uebrig_gelungen;

  /**
   * Initialisierung der Talentprobe.
   * 
   * @param a	erste Eigenschaft
   * @param b	zweite Eigenschaft
   * @param c	dritte Eigenschaft
   * @param t	Talentwert (TaW)
   * @param m	Modifikation (Erschwernis bzw. Erleichterung)
   * @param me	Minimaleffekt-Regelung bei Zaubern
   * @param fm	Vorteil Feste Matrix
   * @param wm	Nachteil Wilde Magie bzw. Tollpatsch
   * @param sh	Nachteil Spruchhemmung
   */
  public Talentprobe(int a, int b, int c, int t, int m, boolean me, boolean fm, boolean wm, boolean sh) {
    es1 = a;
    es2 = b;
    es3 = c;
    taw = t;
    mod = m;
    minimaleffekt = me;
    festematrix = fm;
    wildemagie = wm;
    spruchhemmung = sh;
    
    berechnet = false;
  }
  
  /**
   * Die Talentprobe wird mit neuen Werten initialisiert.
   * 
   * @param a	erste Eigenschaft
   * @param b	zweite Eigenschaft
   * @param c	dritte Eigenschaft
   * @param t	Talentwert (TaW)
   * @param m	Modifikation (Erschwernis bzw. Erleichterung)
   * @param me	Minimaleffekt-Regelung bei Zaubern
   * @param fm	Vorteil Feste Matrix
   * @param wm	Nachteil Wilde Magie bzw. Tollpatsch
   * @param sh	Nachteil Spruchhemmung
   */
  public void setzeWerte(int a, int b, int c, int t, int m, boolean me, boolean fm, boolean wm, boolean sh) {
    es1 = a;
    es2 = b;
    es3 = c;
    taw = t;
    mod = m;
    minimaleffekt = me;
    festematrix = fm;
    wildemagie = wm;
    spruchhemmung = sh;
    
    berechnet = false;
  }

  /**
   * Berechnet die Wahrscheinlichkeit für das Gelingen sowie die
   * durchschnittlich übrig behaltenen TaP*.
   */
  private void berechne() {
    if (!berechnet) {
      gelungensumme = 0;
      uebrigsumme = 0;

      for (int w1 = 1; w1 < 21; w1++) {
        for (int w2 = 1; w2 < 21; w2++) {
          for (int w3 = 1; w3 < 21; w3++) {
            if (bestimmeErfolg(w1, w2, w3) > 0) {
              gelungensumme++;
              uebrigsumme += qualitaet;
            }
          }
        }
      }
      wsk = (float) gelungensumme/80;
      uebrig_gesamt = (float) uebrigsumme/8000;
      uebrig_gelungen = (float) uebrigsumme/gelungensumme;
      
      berechnet = true;
    }
  }
  /**
   * Berechnet und liefert die Wahrscheinlichkeit, dass die Probe gelingt.
   * @return Wahrscheinlichkeit
   */
  public double berechneWahrscheinlichkeit() {
    berechne();
    return wsk;
  }
  
  /**
   * Berechnet und liefert die übrigen TaP* von allen gelungenen Proben.
   * @return durchschnittlich übrige Talentpunkte
   */
  public double berechneUebrigGelungen() {
    berechne();
    return uebrig_gelungen;
  }

  /**
   * Berechnet und liefert die übrigen TaP* von allen Proben.
   * @return durchschnittlich übrige Talentpunkte
   */
  public double berechneUebrigGesamt() {
    berechne();
    return uebrig_gesamt;
  }
  
  /**
   * Bestimmt das Ergebnis einer Talentprobe mit gegebenen Würfelwürfen.
   * 
   * @param ww1  erster Würfel
   * @param ww2  zweiter Würfel
   * @param ww3  dritter Würfel
   */
  void bestimme(int ww1, int ww2, int ww3) {
    erfolg = 0;
    qualitaet = 0;
    
    if (ww1 + ww2 + ww3 == 3) {
      erfolg = 3;  // spektakulärer Erfolg
      if (taw <= 0) {
        if (minimaleffekt) qualitaet = 1;
        else qualitaet = 0;
      }
      else qualitaet = taw;
      return;
    }
    if ((ww1 + ww2 == 2) || (ww1 + ww3 == 2) || (ww2 + ww3 == 2)) {
      erfolg = 2;  // glückliche Probe
      if (taw <= 0) {
        if (minimaleffekt) qualitaet = 1;
        else qualitaet = 0;
      }
      else qualitaet = taw;
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
    
    if (taw < 0) {
      mod -= taw;
      taw = 0;
    }
    int punkte = taw - mod;
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
            if (punkte > taw) punkte = taw;
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
   * Erfolgs-Code:
   * -4 = Spruchhemmung
   * -3 = schlimmer Patzer (20/20/20)
   * -2 = Patzer
   * -1	= misslungen
   *  1 = gelungen
   *  2 = glücklich
   *  3 = spektakulärer Erfolg (1/1/1)
   *
   * @param ww1  erster Würfel
   * @param ww2  zweiter Würfel
   * @param ww3  dritter Würfel
   * @return  Erfolg-Code
   */
  public int bestimmeErfolg(int ww1, int ww2, int ww3) {
    bestimme(ww1, ww2, ww3);
    return erfolg;
  }

  /**
   * Bestimmt und liefert die Qualität der gewürfelten Probe.
   * Die Qualität sind die übrigen TaP für diese Probe.
   * Wenn die Option Minimaleffekt aktiviert ist, so ist die
   * Qualität einer gelungenen Probe immer mindestens 1.
   * 
   * @param ww1  erster Würfel
   * @param ww2  zweiter Würfel
   * @param ww3  dritter Würfel
   * @return Qualität
   */
  public int bestimmeQualitaet(int ww1, int ww2, int ww3) {
    bestimme(ww1, ww2, ww3);
    return qualitaet;
  }
  
  /**
   * Bestimmt, ob es sich bei den gegebenen Würfelwürfen um einen
   * Patzer handelt.
   * 
   * @param ww1  erster Würfel
   * @param ww2  zweiter Würfel
   * @param ww3  dritter Würfel
   * @return ob es ein Patzer ist oder nicht
   */
  boolean istPatzer(int ww1, int ww2, int ww3) {
    if (festematrix && istPatzerFesteMatrix(ww1, ww2, ww3)) return true;
    if (wildemagie && istPatzerWildeMagie(ww1, ww2, ww3)) return true;
    if ((ww1 + ww2 == 40) || (ww1 + ww3 == 40) || (ww2 + ww3 == 40)) return true;
    return false;
  }

  /**
   * Bestimmt, ob es sich bei den gegebenen Würfelwürfen um einen
   * Patzer handelt, wenn die Option Feste Matrix aktiviert ist.
   * 
   * @param ww1  erster Würfel
   * @param ww2  zweiter Würfel
   * @param ww3  dritter Würfel
   * @return ob es ein Patzer ist oder nicht
   */
  boolean istPatzerFesteMatrix(int ww1, int ww2, int ww3) {
    if (((ww1 + ww2 == 40) || (ww1 + ww3 == 40) || (ww2 + ww3 == 40)) && ((ww1 + ww2 + ww3) >= 58)) return true;
    return false;
  }

  /**
   * Bestimmt, ob es sich bei den gegebenen Würfelwürfen um einen
   * Patzer handelt, wenn die Option Wilde Magie aktiviert ist.
   * 
   * @param ww1  erster Würfel
   * @param ww2  zweiter Würfel
   * @param ww3  dritter Würfel
   * @return ob es ein Patzer ist oder nicht
   */
  boolean istPatzerWildeMagie(int ww1, int ww2, int ww3) {
    if (((ww1 >= 19) && (ww2 >= 19)) || ((ww1 >= 19) && (ww3 >= 19)) || ((ww2 >= 19) && (ww3 >= 19))) return true;
    return false;
  }

  /**
   * Bestimmt, ob die gegebenen Würfelwürfe eine Spruchhemmung auslösen.
   * 
   * @param ww1  erster Würfel
   * @param ww2  zweiter Würfel
   * @param ww3  dritter Würfel
   * @return ob es eine Spruchhemmung ist oder nicht
   */
  boolean istSpruchhemmung(int ww1, int ww2, int ww3) {
    if (spruchhemmung && ((ww1 == ww2) || (ww2 == ww3) || (ww1 == ww3))) return true;
    return false;
  }
}
