package created.commands;

import created.*;
import edu.uj.po.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ResultWinCommand extends ResultCheckerCommand {
    public ResultWinCommand() {

    }
    private Board board;
@Override
    public Optional<Move> checkResultImpl(Color color, Board boards) {
        this.board = boards;
            for (Piece piece : board.getPieces()) {
                if (piece.isActive())
                    if (piece.getPieceColor() == color) {
                    List<MoveMore> possibleMoves = piece.getListOfMoveMores();
                    for (MoveMore move : possibleMoves) {
                        Board.BoardMemento memento = board.createMemento();
                        board.executeMove(move);
                        board.printBoard();
                        //System.out.println(" ");
                        //System.out.println("Printed board for move "+ move.getFrom() + " to " + move.getTo());
                        board.recalculateMoves();
//                        if (piece.getPieceType() == ChessPiece.PAWN)
//                        handleEnPassant(move);
                        boolean isCheckmate = isCheckmateOpposite(color, board, move);
                        if (isCheckmate) {
                            return Optional.of(MoveAdapter.convertMoveMoreToMove(move));
                        }
                        board.restoreFromMemento(memento);
                    }
                }
            }

            return Optional.empty();
        }


//        private void handleEnPassant(MoveMore move) {
//            if (move.isEnPassant()) {
//                Position position = move.getTo();
//                Piece piece = board.getPieceAtPosition(position);
//                board.removePiece(piece);
//            }
//        }
        private boolean isCheckmateOpposite(Color color, Board board, MoveMore move) {
            Color oppositeColor = color == Color.WHITE ? Color.BLACK : Color.WHITE;
            Piece attackingpiece = board.getPieceAtPosition(move.getTo());
            // Check if the opposite color's king is in check
            if (!isKingInCheck(oppositeColor)) {
                return false; // King is not in check, not a checkmate
            }
            boolean isCheck = true;
            for (Piece pieced : board.getPieces()) {
                if (!canKingMove(oppositeColor))
                    continue;
                if (pieced.isActive())
                    if (pieced.getPieceColor() == oppositeColor) {
                        List<MoveMore> possibleMoves = pieced.getListOfMoveMores();
                        for (MoveMore moves : possibleMoves) {
                            Board.BoardMemento memento2 = board.createMemento();
                            board.executeMove(moves);
                            board.printBoard();
                            //System.out.println("Printed board for counter "+ moves.getFrom() + " to " + moves.getTo());
                            board.recalculateMoves();
                            if(!isKingInCheck(oppositeColor))
                                isCheck = false;
                            board.restoreFromMemento(memento2);
                            board.recalculateMoves();
                            //board.printBoard();
                            //System.out.println("Counter restored");
                            if (!isCheck) {
                                return false; // King can move, not a checkmate
                            }

                        }
                    }
            }
            return isCheck; // If no moves can eliminate the check, it's a checkmate
        }

    private boolean canKingMove(Color color) {
        // Find the of the king of the specified color
        boolean canMove;
        Position kingPosition = findKingPosition(color);
        Piece king = board.getPieceAtPosition(kingPosition);
        List<MoveMore> possibleMoves = king.getListOfMoveMores();
        if (possibleMoves.size() == 0)
            canMove = false;
        else
            canMove = true;
        return canMove;
    }


    private boolean isKingInCheck(Color color) {
        // Find the position of the king of the specified color
        Position kingPosition = findKingPosition(color);
        // Iterate through all the pieces of the opposite color
        for (Piece piece : board.getPieces()) {
            if (piece.getPieceColor() != color) {
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
private boolean canBlockCheck(Color color) {
    // Find the position of the king of the specified color
    Position kingPosition = findKingPosition(color);



    return false; // Check cannot be blocked
}
private boolean canPieceBeCaptured(Piece attackingpiece) {
    Color oppositeColor = attackingpiece.getPieceColor() == Color.WHITE ? Color.BLACK : Color.WHITE;
    List<MoveMore> allTeamMoves = board.getTeamMoves(oppositeColor);
            // Check if any move can capture the piece that is checking the king
            for (MoveMore move : allTeamMoves) {
                if (move.getTo().equals(attackingpiece.getPiecePosition())) {
                    return true; // Piece can be captured
                }
            }
    return false; // Piece cannot be captured
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

