package created.moves;

import created.MoveMore;
import created.MoveTemplate;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.File;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;

import java.util.ArrayList;
import java.util.List;

public class KnightMove extends MoveTemplate {
    @Override
    public List<MoveMore> generateMovesImpl(Position position, Color color) {
        Rank[] ranks = Rank.values();
        File[] files = File.values();
        List<MoveMore> listOfMoveMores = new ArrayList<>();

        int[] knightOffsets = { -2, -1, 1, 2 };

        for (int offset1 : knightOffsets) {
            for (int offset2 : knightOffsets) {
                if (Math.abs(offset1) != Math.abs(offset2)) {
                    int fileIndex = position.file().ordinal() + offset1;
                    int rankIndex = position.rank().ordinal() + offset2;
                    if (isValidIndex(fileIndex) && isValidIndex(rankIndex)) {
                        Position targetPosition = new Position(files[fileIndex], ranks[rankIndex]);
                        listOfMoveMores.add(new MoveMore(position, targetPosition, true, false));
                    }
                }
            }
        }

        return listOfMoveMores;
    }

    boolean isValidIndex(int index) {
        return index >= 0 && index < 8;
    }
}
