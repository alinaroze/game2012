package character;

import ctrl.Utils;

/**
 * Event class, for random events which affect the player. Currently only includes
 * finding random amounts of elements. May contain more later.
 * @author Will
 *
 */
public class Event {
	
	private String text;
	private int[] affectedStats;
	private double[] effectAmount;
	
	public static final int HYDROGEN_GAIN = 1;
	public static final int HELIUM_GAIN = 2;
	public static final int LITHIUM_GAIN = 3;
	public static final int BERYLLIUM_GAIN = 4;
	public static final int BORON_GAIN = 5;
	public static final int CARBON_GAIN = 6;
	public static final int NITORGEN_GAIN = 7;
	public static final int OXYGEN_GAIN = 8;
	public static final int FLUORINE_GAIN = 9;
	public static final int NEON_GAIN = 10;
	
	private static final int MAX_EVENTS = 10;
	
	/**
	 * @return The number of effects
	 */
	public int getNumEffects(){
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
	 * Default constructor
	 * @param type The type of event
	 */
	public Event(int type){
		int elementAmount=Utils.rndInt(1, 3);//find between 1 and 3 atoms
		switch(type){
		case HYDROGEN_GAIN:
			text = "Find " + elementAmount + " hydrogen atoms.";
			affectedStats = new int[] { HYDROGEN_GAIN };
			effectAmount = new double[] { elementAmount };
			break;
		case HELIUM_GAIN:
			text = "Find " + elementAmount + " helium atoms.";
			affectedStats = new int[] { HELIUM_GAIN };
			effectAmount = new double[] { elementAmount };
			break;
		case LITHIUM_GAIN:
			text = "Find " + elementAmount + " lithium atoms.";
			affectedStats = new int[] { LITHIUM_GAIN };
			effectAmount = new double[] { elementAmount };
			break;
		case BERYLLIUM_GAIN:
			text = "Find " + elementAmount + " beryllium atoms.";
			affectedStats = new int[] { BERYLLIUM_GAIN };
			effectAmount = new double[] { elementAmount };
			break;
		case BORON_GAIN:
			text = "Find " + elementAmount + " boron atoms.";
			affectedStats = new int[] { BORON_GAIN };
			effectAmount = new double[] { elementAmount };
			break;
		case CARBON_GAIN:
			text = "Find " + elementAmount + " carbon atoms.";
			affectedStats = new int[] { CARBON_GAIN };
			effectAmount = new double[] { elementAmount };
			break;
		case NITORGEN_GAIN:
			text = "Find " + elementAmount + " nitrogen atoms.";
			affectedStats = new int[] { NITORGEN_GAIN };
			effectAmount = new double[] { elementAmount };
			break;
		case OXYGEN_GAIN:
			text = "Find " + elementAmount + " oxygen atoms.";
			affectedStats = new int[] { OXYGEN_GAIN };
			effectAmount = new double[] { elementAmount };
			break;
		case FLUORINE_GAIN:
			text = "Find " + elementAmount + " fluorine atoms.";
			affectedStats = new int[] { FLUORINE_GAIN };
			effectAmount = new double[] { elementAmount };
			break;
		case NEON_GAIN:
			text = "Find " + elementAmount + " neon atoms.";
			affectedStats = new int[] { NEON_GAIN };
			effectAmount = new double[] { elementAmount };
			break;

		default:;
		}
	}
	
	/**
	 * @return The description of the event
	 */
	public String getText(){
		return text;
	}
	
	/**
	 * @return Returns a new, random event.
	 */
	public static Event rndEvent(){
		return new Event(Utils.rndInt(1, MAX_EVENTS));
	}

}
