package created;

import created.commands.ResultDrawCommand;
import created.commands.ResultWinCommand;
import edu.uj.po.interfaces.*;
import util.result;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {
    private List<Piece> pieces;
    private List<Position> fields = new ArrayList<>();
    ResultCheckerCommand resultCheckerCommand;

    public void setFields(List<Position> fields) {
        this.fields = fields;
    }

    public List<Position> getFields() {
        return fields;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public Board() {
        this.pieces = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                fields.add(new Position(File.values()[i], Rank.values()[j]));
        setFields(fields);

    }


    public Optional<Move> checkResult(Color color, result result) {
        recalculateMoves();
        if (result == result.CHECKMATE)
            resultCheckerCommand = new ResultWinCommand();
        else //(result == result.STALEMATE)
            resultCheckerCommand = new ResultDrawCommand();
        return resultCheckerCommand.checkResult(color, this);
    }

    public void executeMove(MoveMore moveMore){
        Piece piece = getPieceAtPosition(moveMore.getFrom());
        if (piece == null) {
            throw new IllegalArgumentException("No piece at position " + moveMore.getFrom());
        }
        if (getPieceAtPosition(moveMore.getTo()) != null) {
            deactivatePieceAtPosition(moveMore.getTo());
        }
        piece.setPiecePosition(moveMore.getTo());
        recalculateMoves();
    }

    public void recalculateMoves() {
        for (Piece existingPiece : pieces) {
            existingPiece.recalculateOwnMoves();

        }
        for (Piece existingPiece : pieces) {
            List<MoveMore> listOfMovesToRemove = new ArrayList<>();
            for (MoveMore move : existingPiece.listOfMoveMores){
                if (!isMovePossible(move)){
                    listOfMovesToRemove.add(move);
                }
            }
            existingPiece.listOfMoveMores.removeAll(listOfMovesToRemove);
        }
    }
    //    public void eliminateImpossibleMoves(Board board) {
//        if (!isActive) {
//            this.listOfMoveMores.clear();
//            return;
//        }
//        List <MoveMore> listOfMovesToRemove = new ArrayList<>();
//        for (MoveMore move : this.listOfMoveMores) {
//            if (!board.isMovePossible(move)) {
//                listOfMovesToRemove.add(move);
//            }
//        }
//        this.listOfMoveMores.removeAll(listOfMovesToRemove);
//    }
    public void printBoard() {
        System.out.println("New board:");
        System.out.println("   A   B   C   D   E   F   G   H");
        for (int rank = 7; rank >= 0; rank--) {
            System.out.print(rank + 1 + " ");
            for (int file = 0; file < 8; file++) {
                Position position = new Position(File.values()[file], Rank.values()[rank]);
                Piece piece = getPieceAtPosition(position);
                if (piece == null) {
                    System.out.print("[  ]");
                    continue;
                }
                String symbol = String.valueOf(ChessPieceAsUnicode.getSymbol(piece.pieceType, piece.pieceColor));
                System.out.print("[" + symbol + "]");
            }
            System.out.println();
        }
    }

    public Piece getPieceAtPosition(Position position) {
        for (Piece piece : pieces) {
            if (piece.getPiecePosition().equals(position) && piece.isActive()) {
                return piece;
            }
        }

        return null;
    }
    public BoardMemento createMemento() {
        return new BoardMemento(new ArrayList<>(pieces), new ArrayList<>(fields));
    }

    public void restoreFromMemento(BoardMemento memento) {
        this.pieces = memento.getPieces();
        this.fields = memento.getFields();
        recalculateMoves();
    }

    public class BoardMemento {
        private final List<Piece> pieces;
        private final List<Position> fields;

        public List<Piece> deepCopy(List<Piece> original) {
            List<Piece> copy = new ArrayList<>(original.size());
            for (Piece piece : original) {
                copy.add(piece.clone());
            }
            return copy;
        }
        public List<Position> deepCopyFields(List<Position> original) {
            List<Position> copy = new ArrayList<>(original.size());
            for (Position position : original) {
                copy.add(new Position(position.file(), position.rank()));
            }
            return copy;
        }
        private BoardMemento(List<Piece> pieces, List<Position> fields) {
            this.pieces = deepCopy(pieces);
            this.fields = deepCopyFields(fields);
        }

        private List<Piece> getPieces() {
            return pieces;
        }

        private List<Position> getFields() {
            return fields;
        }
    }

    public void addChessPiece(Position position, Color color, ChessPiece chessPiece) {
        Piece piece = new Piece(chessPiece, color, position);
        pieces.add(piece);


    }

    public List<Piece> getTeam(Color color) {
        List<Piece> teamPieces = new ArrayList<>();
        for (Piece piece : pieces) {
            if (piece.getPieceColor() == color) {
                teamPieces.add(piece);
            }
        }
        return teamPieces;

    }
    public List<MoveMore> getTeamMovesNoKing(Color color) {
        List<MoveMore> moves = new ArrayList<>();
        for (Piece piece : pieces) {
            if (piece.getPieceColor() == color && piece.pieceType != ChessPiece.KING) {
                moves.addAll(piece.listOfMoveMores);
            }
        }
        return moves;

    }
    public List<MoveMore> getTeamMoves(Color color) {
        List<MoveMore> moves = new ArrayList<>();
        for (Piece piece : pieces) {
            if (piece.getPieceColor() == color) {
                moves.addAll(piece.listOfMoveMores);
            }
        }
        return moves;

    }
    public boolean isMovePossibleNoSelfCheck(MoveMore move) {
        if (getPieceAtPosition(move.getFrom()) == null)
            System.out.println("No piece at position " + move.getFrom());
        Piece piece = getPieceAtPosition(move.getFrom());
        Color oppositeColor = getPieceAtPosition(move.getFrom()).getPieceColor() == Color.WHITE ? Color.BLACK : Color.WHITE;
        Piece king = getTeam(piece.getPieceColor()).stream().filter(p -> p.pieceType == ChessPiece.KING).findFirst().get();
        boolean isMovePossible = true;
        // is destination field occupied by enemy piece and move is not pawn move only?
        if (getPieceAtPosition(move.getTo()) != null && getPieceAtPosition(move.getTo()).pieceColor != piece.getPieceColor() && piece.pieceType == ChessPiece.PAWN && move.isHit() != true)
            isMovePossible = false;
        // is destination empty and move is pawn attack?
        if (getPieceAtPosition(move.getTo()) == null  && piece.pieceType == ChessPiece.PAWN && move.isHit() == true)
            isMovePossible = false;

        // is field occupied by friendly piece?
        if (getPieceAtPosition(move.getTo()) != null && getPieceAtPosition(move.getTo()).pieceColor == piece.getPieceColor())
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
                    if (getPieceAtPosition(position) != null) {
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
                    if (getPieceAtPosition(position) != null) {
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
                    if (getPieceAtPosition(position) != null) {
                        isMovePossible = false;
                    }

                }
            }
        }
//        // is destination under attack and piece moving is king?
//        if (((getPieceAtPosition(move.getTo()) != null && getPieceAtPosition(move.getTo()).pieceColor != piece.getPieceColor()) || (getPieceAtPosition(move.getTo()) == null))
//                && piece.pieceType == ChessPiece.KING
//                && getTeamMoves(oppositeColor).stream().anyMatch(m -> m.getTo().equals(move.getTo())
//                && m.isHit()))
//            isMovePossible = false;
        return isMovePossible;
    }
// Not sure if code below accounts for hits, added isActive to piece class
    public boolean isMovePossible(MoveMore move) {
        if (getPieceAtPosition(move.getFrom()) == null)
            System.out.println("No piece at position " + move.getFrom());
        Color oppositeColor = getPieceAtPosition(move.getFrom()).getPieceColor() == Color.WHITE ? Color.BLACK : Color.WHITE;
        Piece piece = getPieceAtPosition(move.getFrom());
        Piece king = getTeam(piece.getPieceColor()).stream().filter(p -> p.pieceType == ChessPiece.KING).findFirst().get();
        boolean isMovePossible = true;
        // is destination field occupied by enemy piece and move is not pawn move only?
        if (getPieceAtPosition(move.getTo()) != null && getPieceAtPosition(move.getTo()).pieceColor != piece.getPieceColor()
                && piece.pieceType == ChessPiece.PAWN
                && !move.isHit())
            isMovePossible = false;


        // is field occupied by friendly piece?
        if (getPieceAtPosition(move.getTo()) != null && getPieceAtPosition(move.getTo()).getPieceColor() == piece.getPieceColor())
            isMovePossible = false;
        // is destination empty and move is pawn attack?
        if (getPieceAtPosition(move.getTo()) == null  && piece.pieceType == ChessPiece.PAWN && move.isHit())
            isMovePossible = false;
        // will the move result in check of self?
        if (getTeam(piece.getPieceColor()).stream()
                .noneMatch(p -> p.listOfMoveMores.stream()
                        .filter(m -> m.getTo().equals(king.getPiecePosition()))
                        .noneMatch(m -> isMovePossibleNoSelfCheck(m)))) {
            isMovePossible = false;
        }


        // is there anything between the start and end position and piece is not knight?
        if (piece.pieceType != ChessPiece.KNIGHT) {
            if (move.getFrom().file() == move.getTo().file()) {
                int rankFrom = move.getFrom().rank().ordinal();
                int rankTo = move.getTo().rank().ordinal();
                int rankDifference = rankTo - rankFrom;
                int rankDirection = rankDifference / Math.abs(rankDifference);
                for (int i = 1; i < Math.abs(rankDifference); i++) {
                    Position position = new Position(move.getFrom().file(), Rank.values()[rankFrom + i * rankDirection]);
                    if (getPieceAtPosition(position) != null) {
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
                    if (getPieceAtPosition(position) != null) {
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
                    if (getPieceAtPosition(position) != null) {
                        isMovePossible = false;
                    }

                }
            }
        }
//         is destination under attack and piece moving is king?
        if ( piece.pieceType == ChessPiece.KING
                && getTeamMoves(oppositeColor).stream().anyMatch(m -> m.getTo().equals(move.getTo())))
            isMovePossible = false;
        return isMovePossible;
    }

    public void deactivatePieceAtPosition(Position to) {
        getPieceAtPosition(to).setActive(false);
    }

    //Verify that isMovePossible is working correctly
    public static void main(String[] args){
        Board board = new Board();
        board.addChessPiece(new Position(File.e, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        board.addChessPiece(new Position(File.e, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        board.addChessPiece(new Position(File.e, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        board.addChessPiece(new Position(File.e, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        board.recalculateMoves();
        board.printBoard();
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SECOND), true))); //false
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SECOND), false))); //false
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SEVENTH), true))); //false
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.d, Rank.SEVENTH), true))); //true
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.f, Rank.SEVENTH), false))); //true
        board.addChessPiece(new Position(File.d, Rank.SECOND), Color.WHITE, ChessPiece.ROOK);
        board.recalculateMoves();
        board.printBoard();
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SECOND), true))); //false
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SECOND), false))); //false
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SEVENTH), true))); //false
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.d, Rank.SEVENTH), true))); //false, king moves to checked spot
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.f, Rank.SEVENTH), true))); //true
        board.addChessPiece(new Position(File.a, Rank.FIRST), Color.BLACK, ChessPiece.ROOK);
        board.recalculateMoves();
        board.printBoard();
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SECOND), true))); //false
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SECOND), false))); //false
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SEVENTH), true))); //false
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.d, Rank.SEVENTH), true))); //false, king moves to checked spot
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.f, Rank.SEVENTH), true))); //true
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.f, Rank.FIRST), true))); //false, king moves to checked spot but only on paper, would have to recalculate after move
        board.addChessPiece(new Position(File.f, Rank.SIXTH), Color.BLACK, ChessPiece.ROOK);
        board.recalculateMoves();
        board.printBoard();
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.f, Rank.SEVENTH), true))); //true
        board.addChessPiece(new Position(File.f, Rank.SECOND), Color.WHITE, ChessPiece.ROOK);
        board.recalculateMoves();
        board.printBoard();
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.f, Rank.SEVENTH), true))); //true, king is shielded by rook ERROR!
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.f, Rank.SECOND), new Position(File.f, Rank.SEVENTH), true))); //false, queen can't pass through rook
        System.out.println(board.isMovePossible(new MoveMore(new Position(File.f, Rank.SECOND), new Position(File.f, Rank.SIXTH), true))); //true, queen can capture rook

    }
}

