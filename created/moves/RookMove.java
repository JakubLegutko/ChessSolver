package created.moves;

import created.MoveMore;
import created.MoveTemplate;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.File;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;

import java.util.ArrayList;
import java.util.List;

public class RookMove extends MoveTemplate {
    @Override
    public List<MoveMore> generateMovesImpl(Position position, Color color) {
        Rank rank [] = Rank.values();
        File file [] = File.values();
        List<MoveMore> listOfMoveMores = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (i != position.file().ordinal()) // skip standing still
                listOfMoveMores.add(new MoveMore(position, new Position(file[i],rank[position.rank().ordinal()]), true));
        }
        for (int i = 0; i < 8; i++) {
            if (i != position.rank().ordinal()) // skip standing still
                listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal()],rank[i]), true));
        }
        return listOfMoveMores;
    }
}
