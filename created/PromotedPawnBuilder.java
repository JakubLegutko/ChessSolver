package created;

import edu.uj.po.interfaces.ChessPiece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;

public class PromotedPawnBuilder implements PieceBuilder {
    ChessPiece pieceType;
    Position position;
    Color color;
    public void setPieceType(ChessPiece pieceType) {
        this.pieceType = pieceType;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    //Builds Queen from pawn
}
