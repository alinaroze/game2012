
package inventory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import monster.Monster;
import character.Player;
import ctrl.Utils;

/**
 * The Weapon class, which contains all the information on weapons. Extends Item.
 * @author Will
 */
public class Weapon extends Item {

	private static final long serialVersionUID = 1L;
	private int index, baseDamage, damage, criticalMult, effect, level;
	private double critRate;

	/**
	 * Default constructor, but should only be called by readWeapon
	 * @param name
	 * @param price
	 * @param text
	 * @param baseD Base damage
	 * @param critM Multiplier for critical hits
	 * @param critR Critical hit rate
	 * @param effectIndex Effect, if any, to be applied in combat
	 * @param lev Level, 1 if not upgraded
	 */
	private Weapon(String name, int price, String text, int index, int baseD, int critM,
			double critR, int effectIndex, int lev) {
		super(name, price, text);
		this.index=index;
		baseDamage = baseD;
		effect = effectIndex;
		criticalMult = critM;
		critRate = critR;
		level = lev;
	}

	/**
	 * @return A random, level 1 weapon
	 */
	public static Weapon rndWeapon() {
		return readWep(Utils.rndInt(1, Utils.MAX_WEAPONS), 1);
	}

	/**
	 * @return The Weapon's current level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @return The Weapon's current damage
	 */
	public double getDamage() {
		return damage;
	}

	/**
	 * @return The multiplier for critical hit damage
	 */
	public int getCriticalMult() {
		return criticalMult;
	}

	/**
	 * @return The probability that this Weapon lands a critical hit
	 */
	public double getCriticalRate() {
		return critRate;
	}

	/**
	 * Increases the level and stats of the current weapon. Reads from the data file.
	 * @return 
	 * @return True if successful, false otherwise
	 */
	public boolean levelUp() {
		if(level<3){
			level++;
			try {
				FileInputStream input = new FileInputStream(Utils.WEAPONFILE);
				Scanner read = new Scanner(input);
				while (!read.next().equals(index + "." + level)) {
				}

				name = read.nextLine().substring(1);
				price = read.nextInt();
				read.nextLine();
				text = read.nextLine();
				baseDamage = read.nextInt();
				criticalMult = read.nextInt();
				critRate = read.nextDouble();
				effect = read.nextInt();
				return true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Applies the ability of the weapon before combat.
	 * @param p The Player using the weapon
	 * @param m The Monster attacking the Player
	 */
	public void applyAbility(Player p, Monster m) { 
		damage=baseDamage;// if nothing else applies
		switch (effect) {
		case 1://Elemental Sword 1+2
			if (m.getIsElem()) {
				if (p.getElement(m.getNumElem()) >= (4 - level)) {
					damage = 2 * baseDamage;
				}
			}
			break;
		case 2://Elemental Sword 3
			if (m.getIsElem())
				damage = (int) (1.5 * baseDamage);
			break;
		case 3://Scythe instant kill
			if (Math.random() < (Math.pow(level, 1.5) * .01)) {
				/*if (!(m instanceof Boss)) {
					m.setHealth(0);
				} else*/
					//damage = baseDamage * level;
				m.setHealth(0);
			}
			break;
		default:
			;// no effect
		}
	}

	/**
	 * Weapons are greater than other items, and are then compared on damage.
	 */
	@Override
	public int compareTo(Item o) {
		if (o instanceof Element)
			return -3;
		if (o instanceof Compound)
			return -2;
		if (o instanceof Armor)
			return -1;
		if (o instanceof Weapon)
			return (int) (damage - (((Weapon) (o)).getDamage()));
		return -10;
	}

	/**
	 * Reads the data file and returns the specified weapon
	 * @param index1 Index of the weapon in the file
	 * @param level Level of the weapon in the file
	 * @return Weapon specified by the file
	 */
	public static Weapon readWep(int index1, int level) {
		try {
			FileInputStream input = new FileInputStream(Utils.WEAPONFILE);
			Scanner read = new Scanner(input);
			while (!read.next().equals(index1 + "." + level)) {
			}
			
			String n = read.nextLine().substring(1);
			int p = read.nextInt();
			read.nextLine();
			String t = read.nextLine();
			int bd = read.nextInt();
			int critMult = read.nextInt();
			double critRate = read.nextDouble();
			int effecti = read.nextInt();
			
			return new Weapon(n, p, t, index1, bd, critMult, critRate, effecti, level);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
