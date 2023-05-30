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
            Color oppositeColor = color == Color.WHITE ? Color.BLACK : Color.WHITE;

            // Check if the opposite color's king is in check
            if (!isKingInCheck(oppositeColor)) {
                return false; // King is not in check, not a checkmate
            }

            // Iterate through all the pieces of the opposite color
            for (Piece piece : board.getPieces()) {
                if (piece.getPieceColor() == oppositeColor) {
                    // Get all possible moves for the piece
                    List<MoveMore> possibleMoves = piece.getListOfMoveMores();

                    // Try each move and see if it eliminates the check
                    for (MoveMore move : possibleMoves) {
                        applyMove(move, board, piece); // Apply the move

                        // Check if the opposite color's king is still in check
                        if (!isKingInCheck(oppositeColor)) {
                            undoMove(move); // Undo the move
                            return false; // King is not in check, not a checkmate
                        }

                        undoMove(move); // Undo the move
                    }
                }
            }

            return true; // If no moves can eliminate the check, it's a checkmate
        }

    private boolean isKingInCheck(Color oppositeColor) {
        // Find the position of the king of the specified color
        Position kingPosition = findKingPosition(oppositeColor);

        // Iterate through all the pieces of the opposite color
        for (Piece piece : board.getPieces()) {
            if (piece.getPieceColor() != oppositeColor) {
                // Get all possible moves for the piece
                List<MoveMore> possibleMoves = piece.getListOfMoveMores();

                // Check if any move can capture the king
                for (MoveMore move : possibleMoves) {
                    if (move.getTo().equals(kingPosition) && move.isHit()) {
                        return true; // King is in check
                    }
                }
            }
        }

        return false; // King is not in check
    }

    private Position findKingPosition(Color color) {
        // Iterate through all the pieces and find the king of the specified color
        for (Piece piece : board.getPieces()) {
            if (piece.getPieceColor() == color && piece.getPieceType() == ChessPiece.KING) {
                return piece.getPiecePosition();
            }
        }

        return null; // King not found very bad
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

