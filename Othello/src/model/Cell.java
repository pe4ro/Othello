package model;

/**
 * Created by pmunoz on 01/04/14. Updated by aeap and jgeorge on 14/05/14.
 * Updated by zwodnik on 09/05/14.
 */

public class Cell {

	public static final char BLACK = 'X'; // displays (X) for the black player.
	public static final char WHITE = 'O'; // displays (O) for the white player.
	public static final char CANSELECT = '?'; // displays (?) for the possible
												// moves available.

	public boolean empty; // boolean if cell empty or not
	public boolean canselect; // boolean if cell can be selected or not

	public int value; // 0 = white, 1 = black, -1 = empty

	/**
	 * Class constructor. Cell empty by default.
	 */
	public Cell() {
		this.empty = true;
		this.value = -1;
	}

	/**
	 * Checks if cell is empty.
	 * 
	 * @return true when empty, false when there is already a chip in it
	 */
	public boolean isEmpty() {
		return this.empty;
	}

	/**
	 * Returns the player's color.
	 * 
	 * @return the player's color
	 */
	public int getPlayer() {
		return this.value;
	}

	/**
	 * Places a chip in the cell.
	 * 
	 * @param int player - the player
	 */
	public void placeChip(int player) {
		this.empty = false;
		this.value = player;
	}

	/**
	 * Changes the color of the chip.
	 */
	public void changeChip() {
		placeChip((value + 1) % 2);
	}

	/**
	 * Sets the cell so that it's possible to select it.
	 */
	public void setSelect() {
		this.canselect = true;
	}

	/**
	 * @return the cells that can be selected.
	 */
	public boolean canSelect() {
		return this.canselect;
	}

	/**
	 * Cancels the selection of the cell.
	 */
	public void unselect() {
		this.canselect = false;
	}

	/**
	 * Displays the cells that: can be selected, are white, are black.
	 */
	public void display() {
		if (this.isEmpty()) // if cell empty
		{
			if (this.canselect) // if can be selected
				System.out.print("[ " + CANSELECT + " ]"); // print (?)
			else
				System.out.print("[ " + " " + " ]"); // otherwise print empty
														// space
		} else {
			char content = BLACK;
			if (this.value == 0)
				content = WHITE;
			System.out.print("[ " + content + " ]"); // or print content. for
														// black (X) & for white
														// (O)
		}
	}
}
