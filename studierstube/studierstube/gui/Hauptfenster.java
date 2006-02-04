/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import studierstube.Main;

public class Hauptfenster extends JFrame implements ActionListener {
	
  static final long serialVersionUID = 1; // brauchbarer Wert ?
  
  static final Color farbeHintergrund = new Color(200,210,255);
  
  private CardLayout cardLayout;
  private JPanel panels;
  private String titel = Main.PROJEKTNAME + " Version " + Main.VERSION;
  private final String nameArtefaktPanel = "Artefakte";
  private final String nameZauberPanel = "Zauber";
  
  public Hauptfenster() {
    setDefaultLookAndFeelDecorated(true);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        Main.beenden();
      }
    });
    // setIconImage(Image)
    setJMenuBar(erzeugeJMenuBar());
    setBackground(farbeHintergrund);
    
    JPanel panelHauptfenster = new JPanel();
    panelHauptfenster.setLayout(new BorderLayout());
    JButton buttonArtefaktPanel = new JButton(nameArtefaktPanel);
    JButton buttonZauberPanel = new JButton(nameZauberPanel);
    buttonArtefaktPanel.addActionListener(new java.awt.event.ActionListener() {
	  public void actionPerformed(java.awt.event.ActionEvent e) {
	    zeigeArtefaktPanel();
	  }
	});
    buttonZauberPanel.addActionListener(new java.awt.event.ActionListener() {
  	  public void actionPerformed(java.awt.event.ActionEvent e) {
  	    zeigeZauberPanel();
  	  }
  	});
    JToolBar toolBar = new JToolBar(JToolBar.HORIZONTAL);
    toolBar.add(buttonArtefaktPanel);
    toolBar.add(buttonZauberPanel);
    panelHauptfenster.add(toolBar, java.awt.BorderLayout.NORTH);
    
//    JPanel statusBar = new JPanel();
//    statusBar.setLayout(new BorderLayout());
//    statusBar.add(new JLabel("Subhash"), BorderLayout.CENTER);
//    statusBar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
//    panelHauptfenster.add(statusBar,BorderLayout.SOUTH);
    
    cardLayout = new CardLayout();
    panels = new JPanel(cardLayout);
    panels.setBackground(farbeHintergrund);
    panels.add(nameArtefaktPanel, new ArtefaktPanel());
    panels.add(nameZauberPanel, new ZauberPanel());
    panelHauptfenster.add(panels, java.awt.BorderLayout.CENTER);
    
    getContentPane().add(panelHauptfenster);
    zeigeArtefaktPanel();
    pack();
    setResizable(true);
    setLocationRelativeTo(null);
    setVisible(true);
    toFront();
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
  	
  	menuItem = new JMenuItem(nameArtefaktPanel, KeyEvent.VK_A);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
    menuItem.addActionListener(this);
    programmMenu.add(menuItem);
    
  	menuItem = new JMenuItem(nameZauberPanel, KeyEvent.VK_Z);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
    menuItem.addActionListener(this);
    programmMenu.add(menuItem);
  	
    programmMenu.addSeparator();
    
  	menuItem = new JMenuItem("Beenden", KeyEvent.VK_B);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
    menuItem.addActionListener(this);
    programmMenu.add(menuItem);
  	
  	return menuBar;
  }
  
  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();
    if (command.equals("Beenden")) Main.beenden();
    else if (command.equals(nameArtefaktPanel)) zeigeArtefaktPanel();
    else if (command.equals(nameZauberPanel)) zeigeZauberPanel();
    else Main.log("FEHLER: ActionCommand nicht erkannt!");
  }
  
  public void zeigeArtefaktPanel() {
    cardLayout.show(panels, nameArtefaktPanel);
    setTitle(titel + " (" + nameArtefaktPanel +")");
  }
  
  public void zeigeZauberPanel() {
    cardLayout.show(panels, nameZauberPanel);
    setTitle(titel + " (" + nameZauberPanel + ")");
  }
  
  public int beendenBestaetigen() {
    int x = JOptionPane.showConfirmDialog(  // TODO gespeichert ?
    		this, 
    		"Sind Sie sicher?",  // TODO andere Frage bei speichern
    		"Programm beenden", 
    		JOptionPane.YES_NO_OPTION);
    return x;
  }
}
