package created;

import edu.uj.po.interfaces.*;
import util.result;

import java.util.ArrayList;
import java.util.List;

public class Board implements ResultCheckerCommand, PieceIterator {
    List<Piece> pieces;
    List<Position> fields = new ArrayList<>();

    public void setFields(List<Position> fields) {
        this.fields = fields;
    }

    public Board() {
        this.pieces = null;
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                fields.add(new Position(File.values()[i], Rank.values()[j]));
        setFields(fields);
    }

    public result checkResult(){
        return null;
    }


    public void addChessPiece(Position position, Color color, ChessPiece chessPiece) {
        PieceBuilder pieceBuilder = new PieceBuilderImpl();
        pieceBuilder.setPieceType(chessPiece);
        pieceBuilder.setColor(color);
        pieceBuilder.setPosition(position);
        Piece piece = new Piece(pieceBuilder);
        pieces.add(piece);
    }
}
