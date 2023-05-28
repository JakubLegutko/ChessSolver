package created.moves;

import created.Move;
import created.MoveTemplate;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;
import edu.uj.po.interfaces.File;

import java.util.ArrayList;
import java.util.List;

public class PawnMove extends MoveTemplate {
    List <Position> startingPositionsWhite = new ArrayList<>();
    List <Position> startingPositionsBlack = new ArrayList<>();
    public PawnMove() {
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
    public List<Move> generateMovesImpl(Position position, Color color) {
        List <Move> listOfMoves = new ArrayList<>();
        Rank rank [] = Rank.values();
        File file [] = File.values();

        if (startingPositionsBlack.contains(position) && color == Color.BLACK) {
            listOfMoves.add(new Move(position, new Position(position.file(), Rank.FIFTH),false));
        }
        else if (startingPositionsWhite.contains(position) && color == Color.WHITE) {
            listOfMoves.add(new Move(position, new Position(position.file(), Rank.FOURTH),false));
        }

            if (color == Color.BLACK) {
                listOfMoves.add(new Move(position, new Position(position.file(), rank[position.rank().ordinal() - 1]),false));
                if (position.file().ordinal() < 7) // add hits if possible
                    listOfMoves.add(new Move(position, new Position(file[position.file().ordinal() + 1], rank[position.rank().ordinal() - 1]),true));
                if (position.file().ordinal() > 0)
                    listOfMoves.add(new Move(position, new Position(file[position.file().ordinal() - 1], rank[position.rank().ordinal() - 1]),true));
            }
            else {
                listOfMoves.add(new Move(position, new Position(position.file(), rank[position.rank().ordinal() + 1]),false));
                if (position.file().ordinal() < 7) // add hits if possible
                    listOfMoves.add(new Move(position, new Position(file[position.file().ordinal() + 1], rank[position.rank().ordinal() + 1]),true));
                if (position.file().ordinal() > 0)
                    listOfMoves.add(new Move(position, new Position(file[position.file().ordinal() - 1], rank[position.rank().ordinal() + 1]),true));
        }


        return listOfMoves;
    }
}
