/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.tests;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * In diesem Fenster kann der Benutzer das Artefakt entwerfen.
 */
public class ArtefaktThesisVE extends JFrame {

	static final long serialVersionUID = 1L;  // TODO brauchbarer Wert
	private JPanel jContentPane = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	/**
	 * This is the default constructor
	 */
	public ArtefaktThesisVE() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(545, 282);
		this.setContentPane(getJContentPane());
		this.setTitle("test");
		this.setVisible(true);
		this.toFront();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(java.awt.Color.orange);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
