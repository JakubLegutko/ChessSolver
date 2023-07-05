import java.util.List;

import edu.uj.po.interfaces.ChessPiece;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.File;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Rank;

public class TestSimpleDiscovery {

    public static boolean testKingDiscovery() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.f, Rank.FIFTH), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 8) {
            return true;
        }
        return false;
    }

    public static boolean testRookDiscovery() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.d, Rank.FIFTH), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 14) {
            return true;
        }
        return false;
    }

    public static boolean testBishopDiscovery() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.d, Rank.FIFTH), Color.WHITE, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.g, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 13) {
            return true;
        }
        return false;
    }

    public static boolean testQueenDiscovery() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.d, Rank.FOURTH), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 27) {
            return true;
        }
        return false;
    }

    public static boolean testKnightDiscovery() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.d, Rank.FOURTH), Color.WHITE, ChessPiece.KNIGHT);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 8) {
            return true;
        }
        return false;
    }

    public static boolean testPawnDiscoverySimple1() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.e, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 2) {
            return true;
        }
        return false;
    }

    public static boolean testPawnDiscoverySimple2() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.e, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 1) {
            return true;
        }
        return false;
    }

    public static boolean testPawnDiscoveryAttack() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.c, Rank.SIXTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.d, Rank.SEVENTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 3) {
            return true;
        }
        return false;
    }
}
