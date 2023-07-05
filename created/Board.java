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
    MoveValidator moveValidator = new MoveValidator();
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

    public void executeMove(MoveMore moveMore) {
        Piece piece = getPieceAtPosition(moveMore.getFrom());
        if (piece == null) {
            throw new IllegalArgumentException("No piece at position " + moveMore.getFrom());
        }
        if (getPieceAtPosition(moveMore.getTo()) != null) {
            deactivatePieceAtPosition(moveMore.getTo());
        }
        piece.setPiecePosition(moveMore.getTo());
        // calculate where the pawn will land after en passant and set its position
        if (moveMore.isEnPassant()) {
            Position enPassantPosition = new Position(moveMore.getTo().file(), moveMore.getFrom().rank());
            deactivatePieceAtPosition(enPassantPosition);
        }


        recalculateMoves();
    }

    public void recalculateMoves() {
        for (Piece existingPiece : pieces) {
            existingPiece.recalculateOwnMoves();

        }
        for (Piece existingPiece : pieces) {
            List<MoveMore> listOfMovesToRemove = new ArrayList<>();
            for (MoveMore move : existingPiece.listOfMoveMores) {
                if (!moveValidator.validateMove(move, this)) {
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


    public void deactivatePieceAtPosition(Position to) {
        getPieceAtPosition(to).setActive(false);
    }
}
    //Verify that isMovePossible is working correctly
//    public static void main(String[] args){
//        Board board = new Board();
//        board.addChessPiece(new Position(File.e, Rank.FIRST), Color.WHITE, ChessPiece.KING);
//        board.addChessPiece(new Position(File.e, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
//        board.addChessPiece(new Position(File.e, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
//        board.addChessPiece(new Position(File.e, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
//        board.recalculateMoves();
//        board.printBoard();
//        System.out.println(board.moveValidator.validateMove(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SECOND), true, false),board)); //false
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SECOND), false, false))); //false
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SEVENTH), true, false))); //false
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.d, Rank.SEVENTH), true, false))); //true
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.f, Rank.SEVENTH), false, false))); //true
//        board.addChessPiece(new Position(File.d, Rank.SECOND), Color.WHITE, ChessPiece.ROOK);
//        board.recalculateMoves();
//        board.printBoard();
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SECOND), true, false))); //false
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SECOND), false, false))); //false
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SEVENTH), true, false))); //false
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.d, Rank.SEVENTH), true, false))); //false, king moves to checked spot
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.f, Rank.SEVENTH), true, false))); //true
//        board.addChessPiece(new Position(File.a, Rank.FIRST), Color.BLACK, ChessPiece.ROOK);
//        board.recalculateMoves();
//        board.printBoard();
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SECOND), true, false))); //false
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SECOND), false, false))); //false
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.e, Rank.SEVENTH), true, false))); //false
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.d, Rank.SEVENTH), true, false))); //false, king moves to checked spot
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.f, Rank.SEVENTH), true, false))); //true
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.FIRST), new Position(File.f, Rank.FIRST), true, false))); //false, king moves to checked spot but only on paper, would have to recalculate after move
//        board.addChessPiece(new Position(File.f, Rank.SIXTH), Color.BLACK, ChessPiece.ROOK);
//        board.recalculateMoves();
//        board.printBoard();
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.f, Rank.SEVENTH), true, false))); //true
//        board.addChessPiece(new Position(File.f, Rank.SECOND), Color.WHITE, ChessPiece.ROOK);
//        board.recalculateMoves();
//        board.printBoard();
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.e, Rank.EIGHTH), new Position(File.f, Rank.SEVENTH), true, false))); //true, king is shielded by rook ERROR!
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.f, Rank.SECOND), new Position(File.f, Rank.SEVENTH), true, false))); //false, queen can't pass through rook
//        System.out.println(board.isMovePossible(new MoveMore(new Position(File.f, Rank.SECOND), new Position(File.f, Rank.SIXTH), true, false))); //true, queen can capture rook
//
//    }
//}

