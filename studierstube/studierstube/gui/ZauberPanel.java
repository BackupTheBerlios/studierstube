/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.gui;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

import studierstube.Global;

public class ZauberPanel extends JSplitPane {
  
  static final long serialVersionUID = 1; // brauchbarer Wert ?
  
  private java.awt.Color farbeHintergrund = new java.awt.Color(200,210,255);
  private String aktuellerZauber = null;
  
  private JList liste;
  
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
    liste = new JList();
    liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    liste.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        angeklickterZauber(liste.locationToIndex(e.getPoint()));
      }
	});
    JScrollPane scrollListe = new JScrollPane(liste);
    scrollListe.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollListe.setMinimumSize(new Dimension(200,0));
    setLeftComponent(scrollListe);
    setOneTouchExpandable(true);
    setDividerLocation(200);
    setPreferredSize(new Dimension(555,444));
    setMinimumSize(new Dimension(400,200));  // funktioniert nicht
    fuelleListe();
  }
  
  private int fuelleListe() {
    int anzahl = Global.getZauberliste().getAnzahlZauber();
    String[] namenListe = new String[anzahl];
    for (int i = 0; i < anzahl; i++) {
      namenListe[i] = Global.getZauberliste().getZauber(i).getName();
    }
    liste.setListData(namenListe);
    return anzahl;
  }
  
  private void angeklickterZauber(int index) {
    aktuellerZauber = Global.getZauberliste().getZauber(index).getName();
    Global.log("angeklickterZauber " + index); // TODO Update rechte seite
  }
}
