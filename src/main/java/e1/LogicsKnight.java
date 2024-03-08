package e1;

public interface LogicsKnight {

    /**
     * Determines whether a knight can move to a certain position on the board.
     * 
     * @param startingPosition
     * @param destinationPosition
     * @return true if the knight can move to that position, false otherwise
     */
    boolean knightCanMove(Pair<Integer,Integer> startingPosition, Pair<Integer,Integer> destinationPosition);
}