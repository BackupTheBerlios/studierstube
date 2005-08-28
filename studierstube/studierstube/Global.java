/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube;

import java.util.Random;

import javax.swing.JOptionPane;

public class Global {
  public static boolean debugmode = false;
  public static final String version = "0.01";
  
  private static Random random = new Random();
  
  public static int Wuerfel(int seiten) {
    return random.nextInt(seiten) + 1;
  }
  
  public static int wuerfeln(String string) {
  	String s = string;
  	int ergebnis = 0;
  	int a,b, stelle;
  	a = s.indexOf("+");
  	b = s.indexOf("-");
  	// TODO
  	return ergebnis;
  }
  
  public static int W6() {
    return Wuerfel(6);
  }
  
  public static int W20() {
    return Wuerfel(20);
  }
  
  void setzeOption(String option) {
    if (option.equals("-debug")) {
      Global g = new Global();
      Global.debugmode = true;
      System.out.println("Debug-Modus an");
    }
    else {
      System.out.println("Sie haben eine ungültige Option angegeben: " + option);
      Usage();
      System.exit(1);
    }
  }
  
  void Usage() {
    System.out.println("Verfügbare Optionen:");
    System.out.println("  -debug          Debug-Meldungen einschalten");
  }
  
  public static void out(String s) {
    if (debugmode == true) System.out.println(s);
  }
  
  public static void log() {
  	if (debugmode == true) {
      // throw exception, get stacktrace, get class/method
  	}
  }
  
  public static void FehlerDialog(String s) {
  	JOptionPane.showMessageDialog(null, s, "Ein Fehler ist aufgetreten", JOptionPane.ERROR_MESSAGE);
  }
  
  public static void ExceptionFehlerDialog(Exception e) {
  	JOptionPane.showMessageDialog(null,
  			e.getMessage(),
			"Ein Fehler ist aufgetreten",
			JOptionPane.ERROR_MESSAGE);
  }
}
