
package inventory;

import java.io.Serializable;

/**
 * The Item class, which has attributes all Items must implement. Items can be saved to file.
 * 
 * @author Will
 */
public abstract class Item implements Comparable<Item>, Serializable {

	private static final long serialVersionUID = 1L;
	protected String name;
	protected int price;
	protected String text;
	//private PlayerEffect playerEffect; Not all Items have these
	//private MonsterEffect monsterEffect;
	/**
	 * Default constructor
	 * @param name Item name
	 * @param price Price in the shop
	 * @param text Description of the Item
	 */
	public Item(String name, int price, String text) {
		this.name = name;
		this.price = price;
		this.text = text;
	}

/*
	public PlayerEffect getPlayerEffect() {
		return playerEffect;
	}

	public void setPlayerEffect(PlayerEffect playerEffect) {
		this.playerEffect = playerEffect;
	}
*/
	/**
	 * @return The Item's price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @return The description of the Item
	 */
	public String getText() {
		return text;
	}
	
	public String toString(){
		return name+": "+text;
	}

	/**
	 * @return The name of the Item
	 */
	public String getName() {
		return this.name;
	}


}
