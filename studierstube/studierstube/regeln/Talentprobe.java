/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details.   *
**************************************************************/

package studierstube.regeln;

public class Talentprobe extends Zauberprobe {

  /**
   * Initialisierung der Talentprobe.
   * 
   * @param a	erste Eigenschaft
   * @param b	zweite Eigenschaft
   * @param c	dritte Eigenschaft
   * @param w	Talentwert (TaW)
   * @param m	Modifikation (Erschwernis bzw. Erleichterung)
   * @param tp	Nachteil Tollpatsch
   * @param me	Minimaleffekt-Regelung wie bei Zaubern
   */
  public Talentprobe(int a, int b, int c, int w, int m, boolean tp, boolean me) {
    super(a, b, c, w, m, false, false, tp, me);
  }
  
  /**
   * Die Talentprobe wird mit neuen Werten initialisiert.
   * 
   * @param a	erste Eigenschaft
   * @param b	zweite Eigenschaft
   * @param c	dritte Eigenschaft
   * @param w	Talentwert (TaW)
   * @param m	Modifikation (Erschwernis bzw. Erleichterung)
   * @param tp	Nachteil Tollpatsch
   * @param me	Minimaleffekt-Regelung
   */
  public void setzeWerte(int a, int b, int c, int w, int m, boolean tp, boolean me) {
	super.setzeWerte(a, b, c, w, m, false, false, tp, me);
  }
}
