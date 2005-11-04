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
 * Global settings
 * 
 * This class stores global settings and also implements some
 * methods which should be easily accessible from everywhere
 * in the program.
 */
public class Global {
  public static boolean debugmode = false;
  public static final String version = "0.2";
  
  private static long startTime, stopTime = 0;
  
  private static Random random = new Random();
  public static Zauberliste zauberListe = new Zauberliste();
  
 /**
  * returns the result of a customizable dice rolled
  */
  public static int Wuerfel(int seiten) {
    return random.nextInt(seiten) + 1;
  }
  
 /**
  * returns the result of a 6-sided dice rolled
  */
  public static int W6() {
    return Wuerfel(6);
  }
  
 /**
  * returns the result of a 20-sided dice rolled
  */
  public static int W20() {
    return Wuerfel(20);
  }
  
 /**
  * returns the summed result of several 6-sided dice rolled
  * 
  * @param number of dice
  */ 
  public static int xW6(int anzahl) {
    int sum = 0;
    for (int i = 0; i < anzahl; i++) {
      sum += Wuerfel(6);
    }
    return sum;
  }
  
 /**
  * returns the summed result of several 20-sided dice rolled
  * 
  * @param number of dice
  */ 
  public static int xW20(int anzahl) {
    int sum = 0;
    for (int i = 0; i < anzahl; i++) {
      sum += Wuerfel(20);
    }
    return sum;
  }
  
 /*
  * Sets option from command line arguments
  * 
  * A single option is processed only - if the program does not
  * support it, a usage instruction is printed to stdout and
  * the program terminated with exit status 1.
  * 
  * @param option string taken from command line arguments
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
  
 /*
  * Prints available command line arguments
  */
  protected void printUsage() {
    System.out.println("Verfügbare Optionen:");
    System.out.println("  -debug          Debug-Meldungen einschalten");
  }
  
 /*
  * Prints to stdout in debug mode
  * 
  * Simple method that only prints a debug message when the
  * program runs in debug mode.
  */
  public static void out(String s) {
    if (debugmode == true) System.out.println(s);
  }
  
 /*
  * start a time measurement
  */
  public static void start() {
    startTime = System.currentTimeMillis();
  }
 
 /*
  * stop a time measurement and print to stdout
  */
  public static void stop() {
    stopTime = System.currentTimeMillis();
    long diff = stopTime - startTime;
    System.out.println(diff + " ms");
  }
  
 /*
  * displays a simple dialog box with a customizable message
  */
  public static void displayMessage(String s) {
    JOptionPane.showMessageDialog(null,
   			s,
   			"Hinweis",
   		//	JOptionPane.PLAIN_MESSAGE);
    		JOptionPane.INFORMATION_MESSAGE);
  }
   
 /*
  * displays a simple dialog box with a customizable error message
  * 
  * @param message string
  */
  public static void displayError(String s) {
  	JOptionPane.showMessageDialog(null,
  			s,
  			"Fehler",
  			JOptionPane.ERROR_MESSAGE);
  }
 
 /*
  * displays an exception and asks the user to submit a bug report
  * 
  * @param exception
  */
  public static void displayException(Exception e) {
	String errormsg = "Ein interner Fehler ist aufgetreten: " + e.getMessage()
			+ "\n\n"
			+ "Bitte schicken Sie diesen Fehlerbericht an den Autor, "
			+ "damit der Fehler behoben werden kann.\n\n"
			+ e.toString() + "\n" + getStackTrace(e) + "\n"
			+ "Diesen Text in die Zwischenablage kopieren?";
	int value = JOptionPane.showConfirmDialog(null,
  			errormsg,
			"Interner Fehler",
			JOptionPane.YES_NO_OPTION);
  	if (value == JOptionPane.YES_OPTION) {
  		// TODO copy to clipboard
  	}
  }
  
 /*
  * gets the stack trace of an Exception as String
  */
  static String getStackTrace(Exception e) {
    StackTraceElement stack[] = e.getStackTrace();
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
