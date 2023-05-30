package created;

import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;

import java.util.List;

public abstract class MoveTemplate {
    public final List<MoveMore> generateMoves(Position position, Color color) {
        List<MoveMore> listOfMoveMores = generateMovesImpl(position, color);
        return listOfMoveMores;
    }
    public abstract List<MoveMore> generateMovesImpl(Position position, Color color);
}
