import java.util.Optional;

import edu.uj.po.interfaces.ChessPiece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.File;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;

public class TestsFromPdf {
    // mate: [H4-F3]
    static boolean case1(){
        ChessSolver chessSolver = new ChessSolver();

        chessSolver.addChessPiece(new Position(File.h, Rank.FOURTH), Color.BLACK, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.f, Rank.SECOND), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.BLACK);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [G4-G7]
    static boolean case2(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.f, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.h, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.SEVENTH), Color.BLACK, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.f, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SIXTH), Color.WHITE, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.c, Rank.FIFTH), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.d, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.FOURTH), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.g, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.a, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);

        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.WHITE, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.a, Rank.FIRST), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.WHITE);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [F7-F1]
    static boolean case3(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.h, Rank.EIGHTH), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.SEVENTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.d, Rank.SIXTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.g, Rank.SIXTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIFTH), Color.WHITE, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.c, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN);

        chessSolver.addChessPiece(new Position(File.a, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.BLACK);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [F3-F7]
    static boolean case4(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.c, Rank.EIGHTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.d, Rank.EIGHTH), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.e, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.g, Rank.EIGHTH), Color.BLACK, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.h, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.SIXTH), Color.BLACK, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.c, Rank.FIFTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.e, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.FOURTH), Color.WHITE, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.e, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.THIRD), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.a, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.a, Rank.FIRST), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.b, Rank.FIRST), Color.WHITE, ChessPiece.KNIGHT);

        chessSolver.addChessPiece(new Position(File.c, Rank.FIRST), Color.WHITE, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.e, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.g, Rank.FIRST), Color.WHITE, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.ROOK);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.WHITE);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [E8-E1]
    static boolean case5(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.b, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.e, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.f, Rank.EIGHTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.g, Rank.EIGHTH), Color.BLACK, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.h, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.SEVENTH), Color.WHITE, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.g, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.FIFTH), Color.WHITE, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.d, Rank.THIRD), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.f, Rank.THIRD), Color.BLACK, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.a, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);

        chessSolver.addChessPiece(new Position(File.a, Rank.FIRST), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.c, Rank.FIRST), Color.WHITE, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.f, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.ROOK);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.BLACK);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [A8-G8]
    static boolean case6(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.f, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SEVENTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.f, Rank.SIXTH), Color.WHITE, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.g, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.FOURTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.THIRD), Color.BLACK, ChessPiece.KNIGHT);

        chessSolver.addChessPiece(new Position(File.g, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.SECOND), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.WHITE);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [A6-F1]
    static boolean case7(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.a, Rank.SIXTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.d, Rank.SIXTH), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.a, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.FIFTH), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.f, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.FOURTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);

        chessSolver.addChessPiece(new Position(File.f, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.THIRD), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.b, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.BLACK);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [H6-D6]
    static boolean case8(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.b, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.c, Rank.EIGHTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.g, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SIXTH), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.d, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.FOURTH), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.f, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.THIRD), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.h, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);

        chessSolver.addChessPiece(new Position(File.b, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.a, Rank.FIRST), Color.WHITE, ChessPiece.ROOK);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.WHITE);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [B3-B1]
    // stalemate: [B3-D3]
    static boolean case9(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.f, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);

        chessSolver.addChessPiece(new Position(File.e, Rank.FIFTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.b, Rank.THIRD), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.a, Rank.SECOND), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.c, Rank.FIRST), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.BLACK);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [H2-D6]
    static boolean case10() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.d, Rank.FOURTH), Color.BLACK, ChessPiece.KING);

        chessSolver.addChessPiece(new Position(File.e, Rank.FOURTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.b, Rank.THIRD), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.d, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.QUEEN);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.WHITE);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [F4-C7]
    static boolean case11(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.e, Rank.EIGHTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.d, Rank.SEVENTH), Color.BLACK, ChessPiece.KING);

        chessSolver.addChessPiece(new Position(File.e, Rank.SIXTH), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.a, Rank.FIFTH), Color.WHITE, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.f, Rank.FOURTH), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.g, Rank.FIRST), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.WHITE);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [C3-A5]
    static boolean case12(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.b, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.g, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.c, Rank.SIXTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SIXTH), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.FOURTH), Color.WHITE, ChessPiece.KNIGHT);

        chessSolver.addChessPiece(new Position(File.c, Rank.THIRD), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.f, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.WHITE);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [C5-D7]
    static boolean case13(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.d, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.SEVENTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.d, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);

        chessSolver.addChessPiece(new Position(File.e, Rank.SIXTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.FIFTH), Color.WHITE, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.c, Rank.FIRST), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.WHITE);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [C3-G7]
    static boolean case14(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.d, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.e, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.c, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.SEVENTH), Color.BLACK, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.e, Rank.SEVENTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.a, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.FOURTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.FOURTH), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.a, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.THIRD), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.c, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.WHITE, ChessPiece.BISHOP);

        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.FIRST), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.f, Rank.FIRST), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.WHITE);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [E7-H4]
    static boolean case15(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.f, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.g, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.e, Rank.SEVENTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.g, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.a, Rank.FIFTH), Color.WHITE, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.e, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.FOURTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.THIRD), Color.WHITE, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.d, Rank.THIRD), Color.BLACK, ChessPiece.QUEEN);

        chessSolver.addChessPiece(new Position(File.a, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.FIRST), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.e, Rank.FIRST), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.BLACK);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [B4-H4]
    static boolean case16(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.f, Rank.EIGHTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.f, Rank.SEVENTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.g, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.a, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.FOURTH), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.e, Rank.SECOND), Color.BLACK, ChessPiece.KNIGHT);

        chessSolver.addChessPiece(new Position(File.f, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.a, Rank.FIRST), Color.WHITE, ChessPiece.BISHOP);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.BLACK);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [D4-B4]
    static boolean case17(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.d, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.f, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.h, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.SEVENTH), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.g, Rank.SEVENTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.g, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.FOURTH), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.a, Rank.THIRD), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.b, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.THIRD), Color.WHITE, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.d, Rank.THIRD), Color.BLACK, ChessPiece.KNIGHT);

        chessSolver.addChessPiece(new Position(File.e, Rank.THIRD), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.a, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.SECOND), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.BLACK);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [D4-B4]
    static boolean case18(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.d, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.f, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.h, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.SEVENTH), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.g, Rank.SEVENTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.g, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.FOURTH), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.a, Rank.THIRD), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.b, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.THIRD), Color.WHITE, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.d, Rank.THIRD), Color.BLACK, ChessPiece.KNIGHT);

        chessSolver.addChessPiece(new Position(File.e, Rank.THIRD), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.a, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.SECOND), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.BLACK);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    // mate: [D5-E6]
    static boolean caseEnPassantHard(){
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.c, Rank.EIGHTH), Color.BLACK, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.e, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.f, Rank.EIGHTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.f, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SEVENTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.d, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.SIXTH), Color.WHITE, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.c, Rank.FIFTH), Color.BLACK, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.d, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.FIFTH), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.FOURTH), Color.BLACK, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.c, Rank.FOURTH), Color.WHITE, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.e, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.FOURTH), Color.BLACK, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.g, Rank.THIRD), Color.WHITE, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.a, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SECOND), Color.WHITE, ChessPiece.BISHOP);

        chessSolver.addChessPiece(new Position(File.c, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.FIRST), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.g, Rank.FIRST), Color.WHITE, ChessPiece.KING);

        Optional<Move> mateMove = chessSolver.findMateInOneMove(Color.WHITE);
        System.out.println(mateMove);
        return mateMove.isPresent();
    }

    static boolean caseMateByPromotion(){
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
}
