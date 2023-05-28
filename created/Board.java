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
        this.pieces = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                fields.add(new Position(File.values()[i], Rank.values()[j]));
        setFields(fields);
    }

    public result checkResult(){
        return null;
    }


    public void addChessPiece(Position position, Color color, ChessPiece chessPiece) {
        Piece piece = new Piece(chessPiece, color, position);
        pieces.add(piece);
    }
}
