package board;

import java.io.Serializable;

public class SubBoard implements Serializable{

	private static final long serialVersionUID = 1L;
	Space[][] spaces;
	int length;

	/**
	 * CONSTRUCTOR
	 * 
	 * @param numSpaces
	 *            the number of spaces making up 1 edge of the square.
	 * @param sbNum
	 *            which subboard is being created by this constructor.
	 * @param sbNumTot
	 *            How many subboards there are total.
	 */
	public SubBoard(int numSpaces, int sbNum, int sbNumTot) {
		spaces = new Space[numSpaces][numSpaces];

		for (int row = 0; row < numSpaces; row++) {
			for (int col = 0; col < numSpaces; col++) {// set perimeter passable
														// =
														// false;
				if ((row == 0 || row == numSpaces - 1)
						|| ((sbNum == 0 && col == 0) || (sbNum == sbNumTot - 1 && col == numSpaces - 1)))
					spaces[row][col] = new Space(false);
				else
					spaces[row][col] = new Space(true);
			}
		}
	}

	public int size() {
		return spaces.length;
	}

	public Space[][] getSpaces() {
		return spaces;
	}

}
