/**
 * An element class, which extends Item. Contains the attributes of elements and their effects on 
 * players and monsters.
 * NOTE: Class and Javadoc Unfinished
 * @author Will and Steven
 */

package inventory;

import character.PlayerEffect;
//TODO Read from file!

public class Element extends Item {
	private int atomicNumber;
	private PlayerEffect pEffect;
	//private MonsterEffect monsterEffect; //We need this class...
	
	/**
	 * Default constructor.
	 * @param name
	 * @param price
	 * @param text
	 * @param atomicNum Atomic number of the element
	 */
	public Element(String name, int price, String text, int atomicNum) {
		super(name, price, text);		
		atomicNumber=atomicNum;
		pEffect=new PlayerEffect(atomicNum);
	}
	/**
	 * @return The element's atomic number
	 */
	public int getAtomicNumber() {
		return atomicNumber;
	}
	
	

	/**
	 * Element is less than other Items, then ordered by atomic number.
	 */
	@Override
	public int compareTo(Item o) {
		if(o instanceof Element)
			return atomicNumber-((Element)(o)).getAtomicNumber();
		if(o instanceof Compound)
			return 1;
		if(o instanceof Armor)
			return 2;
		if(o instanceof Weapon)
			return 3;
		return -10;
	}

	/**
	 * @return This element's PlayerEffect
	 */
	public PlayerEffect getpEffect() {
		return pEffect;
	}

	/*public int getMonsterEffect() {TODO
		return monsterEffect;
	}*/



	
	
}
