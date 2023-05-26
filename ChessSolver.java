import created.Board;
import edu.uj.po.interfaces.*;

import java.util.Optional;


public class ChessSolver implements Solver, Setup {
    Board board;
    public ChessSolver() {
    }

    @Override
    public Optional<Move> findMateInOneMove(Color color) {
        return Optional.empty();
    }

    @Override
    public Optional<Move> findStalemateInOneMove(Color color) {
        return Optional.empty();
    }

    @Override
    public void reset() {
        Board board = new Board();
    }

    @Override
    public void addChessPiece(Position position, Color color, ChessPiece piece) {
        board.addChessPiece(position, color, piece);
    }
}
