/**
 * @author Steven
 * 
 * UpgradeShop is a subsection of shop where weapons and armor can be upgraded
 */

package shop;

import inventory.Armor;
import inventory.Item;
import inventory.Weapon;
import character.Player;

public class UpgradeShop {

	/**
	 * 
	 * @param i
	 * @return upgrade Cost of item, returns 0 if not upgradeable
	 */
	public int upgradeCost(Item i) {
		if (i instanceof Weapon) {
			if (((Weapon) i).getLevel() >= 3) {
				return 0;
			}			
			return ((Weapon) i).getPrice() + 200;

		} else if (i instanceof Armor) {
			if (((Armor) i).getLevel() >= 3) {
				return 0;
			}
			return ((Armor) i).getPrice() + 200; 
		}
		return 0;
	}

	public boolean upgrade(Player p, Item i) {
		int upgradeCost = 0;

		if (i instanceof Weapon) {
			if (((Weapon) i).getLevel() >= 3) {
				return false;
			}
			upgradeCost = ((Weapon) i).getPrice() + 200;
			if (p.getNeutronNum() >= upgradeCost) {
				p.subNeutrons(upgradeCost);
				p.weaponLevelUp();
				return true;
			}
		} else if (i instanceof Armor) {
			if (((Armor) i).getLevel() >= 3) {
				return false;
			}
			upgradeCost = ((Armor) i).getPrice() + 200;
			if (p.getNeutronNum() >= upgradeCost) {
				p.subNeutrons(upgradeCost);
				p.armorLevelUp();
				return true;
			}
		}
		return false;
	}
}
