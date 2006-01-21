/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import studierstube.Main;

public class Hauptfenster extends JFrame implements ActionListener {
	
  static final long serialVersionUID = 1; // brauchbarer Wert ?
  
  private Color farbeHintergrund = new Color(200,210,255);
  
  public Hauptfenster() {
    setDefaultLookAndFeelDecorated(true);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        Main.beenden();
      }
    });
    setTitle(Main.projektName + " Version " + Main.version);
    // setIconImage(Image)
    setJMenuBar(erzeugeJMenuBar());
    setBackground(farbeHintergrund);
    JTabbedPane tabs = new JTabbedPane();
    tabs.setBackground(new java.awt.Color(200,210,255));
    tabs.addTab("Zauberdatenbank", new ZauberPanel(farbeHintergrund));
    tabs.addTab("Artefaktsammlung", new ArtefaktPanel(farbeHintergrund));
    getContentPane().add(tabs);
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
  
  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();
    if (command.equals("Beenden")) Main.beenden();
    else Main.log("FEHLER: ActionCommand nicht erkannt!");
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
