package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author michalsynowiec
 */
public class AI {

    /**
     *Method move_cpu_easy makes a simple move by cpu using random function  
     *
     * @param board 
     * @param player
     */
    public static void move_cpu_easy(Board board, Player player){
        
        List<Move> proper = new ArrayList<Move>(); //list of all avaliable moves that can be done
        

    // lopp that takes out all possible moves
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                Move move = new Move(i,j);
                if(board.findLegalMoveNew(move, player.getColor()))
                    proper.add(move);
            }
        }
        //Random takes out random move from proper
        Random r = new Random();
        
        int randI = r.nextInt(proper.size());
        
        player.placeChip(proper.get(randI).getI(), proper.get(randI).getJ());
        
    }
    
    public static void move_cpu_hard(Board board, Player player){
        
        
        List<Move> proper = new ArrayList<Move>(); //list of all avaliable moves that can be done
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                Move move = new Move(i,j);
                if(board.findLegalMoveNew(move, player.getColor())){
                    proper.add(move);
                }
                
            }
        }
        
        for(Move m : proper){
            
            if(m.getI()==0 && m.getJ()==0){
                player.placeChip(0, 0);
                return;
            }
            if(m.getI()==0 && m.getJ()==7){
                player.placeChip(0, 7);
                return;
            }
            if(m.getI()==7 && m.getJ()==0){
                player.placeChip(7, 0);
                return;
            }
            if(m.getI()==7 && m.getJ()==7){
                player.placeChip(7,7);
                return;
            }
            
        }
        
        
        
        Random r = new Random();
        
        while(true){
            try{
                int a = r.nextInt(proper.size());
                if((proper.get(a).getI() != 1 && proper.get(a).getJ() != 1) || 
                   (proper.get(a).getI() != 1 && proper.get(a).getJ() != 6) ||
                   (proper.get(a).getI() != 6 && proper.get(a).getJ() != 1) ||
                   (proper.get(a).getI() != 6 && proper.get(a).getJ() != 6) ){
                        player.placeChip(proper.get(a).getI(), proper.get(a).getJ());
                        return;
                }
            }catch(IllegalArgumentException e){
                System.err.print(e.toString());
            }
                
        }
        
        /*int m,mmx;
        
        mmx = -10;
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                Move move = new Move(i,j);
                if(board.findLegalMoveNew(move, player.getColor())){
                    Player opponent = new Player("opponent",(player.getColor()+1)%2,board);
                    opponent.placeChip(move.getI(), move.getJ());
                    board.clearQMarks();
                    m = MinMax(board, opponent);

                    board.removeChip(move);

                    if(m > mmx){
                        mmx = m;
                        player.placeChip(i, j);
                    }
                }
            }
        }*/
    }
    
    /**
     * Method  draw check wheather it's a draw or not 
     * @param board
     * @param player
     * @return 
     */
    /*private static boolean draw(Board board, Player player){
        int pChipNumber = board.getChipsCount(player.getColor()); // int contain player's chip number
        int oChipNumber = board.getChipsCount((player.getColor()+1)%2); //contain oponent's chip number
        
        if(pChipNumber == oChipNumber)
            return true;
        
        return false;
    }*/
    /**
     * whoWins check who has more chips 
     * @param board
     * @param player
     * @return 
     */
    /*private static boolean whoWins(Board board, Player player){
        int pChipNumber = board.getChipsCount(player.getColor()); // int contain player's chip number
        int oChipNumber = board.getChipsCount((player.getColor()+1)%2); //contain oponent's chip number
        
        if(pChipNumber > oChipNumber)
            return true;
        
        return false;
    }*/
    
    /*private static int MinMax(Board board, Player player){
        
        int m, mmx;
        
        if(whoWins(board, player))
            return (player.getColor() == 0) ? 1 : -1;
        
        if(draw(board, player))
            return 0;
        
        player.tempChangeColor();
        mmx = (player.getColor() == 0) ? -10 : 10;
        
        //===========
        
    // lopp that takes out all possible moves
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                Move move = new Move(i,j);
                if(board.findLegalMoveNew(move, player.getColor())){
                    player.placeChip(move.getI(), move.getJ());
                    
                    Player opponent = new Player("opponnent",(player.getColor()+1)%2,board);
                    board.clearQMarks();
                    m = MinMax(board, opponent);
                    
                    board.removeChip(move);
                    
                    if((player.getColor()==0 && m < mmx) || player.getColor()==1 && m > mmx)
                        mmx = m;
                }
            }
        }
        
        
        return mmx;
    }*/
    
}
