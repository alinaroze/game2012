package gui;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * Filter for the SaveLoadFrame which only shows .alc files
 * 
 * @author Will
 *
 */
public class AlcFilter extends FileFilter{


	public String getDescription() {
		return "Alchemy files (*.alc)";
	}

	@Override
	public boolean accept(File arg0) {
		if (arg0.isDirectory()) {
			return true;
		}
		return arg0.getName().endsWith(".alc");
	}
}
