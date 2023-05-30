package created.moves;

import created.MoveMore;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;

import java.util.ArrayList;
import java.util.List;

public class KingMoveRestrictionDecorator extends QueenMove {

    @Override
    public List<MoveMore> generateMovesImpl(Position position, Color color) {
        List<MoveMore> listOfMoveMores = super.generateMovesImpl(position, color);
        List<MoveMore> listOfMovesToRemove = new ArrayList<>();
        for (MoveMore moveMore : listOfMoveMores) {
            if (Math.abs(moveMore.getTo().file().ordinal() - moveMore.getFrom().file().ordinal()) > 1 ||
                    Math.abs(moveMore.getTo().rank().ordinal() - moveMore.getFrom().rank().ordinal()) > 1) {
                listOfMovesToRemove.add(moveMore);
            }
        }
        listOfMoveMores.removeAll(listOfMovesToRemove);
        return listOfMoveMores;
    }
}
