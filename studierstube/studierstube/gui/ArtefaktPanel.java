/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

import studierstube.Main;

public class ArtefaktPanel extends JSplitPane {
	
  static final long serialVersionUID = 1; // brauchbarer Wert ?
  
  private String aktuelleThesis = null;
  private String aktuellesArtefakt = null;
  
  private JList listeThesis;
  private JList listeArtefakt;
  private JPanel panelLinks;
  private JPanel panelLinksButtonsThesis;
  private JPanel panelLinksButtonsArtefakt;
  private JButton buttonThesisNeu;
  private JButton buttonThesisKopieren;
  private JButton buttonThesisLoeschen;
  private JButton buttonArtefaktNeu;
  private JButton buttonArtefaktVariieren;
  private JButton buttonArtefaktLoeschen;
  
  public ArtefaktPanel() {
    super(JSplitPane.HORIZONTAL_SPLIT);
    
    setBackground(Hauptfenster.farbeHintergrund);
    setOneTouchExpandable(true);
    
    setLeftComponent(getLinkeSeite());
    setRightComponent(getRechteSeite());

    JPanel panelRechts = new JPanel();
    panelRechts.setBackground(Hauptfenster.farbeHintergrund);
    panelRechts.setLayout(new BoxLayout(panelRechts, BoxLayout.X_AXIS));
    
    resetToPreferredSizes();
  }
  
  private JPanel getLinkeSeite() {
    panelLinks = new JPanel();
    panelLinks.setLayout(new BoxLayout(panelLinks, BoxLayout.PAGE_AXIS));
    
    JLabel labelThesis = new JLabel("Artefaktthesis:");
    panelLinks.add(labelThesis);
    
    listeThesis = new JList();
    listeThesis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listeThesis.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        angeklickteThesis(listeThesis.locationToIndex(e.getPoint()));
      }
	});
    JScrollPane scrollbareListeThesis = new JScrollPane(listeThesis);
    scrollbareListeThesis.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    panelLinks.add(scrollbareListeThesis);
    
    buttonThesisNeu = new JButton("Neu");
    buttonThesisKopieren = new JButton("Kopieren");
    buttonThesisLoeschen = new JButton("Löschen");
    panelLinksButtonsThesis = new JPanel();
    panelLinksButtonsThesis.setLayout(new BoxLayout(panelLinksButtonsThesis, BoxLayout.X_AXIS));
    panelLinksButtonsThesis.add(buttonThesisNeu);
    panelLinksButtonsThesis.add(buttonThesisKopieren);
    panelLinksButtonsThesis.add(buttonThesisLoeschen);
    panelLinks.add(panelLinksButtonsThesis);
    
    JLabel labelArtefakt = new JLabel("Artefakte:");
    panelLinks.add(labelArtefakt);
    
    listeArtefakt = new JList();
    listeArtefakt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listeArtefakt.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        angeklicktesArtefakt(listeArtefakt.locationToIndex(e.getPoint()));
      }
	});
    JScrollPane scrollbareListeArtefakt = new JScrollPane(listeArtefakt);
    scrollbareListeArtefakt.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    panelLinks.add(scrollbareListeArtefakt);
    
    buttonArtefaktNeu = new JButton("Neu");
    buttonArtefaktVariieren = new JButton("Variieren");
    buttonArtefaktLoeschen = new JButton("Löschen");
    panelLinksButtonsArtefakt = new JPanel();
    panelLinksButtonsArtefakt.setLayout(new BoxLayout(panelLinksButtonsArtefakt, BoxLayout.X_AXIS));
    panelLinksButtonsArtefakt.add(buttonArtefaktNeu);
    panelLinksButtonsArtefakt.add(buttonArtefaktVariieren);
    panelLinksButtonsArtefakt.add(buttonArtefaktLoeschen);
    panelLinks.add(panelLinksButtonsArtefakt);
    
    return panelLinks;
  }
  
  private JPanel getRechteSeite() {
    JPanel rechtesPanel = new JPanel();
    
    return rechtesPanel;
  }
  
  private void angeklickteThesis(int index) {
	if (index == -1) return;
    // aktuelleThesis = ???
    Main.log("aktuelleThesis " + aktuelleThesis); // TODO Update rechte seite
  }
  
  private void angeklicktesArtefakt(int index) {
    if (index == -1) return;
    // aktuellesArtefakt = ???
    Main.log("aktuellesArtefakt " + index); // TODO Update rechte seite
  }
}
