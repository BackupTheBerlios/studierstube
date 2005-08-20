/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.tests;

import studierstube.Global;
import studierstube.regeln.Artefakt;
import studierstube.regeln.Artefakt.Ausloeser;
import studierstube.regeln.Artefakt.Ladung;
import studierstube.regeln.Artefakt.Spruch;

public class Test {
  public Test() {
  	Artefakt artefakt = new Artefakt();
  	artefakt.neuerAusloeser(artefakt.new Ausloeser(3, "Fingerschnippen", "einmalig"));
  	artefakt.neueLadungZuAusloeser(artefakt.new Ladung());
  	artefakt.neuerSpruchZuLadung(artefakt.new Spruch("Vocolimbo", "Mag", "MUHA", 12, 9, 1));
	artefakt.neueLadungZuAusloeser(artefakt.new Ladung());
  	artefakt.neuerSpruchZuLadung(artefakt.new Spruch("Vocolimbo", "Mag", "MUHA", 12, 8, 1));
  	artefakt.neuerAusloeser(artefakt.new Ausloeser(5, "Dämonenpräsenz", "Matrixgeber (labil)"));
  	artefakt.neueLadungZuAusloeser(artefakt.new Ladung());
  	artefakt.neuerSpruchZuLadung(artefakt.new Spruch("Flim Flam", "Mag", "SpoMod", 4, 6, 2));
  	artefakt.neuerSpruchZuLadung(artefakt.new Spruch("Fulminictus", "Mag", "SpoMod", 8, 5, 1));
  	for (int i = 0; i<4; i++) {
  	  artefakt.neuerAusloeser(artefakt.new Ausloeser(i, "Fingerschnippen", "einmalig"));
  	}
    Global.out("ergebnis == " + artefakt.zaehleAusloeser());
    
    Global.Fehler("aaaaaaaa");
  }
}
