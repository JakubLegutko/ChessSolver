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
            for (Piece piece : board.getPieces()) {
                if (piece.isActive())
                    if (piece.getPieceColor() == color) {
                        List<MoveMore> possibleMoves = piece.getListOfMoveMores();
                        for (MoveMore move : possibleMoves) {
                            Board.BoardMemento memento = board.createMemento();
                            board.executeMove(move);
                            //board.printBoard();
                            //System.out.println(" ");
                            //System.out.println("Printed board for move "+ move.getFrom() + " to " + move.getTo());
                            board.recalculateMoves();
                            boolean isStalemate = canAnyPieceMoveOpposite(color);
                            if (isStalemate) {
                                return Optional.of(MoveAdapter.convertMoveMoreToMove(move));
                            }
                            board.restoreFromMemento(memento);
                        }
                    }
            }

            return Optional.empty();
        }
        public boolean canAnyPieceMoveOpposite(Color color) {
            Color oppositeColor = color == Color.WHITE ? Color.BLACK : Color.WHITE;
            if(board.getTeamMoves(oppositeColor).size() == 0)
                return true;
            else
                return false;
        }
    }



    // 1. pick piece from list
    // 2. take move from list
    // 3. generate moves based on move
    // 4. check if king can move
    // 5. check if any other piece can move
    // 6. declare stalemate or no outcome


