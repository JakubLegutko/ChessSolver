package created;

import edu.uj.po.interfaces.ChessPiece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;

public interface PieceBuilder {

    void setPieceType(ChessPiece pieceType);
    void setColor(Color color);
    void setPosition(Position position);
}
