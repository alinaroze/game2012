package inventory;

import java.util.ArrayList;

import ctrl.Utils;

import character.PlayerEffect;

/**
 * The CompoundList class, which contains a list of all the compounds, and checks to see if a
 * given combination of elements creates a compound.
 * 
 * @author Will and Steven
 * 
 */
public class CompoundList {
	private ArrayList<Compound> compoundList = new ArrayList<Compound>();

	/**
	 * Creates a new CompoundList which holds all possible compounds in the game.
	 */
	public CompoundList() {

		// Compound blank = new Compound(String name, int price, String text,
		// int H, int He, int Li, int Be, int B, int C, int N, int O, int F, int
		// Ne);

		compoundList.add(hydrogenMolecule());

		compoundList.add(methane());

		compoundList.add(methyllithium());

		compoundList.add(cBe2());

		compoundList.add(hydrofluoricAcid());

		compoundList.add(nitrogenGas());

		compoundList.add(oxygenGas());

		compoundList.add(ozone());

		compoundList.add(boronTrifluoride());

		compoundList.add(methanol());

		compoundList.add(ethanol());

		compoundList.add(caffeine());

		compoundList.add(dopamine());
	}

	/**
	 * Determines if a given set of atoms create a compound
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
	 * @return True if the elements create a compound, false otherwise
	 */
	public boolean isCompound(int H, int He, int Li, int Be, int B, int C,
			int N, int O, int F, int Ne) {
		int[] elements = new int[] { H, He, Li, Be, B, C, N, O, F, Ne };
		for (Compound c : compoundList) {
			for (int i = 1; i <= Utils.NUM_ELEMENTS; i++) {
				if (c.getNumElement(i) != elements[i-1])
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Finds and returns the compound containing the given elements. If no such compound exists,
	 * returns null.
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
	 * @return The compound containing the given elements, null if none exists.
	 */
	public Compound makeCompound(int H, int He, int Li, int Be, int B, int C,
			int N, int O, int F, int Ne) {
		int[] elements = new int[] { H, He, Li, Be, B, C, N, O, F, Ne };
		boolean sameCompound = true;
		for (Compound c : compoundList) {
			sameCompound = true;
			for (int i = 1; i <= Utils.NUM_ELEMENTS; i++) {
				if (c.getNumElement(i) != elements[i - 1]) {
					sameCompound = false;
					break;
				}
			}
			if (sameCompound) {
				return c;
			}
		}
		return null;
	}
	
	/**
	 * The list of all possible compounds
	 * @return An ArrayList which contains all possible compounds in the game
	 */
	public ArrayList<Compound> getCompoundList() {
		return this.compoundList;
	}
	public Compound getCompound(int index){
		return compoundList.get(index);
	}

	/**
	 * Creates and returns a hydrogen (H2) molecule.
	 * 
	 * @return A compound with the attributes of a hydrogen molecule.
	 */
	public Compound hydrogenMolecule() {
		PlayerEffect effect = null;
		// TODO add monsterEffect
		return new Compound("Hydrogen Molecule", 50,
				"Deals 60 damage to opponent", 2, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				effect);
	}

	/**
	 * Creates and returns a methane (CH4) molecule.
	 * 
	 * @return A compound with the attributes of a methane molecule.
	 */
	public Compound methane() {
		PlayerEffect effect = null;
		// TODO add monsterEffect
		return new Compound("Methane", 150, "Deals 50 damage to opponent", 4,
				0, 0, 0, 0, 0, 1, 0, 0, 0, effect);
	}

	/**
	 * Creates and returns a methyllithium (CH3Li) molecule.
	 * 
	 * @return A compound with the attributes of a methyllithium molecule.
	 */
	public Compound methyllithium() {
		int[] effectList = new int[] { PlayerEffect.SKIPTURN_FLAG };
		double[] effectAmount = new double[] { 1.0 };
		PlayerEffect effect = new PlayerEffect(effectList, effectAmount, true,
				1);
		// TODO add monsterEffect
		return new Compound("Methyllithium", 150,
				"Deals 80 damage to opponent, but you cannot attack next turn",
				3, 0, 1, 0, 0, 0, 1, 0, 0, 0, effect);
	}

	/**
	 * Creates and returns a beryllium carbide (CBe2) molecule.
	 * 
	 * @return A compound with the attributes of a beryllium carbide molecule.
	 */
	public Compound cBe2() {
		int[] effectList = new int[] { PlayerEffect.DEFENSEADD_FLAG };
		double[] effectAmount = new double[] { 1.0 };
		PlayerEffect effect = new PlayerEffect(effectList, effectAmount, true,
				1);
		// TODO add monsterEffect
		return new Compound(
				"C Be 2",
				120,
				"Temporarily increases your defense, or lowers your opponent's",
				0, 0, 0, 2, 0, 1, 0, 0, 0, 0, effect);
	}

	/**
	 * Creates and returns a hydrofluoric acid (HF) molecule.
	 * 
	 * @return A compound with the attributes of a hydrofluoric acid molecule.
	 */
	public Compound hydrofluoricAcid() {
		int[] effectList = new int[] { PlayerEffect.DEFENSEMULT_FLAG };
		double[] effectAmount = new double[] { 0.0 };
		PlayerEffect effect = new PlayerEffect(effectList, effectAmount, false,
				1);
		// TODO add monsterEffect
		return new Compound(
				"Hydrofluoric Acid",
				150,
				"Deals substatial damage to opponent, but your defense is 0 until the end of battle",
				1, 0, 0, 0, 0, 0, 0, 0, 1, 0, effect);
	}

	/**
	 * Creates and returns a nitrogen (N2) molecule.
	 * 
	 * @return A compound with the attributes of a nitrogen molecule.
	 */
	public Compound nitrogenGas() {
		PlayerEffect effect = null;
		// TODO add monsterEffect
		return new Compound("Nitrogen Gas", 90,
				"Reduces opponent's attack for 2 turns", 0, 0, 0, 0, 0, 0, 2,
				0, 0, 0, effect);
	}

	/**
	 * Creates and returns a oxygen (O2) molecule.
	 * 
	 * @return A compound with the attributes of a oxygen molecule.
	 */
	public Compound oxygenGas() {
		int[] effectList = new int[] { PlayerEffect.HEAL_FLAG };
		double[] effectAmount = new double[] { 50.0 };
		PlayerEffect effect = new PlayerEffect(effectList, effectAmount, false,
				1);
		return new Compound("Oxygen Gas", 70, "Heals by 50 health", 0, 0, 0, 0,
				0, 0, 0, 2, 0, 0, effect);
	}

	/**
	 * Creates and returns a ozone (O3) molecule.
	 * 
	 * @return A compound with the attributes of a ozone molecule.
	 */
	public Compound ozone() {
		int[] effectList = new int[] { PlayerEffect.HEAL_FLAG };
		double[] effectAmount = new double[] { 100.0 };
		PlayerEffect effect = new PlayerEffect(effectList, effectAmount, false,
				1);
		return new Compound("Ozone", 100, "Heals by 100 health", 0, 0, 0,
				0, 0, 0, 0, 3, 0, 0, effect);
	}

	/**
	 * Creates and returns a boron trifluoride (BF3) molecule.
	 * 
	 * @return A compound with the attributes of a boron trifluoride molecule.
	 */
	public Compound boronTrifluoride() {
		PlayerEffect effect = null;
		//TODO add monsterEffect
		return new Compound("Boron Trifluoride", 330,
				"Deals 20 damage per turn to opponent", 0, 0, 0, 0, 1, 0, 0, 0,
				3, 0, effect);
	}

	/**
	 * Creates and returns a methanol (CH3OH) molecule.
	 * 
	 * @return A compound with the attributes of a methanol molecule.
	 */
	public Compound methanol() {
		PlayerEffect effect = null;
		//TODO add monsterEffect
		return new Compound("Methanol", 180,
				"Reduces opponet's attack and elemental defense", 4, 0, 0, 0,
				0, 1, 0, 1, 0, 0, effect);
	}

	/**
	 * Creates and returns a ethanol (CH3CH2OH) molecule.
	 * 
	 * @return A compound with the attributes of a ethanol molecule.
	 */
	public Compound ethanol() {
		int[] effectList = new int[] { PlayerEffect.DAMAGEMULT_FLAG };
		double[] effectAmount = new double[] { 2.0 };
		PlayerEffect effect = new PlayerEffect(effectList, effectAmount, false,
				1);
		//TODO add monsterEffect
		return new Compound("Ethanol", 280,
				"Doubles your attack or reduces your opponent's", 6, 0, 0, 0,
				0, 2, 0, 1, 0, 0, effect);
	}

	/**
	 * Creates and returns a caffeine (C8 H10 N4 O2) molecule.
	 * 
	 * @return A compound with the attributes of a caffeine molecule.
	 */
	public Compound caffeine() {
		int[] effectList = new int[] { PlayerEffect.EXTRATURN_FLAG };
		double[] effectAmount = new double[] { 3.0 };
		PlayerEffect effect = new PlayerEffect(effectList, effectAmount, true,
				1);
		return new Compound("Caffeine", 860, "Allows three attacks", 10, 0, 0,
				0, 0, 8, 4, 2, 0, 0, effect);
	}

	/**
	 * Creates and returns a dopamine (C8 H11 N O2) molecule.
	 * 
	 * @return A compound with the attributes of a dopamine molecule.
	 */
	public Compound dopamine() {
		int[] effectList = new int[] { PlayerEffect.HEAL_FLAG,
				PlayerEffect.DEFENSEADD_FLAG };
		double[] effectAmount = new double[] { 500.0, 1.0 };
		PlayerEffect effect = new PlayerEffect(effectList, effectAmount, false,
				1);
		return new Compound("Dopamine", 760,
				"Heals 500 health and temporarily raises defense by 1", 11, 0,
				0, 0, 0, 8, 1, 2, 0, 0, effect);
	}

}
