package created;

import edu.uj.po.interfaces.Position;

import java.util.List;

public abstract class MoveTemplate {
    public final List<Move> generateMoves(Position position) {
        List<Move> listOfMoves = generateMovesImpl(position);
        return listOfMoves;
    }
    public abstract List<Move> generateMovesImpl(Position position);
}
