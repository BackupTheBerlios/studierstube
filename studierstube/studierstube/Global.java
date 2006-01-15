/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.JOptionPane;

import studierstube.container.Zauberliste;
import studierstube.gui.Hauptfenster;

/**
 * In dieser Klasse werden globale Einstellungen gespeichert.
 * Außerdem finden sich hier einige Felder und Methoden, die
 * man leicht aus dem ganzen Programm aufrufen können soll.
 */
public class Global {
  
  public static final String name = "Studierstube";
  public static final String version = "0.3";
  public static final String copyright = "Copyright (c) 2005-2006";
  public static final String author = "Stefan Holzmüller";
  public static final String email = "twelwan@gmx.de";
  
  private static FileWriter filewriter;
  private static BufferedWriter logwriter;
  private static Random random = new Random();
  
  private static boolean logging = true;
  private static boolean zauberlisteGespeichert = true;
  private static Zauberliste aktuelleZauberliste = new Zauberliste();
  
  protected static Hauptfenster hauptfenster;
  
 /**
  * Konstruktor.
  */
  Global() {
    oeffneLogfile();
  }
  
  /**
   * Gibt den String auf stdout aus und schreibt ihn in das Logfile.
   * 
   * Tritt beim Schreiben ein Fehler auf, wird das Logging deaktiviert
   * und das Logfile geschlossen.
   * 
   * @param ausgabe Ausgabe
   */
  public static void log(String ausgabe) {
	System.out.println(ausgabe);
	if (logging == true) {
      try {
        logwriter.write(ausgabe);
        logwriter.newLine();
        logwriter.flush();  // ugly
      }
      catch (Exception e) {
        Fehler.zeigeFehlermeldung("Fehler beim Schreiben in Logfile!");
        Fehler.zeigeException(e);
        e.printStackTrace();
        logging = false;
        schliesseLogfile();
      }
    }
  }
  
 /**
  * Initialisiert das Logfile
  */
  private static void oeffneLogfile() {
    try {
      filewriter = new FileWriter("studierstube.log");
    }
    catch (Exception e) {
      Fehler.zeigeException(e);
      e.printStackTrace();
    }
    logwriter = new BufferedWriter(filewriter);
  }
  
 /**
  * Schließt das Logfile
  */
  private static void schliesseLogfile() {
    try {
	//  logwriter.flush(); // wenn beim Schreiben nicht schon flush() aufgerufen wurde
	}
	catch (Exception e) {
	  Fehler.zeigeFehlermeldung("Fehler beim Leeren des Logfile-Buffers!");
	  Fehler.zeigeException(e);
	  e.printStackTrace();
	}
	finally {
	  try {
	    logwriter.close();
	  }
	  catch (Exception e) {
	    Fehler.zeigeFehlermeldung("Fehler beim Schließen des Logfiles!");
	    Fehler.zeigeException(e);
	    e.printStackTrace();
	  }
	}
  }
  
  /**
   * Beenden des Programms.
   * 
   * 'Aufräumen' und dann System.exit(0) aufrufen.
   */
  public static void beenden() {
    if (hauptfenster.beendenBestaetigen() != JOptionPane.YES_OPTION) return;
    log("-> Beenden ...");
    
    log("   * Schließen des Logfiles ...");
    try {
  	  logwriter.flush();
  	}
  	catch (Exception e) {
  	  Fehler.zeigeFehlermeldung("Fehler beim Leeren des Logfile-Buffers!");
  	  Fehler.zeigeException(e);
  	  e.printStackTrace();
  	}
  	finally {
  	  try {
  	    logwriter.close();
  	  }
  	  catch (Exception e) {
  	    Fehler.zeigeFehlermeldung("Fehler beim Schließen des Logfiles!");
  	    Fehler.zeigeException(e);
  	    e.printStackTrace();
  	  }
  	}
  	
  	schliesseLogfile();
  	
  	System.out.println("   * Aufruf von System.exit(0)");
	System.exit(0);
  }
  
  /**
   * Liefert den globalen Zufallsgenerator.
   * 
   * @return Random
   */
   public static Random getRandom() {
 	return random;
   }
  
 /**
  * Liefert die globale Zauberliste.
  * 
  * @return die Zauberliste
  */
  public static Zauberliste getZauberliste() {
	return aktuelleZauberliste;
  }
  
 /**
  * Gibt zurück, ob die Zauberliste gespeichert und auf dem aktuellen Stand ist.
  * 
  * @return ob die Zauberliste gespeichert ist
  */
  public static boolean istZauberlisteGespeichert() {
    return zauberlisteGespeichert;
  }
  
 /**
  * Setzt die Variable, die angibt, ob die Zauberliste auf dem aktuellen Stand ist.
  * 
  * @param status	ob die Zauberliste gespeichert ist oder nicht
  */
  public static void setZauberlisteGespeichert(boolean status) {
    zauberlisteGespeichert = status;
  }
}