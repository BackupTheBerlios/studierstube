/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.container;

/**
 * Einzelner Zauber mit seinen generischen Eigenschaften.
 */
public class Zauber {
  private String name; // rep
  private String komplexitaet;
  private String[] probe = new String[3];
  private String[] merkmale;
  private String[] varianten;
  
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
  
  /**
   * Liefert den Namen des Zaubers.
   * 
   * @return Name des Zaubers
   */
  public String getName() {
	return name;
  }
  
  /**
   * Liefert die Komplexität des Zaubers.
   * 
   * @return Komplexität des Zaubers
   */
  public String getKomplexitaet() {
	return komplexitaet;
  }
  
  /**
   * Liefert die Probe des Zaubers als String-Array.
   * 
   * @return Probe des Zaubers
   */
  public String[] getProbe() {
	return probe;
  }
  
  /**
   * Liefert die Probe des Zaubers als String mit / als Trennzeichen.
   * 
   * @return Probe des Zaubers
   */
  public String getProbeAlsString() {
	String probestring = probe[0] + "/" + probe[1] + "/" + probe[2];
	return probestring;
  }
  
  /**
   * Liefert die Merkmale des Zaubers als String-Array.
   * 
   * @return Merkmale des Zaubers
   */
  public String[] getMerkmale() {
	return merkmale;
  }
  
  /**
   * Liefert die Varianten des Zaubers als String-Array.
   * 
   * @return Varianten des Zaubers
   */
  public String[] getVarianten() {
	return varianten;
  }
  
  protected Zauber copy() {
    Zauber neu = new Zauber();
    neu.name = this.name;
    neu.komplexitaet = this.komplexitaet;
    neu.probe = this.probe;
    neu.merkmale = this.merkmale;
    neu.varianten = this.varianten;
    return neu;
  }
}
