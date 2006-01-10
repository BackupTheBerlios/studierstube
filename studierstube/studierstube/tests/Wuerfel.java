/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.tests;

import studierstube.Global;

public class Wuerfel {
  public Wuerfel() {
    Global.log("" + durchschnittW6(1000000));
  }

  double durchschnittW6(int anzahl) {
	double erg = 0;
	for (int i = 0; i < anzahl; i++) {
	  int plus = Global.W6();
	  switch (plus) {
	  case 1:
	  case 2:
	  case 3:
	  case 4:
	  case 5:
	  case 6:
		  break;
	  default:
		  Global.log("W6 -> " + plus);
	  }
	  erg += plus;
	}
	erg = (double) erg / (double)anzahl;
	return erg;
  }
}
