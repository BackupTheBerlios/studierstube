/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.container;

import java.util.ArrayList;

/**
 * Dies ist eine Klasse von Speicherobjekten, die je ein einzelnes
 * Artefakt mit all seinen Eigenschaften beinhaltet.
 */
public class Artefakt {
  boolean	eigenschaftSiegel,
  		eigenschaftUnzerbrechlichkeit,
  		eigenschaftGespuer,
  		eigenschaftApport;
  
  int	zuschlagMaterial,
  	zuschlagAffinitaetsprinzip,
	zuschlagZeit,
	zuschlagOrt,
	zuschlagGroesse;
  
  ArrayList listeAusloeser = new ArrayList(0);
  
}
