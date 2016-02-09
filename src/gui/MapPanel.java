package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import board.Board;
import board.Location;
import board.Space;
import ctrl.Controller;
import ctrl.Utils;

/**The panel which displays the Map.
 * 
 * @author Grant
 *
 */
public class MapPanel extends JPanel {
	
	private int spaces;
	private BufferedImage passableImg, impassableImg, playerImg, shopImg,
			bossImg;
	private BufferedImage[][] map;
	private Controller ctrl;
	private Board bd; 

	/**CONSTRUCTOR
	 * creates the JPanel, loads the images required to display the map.
	 * @param c
	 */
	public MapPanel(Controller c) {
		
		ctrl = c;
		bd = c.getGame().getGmBoard();
		
spaces = ctrl.getGame().getGmBoard().getNumSpaces();
map = new BufferedImage[spaces][spaces];

		try {
			passableImg = ImageIO.read(new File(Utils.PASSABLE_IMAGE));
			impassableImg = ImageIO.read(new File(Utils.IMPASSABLE_IMAGE));
			playerImg= ImageIO.read(new File(Utils.PLAYER_IMAGE));
			shopImg = ImageIO.read(new File(Utils.ITEMSHOP_IMAGE));
			bossImg = ImageIO.read(new File(Utils.BOSS_IMAGE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		refresh();
		setPreferredSize(new Dimension (spaces * 25 + 10, spaces * 25 + 10));
	}

	/**This method cycles through the space array and places the right image on the right
	 * 
	 */
	public void refresh() {

		int sb = bd.getPlayerLoc().getSubBoard();
		Space[][] spcs = bd.getSubBoard(sb).getSpaces();

		for (int row = 0; row < spaces; row++) {
			for (int col = 0; col < spaces; col++) {
				Location thisLoc = new Location(sb, row, col);
				
				if (!spcs[row][col].isPassable())
					map[row][col] = impassableImg;
				
				else						
				if(thisLoc.equals(bd.getPlayerLoc()))
					map[row][col] = playerImg;
				else
				if(thisLoc.equals(bd.getShopLoc()))
					map[row][col] = shopImg;
				
				else					
				if(thisLoc.equals(bd.getBossLoc()))
					map[row][col] = bossImg;
				
					else
					map[row][col] = passableImg;
			}
		}
	
	repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int row = 0; row < spaces; row++) {
			for (int col = 0; col < spaces; col++) {
				g.drawImage(map[row][col], col * 25 + 5, row * 25 + 5, null);
			}

		}

	}
}
