/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.gui;

import java.awt.Dimension;
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

import studierstube.Global;

public class ArtefaktPanel extends JSplitPane {
	
  static final long serialVersionUID = 1; // brauchbarer Wert ?
  
  private java.awt.Color farbeHintergrund;;
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
  private JButton buttonArtefaktAendern;
  private JButton buttonArtefaktLoeschen;
  
  public ArtefaktPanel(java.awt.Color hintergrund) {
    farbeHintergrund = hintergrund;
    setBackground(farbeHintergrund);
    initialisiere();
  }
  
  public ArtefaktPanel() {
    super(JSplitPane.HORIZONTAL_SPLIT);
    initialisiere();
  }
	  
  private void initialisiere() {
    setLeftComponent(getLinkeSeite());
    setRightComponent(getRechteSeite());
    setOneTouchExpandable(true);

    setPreferredSize(new Dimension(555,444));  // TODO
    setMinimumSize(new Dimension(400,200));  // funktioniert nicht
    // initialisiereListe();
    
    JPanel panelRechts = new JPanel();
    panelRechts.setBackground(farbeHintergrund);
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
    scrollbareListeThesis.setMinimumSize(new Dimension(200,0));
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
    scrollbareListeArtefakt.setMinimumSize(new Dimension(200,0));
    panelLinks.add(scrollbareListeArtefakt);
    
    buttonArtefaktNeu = new JButton("Neu");
    buttonArtefaktAendern = new JButton("Ändern");
    buttonArtefaktLoeschen = new JButton("Löschen");
    panelLinksButtonsArtefakt = new JPanel();
    panelLinksButtonsArtefakt.setLayout(new BoxLayout(panelLinksButtonsArtefakt, BoxLayout.X_AXIS));
    panelLinksButtonsArtefakt.add(buttonArtefaktNeu);
    panelLinksButtonsArtefakt.add(buttonArtefaktAendern);
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
    Global.log("aktuelleThesis " + index); // TODO Update rechte seite
  }
  
  private void angeklicktesArtefakt(int index) {
    if (index == -1) return;
    // aktuellesArtefakt = ???
    Global.log("aktuellesArtefakt " + index); // TODO Update rechte seite
  }
}
