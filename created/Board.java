package created;

import created.commands.ResultDrawCommand;
import created.commands.ResultWinCommand;
import edu.uj.po.interfaces.*;
import util.result;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board {
    List<Piece> pieces;
    List<Position> fields = new ArrayList<>();
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

    public BoardSaveState createSaveState() {
        return new BoardSaveState(this, pieces, fields);
    }

    public Optional<Move> checkResult(Color color, result result) {
        for (Piece existingPiece : pieces) {
            existingPiece.eliminateImpossibleMoves(this);
        }
        if (result == result.CHECKMATE)
            resultCheckerCommand = new ResultWinCommand();
        else //(result == result.STALEMATE)
            resultCheckerCommand = new ResultDrawCommand();
        return resultCheckerCommand.checkResult(color, this);
    }

    public void printBoard() {
        for (int rank = 7; rank >= 0; rank--) {
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


    public void addChessPiece(Position position, Color color, ChessPiece chessPiece) {
        Piece piece = new Piece(chessPiece, color, position);
        pieces.add(piece);

    }

    public List<Piece> getTeam(Color color) {
        List<Piece> pieces = new ArrayList<>();
        for (Piece piece : this.pieces) {
            if (piece.getPieceColor() == color) {
                pieces.add(piece);
            }
        }
        return pieces;

    }
    public List<MoveMore> getTeamMoves(Color color) {
        List<MoveMore> moves = new ArrayList<>();
        for (Piece piece : this.pieces) {
            if (piece.getPieceColor() == color) {
                moves.addAll(piece.listOfMoveMores);
            }
        }
        return moves;

    }

    public boolean isMovePossibleNoSelfCheck(MoveMore move) {
        Piece piece = getPieceAtPosition(move.getFrom());
        Piece king = getTeam(piece.getPieceColor()).stream().filter(p -> p.pieceType == ChessPiece.KING).findFirst().get();
        boolean isMovePossible = true;
        // is destination field occupied by enemy piece and move is not pawn move only?
        if (getPieceAtPosition(move.getTo()) != null && getPieceAtPosition(move.getTo()).pieceColor != piece.getPieceColor() && piece.pieceType != ChessPiece.PAWN && move.isHit() != true)
            isMovePossible = false;
        // is field occupied by friendly piece?
        if (getPieceAtPosition(move.getTo()) != null && getPieceAtPosition(move.getTo()).pieceColor == piece.getPieceColor())
            isMovePossible = false;

        return isMovePossible;
    }
// Not sure if code below accounts for hits, added isActive to piece class
    public boolean isMovePossible(MoveMore move) {
        Piece piece = getPieceAtPosition(move.getFrom());
        Piece king = getTeam(piece.getPieceColor()).stream().filter(p -> p.pieceType == ChessPiece.KING).findFirst().get();
        boolean isMovePossible = true;
        // is destination field occupied by enemy piece and move is not pawn move only?
        if (getPieceAtPosition(move.getTo()) != null && getPieceAtPosition(move.getTo()).pieceColor != piece.getPieceColor() && piece.pieceType != ChessPiece.PAWN && move.isHit() != true)
            isMovePossible = false;
        // is field occupied by friendly piece?
        if (getPieceAtPosition(move.getTo()) != null && getPieceAtPosition(move.getTo()).pieceColor == piece.getPieceColor())
            isMovePossible = false;

        // will the move result in check of self?
        if (getTeam(piece.getPieceColor()).stream().noneMatch(p -> p.listOfMoveMores.stream().filter(m -> m.getTo().equals(king.getPiecePosition())).noneMatch(m -> isMovePossibleNoSelfCheck(m)))) {
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
        return isMovePossible;
    }

    public void deactivatePieceAtPosition(Position to) {
        getPieceAtPosition(to).setActive(false);
    }
}

