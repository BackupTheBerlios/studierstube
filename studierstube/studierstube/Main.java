/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzm¸ller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube;

import java.io.File;
import java.util.Random;

import javax.swing.JOptionPane;

import studierstube.container.Zauberliste;
import studierstube.gui.Hauptfenster;
import studierstube.persistenz.ZauberXML;

/**
 * Hauptklasse.
 * 
 * In dieser Klasse befindet sich main(). Sie dient zum
 * Initialisieren des Programms und zum Starten der GUI.
 * 
 * Die Klasse wird nicht instanziiert, sondern besitzt einige
 * statische Methoden, die man leicht vom ganzen Programm aus
 * aufrufen kann.
 */
public class Main {

  public static final String PROJEKTNAME = "Studierstube";
  public static final String VERSION = "0.1";
  public static final String COPYRIGHT = "Copyright (c) 2005-2007";
  public static final String AUTHOR = "Stefan Holzm¸ller";
  public static final String EMAIL = "twelwan@gmx.de";

  static Hauptfenster hauptfenster;
  
  private static Logfile logfile;
  private static Random zufallsGenerator;
  private static Zauberliste globaleZauberliste;
  
  /**
   * Startet das Programm.
   * 
   * @param args Kommandozeilenargumente (werden ignoriert)
   */
  public static void main(String[] args) {
    logfile = new Logfile("studierstube.log");
    zufallsGenerator = new Random();
    globaleZauberliste = new Zauberliste();
	  
    log(PROJEKTNAME + " Version " + VERSION);
    log(COPYRIGHT + ", " + AUTHOR + " (" + EMAIL + ")");
    log("");
    log("Programm wird gestartet:");
    log("");
    
    log("-> Lade Zauberliste ...");
    ZauberXML z = new ZauberXML();
    z.ladeZauberlisteXDIML2();
    int anzahl = globaleZauberliste.getAnzahlZauber();
    log("   = " + anzahl + " Zauber geladen.");
    log("");
    
    File file = new File("data/zauber/zauber.xml");
    if (!file.exists()) {
      log("-> Schreibe Zauberliste nach zauber.xml ...");
      z.speichereKompletteZauberlisteXDIML2("data/zauber/zauber.xml");
      log("   fertig.");
      log("");
    }
    
    log("-> Starte GUI ...");
    log("");
    javax.swing.SwingUtilities.invokeLater(
      new Runnable() {
        public void run() {
          hauptfenster = new Hauptfenster();
        }
      }
    );
  }
  
  /**
   * Einfache Mˆglichkeit ins Logfile zu schreiben.
   * 
   * @param ausgabe Ausgabe
   */
  public static void log(String ausgabe) {
	logfile.println(ausgabe);
  }
  
  /**
   * Gibt den globale Zufallszahlengenerator zur¸ck.
   */
  public static Random getZufallsGenerator() {
    return zufallsGenerator;
  }
  
  /**
   * Gibt die globale Zauberliste zur¸ck.
   */
  public static Zauberliste getZauberliste() {
    return globaleZauberliste;
  }
  
  /**
   * Beenden des Programms.
   * 
   * 'Aufr‰umen' und dann System.exit(0) aufrufen.
   */
  public static void beenden() {
    if (hauptfenster.beendenBestaetigen() != JOptionPane.YES_OPTION) return;
    log("");
    log("-> Beenden ...");
     
    log("   * Schlieﬂen des Logfiles ...");
    logfile.schliesseLogfile();
    	
    System.out.println("   * Aufruf von System.exit(0)");
    System.exit(0);
  }
  
}
