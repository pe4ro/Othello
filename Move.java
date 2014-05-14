package othello.Othello;

/**
 * Created by aeap and jgeorge on 14/05/14.
 */

class Move {

	int i, j; // i, position on i axis & j position on j axis

	/**
	 * Class constructor. Position we want to look at, to create the directions
	 * on i and j axis
	 */
	public Move(int i, int j) {
		this.i = i;
		this.j = j;
	}

	/**
	 * Gets the location of the position we want to look at on the i axis
	 */
	public int getI() {
		return i;
	}

	/**
	 * Gets the location of the position we want to look at on the j axis
	 */
	public int getJ() {
		return j;
	}
}
