package controller;

import model.Board;
import model.Player;
import model.Turn;
import music.MakeSound;
import view.MyLabel;
import view.Othello;
import view.RotatedIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.AI;
import static view.Othello.N;

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
    public void mouseClicked(final MouseEvent mouseEvent) {
        super.mouseClicked(mouseEvent);
        int row = ((MyLabel) mouseEvent.getSource()).getRow();
        int column = ((MyLabel) mouseEvent.getSource()).getColumn();
        if (board.isMarked(row, column)) {
            players[turn.getTurn()].placeChip(row, column); // place

            new Thread() {
                public void run() {
                    ((MyLabel) mouseEvent.getSource()).setSize(dimension);
                    new MakeSound().playSound("music/beep.wav");

                }
            }.start();

            new Thread() {
                public void run() {
                    playFX(((MyLabel) mouseEvent.getSource()));
                }
            }.start();
            
        }
    }

    private void playFX(MyLabel source) {

        RotatedIcon ri;
        for (int i=0; i< 10; i++) {
            ri = new RotatedIcon(source.getIcon(), 10);
            source.setIcon(ri);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        

        turn.change();
        othello.refreshOthello();    

        
        int count = 0;
        for (int i=0; i<N; i++)
            for (int j=0; j<N; j++)
                if (board.isMarked(i, j) && (board.isEmptyCell(i, j)))
                    count ++;
        if (count == 0) {
            turn.change();
            othello.refreshOthello();    
            System.out.println("kkkkk");
        } else {
            AI.move_cpu_medium(board, players[turn.getTurn()]);
            turn.change();
            othello.refreshOthello();
            
            count = 0;
            for (int i=0; i<N; i++)
                for (int j=0; j<N; j++)
                    if (board.isMarked(i, j) && (board.isEmptyCell(i, j)))
                        count ++;
            if (count == 0) {
                turn.change();
                othello.refreshOthello();    
                System.out.println("kkkkk");
            }
        }
        
    }



    private Dimension dimension;

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        super.mouseEntered(mouseEvent);
        dimension = ((JLabel)mouseEvent.getSource()).getSize();
        Dimension newdimension = new Dimension();
        newdimension.setSize(dimension.getWidth()*1.1, dimension.getHeight()*1.1);
        ((JLabel)mouseEvent.getSource()).setSize(newdimension);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        super.mouseExited(mouseEvent);
        ((JLabel)mouseEvent.getSource()).setSize(dimension);

    }
}
