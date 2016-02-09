package ctrl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Language {

	
public String THE_ALCHEMIST = "";
public String LEVEL = "";
public String HEALTH = "";
public String GAME = "";
public String NEW = "";
public String LOAD = "";
public String SAVE = "";
public String SETTINGS = "";
public String LANGUAGE = "";
public String ENGLISH = "";
public String TURKISH = "";
public String DIFFICULTY = "";
public String HARD = "";
public String MEDIUM = "";
public String EASY = "";
public String ALCHEMY = "";


public Language(File langFile){
	//takes tab/comma delimited file, then loads the Strings into their proper var.
	Scanner scan;
	try {
		scan = new Scanner(langFile);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		scan = new Scanner("");// FIXME
		
	}
	
	 THE_ALCHEMIST = scan.next();
	 LEVEL = scan.next();
	 HEALTH = scan.next();
	 GAME = scan.next();
	 NEW = scan.next();
	 LOAD = scan.next();
	 SAVE = scan.next();
	 SETTINGS = scan.next();
	 LANGUAGE = scan.next();
	 ENGLISH = scan.next();
	 TURKISH = scan.next();
	 DIFFICULTY = scan.next();
	 HARD = scan.next();
	 MEDIUM = scan.next();
	 EASY = scan.next();
	 ALCHEMY = scan.next();
}

}
