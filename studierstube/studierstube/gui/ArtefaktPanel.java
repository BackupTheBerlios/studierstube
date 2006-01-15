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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

import studierstube.Global;

public class ArtefaktPanel extends JSplitPane {
	
  static final long serialVersionUID = 1; // brauchbarer Wert ?
  
  private java.awt.Color farbeHintergrund;;
  private String aktuellesArtefakt = null;
  
  private JList liste;
  private JPanel panelLinks;
  private JPanel panelLinksUnten;
  private JButton buttonNeu;
  private JButton buttonAendern;
  private JButton buttonLoeschen;
  
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
    liste = new JList();
    liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    liste.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        angeklicktesArtefakt(liste.locationToIndex(e.getPoint()));
      }
	});
    JScrollPane scrollListe = new JScrollPane(liste);
    scrollListe.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollListe.setMinimumSize(new Dimension(200,0));
    panelLinks = new JPanel();
    panelLinks.setLayout(new BoxLayout(panelLinks, BoxLayout.Y_AXIS));
    panelLinks.add(scrollListe);
    
    buttonNeu = new JButton("Neu");
    buttonAendern = new JButton("Ändern");
    buttonLoeschen = new JButton("Löschen");
    panelLinksUnten = new JPanel();
    panelLinksUnten.setLayout(new BoxLayout(panelLinksUnten, BoxLayout.X_AXIS));
    panelLinksUnten.add(buttonNeu);
    panelLinksUnten.add(buttonAendern);
    panelLinksUnten.add(buttonLoeschen);
    
    panelLinks.add(panelLinksUnten);
    setLeftComponent(panelLinks);
    setOneTouchExpandable(true);

    setPreferredSize(new Dimension(555,444));  // TODO
    setMinimumSize(new Dimension(400,200));  // funktioniert nicht
    // initialisiereListe();
    
    JPanel panelRechts = new JPanel();
    panelRechts.setBackground(farbeHintergrund);
    panelRechts.setLayout(new BoxLayout(panelRechts, BoxLayout.X_AXIS));
    
    resetToPreferredSizes();
  }
  
  private void angeklicktesArtefakt(int index) {
	if (index == -1) return;
    aktuellesArtefakt = Global.getZauberliste().getZauber(index).getName();
    Global.log("aktuellesArtefakt " + index); // TODO Update rechte seite
  }
}
