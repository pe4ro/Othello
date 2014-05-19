package view;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: lfmingo
 * Date: 14/05/14
 * Time: 19:40
 */
public class MyLabel extends JLabel {
    private int row;
    private int column;

    public MyLabel(int row, int column) {
        super();
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
