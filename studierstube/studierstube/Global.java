/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube;

import java.util.Random;

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
  
  public static void out(String s) {
    if (debugmode == true) System.out.println(s);
  }
  
  public static String version = "0.01";
}
