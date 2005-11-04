/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.container;

public class Zauber {
  public String name;
//  public String[] verbreitung;   /// oder rep?
  public String komplexitaet;
  public String[] probe = new String[3];
  public String[] merkmale;
  public String[] varianten;
  
  public void setName(String n) {
	name = n;
  }
  
  public void setKomplexitaet(String k) {
    komplexitaet = k;
  }
  
  public void setProbe(String p0, String p1, String p2) {
    probe[0] = p0;
    probe[1] = p1;
    probe[2] = p2;
  }
  
  public void setMerkmale(String[] m) {
    merkmale = m;
  }
  
  public void setVarianten(String[] v) {
	varianten = v;
  }
}
