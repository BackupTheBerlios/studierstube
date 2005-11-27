/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube;

import studierstube.daten.ZauberXML;
import studierstube.gui.HauptFrame;

/**
 * In dieser Klasse befindet sich main(). Sie dient nur zum
 * Initialisieren des Programms und zum Starten der GUI.
 */
class Main {
  public static void main(String[] args) {
    new Global();
    Global.log("Programm wird gestartet:\n");

    Global.log("* Lade Zauber ...");
    ZauberXML z = new ZauberXML();
    z.ladeZauberliste();
    Global.log(" fertig.\n");
    
    Global.log("* Starte GUI ...");
    javax.swing.SwingUtilities.invokeLater(
      new Runnable() {
        public void run() {
          new HauptFrame();
        }
      }
    );
    Global.log(" fertig.\n");
  }
}
