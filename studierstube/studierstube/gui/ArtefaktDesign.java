/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.gui;

import javax.swing.BoxLayout;

import studierstube.gui.custom.SCheckBox;
import studierstube.gui.custom.SPanel;

public class ArtefaktDesign extends SPanel {
  
  ArtefaktDesign() {
    super();
    init();
  }
  
  private void init() {
    
  }
  
  private SPanel machePanelEigenschaften() {
    
    SCheckBox checkBoxEigenschaftSiegel = new SCheckBox();
    checkBoxEigenschaftSiegel.setText("Siegel und Zertifikat");
    
    SCheckBox checkBoxEigenschaftUnzerbrechlichkeit = new SCheckBox();
    checkBoxEigenschaftUnzerbrechlichkeit.setText("Unzerbrechlichkeit");
    
    SCheckBox checkBoxEigenschaftGespuer= new SCheckBox();
    checkBoxEigenschaftGespuer.setText("Gespür des Schöpfers");
    checkBoxEigenschaftGespuer.setActionCommand("Gespür des Schöpfers");
    
    SCheckBox checkBoxEigenschaftApport = new SCheckBox();
    checkBoxEigenschaftApport.setText("Magischer Apport");
    
    SPanel panelEigenschaftenInnen = new SPanel();
    panelEigenschaftenInnen.setLayout(new BoxLayout(panelEigenschaftenInnen, BoxLayout.Y_AXIS));
    panelEigenschaftenInnen.add(checkBoxEigenschaftSiegel);
    panelEigenschaftenInnen.add(checkBoxEigenschaftUnzerbrechlichkeit);
    panelEigenschaftenInnen.add(checkBoxEigenschaftGespuer);
    panelEigenschaftenInnen.add(checkBoxEigenschaftApport);
    
    SPanel panelEigenschaften = new SPanel();
    panelEigenschaften.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Optionale Eigenschaften", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51,51,51)));
    panelEigenschaften.add(panelEigenschaftenInnen);
    
    return panelEigenschaften;
  }
}
