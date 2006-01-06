/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
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
 * Außerdem finden sich hier einige Felder und Methoden, die
 * man leicht aus dem ganzen Programm aufrufen können soll.
 */
public class Global {
  
  public static final String version = "0.3";
  
  private static FileWriter filewriter;
  private static BufferedWriter logwriter;
  private static Random random = new Random();
  
  public static Zauberliste zauberliste = new Zauberliste();
  
  Global() {
    try {
      filewriter = new FileWriter("studierstube.log");
    }
    catch (Exception e) {
      System.out.println("Konnte Logfile nicht initialisieren:");
      e.printStackTrace();
    }
    logwriter = new BufferedWriter(filewriter);
  }
  
  /**
   * Gibt den String auf stdout aus und schreibt ihn in das Logfile.
   * 
   * @param string Ausgabe
   */
  public static void log(String string) {
    System.out.println(string);
    try {
      logwriter.write(string);
      logwriter.newLine();
      logwriter.flush();   // TODO ugly
    }
    catch (Exception e) {
      System.out.println("Fehler beim Schreiben in Logfile!");
      e.printStackTrace();
    }
  }
  /**
   * Gibt eine Zahl auf stdout aus und schreibt sie in das Logfile.
   * 
   * @param zahl
   */
  public static void log(int zahl) {
    log("" + zahl);
  }
  
 /**
  * Gibt das Ergebnis eines Wurfs mit einem beliebigen Würfel zurück.
  * 
  * @param seiten	Anzahl der Seiten des Würfels
  * @return			Zufallszahl
  */
  public static int Wuerfel(int seiten) {
    return random.nextInt(seiten) + 1;
  }
  
  /**
   * Gibt das Ergebnis eines Wurfs mit einem 6-seitigen Würfel zurück.
   * 
   * @return		Zufallszahl 1-6
   */
  public static int W6() {
    return Wuerfel(6);
  }
  
  /**
   * Gibt das Ergebnis eines Wurfs mit einem 20-seitigen Würfel zurück.
   * 
   * @return		Zufallszahl 1-20
   */
  public static int W20() {
    return Wuerfel(20);
  }
  
  /**
   * Gibt die Summe einer beliebigen Zahl von W6-Würfen zurück.
   * 
   * @param anzahl	Anzahl der W6
   * @return		Summe der Würfe
   */
  public static int xW6(int anzahl) {
    int sum = 0;
    for (int i = 0; i < anzahl; i++) {
      sum += Wuerfel(6);
    }
    return sum;
  }
  
  /**
   * Gibt die Summe einer beliebigen Zahl von W20-Würfen zurück.
   * 
   * @param anzahl	Anzahl der W20
   * @return		Summe der Würfe
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
   * 'Aufräumen' und dann System.exit(0) aufrufen.
   */
  public static void beenden() {
    int x = JOptionPane.showConfirmDialog(  // TODO gespeichert ?
    		null, 
    		"Sind Sie sicher?",  // TODO andere Frage bei speichern
    		"Programm beenden", 
    		JOptionPane.YES_NO_OPTION);
    if (x == JOptionPane.YES_OPTION) return;
    
	try {
	  logwriter.flush();
	}
	catch (Exception e) {
	  System.out.println("Fehler beim Leeren des Logfile-Buffers!");
	  e.printStackTrace();
	}
	finally {
	  try {
	    logwriter.close();
	  }
	  catch (Exception e) {
	    System.out.println("Fehler beim Schließen des Logfiles!");
	    e.printStackTrace();
	  }
	}
	
	System.exit(0);
  }
}
