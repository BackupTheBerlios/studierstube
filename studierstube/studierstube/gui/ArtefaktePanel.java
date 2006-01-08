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

public class ArtefaktePanel extends JPanel {
	
  static final long serialVersionUID = 1; // TODO brauchbarer Wert ?
  
  public ArtefaktePanel(java.awt.Color hintergrund) {
    setBackground(hintergrund); 
	 
	    JButton button = new JButton();
		  button.setPreferredSize(new Dimension(555,444));
		  add(button);
  }
}
