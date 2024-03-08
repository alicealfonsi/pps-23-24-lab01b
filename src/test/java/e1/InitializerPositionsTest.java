package e1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InitializerPositionsTest {

    private Pair<Integer,Integer> pawnPosition;
    private Pair<Integer,Integer> knightPosition;
    private InitializerPositions initializerPositions;
    private int size = 5;

    @BeforeEach
    void init() {
        this.initializerPositions = new InitializerPositionsImpl(size);
        this.pawnPosition = this.initializerPositions.initializerPawnPosition();
        this.knightPosition = this.initializerPositions.initializerKnightPosition();
    }

    @Test
    void testSameInitialPosition() {
        assertNotEquals(this.pawnPosition, this.knightPosition);     
    }

    @Test
    void testInitialPositionsWithinBounds() {
        assertAll(
            () -> assertTrue(this.pawnPosition.getX() >= 0 && this.pawnPosition.getX() < this.size),
            () -> assertTrue(this.pawnPosition.getY() >= 0 && this.pawnPosition.getY() < this.size),
            () -> assertTrue(this.knightPosition.getX() >= 0 && this.knightPosition.getX() < this.size),
            () -> assertTrue(this.knightPosition.getY() >= 0 && this.knightPosition.getY() < this.size)
        );
    }
}