package monster;

import java.util.Random;

import ctrl.Controller;

import character.Player;

public class MonsterEffect {

	public int dieRoll() {
		Random number = new Random();
		return number.nextInt(5) + 1;
	}
public MonsterEffect(){
	
}
	public void playerTurnEffect(String name, Player player, Monster monster,
			int monsterHpPrev, Controller ctrl) {

		if (name.equalsIgnoreCase("scavanger") == true) {
			scavangerEffect(monster, ctrl);
		} else if (name.equalsIgnoreCase("helium") == true) {
			heliumEffect(monster, ctrl);
		} else if (name.equalsIgnoreCase("lithium") == true) {
			boronEffect(monsterHpPrev, monster, player, ctrl);
		}
	}

	public void monsterBeginTurnEffect(String name, Player player,
			Monster monster, int num, Controller ctrl) {

		if (name.equalsIgnoreCase("scavanger") == true) {
			scavangerEffect(monster, ctrl);
		} else if (name.equalsIgnoreCase("helium") == true) {
			heliumEffect(monster, ctrl);
		} else if (name.equalsIgnoreCase("lithium") == true) {
			lithiumEffect(player, monster, ctrl);
		} else if (name.equalsIgnoreCase("carbon") == true) {
			carbonEffect(monster, ctrl);
		} else if (name.equalsIgnoreCase("oxygen") == true) {
			oxygenEffect(monster, ctrl);
		} else if (name.equalsIgnoreCase("neon") == true) {
			neonEffect(num, player, monster, ctrl);
		}
	}

	public void monsterEndTurnEffect(String name, Player player,
			Monster monster, int num, int playerHpPrev, Controller ctrl) {
		if (name.equalsIgnoreCase("scavanger") == true) {
			scavangerEffect(monster, ctrl);
		} else if (name.equalsIgnoreCase("helium") == true) {
			heliumEffect(monster, ctrl);
		} else if (name.equalsIgnoreCase("beryllium") == true) {
			berylliumEffect(playerHpPrev, player, ctrl);
		} else if (name.equalsIgnoreCase("nitrogen") == true) {
			nitrogenEffect(player, monster, ctrl);
		} else if (name.equalsIgnoreCase("fluorine") == true) {
			fluorineEffect(num, player, ctrl);
		}
	}

	// all times
	protected void scavangerEffect(Monster monster, Controller ctrl) {

		int num1 = dieRoll();
		int num2 = dieRoll();

		if (num1 == num2) {
			ctrl.getGmWindow().display("Scavanger flees!");
			monster.setDrop(new int[][] { { 0 }, { 0 }, { 0 }, { 0 } });
			monster.setHealth(0);
		}
	}

	// all times
	protected void heliumEffect(Monster monster, Controller ctrl) {
		int num = dieRoll();

		if (num == 5) {
			ctrl.getGmWindow().display("Helium flees!");
			monster.setDrop(new int[][] { { 0 }, { 0 }, { 0 }, { 0 } });
			monster.setHealth(0);
		}
	}

	// before monster attacks
	protected void lithiumEffect(Player player, Monster monster, Controller ctrl) {
		int num = dieRoll();

		if (num == 3) {
			ctrl.getGmWindow()
					.display(
							"Lithium blow up. You get damage equal to its current health.");
			player.takeDamage(monster.getHealth());
			monster.setDrop(new int[][] { { 0 }, { 0 }, { 0 }, { 0 } });
			monster.setHealth(0);
		}
	}

	// after monster attacks
	protected void berylliumEffect(int playerHpPrev, Player player,
			Controller ctrl) {

		if (playerHpPrev > player.getHealth()) {
			ctrl.getGmWindow().display(
					"You took damage. You take 20 more damage. ");
			player.takeDamage(20);
		}
	}

	// player turn
	protected void boronEffect(int monsterHpPrev, Monster monster,
			Player player, Controller ctrl) {

		if (monsterHpPrev > monster.getHealth()) {
			ctrl.getGmWindow().display(
					"You get hit back for 1/4 of the damage you inflicted.");
			int dmg = monster.getHealth() - monsterHpPrev;
			player.takeDamage(dmg / 4);
		}
	}

	// before monster attacks
	protected void carbonEffect(Monster monster, Controller ctrl) {
		int num = dieRoll();

		if (num == 5) {
			monster.setAttack(2 * monster.getAttack());
			monster.setHealth(10 + monster.getHealth());
			ctrl.getGmWindow()
					.display(
							"Carbon's health is increased by 10 and it's attack doubles until the end of its turn.");
		}
	}

	// after monster attacks
	protected void nitrogenEffect(Player player, Monster monster,
			Controller ctrl) {
		int num = dieRoll();

		if (num == 5) {
			ctrl.getGmWindow().display("Nitrogen attacks again!");
			player.takeDamage(monster.getAttack());
		}
	}

	// before monster attacks
	protected void oxygenEffect(Monster monster, Controller ctrl) {
		int num = dieRoll();

		if (num == 1) {
			ctrl.getGmWindow().display(
					"Oxygen gains health equal to half its attack.");
			monster.setHealth(monster.getHealth() + (monster.getAttack() / 2));
		}
	}

	// after monster attacks
	protected void fluorineEffect(int num, Player player, Controller ctrl) {
		Random number = new Random();
		int index = number.nextInt(8);

		if (num == 6) {
			ctrl.getGmWindow().display(
					"The fuorine stole one " + player.getElement(index)
							+ " from yourinventory!");
			player.setElement(index, -1);
		}
	}

	// before monster attacks
	protected void neonEffect(int num, Player player, Monster monster,
			Controller ctrl) {

		if (num != 6){
			ctrl.getGmWindow().display("Player's defense is ignored.");
			player.takeDamage(player.getDefense() + monster.getAttack());
		}
	}

}
