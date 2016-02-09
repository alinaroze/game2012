package monster;

/**
 * 
 * @author Alina Rozenbaum
 * 
 */
public class Monster {

	private int health, attack, defense, elemDef, attackCrit, numElement;
	private int[] elemAffected;
	private int[][] droppedItems;
	private boolean isElement;
	private String name;

	/**
	 * 
	 * Monster constructor
	 * 
	 * @param nm
	 *            - The name
	 * @param hp
	 *            - The health
	 * @param atk
	 *            - The attack
	 * @param atkCrit
	 *            - The critical attack multiplier
	 * @param def
	 *            - The defense
	 * @param ED
	 *            - The elemental defense
	 * @param EA
	 *            - The types of elements that when used against the monster are
	 *            changed based on the elemental defense
	 * @param drop
	 *            - The number of protons, neutrons and experience as well as
	 *            elements that are dropped by the mosnter after it dies
	 * @param isElem
	 *            - Whether the element is an element or not
	 * @param numElem
	 *            - The number of elements that are dropped
	 */
	public Monster(String nm, int hp, int atk, int atkCrit, int def, int ED,
			int[] EA, int[][] drop, boolean isElem, int numElem) {
		
		name = nm;
		health = hp;
		attack = atk;
		attackCrit = atkCrit;
		defense = def;
		elemDef = ED;
		elemAffected = EA;
		droppedItems = drop;
		isElement = isElem;
		numElement = numElem;

	}

	/**
	 * Retrieves the monster's name
	 * 
	 * @return - The name of the monster
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Retrieves the health of the monster
	 * 
	 * @return - The health of the monster
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * 
	 * Retrieves the attack of the monster
	 * 
	 * @return- The attack of the monster
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Retrieves the attack critical multiplier
	 * 
	 * @return - The critical multiplier
	 */
	protected int getAttackCrit() {
		return attackCrit;
	}

	/**
	 * Retrieves the defense
	 * 
	 * @return - The defense
	 */
	protected int getDefense() {
		return defense;
	}

	/**
	 * Retreieves the elemental defense
	 * 
	 * @return
	 */
	protected int getED() {
		return elemDef;
	}

	/**
	 * Retrieves the elements affected by the elemental defense
	 * 
	 * @return - The elemental defense
	 */
	protected int[] getEA() {
		return elemAffected;
	}

	/**
	 * 
	 * Retrieves the number of protons that are dropped
	 * 
	 * @return - The number of protons the monster drops
	 */
	protected int getProtDrop() {
		return droppedItems[0][0];
	}

	/**
	 * Retrieves the number of neutrons that are dropped
	 * 
	 * @return - The number of neutrons dropped
	 */
	protected int getNeutDrop() {
		return droppedItems[1][0];
	}

	/**
	 * retrieves the number of experience that is dropped
	 * 
	 * @return - The number of experience dropped
	 */
	protected int getXpDrop() {
		return droppedItems[2][0];
	}

	/**
	 * Retrieves the element that's dropped
	 * 
	 * @return - The element dropped
	 */
	protected int getElemDrop() {

		return droppedItems[3][0];
	}

	/**
	 * retrieves the entire drop array
	 * 
	 * @return - Drop array
	 */
	public int[][] getDrop() {
		return droppedItems;
	}

	/**
	 * retrieves whether monster is and element
	 * 
	 * @return - True is element and false if not
	 */
	public boolean getIsElem() {
		return isElement;
	}

	/**
	 * Retrieves the number of elements that are dropped
	 * 
	 * @return - The number of elements dropped
	 */
	public int getNumElem() {
		return numElement;
	}

	/**
	 * Sets the health of the monster
	 * 
	 * @param hp
	 *            - The monster's name
	 */
	public void setHealth(int hp) {
		health = hp;
	}

	/**
	 * Sets the monster's attack
	 * 
	 * @param atk
	 *            - The monster's attack
	 */
	protected void setAttack(int atk) {
		attack = atk;
	}

	/**
	 * Sets the monster critical multiplier
	 * 
	 * @param atkCrit
	 *            - The monster's attack critical multiplier
	 */
	protected void setAtkCrit(int atkCrit) {
		attackCrit = atkCrit;
	}

	/**
	 * Sets the defense of the monster
	 * 
	 * @param def
	 *            - The defense of the monster
	 */
	protected void setDefense(int def) {
		defense = def;
	}

	/**
	 * Sets the elemental defense of the monster
	 * 
	 * @param ED
	 *            - The elemental defense of the monster
	 */
	protected void setED(int ED) {
		elemDef = ED;
	}

	/**
	 * Sets the elements affected by the monster's elemental defense
	 * 
	 * @param EA
	 *            - The elements affected by the elemental defense
	 */
	protected void setEA(int[] EA) {
		elemAffected = EA;
	}

	/**
	 * Sets the drops for the monster
	 * 
	 * @param drop
	 *            - The array of dropped items
	 */
	protected void setDrop(int[][] drop) {
		droppedItems = drop;
	}

	/**
	 * Sets whether or not the monster is an elemental
	 * 
	 * @param isElem
	 *            - True if elemental, false if not
	 */
	protected void setIsElem(boolean isElem) {
		isElement = isElem;
	}

	/**
	 * Sets the number of elements dropped by the monster
	 * 
	 * @param numElem
	 *            - The number of elementals
	 */
	protected void setNumElem(int numElem) {
		numElement = numElem;
	}

	/**
	 * Makes the elements affected array into a string
	 * 
	 * @param array
	 *            - The array to be turned into a string
	 * @return - The string version of the array of elements affected by the
	 *         elemental defense
	 */
	protected String elemAffectedToString(int[] array) {
		String output = "Affected by the following elements: ";

		for (int i = 0; i < array.length; i++) {
			output = output + array[i] + " ";
		}

		return output;
	}

	/**
	 * 
	 * Displays a mosnter's stats
	 * 
	 */
	protected void displayStat() {

		System.out.println(getName() + "'s current stats are : \n" + "Health: "
				+ getHealth() + "\nAttack: " + getAttack()
				+ "\nAttack Critical Multiplier: " + getAttackCrit()
				+ "\nDefense: " + getDefense() + "\nElemental Defense: "
				+ getED() + "\n" + elemAffectedToString(getEA()) + "\n");
	}

}
