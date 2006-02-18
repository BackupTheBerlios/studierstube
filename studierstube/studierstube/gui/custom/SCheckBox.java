/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.gui.custom;

import javax.swing.JCheckBox;

public class SCheckBox extends JCheckBox {

  private String name = null;
  
  public SCheckBox(String text) {
    super();
    name = text;
    init();
  }
  
  private void init() {
    setText(name);
    setActionCommand(name);
    setBackground(null);
  }
  
  public String getName() {
    return name;
  }
}
