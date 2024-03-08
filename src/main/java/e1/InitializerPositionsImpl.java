package e1;

import java.util.Random;

public class InitializerPositionsImpl implements InitializerPositions {

    private final Random random = new Random();
    final int size;
    private Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;

    public InitializerPositionsImpl(final int size) {
        this.size = size;
        this.pawn = randomEmptyPosition();
        this.knight = randomEmptyPosition();
    }

    private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }

    @Override
    public Pair<Integer,Integer> initializerPawnPosition() {
        return this.pawn;
    }

    @Override
    public Pair<Integer,Integer> initializerKnightPosition() {
        return this.knight;
    }
}