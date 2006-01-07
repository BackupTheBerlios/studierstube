/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

import studierstube.Global;

public class Hauptfenster extends JFrame implements ActionListener {
	
  static final long serialVersionUID = 1; // TODO anderer Wert ?
  
  public Hauptfenster() {
    setDefaultLookAndFeelDecorated(true);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        Global.beenden();
      }
    });
    setTitle(Global.name + " Version " + Global.version);
    // TODO  setIconImage(Image)
    setJMenuBar(erzeugeJMenuBar());
    JTabbedPane tabs = new JTabbedPane();
    tabs.addTab("Zauberdatenbank", new ZauberPanel());
    tabs.addTab("Artefaktsammlung", new ArtefaktePanel());
    getContentPane().add(tabs);
    pack();
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
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
    if (command.equals("Beenden")) Global.beenden();
    else Global.log("FEHLER: ActionCommand nicht erkannt!");
  }
}
