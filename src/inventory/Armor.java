
package inventory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import monster.Monster;
import character.Player;
import ctrl.Utils;
/**
 * Armor class, which contains the defensive properties for the player.
 * @author Will
 */
public class Armor extends Item {

	private static final long serialVersionUID = 1L;
	private int baseDefense, defense, effect, level, index;

	/**
	 * Constructor called by readArmor
	 * 
	 * @param name
	 * @param price
	 * @param text
	 * @param baseD
	 *            Base Defense
	 * @param effectIndex
	 *            The effect of the armor
	 * @param lev
	 *            Level, usually 1
	 */
	private Armor(String name, int price, String text, int index, int baseD,
			int effectIndex, int lev) {
		super(name, price, text);
		this.index = index;
		baseDefense = baseD;
		defense = baseDefense;
		effect = effectIndex;
		level = lev;
	}

	/**
	 * @return Returns a random Armor object, level 1.
	 */
	public static Armor rndArmor() {
		return readArmor(Utils.rndInt(1, Utils.MAX_ARMOR), 1);
	}

	/**
	 * @return The Armor's level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @return The Armor's defense, after effects are applied
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Increases the Armor's level and stats. Reads from file.
	 * 
	 * @return True if successful, false otherwise
	 */
	public boolean levelUp() {
		if (level < 3) {
			level++;
			try {
				FileInputStream input = new FileInputStream(Utils.ARMORFILE);
				Scanner read = new Scanner(input);
				// System.out.println(read.next());
				while (!read.next().equals(index + "." + level)) {
				}
				name = read.nextLine().substring(1);
				price = read.nextInt();
				read.nextLine();
				text = read.nextLine();
				baseDefense = read.nextInt();
				effect = read.nextInt();
				return true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Applies the ability of the Armor before combat.
	 * 
	 * @param p
	 *            The Player using the Armor
	 * @param m
	 *            The Monster attacking the Player
	 */
	public void applyAbility(Player p, Monster m) {
		defense = baseDefense;
		p.setDefenseBuffer(0);//Defaults
		switch (effect) {
		/*case 1:// Elemental Shield 3
			if(m.getIsElem()){
				
			}
			//Intentionally no break*/
		case 2:// Elemental Shield 1-3
			if (m.getIsElem()) {// adds 2-4 defense based on level
				defense = baseDefense + Math.min(2 + level / 3, 4);
			}
			break;
		case 3:// Body Armor 2
			p.setDefenseBuffer(5);
			break;
		case 4:// Body Armor 3
			if (!(m.getIsElem())) {
				p.setDefenseBuffer(5);
				defense = baseDefense + 1;
			}
		case 5: // Spiked Armor
			// TODO counter attack?
		case 6:// Shell, elemental protection
			if (m.getIsElem())// Effectively halves elemental damage
				p.setDefenseBuffer(m.getAttack() / 2);
		default:
			;// no effect
		}
	}

	/**
	 * Armor is greater than everything except Weapons. Armor is compared based
	 * on defense.
	 */
	@Override
	public int compareTo(Item o) {
		if (o instanceof Element)
			return -2;
		if (o instanceof Compound)
			return -1;
		if (o instanceof Armor)
			return defense - ((Armor) (o)).getDefense();
		if (o instanceof Weapon)
			return 2;
		return -10;
	}

	/**
	 * Reads Armor data from file and returns it as an Object.
	 * 
	 * @param index1
	 *            Index of the Armor in the file
	 * @param level
	 *            Level of the Armor to be created
	 * @return An Armor object, with the specified attributes.
	 */
	public static Armor readArmor(int index1, int level) {
		try {
			FileInputStream input = new FileInputStream(Utils.ARMORFILE);
			Scanner read = new Scanner(input);
			// System.out.println(read.next());
			while (!read.next().equals(index1 + "." + level)) {
			}
			String n = read.nextLine().substring(1);
			int p = read.nextInt();
			read.nextLine();
			String t = read.nextLine();
			int bd = read.nextInt();
			int effecti = read.nextInt();
			return new Armor(n, p, t, index1, bd, effecti, level);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
