/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.gui.custom;

import javax.swing.JRadioButton;

public class SRadioButton extends JRadioButton {
  
  private String name = null;

  public SRadioButton(String text) {
    super();
    name = text;
    init();
  }
  
  private void init() {
    setBackground(null);
    setText(name);
  }
  
  public String getName() {
    return name;
  }
}
