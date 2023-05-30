package created.moves;

import created.MoveMore;
import created.MoveTemplate;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;

import java.util.List;

public class QueenMove extends MoveTemplate {
    //Composition of Rook and Bishop moves
    @Override
    public List<MoveMore> generateMovesImpl(Position position, Color color) {
        RookMove rookMove = new RookMove();
        BishopMove bishopMove = new BishopMove();
        List<MoveMore> listOfRookMoveMores = rookMove.generateMovesImpl(position, color);
        List<MoveMore> listOfBishopMoveMores = bishopMove.generateMovesImpl(position, color);
        List<MoveMore> listOfMoveMores = listOfRookMoveMores;
        listOfMoveMores.addAll(listOfBishopMoveMores);
        return listOfMoveMores;
    }

}
