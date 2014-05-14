package othello.Othello;
/**
 * Created by Samuel on 01/04/14.
 *
 */
public class Turn {


   private int value;


   public Turn() {
        this.value =  (int)(Math.random() * 2.0d );
   }

    /**
     *according to the rules, black start to play, but we can change it if we want
     * This class is finished, only is necessary to decide who started first, black, white or random
      * @param v This parameter adjust the value ...
     */
   public Turn(int v) {
       this.value = v;
   }


    /**
     *
     * @return return the value of the turn ...
     */
    public int getTurn() {
        return this.value;
    }

    public void change() {
        this.value = (this.value + 1) % 2;
    }
}
