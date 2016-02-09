package monster;

/**
 * This class creates all the monsters as instances and initializes them It also
 * puts the monsters into lists to be used for every board
 * 
 * @author Alina Rozenbaum
 * 
 */
public class MonsterList {

	public static void main(String args[]) {
		MonsterList list = new MonsterList();
		list.run();
	}

	public void run() {
		Monster[] board2 = getBoard2();

		for (int i = 0; i < board2.length; i++) {
			board2[i].displayStat();
		}
	}

	Monster brute = new Monster(" brute", 70, 11, 3, 3, 0, new int[] { 0 },
			new int[][] { { 10 }, { 10 }, { 20 }, { 0 } }, false, 0);
	Monster gatherer = new Monster("gatherer", 35, 2, 5, 1, 1, new int[] { 1,
			2, 3, 4, 5 }, new int[][] { { 10 }, { 10 }, { 10 },
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9 } }, false, 1);
	Monster hunter = new Monster("hunter", 75, 5, 3, 2, 0, new int[] { 0 },
			new int[][] { { 10 }, { 10 }, { 10 }, { 0 } }, false, 0);
	Monster maniac = new Monster("maniac", 70, 7, 3, 2, 0, new int[] { 0 },
			new int[][] { { 10 }, { 20 }, { 20 }, { 1 } }, false, 0);
	Monster scavenger = new Monster("scavanger", 50, 5, 2, 1, 0,
			new int[] { 0 }, new int[][] { { 10 }, { 10 }, { 20 }, { 0 } },
			false, 0);
	Monster villager = new Monster("villager", 30, 2, 3, 0, 0, new int[] { 0 },
			new int[][] { { 10 }, { 10 }, { 10 }, { 0 } }, false, 0);
	Monster hydrogen = new Monster("hydrogen", 50, 10, 2, 0, 1,
			new int[] { 1 }, new int[][] { { 10 }, { 10 }, { 20 }, { 1 } },
			true, 2);
	Monster helium = new Monster("helium", 80, 5, 3, 2, 1, new int[] { 2 },
			new int[][] { { 10 }, { 30 }, { 40 }, { 2 } }, true, 3);
	Monster lithium = new Monster("lithium", 50, 8, 3, 1, 1, new int[] { 3 },
			new int[][] { { 10 }, { 10 }, { 20 }, { 3 } }, true, 1);
	Monster beryllium = new Monster("beryllium", 60, 7, 1, 2, 1,
			new int[] { 4 }, new int[][] { { 10 }, { 10 }, { 20 }, { 4 } },
			true, 1);
	Monster boron = new Monster("boron", 80, 5, 4, 4, 2, new int[] { 4, 5 },
			new int[][] { { 10 }, { 20 }, { 30 }, { 5 } }, true, 1);
	Monster carbon = new Monster("carbon", 50, 6, 2, 2, 2, new int[] { 6 },
			new int[][] { { 10 }, { 10 }, { 30 }, { 6 } }, true, 1);
	Monster nitrogen = new Monster("nitrogen", 40, 8, 2, 2, 2,
			new int[] { 6, 8 }, new int[][] { { 10 }, { 20 }, { 20 }, { 7 } },
			true, 1);
	Monster oxygen = new Monster("oxygen", 50, 5, 3, 1, 2, new int[] { 6, 8 },
			new int[][] { { 10 }, { 10 }, { 20 }, { 8 } }, true, 1);
	Monster fluorine = new Monster("fluorine", 70, 9, 2, 3, 0, new int[] { 0 },
			new int[][] { { 10 }, { 20 }, { 30 }, { 9 } }, true, 2);
	Monster neon = new Monster("neon", 100, 8, 2, 3, 4, new int[] { 8, 10 },
			new int[][] { { 20 }, { 10 }, { 40 }, { 10 } }, true, 1);
	Monster neonNoble = new Monster("Neon Noble", 300, 12, 2, 5, 4, new int[] { 1,
			2, 3, 4, 5, 6, 7, 8, 9, 10 }, new int[][] { { 30 }, { 50 },
			{ 100 }, { 10 } }, true, 4);

	Monster[] board1 = new Monster[] { villager, gatherer, hydrogen, lithium,
			boron };
	Monster[] board2 = new Monster[] { scavenger, brute, helium, oxygen, carbon };
	Monster[] board3 = new Monster[] { hunter, maniac, beryllium, nitrogen,
			fluorine, neon };
	Monster[] boss = new Monster[]{neonNoble};

	protected Monster[] getBoard1() {
		return board1;
	}

	protected Monster[] getBoard2() {
		return board2;
	}

	protected Monster[] getBoard3() {
		return board3;
	}
	
	protected Monster getBoss(){
		return boss[0];
	}

	protected Monster getMonster(Monster[] list, int i) {
		return list[i];
	}
}
