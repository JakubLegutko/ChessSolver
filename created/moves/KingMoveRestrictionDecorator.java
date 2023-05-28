package created.moves;

import created.Move;
import created.MoveTemplate;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;

import java.util.List;

public class KingMoveRestrictionDecorator extends MoveTemplate {
    @Override
    public List<Move> generateMovesImpl(Position position, Color color) {
        return null;
    }
}
