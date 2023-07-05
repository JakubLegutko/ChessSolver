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
    QueenMove queenMove = new QueenMove();
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
            listOfMoveMores.add(new MoveMore(position, new Position(position.file(), Rank.FIFTH),false, false));
        }
        else if (startingPositionsWhite.contains(position) && color == Color.WHITE) {
            listOfMoveMores.add(new MoveMore(position, new Position(position.file(), Rank.FOURTH),false, false));
        }

            if (color == Color.BLACK) {
                if (position.rank() == Rank.FIRST) { // add promotion if possible
                    listOfMoveMores = queenMove.generateMovesImpl(position, color);
                    //System.out.println("black promotion");
                }else
                    listOfMoveMores.add(new MoveMore(position, new Position(position.file(), rank[position.rank().ordinal() - 1]),false, false));
                if (position.file().ordinal() < 7 && position.rank().ordinal() != 0 && position.rank().ordinal() != 7) // add hits if possible
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() + 1], rank[position.rank().ordinal() - 1]),true, false));
                if (position.file().ordinal() > 0 && position.rank().ordinal() != 0 && position.rank().ordinal() != 7)
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() - 1], rank[position.rank().ordinal() - 1]),true, false));
            }
            else {
                if (position.rank() == Rank.EIGHTH) { // add promotion if possible
                    listOfMoveMores = queenMove.generateMovesImpl(position, color);
                    //System.out.println("white promotion");
                }else
                    listOfMoveMores.add(new MoveMore(position, new Position(position.file(), rank[position.rank().ordinal() + 1]), false, false));
                if (position.file().ordinal() < 7 && position.rank().ordinal() != 0 && position.rank().ordinal() != 7) // add hits if possible
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() + 1], rank[position.rank().ordinal() + 1]),true, false));
                if (position.file().ordinal() > 0 && position.rank().ordinal() != 0 && position.rank().ordinal() != 7)
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() - 1], rank[position.rank().ordinal() + 1]),true, false));
        }
    // Needs logic for En Passant, add dry move (as if en passant is possible)
        if (color == Color.BLACK) {
            if (position.rank().ordinal() == 3) {
                if (position.file().ordinal() < 7)
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() + 1], rank[position.rank().ordinal() - 1]),true, true));
                if (position.file().ordinal() > 0)
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() - 1], rank[position.rank().ordinal() - 1]),true, true));
            }
        }
        else {
            if (position.rank().ordinal() == 4) {
                if (position.file().ordinal() < 7)
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() + 1], rank[position.rank().ordinal() + 1]),true, true));
                if (position.file().ordinal() > 0)
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() - 1], rank[position.rank().ordinal() + 1]),true, true));
            }
        }

        return listOfMoveMores;
    }

    //Test promotion
    public static void main(String[] args){
        PawnMove pawnMove = new PawnMove();
        List<MoveMore> moves = pawnMove.generateMovesImpl(new Position(File.a, Rank.EIGHTH), Color.WHITE);
        for (MoveMore move : moves) {
            System.out.println(move.getFrom()+" "+move.getTo());
        }
        List<MoveMore> moves2 = pawnMove.generateMovesImpl(new Position(File.a, Rank.FIRST), Color.BLACK);
        for (MoveMore move : moves2) {
            System.out.println(move.getFrom()+" "+move.getTo());
        }


    }
}
