/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.gui;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import studierstube.gui.custom.SCheckBox;
import studierstube.gui.custom.SPanel;
import studierstube.gui.custom.SRadioButton;

public class ArtefaktDesign extends JPanel {
  
  ArtefaktDesign() {
    super();
    init();
  }
  
  private void init() {
    add(machePanelEigenschaften());
    add(machePanelTempArtefakt());
  }
  
  private SPanel machePanelEigenschaften() {
    SCheckBox checkBoxEigenschaftSiegel = new SCheckBox("Siegel und Zertifikat");
    SCheckBox checkBoxEigenschaftUnzerbrechlichkeit = new SCheckBox("Unzerbrechlichkeit");
    SCheckBox checkBoxEigenschaftGespuer = new SCheckBox("Gespür des Schöpfers");
    SCheckBox checkBoxEigenschaftApport = new SCheckBox("Magischer Apport");
    
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
  
  private SPanel machePanelTempArtefakt() {
    SCheckBox checkBoxTempArtefakt = new SCheckBox("Temporäres Artefakt");
    
    SPanel panelGrundzeitraum = new SPanel();
    panelGrundzeitraum.setLayout(new BoxLayout(panelGrundzeitraum, BoxLayout.Y_AXIS));
    panelGrundzeitraum.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grundzeitraum", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
    ButtonGroup buttonGroupGrundzeitraum = new ButtonGroup();
    
    SRadioButton radioButtonGrundzeitraumMonat = new SRadioButton("ein Monat");
    buttonGroupGrundzeitraum.add(radioButtonGrundzeitraumMonat);
    panelGrundzeitraum.add(radioButtonGrundzeitraumMonat);
    
    SRadioButton radioButtonGrundzeitraumWoche = new SRadioButton("eine Woche");
    buttonGroupGrundzeitraum.add(radioButtonGrundzeitraumWoche);
    panelGrundzeitraum.add(radioButtonGrundzeitraumWoche);
    
    SRadioButton radioButtonGrundzeitraumTag = new SRadioButton("ein Tag");
    buttonGroupGrundzeitraum.add(radioButtonGrundzeitraumTag);
    panelGrundzeitraum.add(radioButtonGrundzeitraumTag);
    
    SPanel panelTempArtefakt = new SPanel();
    panelTempArtefakt.setLayout(new BoxLayout(panelTempArtefakt, BoxLayout.Y_AXIS));
    
    panelTempArtefakt.add(checkBoxTempArtefakt);
    panelTempArtefakt.add(panelGrundzeitraum);
    
    return panelTempArtefakt;
  }
}
