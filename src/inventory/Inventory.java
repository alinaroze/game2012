
package inventory;

import inventory.Armor;
import inventory.Compound;
import inventory.Element;
import inventory.Item;
import inventory.Weapon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import ctrl.Utils;

import shop.ItemNotFoundException;
/**
 * Inventory for holding player items.
 * 
 * @author Will and Steven
 */
public class Inventory implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<Weapon> weaponInv;
	private ArrayList<Armor> armorInv;
	private int numWeapons;
	private int numArmor;
	private HashMap<Compound, Integer> compoundInv;
	private int[] elements;


	/**
	 * Constructor, which initializes variables
	 */
	public Inventory() {
		weaponInv = new ArrayList<Weapon>();
		armorInv = new ArrayList<Armor>();
		compoundInv = new HashMap<Compound, Integer>();
		elements=new int[Utils.NUM_ELEMENTS];
		Arrays.fill(elements, 0);
		
	/*	Item sword = Weapon.rndWeapon();//These need to be removed at some point
		Item shield = Armor.rndArmor();
		add(sword, 1);
		add(shield, 5);
		//listItems();*/

	}
 
	 /**
	  * Adds the specified amount of a given item. Amount does not change anything for weapons and armor.
	  * @param i Item to be added
	  * @param amount (Does not affect weapons or armor)
	  */
	  public void add(Item i, int amount) {
		if (i instanceof Element)
			elements[((Element) (i)).getAtomicNumber() - 1] += amount;
		if (i instanceof Compound)
			try {
				int temp = compoundInv.get(i);
				compoundInv.put((Compound) i, amount + temp);
			} catch (Exception e) {
				compoundInv.put((Compound) i, amount);
			}
		if (i instanceof Armor) {
			armorInv.add((Armor) i);
			numArmor++;
		}
		if (i instanceof Weapon) {
			weaponInv.add((Weapon) i);
			numWeapons++;
		}
			
	}

	  /**
	   * Lists Items held in the inventory
	   */
	public void listItems() {

		Set set = compoundInv.entrySet();
		Iterator it = set.iterator();
		String name = "";
		// int price = 0;

		for(int i=0;i<elements.length;i++)
		System.out.println(i+1+"	"+elements[i]);
	
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			name = ((Item) me.getKey()).getName();
			// price = ((Item) me.getKey()).getPrice();
			System.out.println(name + "   " + me.getValue());
		}
		for(Armor a:armorInv)
			System.out.println(a);
		for(Weapon w:weaponInv)
			System.out.println(w);

	}
	
	/**
	 * Sorts the inventory
	 */
	public void sort(){
		Collections.sort(weaponInv);
		Collections.sort(armorInv);
	}
	/**
	 * Switches a weapon with another outside of the inventory
	 * @param newWep the weapon to add
	 * @param index index of the weapon to remove
	 * @return the removed weapon
	 * @throws ItemNotFoundException if the index is invalid
	 */
	public Weapon swap(Weapon newWep, int index) throws ItemNotFoundException{
		if (index >= weaponInv.size() || weaponInv.get(index) == null)
			throw new ItemNotFoundException("There is no weapon there");
		return weaponInv.set(index, newWep);
	}
	/**
	 * Switches an armor with another outside of the inventory
	 * @param newArmor the armor to add
	 * @param index index of the armor to remove
	 * @return the removed armor
	 * @throws ItemNotFoundException if the index is invalid
	 */
	public Armor swap(Armor newArmor, int index) throws ItemNotFoundException{
		if (index >= armorInv.size() || armorInv.get(index) == null)
			throw new ItemNotFoundException("There is no armor there");
		return armorInv.set(index, newArmor);
	}

	/**
	 * Returns the amount of a given element in the inventory
	 * @param index Atomic number of the element
	 * @return Amount of the element owned by the inventory
	 */
	public int getElement(int index) {
		return elements[index-1];
	}

	/**
	 * Changes the amount of a given element in the inventory.
	 * @param index Atomic number of the element
	 * @param amount new amount of the specifed element
	 */
	public void setElement(int index, int amount) {
		 elements[index-1]=amount;
		
	}

	/**
	 * Removes the armor at the given index.
	 * @param index location of the armor to remove.
	 */
	public void removeArmor(int index) {
		armorInv.remove(index);
		numArmor--;
	}
	/**
	 * Removes the weapon at the given index.
	 * @param index location of the weapon to remove.
	 */
	public void removeWeapon(int index) {
		weaponInv.remove(index);
		numWeapons--;
	}
	
	/**
	 * Removes a given compound from the inventory
	 * @param c Compound to remove
	 * @param amount amount to remove
	 * @return True if successful, false otherwise
	 */
	public boolean removeCompound(Compound c, int amount){
		if (compoundInv.get(c) - amount > 0) {
			compoundInv.put(c, compoundInv.get(c) - amount);
			return true;
		}
		return false;
	}
	/**
	 * @return the compound inventory- the hashmap of all compounds inside the inventory
	 */
	public HashMap<Compound,Integer> getCompoundInverntory(){
		return this.compoundInv;
	}
	
	/**
	 * Returns the Armor object at a given index
	 * @param index the location of the Armor, less than getNumArmor
	 * @return The Armor object at the given index
	 */
	public Armor getArmor(int index) {
		return armorInv.get(index);
	}

	/**
	 * Returns the Weapon object at a given index
	 * @param index the location of the Weapon, less than getNumWeapons
	 * @return The Weapon object at the given index
	 */
	public Weapon getWeapon(int index) {
		return weaponInv.get(index);
	}
	 /**
	  * @return The number of Weapons in the inventory
	  */
	public int getNumWeapons(){
		return numWeapons;
	}
	
	 /**
	  * @return The number of Armor in the inventory
	  */
	public int getNumArmor(){
		return numArmor;
	}
}