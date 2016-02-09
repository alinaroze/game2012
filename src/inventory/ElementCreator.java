package inventory;

import ctrl.Utils;
import character.Player;

/**
 * Allows the Player to create new elements from protons.
 * @author Will
 *
 */
public class ElementCreator {
	private Player currentPlayer;


	/**
	 * Creates a new ElementCreator for the specified Player
	 * @param p The Player attempting to create new elements
	 */
	public ElementCreator(Player p) {
		currentPlayer = p;
	}
	
	/**
	 * Has the player attempt to create an element and add it to the inventory.
	 * @param atomicNum Atomic number of the element the user attempted to create
	 * @return The success of the alchemy
	 */
	public boolean tryAlchemy(int atomicNum) {
		if (currentPlayer.getProtonNum() >= atomicNum) {
			currentPlayer.subProtons(atomicNum);
			if (Math.random() < currentPlayer.getAlchemyOdds(atomicNum)) {
				currentPlayer.addItems(Utils.ELEMENT_LIST.getElement(atomicNum), 1);
				return true;
			}
		}
		return false;

	}

}
