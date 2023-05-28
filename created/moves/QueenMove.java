package created.moves;

import created.Move;
import created.MoveTemplate;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;

import java.util.List;

public class QueenMove extends MoveTemplate {
    //Composition of Rook and Bishop moves
    @Override
    public List<Move> generateMovesImpl(Position position, Color color) {
        RookMove rookMove = new RookMove();
        BishopMove bishopMove = new BishopMove();
        List<Move> listOfRookMoves = rookMove.generateMovesImpl(position, color);
        List<Move> listOfBishopMoves = bishopMove.generateMovesImpl(position, color);
        List<Move> listOfMoves = listOfRookMoves;
        listOfMoves.addAll(listOfBishopMoves);
        return listOfMoves;
    }

}
