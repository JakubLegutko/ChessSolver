package created.moves;

import created.MoveMore;
import created.MoveTemplate;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.File;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class BishopMove extends MoveTemplate {
    @Override
    public List<MoveMore> generateMovesImpl(Position position, Color color) {
        Rank rank [] = Rank.values();
        File file [] = File.values();
        List<MoveMore> listOfMoveMores = new ArrayList<>();

        int currentFileOrdinal = position.file().ordinal();
        int currentRankOrdinal = position.rank().ordinal();

// Generate top-right diagonal moves
        for (int i = 1; currentFileOrdinal + i < 8 && currentRankOrdinal - i >= 0; i++) {
            listOfMoveMores.add(new MoveMore(position, new Position(file[currentFileOrdinal + i], rank[currentRankOrdinal - i]), true));
        }

// Generate top-left diagonal moves
        for (int i = 1; currentFileOrdinal - i >= 0 && currentRankOrdinal - i >= 0; i++) {
            listOfMoveMores.add(new MoveMore(position, new Position(file[currentFileOrdinal - i], rank[currentRankOrdinal - i]), true));
        }

// Generate bottom-right diagonal moves
        for (int i = 1; currentFileOrdinal + i < 8 && currentRankOrdinal + i < 8; i++) {
            listOfMoveMores.add(new MoveMore(position, new Position(file[currentFileOrdinal + i], rank[currentRankOrdinal + i]), true));
        }

// Generate bottom-left diagonal moves
        for (int i = 1; currentFileOrdinal - i >= 0 && currentRankOrdinal + i < 8; i++) {
            listOfMoveMores.add(new MoveMore(position, new Position(file[currentFileOrdinal - i], rank[currentRankOrdinal + i]), true));
        }

        return listOfMoveMores;
    }
}
