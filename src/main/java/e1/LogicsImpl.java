package e1;

public class LogicsImpl implements Logics {
	
	private Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final int size;
	private final LogicsKnight logicsKnight;
	 
	public LogicsImpl(final int size, final LogicsKnight logicsKnight, final InitializerPositions inizializerPositions) {
    	this.size = size;
		this.logicsKnight = logicsKnight;
		this.pawn = inizializerPositions.initializerPawnPosition();
		this.knight = inizializerPositions.initializerKnightPosition();
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (this.logicsKnight.knightCanMove(this.knight, new Pair<>(row,col))) {
			this.knight = new Pair<>(row,col);
			return this.pawn.equals(this.knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}

	private boolean positionOutOfBounds(Pair<Integer,Integer> position) {
		return position.getX() < 0 || position.getX() > this.size ||
		position.getY() < 0 || position.getY() > this.size;
	}

	public void setKnight(final Pair<Integer, Integer> knightPosition) {
		if (positionOutOfBounds(knightPosition) || knightPosition.equals(this.pawn)) {
			throw new IllegalArgumentException();
		}
        this.knight = knightPosition;
    }
	
	public void setPawn(final Pair<Integer, Integer> pawnPosition) {
		if (positionOutOfBounds(pawnPosition) || pawnPosition.equals(this.knight)) {
			throw new IllegalArgumentException();
		}
        this.pawn = pawnPosition;
    }
}