package created;

import created.moves.*;
import edu.uj.po.interfaces.ChessPiece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;

import java.util.ArrayList;
import java.util.List;

public class Piece { // Needs logic for piece promotion
    ChessPiece pieceType;
    Color pieceColor;
    Position piecePosition;
    boolean isActive = true;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ChessPiece getPieceType() {
        return pieceType;
    }

    public void setPieceType(ChessPiece pieceType) {
        this.pieceType = pieceType;
    }

    public Color getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(Color pieceColor) {
        this.pieceColor = pieceColor;
    }

    public Position getPiecePosition() {
        return piecePosition;
    }

    public void setPiecePosition(Position piecePosition) {
        this.piecePosition = piecePosition;
    }

    public MoveTemplate getMoveTemplate() {
        return moveTemplate;
    }

    public void setMoveTemplate(MoveTemplate moveTemplate) {
        this.moveTemplate = moveTemplate;
    }

    public List<MoveMore> getListOfMoveMores() {
        return listOfMoveMores;
    }

    public void setListOfMoveMores(List<MoveMore> listOfMoveMores) {
        this.listOfMoveMores = listOfMoveMores;
    }

    MoveTemplate moveTemplate;

    List<MoveMore> listOfMoveMores = new ArrayList<>();

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
    public void executeMove(MoveMore moveMore) {
        this.piecePosition = moveMore.getTo();
        this.listOfMoveMores = moveTemplate.generateMoves(piecePosition, pieceColor);

    }
    public void eliminateImpossibleMoves(Board board) {
        List <MoveMore> listOfMovesToRemove = new ArrayList<>();
        for (MoveMore move : this.listOfMoveMores) {
            if (!board.isMovePossible(move)) {
                listOfMovesToRemove.add(move);
            }
        }
        this.listOfMoveMores.removeAll(listOfMovesToRemove);
    }
    public Piece(ChessPiece pieceType, Color pieceColor, Position piecePosition) {
        this.pieceType = pieceType;
        this.pieceColor = pieceColor;
        this.piecePosition = piecePosition;
        this.moveTemplate = setMove(pieceType);
        listOfMoveMores = moveTemplate.generateMoves(piecePosition, pieceColor);
    }
}
