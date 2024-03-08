package e1;

public interface InitializerPositions {

    /**
     * Initializes the position of a pawn on the board.
     * 
     * @return pawn initial position
     */
    Pair<Integer,Integer> initializerPawnPosition();

    /**
     * Initializes the position of the knight on the board.
     * 
     * @return knight initial position
     */
    Pair<Integer,Integer> initializerKnightPosition();
}