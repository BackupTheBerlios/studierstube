/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

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
  
  public static void Fehler(String s) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Ein Fehler ist aufgetreten");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    JLabel label = new JLabel(s);
    frame.getContentPane().add(label);
    frame.pack();
    frame.setVisible(true);
  }
  
  public static final String version = "0.01";
}
