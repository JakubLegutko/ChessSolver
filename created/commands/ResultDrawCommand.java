package created.commands;

import created.*;
import edu.uj.po.interfaces.ChessPiece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;
import util.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ResultDrawCommand extends ResultCheckerCommand {

    public ResultDrawCommand() {

    }

    @Override
    public Optional<Move> checkResultImpl(Color color, Board board) {
        return Optional.empty();
    }
}


    // 1. pick piece from list
    // 2. take move from list
    // 3. generate moves based on move
    // 4. check if king can move
    // 5. check if any other piece can move
    // 6. declare stalemate or no outcome


