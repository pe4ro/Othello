package controller;

import model.Board;
import model.Player;
import model.Turn;
import view.MyLabel;
import view.Othello;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by IntelliJ IDEA.
 * User: lfmingo
 * Date: 14/05/14
 * Time: 20:34
 */
public class MyClickListener extends MouseAdapter {
    private Board board;
    private Turn turn;
    private Othello othello;
    private Player players[];

    public MyClickListener(Othello othello, Board board, Turn turn, Player[] players) {
        this.board = board;
        this.turn = turn;
        this.othello = othello;
        this.players = players;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        int row = ((MyLabel) mouseEvent.getSource()).getRow();
        int column = ((MyLabel) mouseEvent.getSource()).getColumn();
        if (board.isMarked(row, column)) {
            players[turn.getTurn()].placeChip(row, column); // place
            turn.change();
            othello.refreshOthello();
        }
    }
}
