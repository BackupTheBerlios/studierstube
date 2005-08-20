/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube;

import javax.swing.JFrame;
import javax.swing.JLabel;

import studierstube.tests.Test;
import studierstube.tests.XMLtest;

class Main {
    private static void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
    }
    
  public static void main(String[] args) {
  	javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
   //         createAndShowGUI();
        }
    });
  	
    Global global = new Global();
    if (args != null)
      for (int i = 0; i < args.length; i++) {
        if (args[i].startsWith("-")) global.setzeOption(args[i]); 
      }    
    
    XMLtest x = new XMLtest();
    Test t = new Test();
    Global.Fehler("aaaaaaaa");
  }
}
