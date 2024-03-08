package e1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LogicsKnightTest {

    private final int size = 5;
    private LogicsKnight logicsKnight = new LogicsKnightImpl(size);
    private Pair<Integer,Integer> knightPosition = new Pair<Integer,Integer>(0, 4);

    @Test
    void testKnightMustMoveWithinBounds() {
        Pair<Integer,Integer> destinationPosition = new Pair<Integer,Integer>(2, 5);
        // destination position is out of bounds
        assertThrows(IndexOutOfBoundsException.class, () -> {
            this.logicsKnight.knightCanMove(this.knightPosition, destinationPosition);
        });
    }
    
    @Test
    void testNotPossibleKnightMove() {
        Pair<Integer,Integer> destinationPosition = new Pair<Integer,Integer>(2, 4);
        // knight can't reach the destination position with the L move
        assertFalse(this.logicsKnight.knightCanMove(this.knightPosition, destinationPosition));
    }
}