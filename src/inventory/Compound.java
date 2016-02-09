package inventory;

import character.PlayerEffect;

/**
 * The Compound class, which contains most the information on compounds, and extends Item.
 * The CompoundList class contains a list of all the created compounds in the game.
 * 
 * @author Will and Steven
 * 
 */
public class Compound extends Item {
	
	private static final long serialVersionUID = 1L;
	private int[] numElements;
	private PlayerEffect pEffect;
	//TODO add monsterEffects
	
	/**
	 * 
	 * @param name the name of the compound
	 * @param price the price, in neutrons, of the compound
	 * @param text the description of the compound
	 * @param H number of Hydrogen atoms
	 * @param He number of Helium atoms
	 * @param Li number of Lithium atoms
	 * @param Be number of Beryllium atoms
	 * @param B number of Boron atoms
	 * @param C number of Carbon atoms
	 * @param N number of Nitrogen atoms
	 * @param O number of Oxygen atoms
	 * @param F number of Fluorine atoms
	 * @param Ne number of Neon atoms
	 * @param playerEffect the PlayerEffect of the compound, null if none exists
	 */
	public Compound(String name, int price, String text, int H, int He, int Li,
			int Be, int B, int C, int N, int O, int F, int Ne, PlayerEffect playerEffect) {
		
		super(name, price, text);
		numElements = new int[] { H, He, Li, Be, B, C, N, O, F, Ne };
		pEffect=playerEffect;
		
	}

	/**
	 * Compounds are greater than elements, but less than other Items. Ordered
	 * alphabetically.
	 */
	@Override
	public int compareTo(Item o) {
		if (o instanceof Element)
			return -1;
		if (o instanceof Compound)
			return getName().compareTo(o.getName());
		if (o instanceof Armor)
			return 2;
		if (o instanceof Weapon)
			return 3;
		return -10;
	}

	/**
	 * @return The number of Hydrogen atoms in the compound
	 */
	public int getNumH() {
		return numElements[0];
	}

	/**
	 * @return The number of Helium atoms in the compound
	 */
	public int getNumHe() {
		return numElements[1];
	}

	/**
	 * @return The number of Lithium atoms in the compound
	 */
	public int getNumLi() {
		return numElements[2];
	}

	/**
	 * @return The number of Beryllium atoms in the compound
	 */
	public int getNumBe() {
		return numElements[3];
	}

	/**
	 * @return The number of Boron atoms in the compound
	 */
	public int getNumB() {
		return numElements[4];
	}

	/**
	 * @return The number of Carbon atoms in the compound
	 */
	public int getNumC() {
		return numElements[5];
	}

	/**
	 * @return The number of Nitrogen atoms in the compound
	 */
	public int getNumN() {
		return numElements[6];
	}

	/**
	 * @return The number of Oxygen atoms in the compound
	 */
	public int getNumO() {
		return numElements[7];
	}

	/**
	 * @return The number of Fluorine atoms in the compound
	 */
	public int getNumF() {
		return numElements[8];
	}

	/**
	 * @return The number of Neon atoms in the compound
	 */
	public int getNumNe() {
		return numElements[9];
	}

	/**
	 * Returns the number of atoms with the given atomic number in the compound
	 * @param atomicNum The atomic number of the requested element
	 * @return The number of atoms of that element in the compound
	 */
	public int getNumElement(int atomicNum) {
		return numElements[atomicNum-1];
	}
	
	/**
	 * Returns the PlayerEffect of the compound. This may be null if the compound 
	 * does not have a PlayerEffect.
	 * @return The PlayerEffect of the compound
	 */
	public PlayerEffect getpEffect() {
		return pEffect;
	}


	
}
