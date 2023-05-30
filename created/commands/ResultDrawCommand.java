package created.commands;

import created.*;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import util.result;

import java.util.List;
import java.util.Optional;

public class ResultDrawCommand extends ResultCheckerCommand {

    public ResultDrawCommand() {

    }
    BoardSaveState boardSaveState;
    Board board;
    public Optional<Move> checkResultImpl(Color color, Board boards) {
        this.board = boards;
        for (Piece piece : board.getPieces()) {
            if (piece.getPieceColor() == color) {
                List<MoveMore> possibleMoves = piece.getListOfMoveMores();
                for (MoveMore move : possibleMoves) {
                    applyMove(move);
                    boolean isStalemate = isStalemateOpposite(color);
                    undoMove(move);

                    if (isStalemate) {
                        return Optional.of(MoveAdapter.convertMoveMoreToMove(move));
                    }
                }
            }
        }

        return Optional.empty();
    }

    private void applyMove(MoveMore move) {
        board.createSaveState();
        // Apply the move to the board
    }

    private void undoMove(MoveMore move) {
        boardSaveState.restoreBoard();
    }

    private boolean isStalemateOpposite(Color color) {
        // Check if the opposite color is in checkmate
        // Return true if checkmate, false otherwise
        return false;
    }
    // 1. pick piece from list
    // 2. take move from list
    // 3. generate moves based on move
    // 4. check if king can move
    // 5. check if any other piece can move
    // 6. declare stalemate or no outcome

}
