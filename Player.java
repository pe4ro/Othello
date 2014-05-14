package othello.Othello;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by pmunoz on 01/04/14. Updated by aeap and jgeorge on 14/05/14.
 */

public class Player {

	private String name; // name of the player
	private int color; // color of the chips
	private Board board; // board

	/**
	 * Class constructor. Creates a player.
	 * 
	 * @param String
	 *            name - the player's name
	 * @param int color - the color of the chips
	 * @param Board
	 *            board - the board used
	 */
	public Player(String name, int color, Board board) {
		this.name = name;
		this.color = color;
		this.board = board;
	}

	/**
	 * Prompts the user for their name and sets it as the name variable.
	 * 
	 * Null values throws a message
	 */
	public void setNames() throws IOException {
		BufferedReader line = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("tell me your name: ");
		this.name = line.readLine();
	}

	/**
	 * Gets the name of the player.
	 * 
	 * @return name of the player
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the number of the player.
	 * 
	 * @return the number of the player
	 */
	public int getColor() {
		return this.color;
	}

	/**
	 * Places a chip for a chosen player at the chosen location. Replaces the
	 * chips in between the player's chips to the player's color.
	 * 
	 * @param int row - the row of the chip
	 * @param int col - the column of the chip
	 */
	public void placeChip(int row, int col) {
		this.board.placeChip(this.color, row, col);

		Move move = new Move(row, col);
		this.board.replaceChip(move, this.color);
	}

	/**
	 * Find the valid moves and allow them to be selected.
	 */
	public void findCanSelect() {

		ArrayList<Move> moves = board.validMove(this.color);

		for (Move move : moves)
			board.setCanSelect(move);
	}
}
