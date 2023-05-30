package created;

import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;

public class MoveAdapter {
    public static Move convertMoveMoreToMove(MoveMore moveMore) {
        Position initialPosition = moveMore.getFrom();
        Position finalPosition = moveMore.getTo();
        return new Move(initialPosition, finalPosition);
    }
}