package character;

import java.io.Serializable;

/**
 * The PlayerEffect class, which gives certain effects to the Player, both good and bad.
 * @author Will
 */
public class PlayerEffect implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int[] affectedStats;     //I need a key for this to know what number belongs to which effect
/*
 * Feel free to define them however you want. I don't know what kind of effects are needed yet.
 * Just add to the chart below as necessary:
 * -1=Escape from battle
 * 0=Damage multiplier
 * 1=Damage addition to attacks (ex. Be)
 * 2=Damage to player (ex. Be)
 * 3=Defense addition (ex. B)
 * 4=Carbon heal ({amount} health/type of element owned)
 * 5=Increased element use next attack (and combines them) amount increases the number (ex. N)
 * 6=Heal by given amount
 * 7=Defense multiplier (Includes F now)
 * 8=
 * Example:
 * For Li, battleOnly=true, turnsLeft=1(only applies next turn), affectedStats={0},effectAmount={2.0}(double)
 * If something needs to be instantaneous, let's say turnsLeft=0
 * Hopefully that's clear enough.
 * 
 */
	public final static int ESACPE_FLAG = -1;
	public final static int DAMAGEMULT_FLAG = 0;
	public final static int DAMAGEADD_FLAG = 1;
	public final static int DAMAGETOSELF_FLAG = 2;
	public final static int DEFENSEADD_FLAG = 3;
	public final static int CARBONHEAL_FLAG = 4;
	public final static int MORE_ELEMENT_USE_FLAG = 5;
	public final static int HEAL_FLAG = 6;
	public final static int DEFENSEMULT_FLAG = 7;
	public final static int SKIPTURN_FLAG = 8;
	public final static int EXTRATURN_FLAG = 9;


	
	private double[] effectAmount;	 
	private boolean battleOnly;
	private int turnsLeft;
	/**
	 * Default constructor
	 * @param stats Array of affected stats
	 * @param amount Array containing the amount of the effect
	 * @param battle True if this effect applies exclusively during combat
	 * @param turns Duration of the effect
	 */
	public PlayerEffect(int[] stats, double[] amount, boolean battle, int turns){
		affectedStats=stats;
		effectAmount=amount;
		battleOnly=battle;
		turnsLeft=turns;
	}
	
	/**
	 * Generates an Effect for the Element specified by the given atomic number.
	 * @param atomicNum The atomic number of the Element
	 */
	public PlayerEffect(int atomicNum){
		switch(atomicNum){
		case 2:
			affectedStats=new int[]{ESACPE_FLAG};
			effectAmount= new double[] {.5};
			battleOnly=true;//Escape?
			turnsLeft=0;
		case 3:
			battleOnly=true;
			turnsLeft=1;
			affectedStats=new int[]{DAMAGEMULT_FLAG};
			effectAmount=new double[]{2.0};
		case 4:
			battleOnly=true;
			turnsLeft=1;
			affectedStats=new int[]{DAMAGEADD_FLAG,DAMAGETOSELF_FLAG};
			effectAmount=new double[]{20,10};
		case 5:
			battleOnly=false;
			turnsLeft=1;
			affectedStats=new int[]{DEFENSEADD_FLAG};
			effectAmount=new double[]{1};
		case 6:
			battleOnly=false;
			turnsLeft=0;
			affectedStats=new int[]{CARBONHEAL_FLAG};
			effectAmount=new double[]{10};
		case 7:
			battleOnly=true;
			turnsLeft=1;
			affectedStats=new int[]{MORE_ELEMENT_USE_FLAG};
			effectAmount=new double[]{2};
		case 8:
			battleOnly=false;
			turnsLeft=0;
			affectedStats=new int[]{HEAL_FLAG};
			effectAmount=new double[]{20};
		case 9:
			battleOnly=false;
			turnsLeft=1;
			affectedStats=new int[]{DEFENSEMULT_FLAG};
			effectAmount=new double[]{1.5};
		case 10:
			battleOnly=false;
			turnsLeft=0;
			affectedStats=new int[]{HEAL_FLAG};
			effectAmount=new double[]{40};
		default:
			battleOnly=false;
			turnsLeft=0;
			affectedStats=null;
			effectAmount=null;
		}
	}
	
	/**
	 * @return The number of effects
	 */
	public int getNumEffects() {
		return affectedStats.length;
	}
	
	/**
	 * @param index The index of the affected stat, 0<=index< numEffects
	 * @return The stat affected by the given index.
	 */
	public int getAffectedStat(int index){
		return affectedStats[index];
	}
	
	/**
	 * @param index The index of the affected stat, 0<=index< numEffects
	 * @return The amount the affected stat is changed by.
	 */
	public double getEffectAmount(int index){
		return effectAmount[index];
	}
	
	/**
	 * @return True if the effect only applies during battle, false otherwise.
	 */
	public boolean getBattleOnly(){
		return battleOnly;
	}
	
	/**
	 * Decreases the number of turns left for the PlayerEffect.
	 */
	public void reduceTurnsLeft(){
		turnsLeft--;
	}
	
	/**
	 * @return The number of turns left for the PlayerEffect.
	 */
	public int getTurnsLeft(){
		return turnsLeft;
	}

	
	
}
