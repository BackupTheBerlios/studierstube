/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube;

import gui.ArtefaktFrame;
import studierstube.tests.XMLtest;

class Main {
  public static void main(String[] args) {
    Global global = new Global();
    if (args != null)
      for (int i = 0; i < args.length; i++) {
        if (args[i].startsWith("-")) global.setzeOption(args[i]); 
      }    
    
    new ArtefaktFrame();
    XMLtest x = new XMLtest();
  }
}
