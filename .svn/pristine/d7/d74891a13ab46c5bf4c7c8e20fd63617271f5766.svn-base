package board;

import java.io.Serializable;

public class Location implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int subBoard;
	private int row;
	private int col;

	/**CONSTRUCTOR
	 * 
	 * @param sub The subboard number. @see Board.java
	 * 
	 * @param r The row within the space[]
	 * @param c the column within the space[]
	 */
	public Location(int sub, int r, int c) {
		subBoard = sub;
		row = r;
		col = c;
	}

	public int getSubBoard() {
		return subBoard;
	}

	public void setSubBoard(int subBoard) {
		this.subBoard = subBoard;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	/**Checks to make sure all fields of the parameter are equal to this instance.
	 * @param loc the location being checked.
	 * @return True if all are equal, else false.
	 */
	public boolean equals(Location loc) {
		if (loc.getSubBoard() == this.subBoard && loc.getRow() == this.row
				&& loc.getCol() == this.col)
			return true;
		else
			return false;
	}
	public String toString(){
		return this.getSubBoard() + " " + this.row + " " + this.col;
	}
}
