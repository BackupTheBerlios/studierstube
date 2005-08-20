/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005 Stefan Holzmüller (twelwan@gmx.de)       *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube.regeln;

import java.util.ArrayList;

public class Artefakt {
  boolean siegel, unzerbrechlichkeit, gespuer, apport;
  int material, affinitaetsprinzip;
  ArrayList ausloeserListe = new ArrayList(0);
  
  int aktuellerAusloeser = -1;
  int aktuelleLadung = -1;
  int aktuellerSpruch = -1;
  
  public void neuerAusloeser(Ausloeser a) {
  	ausloeserListe.add(a);
  	aktuellerAusloeser++;
    aktuelleLadung = -1;
    aktuellerSpruch = -1;
  }
  
  public void neueLadungZuAusloeser(Ladung l) {
  	((Ausloeser) ausloeserListe.get(aktuellerAusloeser)).ladungListe.add(l);
  	aktuelleLadung++;
  	aktuellerSpruch = -1;
  }
  
  public void neuerSpruchZuLadung(Spruch s) {
  	((Ladung) ((Ausloeser) ausloeserListe.get(aktuellerAusloeser)).ladungListe.get(aktuelleLadung)).spruchListe.add(s);
  	aktuellerSpruch++;
  }
  
  public int zaehleAusloeser() {
  	return ausloeserListe.size();
  }
  
  
  
  public class Ausloeser {
    int ausloeser;
    String ausloesertext;
    String praeservanz;
    ArrayList ladungListe = new ArrayList(0);
    
    public Ausloeser(int zuschlag, String text, String praes) {
      ausloeser = zuschlag;
      ausloesertext = text;
      praeservanz = praes;
    }
  }
  
  public class Ladung {
    ArrayList spruchListe = new ArrayList(0);
    
    public Ladung() {
    	
    }
  }
  
  public class Spruch {
    String zauber;
    String repraesentation;
    String wirkung;
    int zfw;
    int zfp;
    int stapelung;
    ArrayList modifikationListe = new ArrayList(0);
  
    public Spruch(String id, String rep, String wirk, int zw, int zp, int stapel) {
  	  zauber = id;
  	  repraesentation = rep;
  	  wirkung = wirk;
  	  zfw = zw;
  	  zfp = zp;
  	  stapelung = stapel;
    }
  }
}
