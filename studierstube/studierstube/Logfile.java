/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the (3-clause) BSD license. See LICENSE.txt for details. *
**************************************************************/

package studierstube;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Diese Klasse sorgt für Logging.
 */
public class Logfile {
  
  private FileWriter filewriter;
  private BufferedWriter bufferedwriter;

  private boolean logging = true;

  /**
   * Konstruktor.
   * 
   * @param dateiname Name des Logfiles
   */
  Logfile(String dateiname) {
    initialisiereLogfile(dateiname);
  }
  
  /**
   * Gibt den String auf stdout aus und schreibt ihn in das Logfile.
   * 
   * Tritt beim Schreiben ein Fehler auf, wird das Logging deaktiviert
   * und das Logfile geschlossen.
   * 
   * @param ausgabe Ausgabe
   */
  void println(String ausgabe) {
	System.out.println(ausgabe);
	if (logging == true) {
      try {
        bufferedwriter.write(ausgabe);
        bufferedwriter.newLine();
        bufferedwriter.flush();  // ugly
      }
      catch (Exception e) {
        Fehler.zeigeFehlermeldung("Fehler beim Schreiben in Logfile!");
        Fehler.zeigeException(e);
        e.printStackTrace();
        logging = false;
        schliesseLogfile();
      }
    }
  }
  
 /**
  * Initialisiert das Logfile
  */
  void initialisiereLogfile(String dateiname) {
    try {
      filewriter = new FileWriter(dateiname);
    }
    catch (Exception e) {
      Fehler.zeigeException(e);
      e.printStackTrace();
    }
    bufferedwriter = new BufferedWriter(filewriter);
  }
  
 /**
  * Schließt das Logfile
  */
  void schliesseLogfile() {
    try {
	//  logwriter.flush(); // wenn beim Schreiben nicht schon flush() aufgerufen wurde
	}
	catch (Exception e) {
	  Fehler.zeigeFehlermeldung("Fehler beim Leeren des Logfile-Buffers!");
	  Fehler.zeigeException(e);
	  e.printStackTrace();
	}
	finally {
	  try {
	    bufferedwriter.close();
	  }
	  catch (Exception e) {
	    Fehler.zeigeFehlermeldung("Fehler beim Schließen des Logfiles!");
	    Fehler.zeigeException(e);
	    e.printStackTrace();
	  }
	}
  }
}