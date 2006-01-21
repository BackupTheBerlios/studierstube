/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.tests;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;

/**
 * In diesem Fenster kann der Benutzer das Artefakt entwerfen.
 */
public class ArtefaktThesisVE extends JFrame {

	static final long serialVersionUID = 1L;  // TODO brauchbarer Wert
	private JPanel jContentPane = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private JLabel labelName = null;
	private JTextField textFieldName = null;
	private JTextArea textAreaBeschreibung = null;
	private JPanel panelHaltbarkeit = null;
	private JTree treeSprueche = null;
	private JRadioButton radioButtonHaltbarkeitPermanent = null;
	private JRadioButton radioButtonHaltbarkeitMonat = null;
	private JRadioButton radioButtonHaltbarkeitWoche = null;
	private JRadioButton radioButtonHaltbarkeitTag = null;
	private JPanel panelHaltbarkeitInnen = null;
	private JButton buttonSpruchHinzufuegen = null;
	private JPanel panelEigenschaften = null;
	private JPanel panelEigenschaftenInnen = null;
	private JCheckBox checkBoxEigenschaftSiegel = null;
	private JCheckBox checkBoxEigenschaftUnzerbrechlichkeit = null;
	private JCheckBox checkBoxEigenschaftGespuer = null;
	private JCheckBox checkBoxEigenschaftApport = null;
	private JButton buttonSpruchEntfernen = null;
	private JButton buttonSpruchBearbeiten = null;
	private JLabel labelZauberwirkungen = null;
	private JButton buttonLaden = null;
	private JButton buttonSpeichern = null;
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
		this.setSize(571, 391);
		this.setMinimumSize(new java.awt.Dimension(90,208));
		this.setResizable(true);
		this.setContentPane(getJContentPane());
		this.setTitle("Artefaktthesis für: unbenanntes Artefakt");
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
			labelZauberwirkungen = new JLabel();
			labelZauberwirkungen.setText("Zauberwirkungen:");
			labelZauberwirkungen.setLocation(new java.awt.Point(4,144));
			labelZauberwirkungen.setSize(new java.awt.Dimension(174,16));
			labelName = new JLabel();
			labelName.setText("Name");
			labelName.setLocation(new java.awt.Point(9,9));
			labelName.setSize(new java.awt.Dimension(34,16));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setBackground(new java.awt.Color(200,210,255));
			jContentPane.setForeground(new java.awt.Color(255,255,204));
			jContentPane.add(labelName, null);
			jContentPane.add(getTextFieldName(), null);
			jContentPane.add(getTextAreaBeschreibung(), null);
			jContentPane.add(getPanelHaltbarkeit(), null);
			jContentPane.add(getPanelEigenschaften(), null);
			jContentPane.add(getButtonSpruchEntfernen(), null);
			jContentPane.add(getButtonSpruchBearbeiten(), null);
			jContentPane.add(getTreeSprueche(), null);
			jContentPane.add(getButtonSpruchHinzufuegen(), null);
			jContentPane.add(labelZauberwirkungen, null);
			jContentPane.add(getButtonLaden(), null);
			jContentPane.add(getButtonSpeichern(), null);
			ButtonGroup buttonGroupHaltbarkeit = new ButtonGroup();
			buttonGroupHaltbarkeit.add(radioButtonHaltbarkeitPermanent);
			buttonGroupHaltbarkeit.add(radioButtonHaltbarkeitMonat);
			buttonGroupHaltbarkeit.add(radioButtonHaltbarkeitWoche);
			buttonGroupHaltbarkeit.add(radioButtonHaltbarkeitTag);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextFieldName() {
		if (textFieldName == null) {
			textFieldName = new JTextField();
			textFieldName.setBounds(new java.awt.Rectangle(47,8,256,20));
			textFieldName.setText("unbenanntes Artefakt");
			textFieldName.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) {
					System.out.println("keyTyped()"); // TODO Auto-generated Event stub keyTyped()
				}
			});
		}
		return textFieldName;
	}

	/**
	 * This method initializes textAreaBeschreibung	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTextAreaBeschreibung() {
		if (textAreaBeschreibung == null) {
			textAreaBeschreibung = new JTextArea();
			textAreaBeschreibung.setBounds(new java.awt.Rectangle(9,31,244,109));
			textAreaBeschreibung.setText("Beschreibungstext");
			textAreaBeschreibung.setToolTipText("Hier können Sie eine Beschreibung des Artefakts verfassen");
			textAreaBeschreibung.setLineWrap(true);
		}
		return textAreaBeschreibung;
	}

	/**
	 * This method initializes panelHaltbarkeit	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelHaltbarkeit() {
		if (panelHaltbarkeit == null) {
			panelHaltbarkeit = new JPanel();
			panelHaltbarkeit.setLayout(new BoxLayout(getPanelHaltbarkeit(), BoxLayout.X_AXIS));
			panelHaltbarkeit.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Haltbarkeit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
			panelHaltbarkeit.setBackground(new java.awt.Color(255,255,204));
			panelHaltbarkeit.setSize(new java.awt.Dimension(125,120));
			panelHaltbarkeit.setLocation(new java.awt.Point(433,31));
			panelHaltbarkeit.add(getPanelHaltbarkeitInnen(), null);
		}
		return panelHaltbarkeit;
	}

	/**
	 * This method initializes treeSprueche	
	 * 	
	 * @return javax.swing.JTree	
	 */
	private JTree getTreeSprueche() {
		if (treeSprueche == null) {
			treeSprueche = new JTree();
			treeSprueche.setRootVisible(false);
			treeSprueche.setBounds(new java.awt.Rectangle(5,168,414,78));
			treeSprueche.setToolTipText("asd");
			treeSprueche.setPreferredSize(new java.awt.Dimension(999,999));
		}
		return treeSprueche;
	}

	/**
	 * This method initializes radioButtonHaltbarkeit	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRadioButtonHaltbarkeitPermanent() {
		if (radioButtonHaltbarkeitPermanent == null) {
			radioButtonHaltbarkeitPermanent = new JRadioButton();
			radioButtonHaltbarkeitPermanent.setText("permanent");
			radioButtonHaltbarkeitPermanent.setBackground(new java.awt.Color(255,255,204));
			radioButtonHaltbarkeitPermanent.setSelected(true);
			radioButtonHaltbarkeitPermanent.setName("");
		}
		return radioButtonHaltbarkeitPermanent;
	}

	/**
	 * This method initializes radioButtonHaltbarkeitTag	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRadioButtonHaltbarkeitMonat() {
		if (radioButtonHaltbarkeitMonat == null) {
			radioButtonHaltbarkeitMonat = new JRadioButton();
			radioButtonHaltbarkeitMonat.setText("mind. 1 Monat");
			radioButtonHaltbarkeitMonat.setBackground(new java.awt.Color(255,255,204));
		}
		return radioButtonHaltbarkeitMonat;
	}

	/**
	 * This method initializes radioButtonHaltbarkeitWoche	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRadioButtonHaltbarkeitWoche() {
		if (radioButtonHaltbarkeitWoche == null) {
			radioButtonHaltbarkeitWoche = new JRadioButton();
			radioButtonHaltbarkeitWoche.setText("mind. 1 Woche");
			radioButtonHaltbarkeitWoche.setBackground(new java.awt.Color(255,255,204));
		}
		return radioButtonHaltbarkeitWoche;
	}

	/**
	 * This method initializes radioButtonHaltbarkeitTag	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRadioButtonHaltbarkeitTag() {
		if (radioButtonHaltbarkeitTag == null) {
			radioButtonHaltbarkeitTag = new JRadioButton();
			radioButtonHaltbarkeitTag.setText("mind. 1 Tag");
			radioButtonHaltbarkeitTag.setBackground(new java.awt.Color(255,255,204));
		}
		return radioButtonHaltbarkeitTag;
	}

	/**
	 * This method initializes panelHaltbarkeitInnen	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelHaltbarkeitInnen() {
		if (panelHaltbarkeitInnen == null) {
			panelHaltbarkeitInnen = new JPanel();
			panelHaltbarkeitInnen.setLayout(new BoxLayout(getPanelHaltbarkeitInnen(), BoxLayout.Y_AXIS));
			panelHaltbarkeitInnen.setBackground(new java.awt.Color(255,255,204));
			panelHaltbarkeitInnen.add(getRadioButtonHaltbarkeitPermanent(), null);
			panelHaltbarkeitInnen.add(getRadioButtonHaltbarkeitMonat(), null);
			panelHaltbarkeitInnen.add(getRadioButtonHaltbarkeitWoche(), null);
			panelHaltbarkeitInnen.add(getRadioButtonHaltbarkeitTag(), null);
		}
		return panelHaltbarkeitInnen;
	}

	/**
	 * This method initializes buttonSpruchHinzufuegen	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButtonSpruchHinzufuegen() {
		if (buttonSpruchHinzufuegen == null) {
			buttonSpruchHinzufuegen = new JButton();
			buttonSpruchHinzufuegen.setText("Hinzufügen ...");
			buttonSpruchHinzufuegen.setBounds(new java.awt.Rectangle(431,174,109,26));
			buttonSpruchHinzufuegen.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return buttonSpruchHinzufuegen;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelEigenschaften() {
		if (panelEigenschaften == null) {
			panelEigenschaften = new JPanel();
			panelEigenschaften.setLayout(null);
			panelEigenschaften.setBackground(new java.awt.Color(255,255,204));
			panelEigenschaften.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Optionale Eigenschaften", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12), new java.awt.Color(51,51,51)));
			panelEigenschaften.setSize(new java.awt.Dimension(167,120));
			panelEigenschaften.setLocation(new java.awt.Point(261,30));
			panelEigenschaften.add(getPanelEigenschaftenInnen(), null);
		}
		return panelEigenschaften;
	}

	/**
	 * This method initializes panelEigenschaftenInnen	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelEigenschaftenInnen() {
		if (panelEigenschaftenInnen == null) {
			panelEigenschaftenInnen = new JPanel();
			panelEigenschaftenInnen.setLayout(new BoxLayout(getPanelEigenschaftenInnen(), BoxLayout.Y_AXIS));
			panelEigenschaftenInnen.setBounds(new java.awt.Rectangle(7,18,155,96));
			panelEigenschaftenInnen.setBackground(new java.awt.Color(255,255,204));
			panelEigenschaftenInnen.add(getCheckBoxEigenschaftSiegel(), null);
			panelEigenschaftenInnen.add(getCheckBoxEigenschaftUnzerbrechlichkeit(), null);
			panelEigenschaftenInnen.add(getCheckBoxEigenschaftGespuer(), null);
			panelEigenschaftenInnen.add(getCheckBoxEigenschaftApport(), null);
		}
		return panelEigenschaftenInnen;
	}

	/**
	 * This method initializes checkBoxEigenschaftSiegel	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getCheckBoxEigenschaftSiegel() {
		if (checkBoxEigenschaftSiegel == null) {
			checkBoxEigenschaftSiegel = new JCheckBox();
			checkBoxEigenschaftSiegel.setText("Siegel und Zertifikat");
			checkBoxEigenschaftSiegel.setBackground(new java.awt.Color(255,255,204));
		}
		return checkBoxEigenschaftSiegel;
	}

	/**
	 * This method initializes checkBoxEigenschaftUnzerbrechlich	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getCheckBoxEigenschaftUnzerbrechlichkeit() {
		if (checkBoxEigenschaftUnzerbrechlichkeit == null) {
			checkBoxEigenschaftUnzerbrechlichkeit = new JCheckBox();
			checkBoxEigenschaftUnzerbrechlichkeit.setBackground(new java.awt.Color(255,255,204));
			checkBoxEigenschaftUnzerbrechlichkeit.setText("Unzerbrechlichkeit");
		}
		return checkBoxEigenschaftUnzerbrechlichkeit;
	}

	/**
	 * This method initializes checkBoxEigenschaftGespuer	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getCheckBoxEigenschaftGespuer() {
		if (checkBoxEigenschaftGespuer == null) {
			checkBoxEigenschaftGespuer = new JCheckBox();
			checkBoxEigenschaftGespuer.setText("Gespür des Schöpfers");
			checkBoxEigenschaftGespuer.setActionCommand("Gespür des Schöpfers");
			checkBoxEigenschaftGespuer.setBackground(new java.awt.Color(255,255,204));
		}
		return checkBoxEigenschaftGespuer;
	}

	/**
	 * This method initializes checkBoxEigenschaftApport	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getCheckBoxEigenschaftApport() {
		if (checkBoxEigenschaftApport == null) {
			checkBoxEigenschaftApport = new JCheckBox();
			checkBoxEigenschaftApport.setBackground(new java.awt.Color(255,255,204));
			checkBoxEigenschaftApport.setText("Magischer Apport");
		}
		return checkBoxEigenschaftApport;
	}

	/**
	 * This method initializes buttonSpruchEntfernen	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButtonSpruchEntfernen() {
		if (buttonSpruchEntfernen == null) {
			buttonSpruchEntfernen = new JButton();
			buttonSpruchEntfernen.setText("Entfernen");
			buttonSpruchEntfernen.setBounds(new java.awt.Rectangle(432,245,89,26));
			buttonSpruchEntfernen.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return buttonSpruchEntfernen;
	}

	/**
	 * This method initializes buttonSpruchBearbeiten	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButtonSpruchBearbeiten() {
		if (buttonSpruchBearbeiten == null) {
			buttonSpruchBearbeiten = new JButton();
			buttonSpruchBearbeiten.setText("Bearbeiten ...");
			buttonSpruchBearbeiten.setBounds(new java.awt.Rectangle(429,201,108,26));
			buttonSpruchBearbeiten.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return buttonSpruchBearbeiten;
	}

	/**
	 * This method initializes buttonLaden	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButtonLaden() {
		if (buttonLaden == null) {
			buttonLaden = new JButton();
			buttonLaden.setBounds(new java.awt.Rectangle(328,8,106,19));
			buttonLaden.setText("Laden ...");
		}
		return buttonLaden;
	}

	/**
	 * This method initializes buttonSpeichern	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButtonSpeichern() {
		if (buttonSpeichern == null) {
			buttonSpeichern = new JButton();
			buttonSpeichern.setBounds(new java.awt.Rectangle(448,7,108,20));
			buttonSpeichern.setText("Speichern ...");
		}
		return buttonSpeichern;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
