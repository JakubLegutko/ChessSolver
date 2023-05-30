package created;

import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import util.result;

import java.util.Optional;

public abstract class ResultCheckerCommand {
    public final Optional<Move> checkResult(Color color, Board board) {
        Optional<Move> move = checkResultImpl(color, board);
        return move;
    }

    public abstract Optional <Move> checkResultImpl(Color color, Board board);

}
