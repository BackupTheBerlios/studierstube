/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube;

import studierstube.daten.Import;
import studierstube.gui.HauptFrame;

/*
 * Main class
 * 
 * This is where main() resides. It just parses command line
 * arguments and starts up the other program parts.
 */
class Main {
  public static void main(String[] args) {
    Global global = new Global();
    if (args != null)
      for (int i = 0; i < args.length; i++) {
        if (args[i].startsWith("-")) global.setOption(args[i]); 
      }
    
    Global.start();
    Import i = new Import();
    i.loadZauberliste();
    Global.stop();
    
    javax.swing.SwingUtilities.invokeLater(
      new Runnable() {
        public void run() {
          new HauptFrame();
        }
      }
    );
  }
}
