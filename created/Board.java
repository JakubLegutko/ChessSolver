package created;

import created.commands.ResultDrawCommand;
import created.commands.ResultWinCommand;
import edu.uj.po.interfaces.*;
import util.result;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Board  {
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
        if(result == result.CHECKMATE)
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
                    System.out.print("[ ]");
                    continue;
                }
                String symbol = String.valueOf(ChessPieceAsUnicode.getSymbol(piece.pieceType, piece.pieceColor));
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private Piece getPieceAtPosition(Position position) {
        for (Piece piece : pieces) {
            if (piece.getPiecePosition().equals(position)) {
                return piece;
            }
        }

        return null;
    }



    public void addChessPiece(Position position, Color color, ChessPiece chessPiece) {
        Piece piece = new Piece(chessPiece, color, position);
        pieces.add(piece);
    }
}
