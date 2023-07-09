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
    Board board;
    @Override
        public Optional<Move> checkResultImpl(Color color, Board boards) {
            this.board = boards;
            board.printBoard();
            for (Piece piece : board.getPieces()) {
                if (piece.isActive())
                    if (piece.getPieceColor() == color) {
                        List<MoveMore> possibleMoves = piece.getListOfMoveMores();
                        for (MoveMore move : possibleMoves) {
                            Board.BoardMemento memento = board.createMemento();
                            board.executeMove(move);
                            //board.printBoard();
                            boolean isStalemate = isStalemate(color);
                            if (isStalemate) {
                                return Optional.of(MoveAdapter.convertMoveMoreToMove(move));
                            }
                            board.restoreFromMemento(memento);
                        }
                    }
            }

            return Optional.empty();
        }
        public boolean isStalemate(Color color) {
            Color oppositeColor = color == Color.WHITE ? Color.BLACK : Color.WHITE;
            List<MoveMore> leftMoves = new ArrayList<>();
            if(board.getTeamMoves(oppositeColor).isEmpty()) {
                if(!isKingInCheck(color) && !isKingInCheck(oppositeColor)) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else // Make sure that any leftover moves are legal (do not result in check of king)
            {
                Piece enemyKing = board.getPieceAtPosition(findKingPosition(color));

                for (MoveMore move : board.getTeamMoves(oppositeColor)) {

                    // Will the move place the king next to enemy king?
                if (board.getPieceAtPosition(move.getFrom()).getPieceType() == ChessPiece.KING) {
                    if (Math.abs(move.getTo().file().ordinal() - enemyKing.getPiecePosition().file().ordinal()) <= 1
                            && Math.abs(move.getTo().rank().ordinal() - enemyKing.getPiecePosition().rank().ordinal()) <= 1) {
                        leftMoves.add(move);
                        continue;
                    }
                }

                // Will the move place the king in a position diagonally next to enemy pawn?
                    if (board.getPieceAtPosition(move.getFrom()).getPieceType() == ChessPiece.KING) {
                        boolean hasPawn = false;

        List<Position> positions = board.getDiagonalAdjacentPositions(move.getTo());
        for (Position position : positions) {
            if (board.getPieceAtPosition(position) != null)
                if (board.getPieceAtPosition(position).getPieceType() == ChessPiece.PAWN
                    && board.getPieceAtPosition(position).getPieceColor() == color) {
                    hasPawn = true;
            }
        }
        if (hasPawn) {
            leftMoves.add(move);
            continue;
        }
                    }



                    if (isKingInCheck(oppositeColor) )
                        return false;
                    Board.BoardMemento memento = board.createMemento();
                    board.executeMove(move);
                    //board.printBoard();
                    boolean wasChecked = isKingInCheck(color);
                    boolean wasEnemyChecked = isKingInCheck(oppositeColor);
                    board.restoreFromMemento(memento);
                    if (wasEnemyChecked) {
                        leftMoves.add(move);

                    }

                }

            }
            if (leftMoves.size() == board.getTeamMoves(oppositeColor).size()) {
                return true;
            }
            else {
                return false;
            }
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


    private Position findKingPosition(Color oppositeColor) {
        for (Piece piece : board.getPieces()) {
            if (piece.getPieceType() == ChessPiece.KING && piece.getPieceColor() == oppositeColor) {
                return piece.getPiecePosition();
            }
        }
        return null;
    }
}



    // 1. pick piece from list
    // 2. take move from list
    // 3. generate moves based on move
    // 4. check if king can move
    // 5. check if any other piece can move
    // 6. declare stalemate or no outcome


