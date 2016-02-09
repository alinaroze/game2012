package ctrl;

import inventory.CompoundList;
import inventory.ElementList;

/**
 * Utils contains static methods and constants for use throughout the program.
 * 
 * @author Everyone
 *
 */
public class Utils {

	// Filepaths
	public static final String WEAPONFILE = "data/weapons.dat";
	public static final String ARMORFILE = "data/armor.dat";
	public static final String ENGLISH_LANG_FILE = "data/englishLang.txt";
	
	//Images
	public static final String GAMEOVER_IMAGE="data/images/gmover.bmp";
	public static final String IMPASSABLE_IMAGE="data/images/impassable.bmp";
	public static final String ITEMSHOP_IMAGE="data/images/itemShop.bmp";
	public static final String BOSS_IMAGE = "data/images/boss.bmp";
	public static final String PASSABLE_IMAGE="data/images/passable.bmp";
	public static final String PLAYER_IMAGE="data/images/player.bmp";
	public static final String TITLE_IMAGE="data/images/titleImg.bmp";
	public static final String BATTLE_IMAGE="data/images/battleImg.bmp";
	
	// Item constants
	public static final int MAX_WEAPONS = 8;
	public static final int MAX_ARMOR = 8;
	public static final int NUM_ELEMENTS = 10;

	public static final CompoundList COMPOUND_LIST = new CompoundList();
	public static final ElementList ELEMENT_LIST = new ElementList();

	
	/**
	 * A random integer in the range [min,max]
	 * 
	 * @param min
	 *            The minimum value
	 * @param max
	 *            The maximum value
	 * @return A random integer in the given range
	 */
	public static int rndInt(int min, int max) {
		int result = (int) (((max - min) + 1) * Math.random() + min);
		return result;
	}
}
