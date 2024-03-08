package e1;

public class LogicsKnightImpl implements LogicsKnight {

    private final int size;

    public LogicsKnightImpl(final int size) {
        this.size = size;
    }

    @Override
    public boolean knightCanMove(final Pair<Integer,Integer> startingPosition, final Pair<Integer,Integer> destinationPosition) {
        if (destinationPosition.getX() < 0 || destinationPosition.getY() < 0 ||
            destinationPosition.getX() >= this.size || destinationPosition.getY() >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		int x = destinationPosition.getX() - startingPosition.getX();
		int y = destinationPosition.getY() - startingPosition.getY();
        if (x!=0 && y!=0 && Math.abs(x) + Math.abs(y) == 3) {
            return true;
        }
        return false;
    }
}
