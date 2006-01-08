/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ZauberPanel extends JPanel {
  
  static final long serialVersionUID = 1; // TODO brauchbarer Wert ?
  
  private java.awt.Color farbeHintergrund = new java.awt.Color(200,210,255);
  
  public ZauberPanel(java.awt.Color hintergrund) {
    farbeHintergrund = hintergrund;
    setBackground(farbeHintergrund);
    initialisiere();
  }
  
  public ZauberPanel() {
    initialisiere();
  }
  
  private void initialisiere() {
    JButton button = new JButton();
	  button.setPreferredSize(new Dimension(333,222));
	  add(button);
  }
}
