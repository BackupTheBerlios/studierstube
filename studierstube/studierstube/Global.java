/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzm�ller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube;

import java.util.Random;

import javax.swing.JOptionPane;

public class Global {
  private static Random zufall = new Random();
  
  public static int Wuerfel(int seiten) {
    return zufall.nextInt(seiten) + 1;
  }
  
  public static int W6() {
    return Wuerfel(6);
  }
  
  public static int W20() {
    return Wuerfel(20);
  }
  
  public static boolean debugmode = false;
  
  void setzeOption(String option) {
    if (option.equals("-debug")) {
      Global g = new Global();
      Global.debugmode = true;
      System.out.println("Debug-Modus an");
    }
    else {
      System.out.println("Sie haben eine ung�ltige Option angegeben: " + option);
      Usage();
      System.exit(1);
    }
  }
  
  void Usage() {
    System.out.println("Verf�gbare Optionen:");
    System.out.println("  -debug          Debug-Meldungen einschalten");
  }
  
  public static void out(String s) {
    if (debugmode == true) System.out.println(s);
  }
  
  public static void FehlerDialog(String s) {
  	JOptionPane.showMessageDialog(null, s, "Ein Fehler ist aufgetreten", JOptionPane.ERROR_MESSAGE);
  }
  
  public static void ExceptionFehlerDialog(Exception e) {
  	JOptionPane.showMessageDialog(null,
  			e.getMessage(),
			"Ein Fehler ist aufgetreten", JOptionPane.ERROR_MESSAGE);
  }
  
  public static final String version = "0.01";
}
