import java.util.Optional;

import edu.uj.po.interfaces.ChessPiece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.File;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;

public class TestStalemate {

    public static boolean case1() {
        // https://lichess.org/c1CeBiTe#2
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.c, Rank.FIFTH), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SIXTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.WHITE, ChessPiece.KING);

        Optional<Move> stalemateMove = chessSolver.findStalemateInOneMove(Color.BLACK);
        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.BLACK);
        System.out.println(stalemateMove);
        System.out.println(mateMove);
        return stalemateMove.isPresent() && mateMove.isPresent();
    }

    public static boolean case2() {
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.c, Rank.FIFTH), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SIXTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);

        Optional<Move> stalemateMove = chessSolver.findStalemateInOneMove(Color.BLACK);
        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.BLACK);
        System.out.println(stalemateMove);
        System.out.println(mateMove);
        return stalemateMove.isEmpty() && mateMove.isPresent();
    }

    public static boolean case3() {
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.c, Rank.FOURTH), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.f, Rank.SEVENTH), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);

        Optional<Move> stalemateMove = chessSolver.findStalemateInOneMove(Color.WHITE);
        System.out.println(stalemateMove);
        return stalemateMove.isPresent();
    }


    public static boolean case4() {
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.c, Rank.EIGHTH), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.e, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.g, Rank.FIRST), Color.WHITE, ChessPiece.ROOK);

        Optional<Move> stalemateMove = chessSolver.findStalemateInOneMove(Color.WHITE);
        System.out.println(stalemateMove);
        return stalemateMove.isPresent();
    }

    public static boolean case5() {
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.f, Rank.SIXTH), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);

        Optional<Move> stalemateMove = chessSolver.findStalemateInOneMove(Color.WHITE);
        System.out.println(stalemateMove);
        return stalemateMove.isPresent();
    }

    public static boolean case6() {
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.a, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.g, Rank.FIFTH), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.h, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);

        Optional<Move> stalemateMove = chessSolver.findStalemateInOneMove(Color.WHITE);
        System.out.println(stalemateMove);
        return stalemateMove.isPresent();
    }

    public static boolean case7() {
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.f, Rank.FIFTH), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.f, Rank.SEVENTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);

        Optional<Move> stalemateMove = chessSolver.findStalemateInOneMove(Color.WHITE);
        System.out.println(stalemateMove);
        return stalemateMove.isPresent();
    }

    public static boolean case8() {
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.a, Rank.FIRST), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.a, Rank.SECOND), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.THIRD), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.g, Rank.FIFTH), Color.WHITE, ChessPiece.KING);

        Optional<Move> stalemateMove = chessSolver.findStalemateInOneMove(Color.WHITE);
        System.out.println(stalemateMove);
        return stalemateMove.isPresent();
    }

    public static boolean case9() {
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.a, Rank.SIXTH), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.e, Rank.THIRD), Color.WHITE, ChessPiece.BISHOP);

        Optional<Move> stalemateMove = chessSolver.findStalemateInOneMove(Color.WHITE);
        System.out.println(stalemateMove);
        return stalemateMove.isPresent();
    }

    public static boolean case10() {
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.b, Rank.FIFTH), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.h, Rank.EIGHTH), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.b, Rank.EIGHTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);

        Optional<Move> stalemateMove = chessSolver.findStalemateInOneMove(Color.WHITE);
        System.out.println(stalemateMove);
        return stalemateMove.isPresent();
    }

    public static boolean case11() {
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.e, Rank.FIFTH), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.g, Rank.SEVENTH), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.h, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);

        Optional<Move> stalemateMove = chessSolver.findStalemateInOneMove(Color.WHITE);
        System.out.println(stalemateMove);
        return stalemateMove.isPresent();
    }
}
