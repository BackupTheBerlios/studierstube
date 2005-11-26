/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.container;

/**
 * Einzelner Zauber mit seinen generischen Eigenschaften.
 */
public class Zauber {
  public String name;
//  public String[] verbreitung;   /// oder rep?
  public String komplexitaet;
  public String[] probe = new String[3];
  public String[] merkmale;
  public String[] varianten;
  
  /**
   * Setter für Name des Zaubers.
   * 
   * @param n	neuer Name
   */
  public void setName(String n) {
	name = n;
  }
  
  /**
   * Setter für Komplexität des Zaubers.
   * 
   * @param k	neue Komplexität
   */
  public void setKomplexitaet(String k) {
    komplexitaet = k;
  }
  
  /**
   * Setter für Probe des Zaubers.
   * 
   * @param p0	erste Eigenschaft
   * @param p1	zweite Eigenschaft
   * @param p2	dritte Eigenschaft
   */
  public void setProbe(String p0, String p1, String p2) {
    probe[0] = p0;
    probe[1] = p1;
    probe[2] = p2;
  }
  
  /**
   * Setter für Merkmale des Zaubers.
   * 
   * @param m	neue Merkmale in einem Array
   */
  public void setMerkmale(String[] m) {
    merkmale = m;
  }
  
  /**
   * Setter für Varianten des Zaubers.
   * 
   * @param v	neue Varianten in einem Array
   */
  public void setVarianten(String[] v) {
	varianten = v;
  }
}
