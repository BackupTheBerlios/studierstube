/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
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
    Global.log(Global.name + " Version " + Global.version);
    Global.log("Copyright (c) " + Global.author + "(" + Global.email + ")");
    Global.log("");
    Global.log("Programm wird gestartet:");
    Global.log("");
    
    Global.log("-> Lade mitgelieferte Zauber ...");
    ZauberXML z = new ZauberXML();
    z.ladeZauberliste();
    int anzahl = Global.getZauberliste().getAnzahlZauber();
    Global.log("   = " + anzahl + " Zauber geladen.");
    Global.log("");
    
    File file = new File("zauber.xml");
    if (file.canRead()) {
      Global.log("-> Lade zauber.xml ...");
      // TODO
      Global.log("   fertig.");  // TODO mehr verbosity
      Global.log("");
    }
    
    Global.log("-> Starte GUI ...");
    Global.log("");
    javax.swing.SwingUtilities.invokeLater(
      new Runnable() {
        public void run() {
          new Hauptfenster();
        }
      }
    );
  }
}
