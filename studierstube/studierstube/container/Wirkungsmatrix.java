/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube.container;

import java.util.ArrayList;

/**
 * Dies ist eine Klasse von Speicherobjekten, die je einen wirkenden
 * Spruch mit all seinen Eigenschaften beinhaltet.
 */
public class Wirkungsmatrix {
  
  String zauberID;
  String repraesentation;
  String wirkung;
  
  int zfw;
  int zfp;
  int reihung;
  int stapelung;
  
  ArrayList listeModifikationen = new ArrayList(0);
  
}
