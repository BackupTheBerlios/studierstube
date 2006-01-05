/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import studierstube.Global;
import studierstube.tests.ArtefaktThesisVE;

/**
 * Dies ist das Fenster, von wo aus der Benutzer alle Unterprogramme
 * aufrufen kann.
 */
public class Hauptfenster implements ActionListener {
  
  private ArtefaktThesisVE artefaktthesis;

  public Hauptfenster() {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Studierstube, Version " + Global.version);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    // TODO  void setIconImage(Image)
    frame.setJMenuBar(erzeugeJMenuBar());
    frame.getContentPane().add(createPanel());
    frame.pack();
    frame.setLocationRelativeTo(null);  // centered on screen
    frame.setVisible(true);
    frame.setResizable(false);
  }
  
  private JMenuBar erzeugeJMenuBar() {
  	JMenuBar menuBar = new JMenuBar();
  	JMenu programmMenu = new JMenu("Programm");
  	JMenu datenMenu = new JMenu("Daten");
  	JMenu optionenMenu = new JMenu("Optionen");
  	JMenu hilfeMenu = new JMenu("Hilfe");
  	JMenuItem menuItem;
  	
  	programmMenu.setMnemonic(KeyEvent.VK_P);
  	menuBar.add(programmMenu);
  	
  	datenMenu.setMnemonic(KeyEvent.VK_D);
  	menuBar.add(datenMenu);
  	
  	optionenMenu.setMnemonic(KeyEvent.VK_O);
  	menuBar.add(optionenMenu);
  	
  	hilfeMenu.setMnemonic(KeyEvent.VK_H);
  	menuBar.add(hilfeMenu);
  	
  	menuItem = new JMenuItem("Artefakterschaffung", KeyEvent.VK_A);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
    menuItem.addActionListener(this);
    programmMenu.add(menuItem);
  	
    programmMenu.addSeparator();
    
  	menuItem = new JMenuItem("Beenden", KeyEvent.VK_B);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
    menuItem.addActionListener(this);
    programmMenu.add(menuItem);
  	
  	return menuBar;
  }
  
  private JPanel createPanel() {
  	JPanel panel = new JPanel();
    JButton button = new JButton("Klick!");
    button.setPreferredSize(new Dimension(450, 360));
    panel.add(button);
    button.addActionListener(this);
  	return panel;
  }
  
  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();
    if (command.equals("Beenden")) Global.beenden();
    else if (command.equals("Artefakterschaffung")) zeigeArtefaktThesis();
    else Global.log("FEHLER: ActionCommand nicht erkannt!");
  }
  
  private void zeigeArtefaktThesis() {
	if (artefaktthesis == null)
	  artefaktthesis = new ArtefaktThesisVE();
	else
	  artefaktthesis.toFront();
  }
}
