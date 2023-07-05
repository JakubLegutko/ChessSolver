package created;


import edu.uj.po.interfaces.*;

public class MoveValidator {
    public boolean validateMove(MoveMore move, Board board) {
            if (board.getPieceAtPosition(move.getFrom()) == null)
                System.out.println("No piece at position " + move.getFrom());
            // filter only legal en passant moves
            if (move.isEnPassant() && board.getPieceAtPosition(move.getTo()) == null)
                return false;
            Color oppositeColor = board.getPieceAtPosition(move.getFrom()).getPieceColor() == Color.WHITE ? Color.BLACK : Color.WHITE;
            Piece piece = board.getPieceAtPosition(move.getFrom());
            boolean isMovePossible = true;
            // is destination field occupied by enemy piece and move is not pawn move only?
            if (board.getPieceAtPosition(move.getTo()) != null && board.getPieceAtPosition(move.getTo()).pieceColor != piece.getPieceColor()
                    && piece.pieceType == ChessPiece.PAWN
                    && !move.isHit())
                isMovePossible = false;


            // is field occupied by friendly piece?
            if (board.getPieceAtPosition(move.getTo()) != null && board.getPieceAtPosition(move.getTo()).getPieceColor() == piece.getPieceColor())
                isMovePossible = false;
            // is destination empty and move is pawn attack?
            if (board.getPieceAtPosition(move.getTo()) == null && piece.pieceType == ChessPiece.PAWN && move.isHit())
                isMovePossible = false;



            // is there anything between the start and end position and piece is not knight?
            if (piece.pieceType != ChessPiece.KNIGHT) {
                if (move.getFrom().file() == move.getTo().file()) {
                    int rankFrom = move.getFrom().rank().ordinal();
                    int rankTo = move.getTo().rank().ordinal();
                    int rankDifference = rankTo - rankFrom;
                    int rankDirection = rankDifference / Math.abs(rankDifference);
                    for (int i = 1; i < Math.abs(rankDifference); i++) {
                        Position position = new Position(move.getFrom().file(), Rank.values()[rankFrom + i * rankDirection]);
                        if (board.getPieceAtPosition(position) != null) {
                            isMovePossible = false;
                        }
                    }
                } else if (move.getFrom().rank() == move.getTo().rank()) {
                    int fileFrom = move.getFrom().file().ordinal();
                    int fileTo = move.getTo().file().ordinal();
                    int fileDifference = fileTo - fileFrom;
                    int fileDirection = fileDifference / Math.abs(fileDifference);
                    for (int i = 1; i < Math.abs(fileDifference); i++) {
                        Position position = new Position(File.values()[fileFrom + i * fileDirection], move.getFrom().rank());
                        if (board.getPieceAtPosition(position) != null) {
                            isMovePossible = false;
                        }
                    }
                } else if (Math.abs(move.getFrom().file().ordinal() - move.getTo().file().ordinal()) == Math.abs(move.getFrom().rank().ordinal() - move.getTo().rank().ordinal())) {
                    int fileFrom = move.getFrom().file().ordinal();
                    int fileTo = move.getTo().file().ordinal();
                    int fileDifference = fileTo - fileFrom;
                    int fileDirection = fileDifference / Math.abs(fileDifference);
                    int rankFrom = move.getFrom().rank().ordinal();
                    int rankTo = move.getTo().rank().ordinal();
                    int rankDifference = rankTo - rankFrom;
                    int rankDirection = rankDifference / Math.abs(rankDifference);
                    for (int i = 1; i < Math.abs(fileDifference); i++) {
                        Position position = new Position(File.values()[fileFrom + i * fileDirection], Rank.values()[rankFrom + i * rankDirection]);
                        if (board.getPieceAtPosition(position) != null) {
                            isMovePossible = false;
                        }

                    }
                }
            }
//         is destination under attack and piece moving is king?
//            if (piece.pieceType == ChessPiece.KING) {
//                for (MoveMore movee : board.getTeamMoves(oppositeColor)) {
//                    if (movee.getTo().equals(move.getTo())) {
//                        isMovePossible = false;
//                    }
//                }
//
//            }
            return isMovePossible;
        }
}