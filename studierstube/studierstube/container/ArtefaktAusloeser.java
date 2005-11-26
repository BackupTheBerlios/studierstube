/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzm�ller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.container;

import java.util.ArrayList;

/**
 * Dies ist eine Klasse von Speicherobjekten, die je einen Ausl�ser
 * mit seinen Eigenschaften und einer Liste von wirkenden Spr�chen
 * beinhaltet.
 */
public class ArtefaktAusloeser {

  int zuschlag;
  int ladungen;
  
  String text;
  String praeservanz;

  ArrayList listeWirkendeSprueche = new ArrayList(0);

}
