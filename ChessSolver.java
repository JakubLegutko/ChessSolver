import created.Board;
import edu.uj.po.interfaces.*;
import util.result;
import java.util.Optional;


public class ChessSolver implements Solver, Setup {
    Board board;
    public ChessSolver() {
        board = new Board();
    }

    @Override
    public Optional<Move> findMateInOneMove(Color color) {
        return board.checkResult(color, result.CHECKMATE);
    }

    @Override
    public Optional<Move> findStalemateInOneMove(Color color) {
        return board.checkResult(color, result.STALEMATE);
    }

    @Override
    public void reset() {
        board = new Board();
    }
    public void printBoard() {
        board.printBoard();
    }

    @Override
    public void addChessPiece(Position position, Color color, ChessPiece piece) {
        board.addChessPiece(position, color, piece);


    }
}
