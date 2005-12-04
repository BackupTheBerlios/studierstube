/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube;

import java.io.File;

import studierstube.daten.ZauberXML;
import studierstube.gui.Hauptfenster;

/**
 * In dieser Klasse befindet sich main(). Sie dient nur zum
 * Initialisieren des Programms und zum Starten der GUI.
 */
class Main {

  /**
   * Startet das Programm.
   * 
   * @param args Kommandozeilenargumente (werden ignoriert)
   */
  public static void main(String[] args) {
    new Global();
    Global.log("Studierstube Version " + Global.version);
    Global.log("Copyright (c) Stefan Holzmüller (twelwan@gmx.de)");
    Global.log("");
    Global.log("Programm wird gestartet:");
    Global.log("");
    
    Global.log("-> Lade Zauber aus zauber.xml ...");
    ZauberXML z = new ZauberXML();
    z.ladeZauberliste();
    int anzahl = Global.zauberliste.getAnzahlZauber();
    Global.log("   = " + anzahl + " Zauber geladen.");
    Global.log("");
    
    File file = new File("zauber.xml");
    if (!file.canRead()) {
      Global.log("-> Schreibe Zauberliste neu ...");
      z.speichereZauberliste();
      Global.log("   fertig.");
      Global.log("");
    }
    
    Global.log("-> Starte GUI ...");
    javax.swing.SwingUtilities.invokeLater(
      new Runnable() {
        public void run() {
          new Hauptfenster();
        }
      }
    );
    Global.log("   fertig.");
    Global.log("");
  }
}
