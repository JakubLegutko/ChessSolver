package created;

import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;

import java.util.List;

public abstract class MoveTemplate {
    public final List<Move> generateMoves(Position position, Color color) {
        List<Move> listOfMoves = generateMovesImpl(position, color);
        return listOfMoves;
    }
    public abstract List<Move> generateMovesImpl(Position position, Color color);
}
