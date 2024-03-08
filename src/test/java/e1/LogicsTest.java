package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LogicsTest {

  private LogicsImpl logic;
  private int size = 5;
  private LogicsKnightImpl logicsKnight;
  private InitializerPositionsImpl initializerPositions;

  @BeforeEach
  void init() {
    this.logicsKnight = new LogicsKnightImpl(size);
    this.initializerPositions = new InitializerPositionsImpl(size);
    this.logic = new LogicsImpl(size, logicsKnight, initializerPositions);
  }

  private Pair<Integer,Integer> getPawn() {
    for (int i=0; i<this.size; i++) { // for each row
      for (int j=0; j<this.size; j++) { // for each column
        if (this.logic.hasPawn(i,j)) {
          return new Pair<Integer,Integer>(i, j);
        }
      }
    }
    return null;
  }

  private Pair<Integer,Integer> getKnight() {
    for (int i=0; i<this.size; i++) { // for each row
      for (int j=0; j<this.size; j++) { // for each column
        if (this.logic.hasKnight(i,j)) {
          return new Pair<Integer,Integer>(i, j);
        }
      }
    }
    return null;
  }

  @Test
  void testNotConflictRandomPositions() {
    assertNotEquals(this.getPawn(), this.getKnight());
  }

  @Test
  void testIsPawnInLimit() {
    assertAll(
      () -> assertTrue(this.getPawn().getX() >= 0),
      () -> assertTrue(this.getPawn().getY() >= 0),
      () -> assertTrue(this.getPawn().getX() < this.size),
      () -> assertTrue(this.getPawn().getY() < this.size)
    );
  }

  @Test
  void testIsKnightInLimit() {
    assertAll(
      () -> assertTrue(this.getKnight().getX() >= 0),
      () -> assertTrue(this.getKnight().getY() >= 0),
      () -> assertTrue(this.getKnight().getX() < this.size),
      () -> assertTrue(this.getKnight().getY() < this.size)
    );
  }

  @Test
  void testHit() {
    this.logic.setPawn(new Pair<Integer,Integer>(1,1));
    this.logic.setKnight(new Pair<Integer,Integer>(this.getPawn().getX() + 2, this.getPawn().getY() + 1));
    assertAll(
      () -> assertThrows(IndexOutOfBoundsException.class, () -> {
        this.logic.hit(6, 6);
      }),
      () -> assertFalse(this.logic.hit(0,0)),
      () -> assertFalse(this.logic.hit(2,2)),
      () -> assertTrue(this.logic.hit(this.getKnight().getX() - 2, this.getKnight().getY() - 1))
    );
  }

  @Test
  void testHasKnight() {
    this.logic.setKnight(new Pair<Integer,Integer>(1,1));
    assertTrue(this.logic.hasKnight(1, 1));
  }

  @Test
  void testHasPawn() {
    this.logic.setPawn(new Pair<Integer,Integer>(4,4));
    assertTrue(this.logic.hasPawn(4, 4));
  }

  @Test
  void testSetPawnOnKnight() {
    this.logic.setKnight(new Pair<Integer,Integer>(1,1));
    assertThrows(IllegalArgumentException.class, () -> {
      this.logic.setPawn(new Pair<Integer,Integer>(1,1));
    });
  } 
}