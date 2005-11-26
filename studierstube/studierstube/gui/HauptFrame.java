/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
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

/**
 * Dies ist das Fenster, von wo aus der Benutzer alle Unterprogramme
 * aufrufen kann.
 */
public class HauptFrame implements ActionListener {
  public HauptFrame() {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Die magische Werkstatt" + ", Version " + Global.version);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    // TODO  void setIconImage(Image)
    frame.setJMenuBar(createJMenuBar());
    frame.getContentPane().add(createPanel());
    frame.pack();
    frame.setLocationRelativeTo(null);  // centered on screen
    frame.setVisible(true);
  }
  
  public JMenuBar createJMenuBar() {
  	JMenuBar menuBar = new JMenuBar();
  	JMenu programMenu = new JMenu("Programm");
  	JMenu optionMenu = new JMenu("Optionen");
  	JMenu helpMenu = new JMenu("Hilfe");
  	JMenuItem menuItem;
  	
  	programMenu.setMnemonic(KeyEvent.VK_P);
  	programMenu.getAccessibleContext().setAccessibleDescription("TODO");
  	menuBar.add(programMenu);
  	
  	optionMenu.setMnemonic(KeyEvent.VK_O);
  	optionMenu.getAccessibleContext().setAccessibleDescription("TODO");
  	menuBar.add(optionMenu);
  	
  	helpMenu.setMnemonic(KeyEvent.VK_H);
  	helpMenu.getAccessibleContext().setAccessibleDescription("TODO");
  	menuBar.add(helpMenu);
  	
  	menuItem = new JMenuItem("Beenden", KeyEvent.VK_B);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
    menuItem.getAccessibleContext().setAccessibleDescription("Programm beenden");
    menuItem.addActionListener(this);
    programMenu.add(menuItem);
  	
  	return menuBar;
  }
  
  public JPanel createPanel() {
  	JPanel panel = new JPanel();
    JButton button = new JButton("Klick!");
    button.setPreferredSize(new Dimension(450, 360));
    panel.add(button);
    button.addActionListener(this);
  	return panel;
  }
  
  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();
    if (command.equals("Beenden")) beenden();
  }
  
  public void beenden() {
  	System.exit(0);
  }
}
