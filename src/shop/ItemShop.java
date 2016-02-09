package shop;

import gui.ShopGUI;
import inventory.Armor;
import inventory.Compound;
import inventory.Element;
import inventory.Item;
import inventory.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import board.Board;
import board.Location;
import character.Player;
import ctrl.Utils;

/**
 * 
 * @author Steven ItemShop is a subsection of the entire shop where available
 *         items can be bought or sold ItemShop contains the logic for buying
 *         and selling.
 */
public class ItemShop {

	private int price;
	private ArrayList<Item> shopInventory;
	private HashMap<Item, Integer> playerInventory;
	private HashMap<Compound, Integer> playerCompoundInventory;
	int distanceFromBoss;
	private Location playerLoc;
	private Player player;
	private ShopGUI dialog;
	ShopList shopList;
	private Board board;
	

	/**
	 * 
	 * @param loc
	 *            exact location of shop
	 * @param bossLocation
	 */
	public ItemShop(Board b, Player p) {
		player = p;
		board = b;
		board.getShopLoc();
		shopList = new ShopList();
		price = 0;
		playerInventory = new HashMap<Item, Integer>();
		playerInventory = getThePlayerInventory();
		//playerLoc = board.getPlayerLoc();
		populateShop();
		dialog = new ShopGUI(this, playerInventory, shopInventory,
				player);

	}

	/**
	 * uses a pre-made list to populate the shop with items. List used is based
	 * on location.
	 * 
	 * each if statement will includes to a range of numbers to consider which
	 * shop list to use
	 */
	private void populateShop() {
		Random rand = new Random();
		shopInventory = shopList.getShop(rand.nextInt(4));
	}


	/**
	 * 
	 * @param p
	 *            player
	 */
	public void setCurrentPlayer(Player p) {
		player = p;
	}

	/**
	 * Sends both player inventory and shop inventory to GUI
	 * 
	 * @param p
	 *            Player inventory
	 */

	
	/**
	 * 
	 * @return a HashMap<Item, Integer> of the player's inventory
	 */
	public HashMap<Item, Integer> getThePlayerInventory() {
		playerInventory.clear();

		playerCompoundInventory = player.getCompoundInv();

		for (int i = 1; i <= Utils.NUM_ELEMENTS; i++) {
			if (player.getElement(i) > 0) {

				playerInventory.put(Utils.ELEMENT_LIST.getElement(i),
						player.getElement(i));
			}

		}
		
		Iterator<Compound> it = playerCompoundInventory.keySet().iterator();
		while (it.hasNext()) {
			Compound curr = (Compound) it.next();
			if (playerCompoundInventory.get(curr) > 0) {
				playerInventory.put(curr, playerCompoundInventory.get(curr));
			}
		}
		for (int i = 0; i < player.getNumStoredArmor(); i++) {
			playerInventory.put(player.getStoredArmor(i), 1);
		}

		for (int i = 0; i < player.getNumStoredWeapons(); i++) {
			playerInventory.put(player.getStoredWeapon(i), 1);
		}
		return playerInventory;
	}
	
	/**
	 * 
	 * @return ArrayList<Item> of items available in this shop
	 */
	public ArrayList<Item> getShopInventory() {
		return shopInventory;
	}

	/**
	 * 
	 
	 * @param i
	 *            Item in question
	 * @return whether the item was purchased successfully (true) or not (false)
	 */
	public boolean buyItem(Item i) {
		price = i.getPrice();
		if (price > player.getNeutronNum()) {
			return false;
		} else {
			player.subNeutrons(price); // subtracts neutrons from player's
										// wallet
			player.addItems(i, 1);
			return true;
		}
	}

	/**
	 * 
	 * @param i
	 *            Item in question
	 * @return whether the player has enough money to buy the item
	 */
	public boolean canBuyItem(Item i) {

		if (i.getPrice() <= player.getNeutronNum()) {

			return true;
		} else {

			return false;
		}
	}

	/**
	 * 
	 * @param i
	 *            Item in question
	 * 
	 *            Pre-Condition: Item must exist in player inventory
	 */
	public boolean sellItem(Item i) {
		// sell item for 1/4 original price, add 5% times Item level for
		// upgraded
		// items

		if (i instanceof Weapon) {
			player.removeWeapon(0);
			price = (int) ((int) (Math.pow(((Weapon) i).getLevel(), 2)
					* i.getPrice() * .01) + (i.getPrice() * .25));
		}

		else if (i instanceof Armor) {
			player.removeArmor(0);
			price = (int) ((int) (Math.pow(((Armor) i).getLevel(), 2)
					* i.getPrice() * .01) + (i.getPrice() * .25));

		} else if (i instanceof Compound) {

			player.removeCompound((Compound) i, 1);
			price = (int) (i.getPrice() * .25); // need a method to remove other
												// items from inventory
		} else if (i instanceof Element) {

			player.setElement(((Element) i).getAtomicNumber(),
					player.getElement(((Element) i).getAtomicNumber()) - 1);

			price = (int) (i.getPrice() * .25);
		} else {
			return false;
		}

		if (price <= 0) {
			player.addNeutrons(1);

			return true;// ensures all items have a value of at least 1
		} else {
			player.addNeutrons(price);
			return true;
		}

	}

	/**
	 * 
	 * @param i
	 *            Item in question
	 * @return sell price of the item
	 */
	public int sellPrice(Item i) {
		if (i instanceof Weapon) {

			price = (int) ((int) (Math.pow(((Weapon) i).getLevel(), 2)
					* i.getPrice() * .01) + (i.getPrice() * .25));
		} else if (i instanceof Armor) {
			price = (int) ((int) (Math.pow(((Armor) i).getLevel(), 2)
					* i.getPrice() * .01) + (i.getPrice() * .25));
		} else {
			price = (int) (i.getPrice() * .25);
		}
		if (price == 0) {
			return 1; // ensures all items have a value of at least 1
		}
		return price;
	}
}
