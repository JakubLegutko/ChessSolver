package created;

import created.moves.*;
import edu.uj.po.interfaces.ChessPiece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    ChessPiece pieceType;
    Color pieceColor;
    Position piecePosition;
    MoveTemplate moveTemplate;

    List<Move> listOfMoves = new ArrayList<>();

    public MoveTemplate setMove(ChessPiece pieceType) {
        switch (pieceType) {
            case PAWN:
                return new PawnMove();
            case ROOK:
                return new RookMove();
            case KNIGHT:
                return new KnightMove();
            case BISHOP:
                return new BishopMove();
            case QUEEN:
                return new QueenMove();
            case KING:
                return new KingMoveRestrictionDecorator();
            default:
                return null;
        }
    }
    public Piece(ChessPiece pieceType, Color pieceColor, Position piecePosition) {
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
        this.piecePosition = piecePosition;
        this.moveTemplate = setMove(pieceType);
        listOfMoves = moveTemplate.generateMovesImpl(piecePosition, pieceColor);
    }
}
