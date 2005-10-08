/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.container;

public class Zauber {
  String name;
  String komplexitaet;
  String[] probe = new String[3];
  String[] merkmale;
  String[] varianten;
  
  public String gibName() {
    return name;
  }
  
  public String gibKomplexitaet() {
    return komplexitaet;
  }
  
  public String[] gibProbe() {
    return probe;
  }
  
  public String[] gibMerkmale() {
    return merkmale;
  }
  
  public String[] gibVarianten() {
    return varianten;
  }
  
  public void setzeName(String n) {
    name = n;
  }
  
  public void setzeKomplexitaet(String k) {
    komplexitaet = k;
  }
  
  public void setzeProbe(String[] p) {
    probe = p;
  }
  
  public void setzeProbe(String a, String b, String c) {
    String[] p = new String[3];
    p[0] = a;
    p[1] = b;
    p[2] = c;
    probe = p;
  }
  
  public void setzeMerkmale(String[] m) {
    merkmale = m;
  }
  
  public void setzeVarianten(String[] v) {
    varianten = v;
  }
}
