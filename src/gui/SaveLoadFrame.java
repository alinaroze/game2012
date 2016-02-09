package gui;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * Prompts where to save of load files from. Only shows .alc files.
 * 
 * @author Will
 *
 */
public class SaveLoadFrame {
	private JFileChooser fc;
	private JFrame frame;
	
	/**
	 * Creates a new frame to find files to save or load
	 */
	public SaveLoadFrame() {
		frame = new JFrame("Choose save location");
		fc= new JFileChooser();
		fc.setFileFilter(new AlcFilter());
		
	}
	
	/**
	 * Prompts the user to specify the file location to save to graphically
	 * @return specified file location to save to, null if no valid location is chosen
	 */
	public String getWhereToSave(){
	    int retVal = fc.showSaveDialog(fc);
	    if(retVal == JFileChooser.APPROVE_OPTION){
	        File file = fc.getSelectedFile();
	        return file.getAbsolutePath();
	    }
	    return null;
	}
	
	/**
	 * Prompts the user to specify the file to load from graphically
	 * @return specified file to load from, null if no valid file is chosen
	 */
	public File getFileToOpen(){
		int returnVal = fc.showOpenDialog(fc);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			return file;
		}
		return null;
	}
}
