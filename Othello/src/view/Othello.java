package view;

import controller.MyClickListener;
import model.Board;
import model.Player;
import model.Turn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class Othello extends JPanel {

    private Board board = new Board();
    private Player[] players = new Player[NUM_PLAYERS]; // array of players for two
    private Turn turn; // creates a turn
    private JLabel currentPlayerImage = new JLabel();

    private MouseListener myClickListener;

    final public static int NUM_PLAYERS = 2;
    final public static int N = 8;

    private JLabel[] playerpoints = new JLabel[NUM_PLAYERS];
    private JLabel[][] labels = new JLabel[N][N];
    public static Icon icon_android = new ImageIcon("images/android.png");
    public static Icon icon_apple = new ImageIcon("images/apple.png");
    private Icon icon_empty = new ImageIcon("images/empty.png");
    private Icon icon_mark = new ImageIcon("images/mark.png");
    private Font font = null;

    public Othello() {
        initModel();
        myClickListener = new MyClickListener(this, board, turn, players);
        setLayout(new BorderLayout());


        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Herculanum.ttf")).deriveFont(20.0f);
        } catch (FontFormatException e) {

        } catch (IOException e) {

        }

        currentPlayerImage.setFont(font);

        /// CENTER
        JPanel centerPanel = new JPanel(new GridLayout(N,N));


        for (int i=0; i<N; i++)
            for (int j=0; j<N; j++) {
                labels[i][j] = new MyLabel(i, j);
                labels[i][j].addMouseListener(myClickListener);
                centerPanel.add(labels[i][j]);
            }
        this.add(centerPanel, BorderLayout.CENTER);


        //// NORTH

        JPanel northPanel = new JPanel();
        currentPlayerImage.setText("Current Player");
        northPanel.add(currentPlayerImage);
        this.add(northPanel, BorderLayout.NORTH);

        /// WEST
        JPanel westPanel = new JPanel();
        for (int i=0;i<NUM_PLAYERS; i++) {
            playerpoints[i] = new JLabel();
            playerpoints[i].setFont(font);
            westPanel.add(playerpoints[i]);
        }
        playerpoints[players[0].getColor()].setIcon(icon_android);
        playerpoints[players[1].getColor()].setIcon(icon_apple);


        this.add(westPanel, BorderLayout.SOUTH);
    }

    private void initModel() {
        int who = initPlayers();
        turn = new Turn((who + 1) % 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Othello -- Eagles");
        Othello othello = new Othello();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
                System.exit(0);
            }
        });
        othello.refreshOthello();
        frame.setResizable(false);
        frame.getContentPane().add(othello);
        frame.pack();
        frame.setVisible(true);


    }

    public void refreshOthello() {
        this.players[turn.getTurn()].findCanSelect();

        for (int i=0;i<NUM_PLAYERS; i++)
            playerpoints[i].setText(""+board.getChipsCount(this.players[i].getColor()));


        if (players[turn.getTurn()].getColor() == 1)
            this.currentPlayerImage.setIcon(icon_apple);
        else
            this.currentPlayerImage.setIcon(icon_android);

        for (int i=0; i<N; i++)
            for (int j=0; j<N; j++)
                if (board.isMarked(i,j))
                    labels[i][j].setIcon(icon_mark);
                else if (board.isEmptyCell(i,j))
                    labels[i][j].setIcon(icon_empty);
                else if (board.getPlayerColor(i, j) == 0)
                    labels[i][j].setIcon(icon_android);
                else
                    labels[i][j].setIcon(icon_apple);
    }

    private int initPlayers() {
        Turn aux = new Turn(); // temporary turn

        this.players[0] = new Player("name 1", aux.getTurn(), this.board); // player
        // 1
        aux.change(); // changes to player 2
        this.players[1] = new Player("name 2", aux.getTurn(), this.board); // player
        // 2

        if (aux.getTurn() == 0) { // if player is player 1 then start with black
            return 1;
        } else {
            return 0; // start with white
        }
    }
}