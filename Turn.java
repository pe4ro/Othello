package othello.Othello;
/**
 * Implementation o a turn class, tha is a value that changes from 0 to 1 or 1 to 0.
 */
public class Turn {

    /**
     * Inner value 0 or 1.
     * Just two turns.
     */
   private int value;

    /**
     * Number of turns, by default 2.
     */
   private int TURNS = 2;

    /**
     * Generates a random turn
     */
   public Turn() {
        this.value =  (int)(Math.random() * TURNS);
   }

    /**
     * According to the rules, black start to play, but we can change it if we want
     * * @param v This parameter adjust the turn value, 0 or 1.
     */
   public Turn(int v) {

       this.value = v;
   }

    /**
     * Get the turn value
     * @return return the value of the turn 0 or 1
     */
    public int getTurn() {
        return this.value;
    }

    /**
     * Change the turn value from 0 to 1 or from 1 to 0.
     */
    public void change() {
        this.value = (this.value + 1) % TURNS;
    }
}
