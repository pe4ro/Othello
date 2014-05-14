package othello.Othello;
import java.io.*;
import java.util.ArrayList;
   
    public class Player{
    
    private String name;
    private int color;
    private Board board;

    public Player(String name, int color, Board board) {
        this.name = name;
        this.color = color;
        this.board = board;
    }
    public void setNames() throws IOException{
    	BufferedReader line= new BufferedReader(new InputStreamReader (System.in));
    	System.out.println("tell me your name: ");
    	this.name=line.readLine();	
    }
    public String getName() {
        return this.name;
    }
    
    public int getColor() {
        return this.color;
    }

    public void placeChip(int row, int col) {
        this.board.placeChip( this.color, row, col );
        
        Move move = new Move(row, col);
        this.board.replaceChip(move, this.color);
    }
    
    public void findCanSelect(){

        ArrayList<Move> moves = board.validMove(this.color);

        //for( int i=0; i<moves.size(); i++)
        //    board.setCanSelect(moves.get(i));

        for (Move move : moves)
            board.setCanSelect(move);
    }
    }

