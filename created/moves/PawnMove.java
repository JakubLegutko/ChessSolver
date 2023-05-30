package created.moves;

import created.MoveMore;
import created.MoveTemplate;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;
import edu.uj.po.interfaces.File;

import java.util.ArrayList;
import java.util.List;

public class PawnMove extends MoveTemplate {
    List <Position> startingPositionsWhite;
    List <Position> startingPositionsBlack;
    public PawnMove() {
        startingPositionsBlack = new ArrayList<>();
        startingPositionsWhite = new ArrayList<>();
        startingPositionsWhite.add(new Position(File.a,Rank.SECOND));
        startingPositionsWhite.add(new Position(File.b,Rank.SECOND));
        startingPositionsWhite.add(new Position(File.c,Rank.SECOND));
        startingPositionsWhite.add(new Position(File.d,Rank.SECOND));
        startingPositionsWhite.add(new Position(File.e,Rank.SECOND));
        startingPositionsWhite.add(new Position(File.f,Rank.SECOND));
        startingPositionsWhite.add(new Position(File.g,Rank.SECOND));
        startingPositionsWhite.add(new Position(File.h,Rank.SECOND));
        startingPositionsBlack.add(new Position(File.a,Rank.SEVENTH));
        startingPositionsBlack.add(new Position(File.b,Rank.SEVENTH));
        startingPositionsBlack.add(new Position(File.c,Rank.SEVENTH));
        startingPositionsBlack.add(new Position(File.d,Rank.SEVENTH));
        startingPositionsBlack.add(new Position(File.e,Rank.SEVENTH));
        startingPositionsBlack.add(new Position(File.f,Rank.SEVENTH));
        startingPositionsBlack.add(new Position(File.g,Rank.SEVENTH));
        startingPositionsBlack.add(new Position(File.h,Rank.SEVENTH));
    }

    @Override
    public List<MoveMore> generateMovesImpl(Position position, Color color) {
        List <MoveMore> listOfMoveMores = new ArrayList<>();
        Rank rank [] = Rank.values();
        File file [] = File.values();

        if (startingPositionsBlack.contains(position) && color == Color.BLACK) {
            listOfMoveMores.add(new MoveMore(position, new Position(position.file(), Rank.FIFTH),false));
        }
        else if (startingPositionsWhite.contains(position) && color == Color.WHITE) {
            listOfMoveMores.add(new MoveMore(position, new Position(position.file(), Rank.FOURTH),false));
        }

            if (color == Color.BLACK) {
                if (position.rank().ordinal() == 0) // add promotion if possible
                    // Promotion to Queen
                    System.out.println("Promotion to Queen");
                else
                    listOfMoveMores.add(new MoveMore(position, new Position(position.file(), rank[position.rank().ordinal() - 1]),false));
                if (position.file().ordinal() < 7 && position.rank().ordinal() != 0 && position.rank().ordinal() != 7) // add hits if possible
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() + 1], rank[position.rank().ordinal() - 1]),true));
                if (position.file().ordinal() > 0 && position.rank().ordinal() != 0 && position.rank().ordinal() != 7)
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() - 1], rank[position.rank().ordinal() - 1]),true));
            }
            else {
                if (position.rank().ordinal() == 7) // add promotion if possible
                    // Promotion to Queen
                    System.out.println("Promotion to Queen");
                else
                    listOfMoveMores.add(new MoveMore(position, new Position(position.file(), rank[position.rank().ordinal() + 1]),false));
                if (position.file().ordinal() < 7 && position.rank().ordinal() != 0 && position.rank().ordinal() != 7) // add hits if possible
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() + 1], rank[position.rank().ordinal() + 1]),true));
                if (position.file().ordinal() > 0 && position.rank().ordinal() != 0 && position.rank().ordinal() != 7)
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() - 1], rank[position.rank().ordinal() + 1]),true));
        }
    // Needs logic for En Passant

        return listOfMoveMores;
    }
}
