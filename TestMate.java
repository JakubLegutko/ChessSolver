import java.util.Optional;

import edu.uj.po.interfaces.ChessPiece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.File;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;

public class TestMate {

    public static boolean case1() {
        // https://lichess.org/97Cxaqvr#2
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.h, Rank.FOURTH), Color.BLACK, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.f, Rank.SECOND), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.BLACK);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    public static boolean case2() {
        // https://lichess.org/UdVfaoy0
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.e, Rank.SIXTH), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SIXTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.h, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.BLACK);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    public static boolean promotion() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.f, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);

        chessSolver.addChessPiece(new Position(File.g, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.WHITE, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.c, Rank.SEVENTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.b, Rank.SIXTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.FIFTH), Color.WHITE, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.d, Rank.FOURTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.FOURTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.f, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.WHITE);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    public static boolean kingDefense() {
        // https://lichess.org/3o7nl3OO
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.b, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);

        chessSolver.addChessPiece(new Position(File.a, Rank.SIXTH), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.WHITE);
        System.out.println(mateMove);
        return mateMove.isEmpty();
    }
}
