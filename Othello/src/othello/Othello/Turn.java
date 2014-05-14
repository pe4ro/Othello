package othello.Othello ;

/**
 * Created by Samuel on 01/04/14. Updated by aeap and jgeorge on 14/05/14.
 */

public class Turn {

	private int value; // the player.

	/**
	 * Class constructor. Creates a turn starting with a random player.
	 */
	public Turn() {
		this.value = (int) (Math.random() * 2.0d);
	}

	/**
	 * Class constructor. Creates a turn starting with the selected player.
	 * 
	 * @param int v - adjust the value
	 */
	public Turn(int v) {
		this.value = v;
	}

	/**
	 * Returns the player whose turn it is.
	 * 
	 * @return value of the turn
	 */
	public int getTurn() {
		return this.value;
	}

	/**
	 * Changes the turn to the other player.
	 */
	public void change() {
		this.value = (this.value + 1) % 2;
	}
}
