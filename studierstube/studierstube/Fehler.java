/**************************************************************
* This file is part of the project 'Studierstube' at berliOS. *
* Copyright (c) 2005-2006 Stefan Holzmüller (twelwan@gmx.de)  *
* The software and its sources are available under the terms  *
* of the zlib/libpng license. See LICENSE.txt for details.    *
**************************************************************/

package studierstube;

import javax.swing.JOptionPane;

/**
 * In dieser Klasse werden Exceptions und interne Fehler verarbeitet.
 */
public class Fehler {

  private static Zwischenablage zwischenablage = new Zwischenablage();

 /**
  * Zeigt eine simple Dialogbox mit einem Text darin.
  * 
  * param text Ausgabe
  */
  public static void zeigeHinweis(String text) {
    JOptionPane.showMessageDialog(null,
   			text,
   			"Hinweis",
   		//	JOptionPane.PLAIN_MESSAGE);
    		JOptionPane.INFORMATION_MESSAGE);
  }
   
 /**
  * Zeigt einen Fehler-Dialog mit einem Text darin.
  * 
  * @param text Ausgabe
  */
  public static void zeigeFehlermeldung(String text) {
  	JOptionPane.showMessageDialog(null,
  			text,
  			"Fehler",
  			JOptionPane.ERROR_MESSAGE);
  }

 /**
  * Zeigt eine Exception an und bittet den Benutzer, den Bug zu melden.
  * 
  * @param exception Die anzuzeigende Exception
  */
  public static void zeigeException(Exception exception) {
	String errormsg = "Ein interner Fehler ist aufgetreten: " + exception.getMessage()
			+ "\n\n"
			+ "Bitte schicken Sie diese Meldung an den Autor, "
			+ "damit der Fehler behoben werden kann.\n\n"
			+ exception.toString() + "\n" + stackTraceAlsString(exception) + "\n"
			+ "Verwendete Version: " + Global.name + " " + Global.version;
	int value = JOptionPane.showConfirmDialog(null,
  			errormsg + "\n\nDiesen Text in die Zwischenablage kopieren?",
			"Interner Fehler",
			JOptionPane.YES_NO_OPTION);
  	if (value == JOptionPane.YES_OPTION) {
  	  zwischenablage.schreibeInZwischenablage(errormsg);
  	}
  }

 /**
  * Wandelt den Stacktrace einer Exception in einen String um.
  * 
  * @param exception	Die Exception
  * @return text		String des Stacktrace
  */
  private static String stackTraceAlsString(Exception exception) {
    StackTraceElement ste[] = exception.getStackTrace();
    String text = "";
    for (int i = 0; i < ste.length; i++) {
      String fileName = ste[i].getFileName();
      String className = ste[i].getClassName();
      String methodName = ste[i].getMethodName();
      int lineNumber = ste[i].getLineNumber();
      
      text += "at " + className + "." + methodName;
      if (fileName != null)
        text += " (" + fileName + ":" + lineNumber + ")\n";
      else
    	text += "\n";
    }
	return text;
  }
}
