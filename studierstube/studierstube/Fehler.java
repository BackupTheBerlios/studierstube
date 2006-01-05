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

 /**
  * Zeigt eine simple Dialogbox mit einem Text darin.
  * 
  * param string Ausgabe
  */
  public static void displayMessage(String string) {
    JOptionPane.showMessageDialog(null,
   			string,
   			"Hinweis",
   		//	JOptionPane.PLAIN_MESSAGE);
    		JOptionPane.INFORMATION_MESSAGE);
  }
   
 /**
  * Zeigt einen Fehler-Dialog mit einem Text darin.
  * 
  * @param string Ausgabe
  */
  public static void displayError(String string) {
  	JOptionPane.showMessageDialog(null,
  			string,
  			"Fehler",
  			JOptionPane.ERROR_MESSAGE);
  }

 /**
  * Zeigt eine Exception an und bittet den Benutzer, den Bug zu melden.
  * 
  * @param exception Die anzuzeigende Exception
  */
  public static void displayException(Exception exception) {
	String errormsg = "Ein interner Fehler ist aufgetreten: " + exception.getMessage()
			+ "\n\n"
			+ "Bitte schicken Sie diese Meldung an den Autor, "
			+ "damit der Fehler behoben werden kann.\n\n"
			+ exception.toString() + "\n" + getStackTrace(exception) + "\n"
			+ "Diesen Text in die Zwischenablage kopieren?";
	int value = JOptionPane.showConfirmDialog(null,
  			errormsg,
			"Interner Fehler",
			JOptionPane.YES_NO_OPTION);
  	if (value == JOptionPane.YES_OPTION) {
  		// TODO copy to clipboard
  	}
  }

 /**
  * Wandelt den Stacktrace einer Exception in einen String um.
  * 
  * @param exception	Die Exception
  * @return s			String des Stacktrace
  */
  static String getStackTrace(Exception exception) {
    StackTraceElement stack[] = exception.getStackTrace();
    String s = "";
    for (int i = 0; i < stack.length; i++) {
      String fileName = stack[i].getFileName();
      String className = stack[i].getClassName();
      String methodName = stack[i].getMethodName();
      int lineNumber = stack[i].getLineNumber();
      
      s += "at " + className + "." + methodName;
      if (fileName != null)
        s += "(" + fileName + ":" + lineNumber + ")\n";
      else
    	s += "\n";
    }
	return s;
  }
}
