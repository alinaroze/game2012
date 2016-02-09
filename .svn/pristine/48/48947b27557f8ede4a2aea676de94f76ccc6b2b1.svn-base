package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
private BufferedImage Img;
	/**
	 * Create the panel.
	 */
	public ImagePanel(String ImgFileName) {
		try {
			Img = ImageIO.read(new File(ImgFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(Img, 0, 0, null); // see javadoc for more info on the parameters            
	    }

}