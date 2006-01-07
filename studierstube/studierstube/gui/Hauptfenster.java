/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import studierstube.Global;

public class Hauptfenster extends JFrame {
	
  static final long serialVersionUID = 1; // TODO anderer Wert ?
  
  public Hauptfenster() {
    setDefaultLookAndFeelDecorated(true);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        Global.beenden();
      }
    });
    setTitle("Studierstube, Version " + Global.version);
    // TODO  setIconImage(Image)
    getContentPane().add(new ZauberPanel());
    pack();
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
