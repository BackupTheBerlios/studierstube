/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzm�ller (twelwan@gmx.de)  *
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

public class ZauberPanel extends JSplitPane {
  
  static final long serialVersionUID = 1; // brauchbarer Wert ?
  
  private java.awt.Color farbeHintergrund;;
  private String aktuellerZauber = null;
  
  private JList listeZauber;
  private JPanel panelLinks;
  private JPanel panelLinksUnten;
  private JButton buttonNeu;
  private JButton buttonKopieren;
  private JButton buttonLoeschen;
  
  public ZauberPanel(java.awt.Color hintergrund) {
    farbeHintergrund = hintergrund;
    setBackground(farbeHintergrund);
    initialisiere();
  }
  
  public ZauberPanel() {
	super(JSplitPane.HORIZONTAL_SPLIT);
    initialisiere();
  }
  
  private void initialisiere() {
    listeZauber = new JList();
    listeZauber.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    listeZauber.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        angeklickterZauber(listeZauber.locationToIndex(e.getPoint()));
      }
	});
    JScrollPane scrollListe = new JScrollPane(listeZauber);
    scrollListe.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollListe.setMinimumSize(new Dimension(200,0));
    panelLinks = new JPanel();
    panelLinks.setLayout(new BoxLayout(panelLinks, BoxLayout.Y_AXIS));
    panelLinks.add(scrollListe);
    
    buttonNeu = new JButton("Neu");
    buttonKopieren = new JButton("Kopieren");
    buttonLoeschen = new JButton("L�schen");
    panelLinksUnten = new JPanel();
    panelLinksUnten.setLayout(new BoxLayout(panelLinksUnten, BoxLayout.X_AXIS));
    panelLinksUnten.add(buttonNeu);
    panelLinksUnten.add(buttonKopieren);
    panelLinksUnten.add(buttonLoeschen);
    
    panelLinks.add(panelLinksUnten);
    setLeftComponent(panelLinks);
    setOneTouchExpandable(true);
    setDividerLocation(200);
    setPreferredSize(new Dimension(555,444));  // TODO
    setMinimumSize(new Dimension(400,200));  // funktioniert nicht
    initialisiereListe();
  }
  
  private int initialisiereListe() {
    int anzahl = Global.getZauberliste().getAnzahlZauber();
    String[] namenListe = new String[anzahl];
    for (int i = 0; i < anzahl; i++) {
      namenListe[i] = Global.getZauberliste().getZauber(i).getName();
    }
    listeZauber.setListData(namenListe);
    return anzahl;
  }
  
  private void angeklickterZauber(int index) {
    aktuellerZauber = Global.getZauberliste().getZauber(index).getName();
    Global.log("aktuellerZauber " + index); // TODO Update rechte seite
  }
}
