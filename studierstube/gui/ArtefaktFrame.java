/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ArtefaktFrame {
  public ArtefaktFrame() {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Die magische Werkstatt");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    JLabel label = new JLabel("asdasfsdfgsdg");
    frame.getContentPane().add(label);
    frame.pack();
    frame.setLocationRelativeTo(null);  // centered on screen
    frame.setVisible(true);
  }
}
