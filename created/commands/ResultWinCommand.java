package created.commands;

import created.*;
import edu.uj.po.interfaces.*;

import java.util.List;
import java.util.Optional;

public class ResultWinCommand extends ResultCheckerCommand {
    public ResultWinCommand() {

    }
    BoardSaveState boardSaveState;
    Board board;
    public Optional<Move> checkResultImpl(Color color, Board boards) {
        this.board = boards;
            for (Piece piece : board.getPieces()) {
                if (piece.getPieceColor() == color) {
                    List<MoveMore> possibleMoves = piece.getListOfMoveMores();
                    for (MoveMore move : possibleMoves) {
                        applyMove(move, board, piece);
                        boolean isCheckmate = isCheckmateOpposite(color);
                        undoMove(move);

                        if (isCheckmate) {
                            return Optional.of(MoveAdapter.convertMoveMoreToMove(move));
                        }
                    }
                }
            }

            return Optional.empty();
        }

        private void applyMove(MoveMore move, Board board, Piece piece) {
            board.createSaveState();
            piece.executeMove(move);

        }

        private void undoMove(MoveMore move) {
            if (boardSaveState != null)
                boardSaveState.restoreBoard();
        }

        private boolean isCheckmateOpposite(Color color) {
            // Check if the opposite color is in checkmate
            // Return true if checkmate, false otherwise
            return false;
        }
    }
    // 1. pick piece from list
    // 2. take move from list
    // 3. generate moves based on move
    // 4. check if enemy king is in check
    // 5. check if any other piece can move to block check
    // 6. check if any other piece can hit piece that is checking king
    // 7. check if king can move to block check
    // 8. check if king can hit piece that is checking king
    // 9. declare checkmate or no outcome

