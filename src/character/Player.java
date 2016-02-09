
package character;

import inventory.Armor;
import inventory.Compound;
import inventory.Inventory;
import inventory.Item;
import inventory.Weapon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import monster.Monster;
import shop.ItemNotFoundException;
import ctrl.Game;
import ctrl.Utils;

/**
 * The Player class, which contains all the player's attributes and methods.
 * 
 * @author Will
 */
public class Player implements Serializable{

	
	private static final long serialVersionUID = 1L;


	private String name;
	
	private Game game;
	
	private int health, maxHealth;
	private int experience, level;
	private int protonNum, neutronNum;
	private Inventory inventory;
	private double[] alchemyOdds;

	private Weapon currWeapon;
	private Armor currArmor;

	private ArrayList<PlayerEffect> effectList;

	// Event, element and/or world state multipliers
	private double healthMultiplier, experienceMultiplier; // hpMultiplier is a special case
	private double protonMultipler,neutronMultiplier;
	private double defenseMultiplier, damageMultiplier;
	
	private int damageAddition, defenseAddition;
	private int defenseBuffer;
	
	
	/** Constructor with default values<br>
	 * Level=1, Hp=100, random armor and weapon, creates inventory, etc.
	 * 
	 * @param name Player's name
	 * @param game The Game the Player is a part of.
	 */
	public Player(String name) {
		
		this.name = name;

		
		health = maxHealth = 100;
		level = 1;
		experience = 0;
		
		protonNum = 0;
		neutronNum = 0;

		currWeapon = Weapon.rndWeapon();
		currArmor = Armor.rndArmor();
		
		inventory = new Inventory();
		
		alchemyOdds = new double[Utils.NUM_ELEMENTS];
		//Odds are 1/3 for the first 5 elements, and 1/6 for 6-10, 0 for anything greater.
		for(int index=0;index<Utils.NUM_ELEMENTS;index++)
			alchemyOdds[index]=(Math.ceil((10-index)/5.0))/6.0;
		
		
		effectList = new ArrayList<PlayerEffect>();
		
		healthMultiplier = experienceMultiplier = protonMultipler = 1.0;
		neutronMultiplier = defenseMultiplier = damageMultiplier = 1.0;
		
		damageAddition = defenseAddition = 0;
		defenseBuffer = 0;
	}

	/**
	 * Resets the previous event and applies a new one. Currently unimplemented since 
	 * events are undefined.
	 * @param event event affecting the player
	 */
	public void applyEvent(Event event) {
		damageAddition = defenseAddition = 0;
		defenseBuffer = 0;
		healthMultiplier = experienceMultiplier = protonMultipler = 1.0;
		neutronMultiplier = defenseMultiplier = damageMultiplier = 1.0;
		// Also need to reset previous event more thoroughly
		for (int i = 0; i < event.getNumEffects(); i++) {
			switch (event.getAffectedStat(i)) {
			case Event.HYDROGEN_GAIN:
				setElement(1, getElement(1) + (int) event.getEffectAmount(i));
				break;
			case Event.HELIUM_GAIN:
				setElement(2, getElement(2) + (int) event.getEffectAmount(i));
				break;
			case Event.LITHIUM_GAIN:
				setElement(3, getElement(3) + (int) event.getEffectAmount(i));
				break;
			case Event.BERYLLIUM_GAIN:
				setElement(4, getElement(4) + (int) event.getEffectAmount(i));
				break;
			case Event.BORON_GAIN:
				setElement(5, getElement(5) + (int) event.getEffectAmount(i));
				break;
			case Event.CARBON_GAIN:
				setElement(6, getElement(6) + (int) event.getEffectAmount(i));
				break;
			case Event.NITORGEN_GAIN:
				setElement(7, getElement(7) + (int) event.getEffectAmount(i));
				break;
			case Event.OXYGEN_GAIN:
				setElement(8, getElement(8) + (int) event.getEffectAmount(i));
				break;
			case Event.FLUORINE_GAIN:
				setElement(9, getElement(9) + (int) event.getEffectAmount(i));
				break;
			case Event.NEON_GAIN:
				setElement(10, getElement(10) + (int) event.getEffectAmount(i));
				break;
			default:
				;
			}
		}

	}

	/**
	 * Levels up the player, increasing stats. Automatically called when Experience=100*level.
	 */
	private void levelUp() {// Theoretically complete
		level++;
		maxHealth += 25; 
		health += 25; 
		if (level > 3 && level < 6) {
			for (int atomicNum = 1; atomicNum <= 10; atomicNum++)
				// Increases all odds for elements 1-10 by 1/6
				alchemyOdds[atomicNum - 1] += (1 / 6.0);
		}
		if(level==6){
			for (int atomicNum = 1; atomicNum <= 10; atomicNum++)
				// Increases all odds for elements 6-10 by 1/6
				alchemyOdds[atomicNum - 1] += (1 / 6.0);
		}
			
	}

	/**
	 * Returns the Armor object at a given index in inventory
	 * @param index the location of the Armor, less than getNumStoredArmor
	 * @return The Armor object at the given index
	 */
	public Armor getStoredArmor(int index) {
		return inventory.getArmor(index);
	}

	/**
	 * Returns the Weapon object at a given index in inventory
	 * @param index the location of the Weapon, less than getNumStoredWeapons
	 * @return The Weapon object at the given index
	 */
	public Weapon getStoredWeapon(int index) {
		return inventory.getWeapon(index);
	}

	/**
	 * @return the number of Weapon objects in inventory
	 */
	public int getNumStoredWeapons() {
		return inventory.getNumWeapons();
	}

	/**
	 * @return the number of Armor objects in inventory
	 */
	public int getNumStoredArmor() {
		return inventory.getNumArmor();
	}

	/**
	 * Increases experience (xp) and levels the player up as needed.
	 * @param amount amount of Xp gained
	 */
	public void gainExperience(int amount) {
		experience += (int) (amount * experienceMultiplier);
		while (experience >= 100 * level) {
			experience -= 100 * level;
			levelUp();
		}
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", hp=" + health + ", maxHp=" + maxHealth
				+ ", xp=" + experience + ", protonNum=" + protonNum + ", neutronNum="
				+ neutronNum + ", alchemy odds=" + Arrays.toString(alchemyOdds)
				+ "]";
	}

	/**
	 * @return number of protons the player has
	 */
	public int getProtonNum() {
		return protonNum;
	}

	/**
	 * Adds the specified amount of protons, applying any multipliers.
	 * @param protonNum added number of protons
	 */
	public void addProtons(int protonNum) {
		this.protonNum = this.protonNum + (int) (protonNum * protonMultipler);
	}

	/**
	 * Subtracts the specified amount of protons, ignoring any multipliers.
	 * @param protonNum subtracted number of protons
	 */
	public void subProtons(int protonNum) {
		this.protonNum = this.protonNum - (int) (protonNum);
	}

	/**
	 * @return number of neutrons the player has
	 */
	public int getNeutronNum() {
		return neutronNum;
	}

	/**
	 * Subtracts the specified amount of neutrons, ignoring any multipliers.
	 * @param neutronNum subtracted number of neutrons
	 */
	public void subNeutrons(int neutronNum) {
		this.neutronNum = this.neutronNum - (int) (neutronNum);
	}

	/**
	 * Adds the specified amount of neutrons, applying any multipliers.
	 * @param neutronNum added number of neutrons
	 */
	public void addNeutrons(int neutronNum) {
		this.neutronNum = this.neutronNum
				+ (int) (neutronNum * neutronMultiplier);
	}

	/**
	 * Returns the number of the specified element the player has
	 * @param index Atomic number of requested element
	 * @return number of specified element the player controls
	 */
	public int getElement(int index) {// Referenced by atomic number
		return inventory.getElement(index);
	}

	/**
	 * Changes the amount of an element the player has
	 * @param index Atomic number of requested element
	 * @param amount new amount of the element the player controls
	 */
	public void setElement(int index, int amount) {// Referenced by atomic number
		inventory.setElement(index, amount);
	}

	/**
	 * Adds an item to the inventory
	 * @param i Item to be added
	 * @param amount amount of item to be added (Does not apply to weapons or armor)
	 */
	public void addItems(Item i, int amount) {
		inventory.add(i, amount);
	}

	/**
	 * Displays the items in the player's inventory
	 */
	public void listItems() {
		inventory.listItems();
	}

	/**
	 * Sorts the player's inventory
	 */
	public void sortItems() {
		inventory.sort();
	}
	/**
	 * @return Returns the compounds the player owns.
	 */
	public HashMap<Compound,Integer> getCompoundInv(){
		return inventory.getCompoundInverntory();
	}
	/**
	 * Removes an armor from the player's inventory
	 * @param index location of the armor to be removed
	 */
	public void removeArmor(int index) {
		inventory.removeArmor(index);
	}

	/**
	 * Removes a weapon from the player's inventory
	 * @param index location of the weapon to be removed
	 */
	public void removeWeapon(int index) {
		inventory.removeWeapon(index);
	}
	/**
	 * Removes the requested compound from the player's inventory
	 * @param c compound to be removed
	 * @param amount amount to remove
	 */
	public void removeCompound(Compound c, int amount) {
		inventory.removeCompound(c, amount);
	}
	

	/**
	 * @return Description of the equipped Armor
	 */
	public String getArmorText() {
		return currArmor.getText();
	}

	/**
	 * @return Description of the equipped Weapon
	 */
	public String getWeaponText() {
		return currWeapon.getText();
	}

	/**
	 * @return Weapon name
	 */
	public String getWeaponName() {
		return currWeapon.getName();
	}

	/**
	 * @return Weapon price
	 */
	public int getWeaponPrice() {
		return currWeapon.getPrice();
	}
	
	/**
	 * @return Armor price
	 */
	public int getArmorPrice() {
		return currArmor.getPrice();
	}
	
	/**
	 * @return Armor name
	 */
	public String getArmorName() {
		return currArmor.getName();
	}
	/**
	 * @return Weapon level
	 */
	public int getWeaponLevel() {
		return currWeapon.getLevel();
	}
	/**
	 * @return Armor level
	 */
	public int getArmorLevel() {
		return currArmor.getLevel();
	}
	
	/**
	 * Increases the Armor's level and stats. Reads from file.
	 * 
	 * @return True if successful, false otherwise
	 */
	public boolean armorLevelUp() {
		return currArmor.levelUp();
	}
	
	/**
	 * Increases the Weapons's level and stats. Reads from file.
	 * 
	 * @return True if successful, false otherwise
	 */
	public boolean weaponLevelUp() {
		return currWeapon.levelUp();
	}

	/**
	 * @return Current health (hp)
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @return Maximum health (hp)
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * @return Player level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Returns the odds of successfully creating an element
	 * @param index Atomic number of element attempted to be generated
	 * @return Odds of generating the given element
	 */
	public double getAlchemyOdds(int index) {// Referenced by atomic number
		return alchemyOdds[index - 1];
	}

	/**
	 * @return Player's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Applies all modifiers. Call applyItemAbilities first to ensure accuracy
	 * @return Player's modified defense stat
	 */
	public int getDefense() {
		return (int) ((currArmor.getDefense() + defenseAddition) * defenseMultiplier);
	}

	/**
	 * Applies all non-crit modifiers. Call applyItemAbilities first to ensure accuracy
	 * @return Player's modified damage 
	 */
	public int getDamage() {
		return (int) ((currWeapon.getDamage() + damageAddition) * damageMultiplier);
	}

	/**
	 * @return Multiplier for the given weapon's critical damage
	 */
	public int getCriticalMult() {
		return currWeapon.getCriticalMult();
	}
	/**
	 * @return Odds of landing a critical hit with the equipped weapon
	 */
	public double getCriticalRate() {
		return currWeapon.getCriticalRate();
	}

	/**
	 * Called automatically if health (hp) falls below zero. Restores hp and reduces 
	 * experience (xp) to 0.
	 */
	public void die() {
		health = maxHealth;
		experience = 0;
		game.gameOver();
	}

	/**
	 * Reduces player health(hp) by the specified amount. Does not apply defense or multipliers.
	 * Automatically kills the player if health (hp) falls below zero.
	 * @param amount of damage to take
	 */
	public void takeDamage(int amount) {
		health = health - (amount - defenseBuffer);
		if (health <= 0)
			die();
	}

	/**
	 * Increases player health (hp) by the specified amount. This method ensures that
	 * health cannot exceed the maximum.
	 * @param amount of health (hp) to restore
	 */
	public void heal(int amount) {
		health = health + amount;
		if (health > maxHealth)
			health = maxHealth;
	}

	/**
	 * Applies all abilities of the equipped weapon and armor. Should be called at the beginning of combat to
	 * ensure accuracy of later methods.
	 * @param m Monster currently faced in battle
	 */
	public void applyItemAblites(Monster m) {
		currWeapon.applyAbility(this, m);
		currArmor.applyAbility(this, m);
	}

	/**
	 * Applies the given effect to the player 
	 * @param e The PlayerEffect to be applied
	 */
	public void applyNewEffect(PlayerEffect e) {
		effectList.add(e);
	}

	/**
	 * Applies the effects of all PlayerEffects which still affect the player, and removes those no longer
	 * applicable.
	 */
	public void applyCurrentEffects(boolean inBattle) {
		for (PlayerEffect effect : effectList) {
			if (!effect.getBattleOnly() || effect.getBattleOnly() == inBattle) {
				for (int i = 0; i < effect.getNumEffects(); i++) {
					switch (effect.getAffectedStat(i)) {
					case PlayerEffect.ESACPE_FLAG://see battle system
						break;//escape
					case PlayerEffect.DAMAGEMULT_FLAG:
						damageMultiplier *= effect.getEffectAmount(i);
						break;
					case PlayerEffect.DAMAGEADD_FLAG:
						damageAddition += (int) effect.getEffectAmount(i);
						break;
					case PlayerEffect.DAMAGETOSELF_FLAG:
						takeDamage((int) effect.getEffectAmount(i));
						break;
					case PlayerEffect.DEFENSEADD_FLAG:
						defenseAddition += (int) effect.getEffectAmount(i);
						break;
					case PlayerEffect.CARBONHEAL_FLAG:
						int numElements = 0;
						for (int index = 1; index <= Utils.NUM_ELEMENTS; index++)
							if (inventory.getElement(index) > 0)
								numElements++;
						heal((int) effect.getEffectAmount(i) * numElements);
					case PlayerEffect.MORE_ELEMENT_USE_FLAG://see battle system
						// Increased element use
						break;
					case PlayerEffect.HEAL_FLAG:
						heal((int) effect.getEffectAmount(i));
						break;
					case PlayerEffect.DEFENSEMULT_FLAG:
						defenseMultiplier *= effect.getEffectAmount(i);
						break;
					case PlayerEffect.SKIPTURN_FLAG://see battle system
						//skip turn
						break;
					case PlayerEffect.EXTRATURN_FLAG://see battle system
						//extra turn
						break;
					default:// no effect
					}
				}

			}
		}

	}

	/**
	 * Swaps the equipped weapon with a specified on in the player's inventory
	 * @param index location of the weapon to equip
	 * @throws ItemNotFoundException If index is an invalid location
	 */
	public void swapWep(int index) throws ItemNotFoundException {
		currWeapon = inventory.swap(currWeapon, index);
	}

	/**
	 * Swaps the equipped armor with a specified on in the player's inventory
	 * @param index location of the weapon to equip
	 * @throws ItemNotFoundException If index is an invalid location
	 */
	public void swapArmor(int index) throws ItemNotFoundException {
		currArmor = inventory.swap(currArmor, index);
	}

	/**
	 * @return The player's current xp
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * Sets the amount of damage to reduce from all attacks (including self-inflicted)
	 * @param i buffer amount
	 */
	public void setDefenseBuffer(int i) {
		defenseBuffer = i;
	}
	
	/**
	 * Sets the Game the Player is a part of. Required for Player death to work properly.
	 * @param g the Game the Player is part of.
	 */
	public void setGame(Game g){
		game=g;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Armor getCurrArmor() {
		return currArmor;
	}

	public void setCurrArmor(Armor currArmor) {
		this.currArmor = currArmor;
	}


}
