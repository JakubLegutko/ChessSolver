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
            listOfMoveMores.add(new MoveMore(position, new Position(position.file(), Rank.FIFTH),false));
        }
        else if (startingPositionsWhite.contains(position) && color == Color.WHITE) {
            listOfMoveMores.add(new MoveMore(position, new Position(position.file(), Rank.FOURTH),false));
        }

            if (color == Color.BLACK) {
                if (position.rank() == Rank.FIRST) { // add promotion if possible
                    listOfMoveMores = queenMove.generateMovesImpl(position, color);
                    //System.out.println("black promotion");
                }else
                    listOfMoveMores.add(new MoveMore(position, new Position(position.file(), rank[position.rank().ordinal() - 1]),false));
                if (position.file().ordinal() < 7 && position.rank().ordinal() != 0 && position.rank().ordinal() != 7) // add hits if possible
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() + 1], rank[position.rank().ordinal() - 1]),true));
                if (position.file().ordinal() > 0 && position.rank().ordinal() != 0 && position.rank().ordinal() != 7)
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() - 1], rank[position.rank().ordinal() - 1]),true));
            }
            else {
                if (position.rank() == Rank.EIGHTH) { // add promotion if possible
                    listOfMoveMores = queenMove.generateMovesImpl(position, color);
                    //System.out.println("white promotion");
                }else
                    listOfMoveMores.add(new MoveMore(position, new Position(position.file(), rank[position.rank().ordinal() + 1]),false));
                if (position.file().ordinal() < 7 && position.rank().ordinal() != 0 && position.rank().ordinal() != 7) // add hits if possible
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() + 1], rank[position.rank().ordinal() + 1]),true));
                if (position.file().ordinal() > 0 && position.rank().ordinal() != 0 && position.rank().ordinal() != 7)
                    listOfMoveMores.add(new MoveMore(position, new Position(file[position.file().ordinal() - 1], rank[position.rank().ordinal() + 1]),true));
        }
    // Needs logic for En Passant
    // check if the attacking pawn has moved exactly 3 ranks (is on rank 5 or 4 for white, 3 or 4 for black)
    // check if the attacked pawn is on the same file and on the 5th rank (for white) or 4th rank (for black)
// check if the attacked pawn has moved exactly 2 ranks (is on rank 7 or 6 for white, 2 or 3 for black)


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
