/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzm�ller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.JOptionPane;

import studierstube.container.Zauberliste;

/**
 * In dieser Klasse werden globale Einstellungen gespeichert.
 * Au�erdem finden sich hier einige Felder und Methoden, die
 * man leicht aus dem ganzen Programm aufrufen k�nnen soll.
 */
public class Global {
  
  public static final String name = "Studierstube";
  public static final String version = "0.3";
  public static final String author = "Stefan Holzm�ller";
  public static final String email = "twelwan@gmx.de";
  
  private static FileWriter filewriter;
  private static BufferedWriter logwriter;
  private static Random random = new Random();
  
  private static boolean logging = true;
  private static boolean zauberlisteGespeichert = true;
  private static Zauberliste zauberliste = new Zauberliste();
  
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
        logwriter.flush();   // TODO ugly
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
  * Schlie�t das Logfile
  */
  private static void schliesseLogfile() {
    try {
	//  logwriter.flush(); // TODO
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
	    Fehler.zeigeFehlermeldung("Fehler beim Schlie�en des Logfiles!");
	    Fehler.zeigeException(e);
	    e.printStackTrace();
	  }
	}
  }
  
 /**
  * Gibt das Ergebnis eines Wurfs mit einem beliebigen W�rfel zur�ck.
  * 
  * @param seiten	Anzahl der Seiten des W�rfels
  * @return			Zufallszahl
  */
  public static int Wuerfel(int seiten) {
    return random.nextInt(seiten) + 1;
  }
  
  /**
   * Gibt das Ergebnis eines Wurfs mit einem 6-seitigen W�rfel zur�ck.
   * 
   * @return		Zufallszahl 1-6
   */
  public static int W6() {
    return Wuerfel(6);
  }
  
  /**
   * Gibt das Ergebnis eines Wurfs mit einem 20-seitigen W�rfel zur�ck.
   * 
   * @return		Zufallszahl 1-20
   */
  public static int W20() {
    return Wuerfel(20);
  }
  
  /**
   * Gibt die Summe einer beliebigen Zahl von W6-W�rfen zur�ck.
   * 
   * @param anzahl	Anzahl der W6
   * @return		Summe der W�rfe
   */
  public static int xW6(int anzahl) {
    int sum = 0;
    for (int i = 0; i < anzahl; i++) {
      sum += Wuerfel(6);
    }
    return sum;
  }
  
  /**
   * Gibt die Summe einer beliebigen Zahl von W20-W�rfen zur�ck.
   * 
   * @param anzahl	Anzahl der W20
   * @return		Summe der W�rfe
   */
  public static int xW20(int anzahl) {
    int sum = 0;
    for (int i = 0; i < anzahl; i++) {
      sum += Wuerfel(20);
    }
    return sum;
  }
  
  /**
   * Beenden des Programms.
   * 
   * 'Aufr�umen' und dann System.exit(0) aufrufen.
   */
  public static void beenden() {
    int x = JOptionPane.showConfirmDialog(  // TODO gespeichert ?
    		null, 
    		"Sind Sie sicher?",  // TODO andere Frage bei speichern
    		"Programm beenden", 
    		JOptionPane.YES_NO_OPTION);
    if (x != JOptionPane.YES_OPTION) return;
    
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
  	    Fehler.zeigeFehlermeldung("Fehler beim Schlie�en des Logfiles!");
  	    Fehler.zeigeException(e);
  	    e.printStackTrace();
  	  }
  	}
  	
  	schliesseLogfile();
  	
	System.exit(0);
  }
  
 /**
  * Liefert die globale Zauberliste.
  * 
  * @return die Zauberliste
  */
  public static Zauberliste getZauberliste() {
	return zauberliste;
  }
  
 /**
  * Gibt zur�ck, ob die Zauberliste gespeichert und auf dem aktuellen Stand ist.
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