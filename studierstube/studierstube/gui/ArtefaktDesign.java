/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import studierstube.gui.custom.SButton;
import studierstube.gui.custom.SCheckBox;
import studierstube.gui.custom.SList;
import studierstube.gui.custom.SPanel;
import studierstube.gui.custom.SRadioButton;

public class ArtefaktDesign extends JPanel {
  
  private SCheckBox checkBoxEigenschaftSiegel = new SCheckBox("Siegel und Zertifikat");
  private SCheckBox checkBoxEigenschaftUnzerbrechlichkeit = new SCheckBox("Unzerbrechlichkeit");
  private SCheckBox checkBoxEigenschaftGespuer = new SCheckBox("Gespür des Schöpfers");
  private SCheckBox checkBoxEigenschaftApport = new SCheckBox("Magischer Apport");
  
  private SRadioButton radioButtonGrundzeitraumMonat = null;
  private SRadioButton radioButtonGrundzeitraumWoche = null;
  private SRadioButton radioButtonGrundzeitraumTag = null;
  
  ArtefaktDesign() {
    super();
    init();
    enableGrundzeitraum(false);
  }
  
  private void init() {
    SPanel panelArtefaktDesign1 = new SPanel();
    panelArtefaktDesign1.add(machePanelEigenschaften());
    panelArtefaktDesign1.add(machePanelTempArtefakt());
    
    SPanel panelArtefaktDesign = new SPanel();
    panelArtefaktDesign.setLayout(new BoxLayout(panelArtefaktDesign, BoxLayout.Y_AXIS));
    panelArtefaktDesign.add(panelArtefaktDesign1);
    panelArtefaktDesign.add(macheAusloeser());
    panelArtefaktDesign.add(macheZauber());
    add(panelArtefaktDesign);
  }
  
  private SPanel machePanelEigenschaften() {
    SPanel panelEigenschaftenInnen = new SPanel();
    panelEigenschaftenInnen.setLayout(new BoxLayout(panelEigenschaftenInnen, BoxLayout.Y_AXIS));
    panelEigenschaftenInnen.add(checkBoxEigenschaftSiegel);
    panelEigenschaftenInnen.add(checkBoxEigenschaftUnzerbrechlichkeit);
    panelEigenschaftenInnen.add(checkBoxEigenschaftGespuer);
    panelEigenschaftenInnen.add(checkBoxEigenschaftApport);
    
    SPanel panelEigenschaften = new SPanel();
   // panelEigenschaften.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Optionale Eigenschaften", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51,51,51)));
    panelEigenschaften.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Optionale Eigenschaften"));
    panelEigenschaften.add(panelEigenschaftenInnen);
    
    return panelEigenschaften;
  }
  
  private SPanel machePanelTempArtefakt() {
    SCheckBox checkBoxTempArtefakt = new SCheckBox("Temporäres Artefakt");
    
    SPanel panelGrundzeitraum = new SPanel();
    panelGrundzeitraum.setLayout(new BoxLayout(panelGrundzeitraum, BoxLayout.Y_AXIS));
    panelGrundzeitraum.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Grundzeitraum"));
    ButtonGroup buttonGroupGrundzeitraum = new ButtonGroup();
    
    radioButtonGrundzeitraumMonat = new SRadioButton("ein Monat");
    buttonGroupGrundzeitraum.add(radioButtonGrundzeitraumMonat);
    panelGrundzeitraum.add(radioButtonGrundzeitraumMonat);
    
    radioButtonGrundzeitraumWoche = new SRadioButton("eine Woche "); // Leerzeichen wegen Abstand
    buttonGroupGrundzeitraum.add(radioButtonGrundzeitraumWoche);
    panelGrundzeitraum.add(radioButtonGrundzeitraumWoche);
    
    radioButtonGrundzeitraumTag = new SRadioButton("ein Tag");
    buttonGroupGrundzeitraum.add(radioButtonGrundzeitraumTag);
    panelGrundzeitraum.add(radioButtonGrundzeitraumTag);
    
    SPanel panelTempArtefakt = new SPanel();
    panelTempArtefakt.setLayout(new BoxLayout(panelTempArtefakt, BoxLayout.Y_AXIS));
    
    panelTempArtefakt.add(checkBoxTempArtefakt);
    panelTempArtefakt.add(panelGrundzeitraum);
    
    return panelTempArtefakt;
  }
  
  private SPanel macheAusloeser() {
    SPanel panelAusloeser = new SPanel();
    
    
    return panelAusloeser;
  }
  
  private SPanel macheZauber() {
    SPanel panelZauber = new SPanel();
    SpringLayout layout = new SpringLayout();
    panelZauber.setLayout(layout);

    JScrollPane zauberliste = macheZauberListe();
    SPanel zauberbuttons = macheZauberButtons();
    panelZauber.add(zauberliste);
    panelZauber.add(zauberbuttons);
    
    layout.putConstraint(SpringLayout.WEST, zauberliste, 5, SpringLayout.WEST, panelZauber);
  //  layout.putConstraint(SpringLayout.NORTH, zauberliste, 5, SpringLayout.NORTH, panelZauber);
    
    layout.putConstraint(SpringLayout.WEST, zauberbuttons, 5, SpringLayout.EAST, zauberliste);
 //   layout.putConstraint(SpringLayout.NORTH, zauberbuttons, 5, SpringLayout.NORTH, panelZauber);
    
    layout.putConstraint(SpringLayout.EAST, panelZauber, 5, SpringLayout.EAST, zauberbuttons);
    layout.putConstraint(SpringLayout.SOUTH, panelZauber, 5, SpringLayout.SOUTH, zauberliste);
    
    zauberliste.setPreferredSize(new Dimension(300, 100));
    
    return panelZauber;
  }
  
  private JScrollPane macheZauberListe() {
    SList listZauber = new SList();
    JScrollPane scrollListZauber = new JScrollPane(listZauber);
    
    DefaultListModel listModel = new DefaultListModel();
    listModel.addElement("test 1");
    listModel.addElement("test 2");
    listZauber.setModel(listModel);
    
    return scrollListZauber;
  }
  
  private SPanel macheZauberButtons() {
    SButton buttonZauberHinzu = new SButton("Hinzufügen");
    SButton buttonZauberEdit = new SButton("Bearbeiten");
    SButton buttonZauberEntf = new SButton("Entfernen");
    
    SPanel panelZauberButtons = new SPanel();
    panelZauberButtons.setLayout(new BoxLayout(panelZauberButtons, BoxLayout.Y_AXIS));
    panelZauberButtons.add(buttonZauberHinzu);
    panelZauberButtons.add(buttonZauberEdit);
    panelZauberButtons.add(buttonZauberEntf);
    
    return panelZauberButtons;
  }
  
  private void enableGrundzeitraum(boolean state) {
    radioButtonGrundzeitraumMonat.setEnabled(state);
    radioButtonGrundzeitraumTag.setEnabled(state);
    radioButtonGrundzeitraumWoche.setEnabled(state);
  }
}
