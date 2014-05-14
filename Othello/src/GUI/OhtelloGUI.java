package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Othello extends JPanel {
	public Othello() {
		super();
		this.setLayout(new BorderLayout());

		// NORTH

		JPanel north = new JPanel(new FlowLayout());
		JLabel l1 = new JLabel("Othello Game   \n\n     ");
		JLabel l2 = new JLabel("    Player (X or O) " + " Moves \n\n  ");
		north.add(l1);
		north.add(l2);
		this.add(north, BorderLayout.NORTH);

		// EAST

		JButton b1 = new JButton("Highscores");
		JPanel west = new JPanel(new GridLayout(3, 1));
		this.add(b1, BorderLayout.EAST);

		// WEST

		JButton q = new JButton("Computer moves");
		q.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			}
		);
		west.add(q);
		JButton w = new JButton("Black chips");
		west.add(w);
		JButton e = new JButton("White chips");
		west.add(e);
		this.add(west, BorderLayout.WEST);

		// SOUTH

		JButton b3 = new JButton("Restart the game \n\n");
		this.add(b3, BorderLayout.SOUTH);

		// CENTRE

		JPanel tablero = new JPanel(new GridLayout(8, 8));
		for (int i = 0; i < 64; i++) {
			JButton bcells = new JButton();
			tablero.add(bcells);
		}
		this.add(tablero);

	}

	public static void main(String[] args) {
		JFrame principal = new JFrame("Main menu");
		JFrame marco = new JFrame("Othello");
		marco.getContentPane().add(new Othello());
		principal.pack();
		marco.pack();
		principal.setVisible(false);
		marco.setVisible(true);
	}
}
