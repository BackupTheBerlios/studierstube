/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.container;

import java.util.ArrayList;

public class Zauberliste {
  ArrayList liste = new ArrayList(270);  // 270 = grobe Anzahl der Zauber im LC
  
  public void add(Zauber z) {
    liste.add(z);
  }
}
