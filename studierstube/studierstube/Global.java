/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube;

import java.util.Random;

import javax.swing.JOptionPane;

import studierstube.container.Zauberliste;

/**
 * In dieser Klasse werden globale Einstellungen gespeichert.
 * Außerdem finden sich hier einige Felder und Methoden, die
 * man leicht aus dem ganzen Programm aufrufen können soll.
 */
public class Global {
  public static boolean debugmode = false;
  public static final String version = "0.2";
  
  private static long startTime, stopTime = 0;
  
  private static Random random = new Random();
  public static Zauberliste zauberListe = new Zauberliste();
  
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
  * TODO
  * 
  * @param option 	eine einzelnes Argument
  */
  protected void setOption(String option) {
    if (option.equals("-debug")) {
      Global.debugmode = true;
      System.out.println("Debug-Modus an");
    }
    else {
      System.out.println("Sie haben eine ungültige Option angegeben: " + option);
      printUsage();
      System.exit(1);
    }
  }
  
 /**
  * TODO
  */
  protected void printUsage() {
    System.out.println("Verfügbare Optionen:");
    System.out.println("  -debug          Debug-Meldungen einschalten");
  }
  
 /**
  * Ausgabe nach stdout wenn Debug-Modus aktiv ist.
  * 
  * @param string Ausgabe
  */
  public static void out(String string) {
    if (debugmode == true) System.out.println(string);
  }
  
 /**
  * Startet eine Zeitmessung. stop() beendet die Messung und
  * schreibt die Zeitdifferenz nach stdout.
  */
  public static void start() {
    startTime = System.currentTimeMillis();
  }
 
  /**
   * Beendet die Zeitmessung, die vorher durch start() begonnen werden
   * muss, und schreibt die Zeitdifferenz nach stdout.
   */
  public static void stop() {
    stopTime = System.currentTimeMillis();
    long diff = stopTime - startTime;
    System.out.println(diff + " ms");
  }
  
 /**
  * Zeigt eine simple Dialogbox mit einem Text darin.
  * 
  * param string	Ausgabe
  */
  public static void displayMessage(String string) {
    JOptionPane.showMessageDialog(null,
   			string,
   			"Hinweis",
   		//	JOptionPane.PLAIN_MESSAGE);
    		JOptionPane.INFORMATION_MESSAGE);
  }
   
 /**
  * Zeigt einen Fehler-Dialog mit einem Text darin.
  * 
  * @param string Ausgabe
  */
  public static void displayError(String string) {
  	JOptionPane.showMessageDialog(null,
  			string,
  			"Fehler",
  			JOptionPane.ERROR_MESSAGE);
  }
 
 /**
  * Zeigt eine Exception an und bittet den Benutzer, den Bug zu melden.
  * 
  * @param exception	Die anzuzeigende Exception
  */
  public static void displayException(Exception exception) {
	String errormsg = "Ein interner Fehler ist aufgetreten: " + exception.getMessage()
			+ "\n\n"
			+ "Bitte schicken Sie diesen Fehlerbericht an den Autor, "
			+ "damit der Fehler behoben werden kann.\n\n"
			+ exception.toString() + "\n" + getStackTrace(exception) + "\n"
			+ "Diesen Text in die Zwischenablage kopieren?";
	int value = JOptionPane.showConfirmDialog(null,
  			errormsg,
			"Interner Fehler",
			JOptionPane.YES_NO_OPTION);
  	if (value == JOptionPane.YES_OPTION) {
  		// TODO copy to clipboard
  	}
  }
  
 /**
  * Wandelt den Stacktrace einer Exception in einen String um.
  * 
  * @param exception	die Exception
  * @return s	String des Stacktrace
  */
  static String getStackTrace(Exception exception) {
    StackTraceElement stack[] = exception.getStackTrace();
    String s = "";
    for (int i=0; i<stack.length; i++) {
      String fileName = stack[i].getFileName();
      String className = stack[i].getClassName();
      String methodName = stack[i].getMethodName();
      int lineNumber = stack[i].getLineNumber();
      
      s += "at " + className + "." + methodName;
      if (fileName != null)
        s += "(" + fileName + ":" + lineNumber + ")\n";
      else
    	s += "\n";
    }
	return s;
  }
}
