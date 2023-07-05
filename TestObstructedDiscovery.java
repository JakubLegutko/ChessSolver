import java.util.List;

import edu.uj.po.interfaces.ChessPiece;
import edu.uj.po.interfaces.Color;
import edu.uj.po.interfaces.File;
import edu.uj.po.interfaces.Move;
import edu.uj.po.interfaces.Position;
import edu.uj.po.interfaces.Rank;

public class TestObstructedDiscovery {

    public static boolean testKingDiscovery() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.f, Rank.FIFTH), Color.WHITE, ChessPiece.KING);
        // Obstacles
        chessSolver.addChessPiece(new Position(File.f, Rank.SIXTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.f, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.g, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        // Control group
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.PAWN);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 3) {
            return true;
        }
        return false;
    }

    public static boolean testRookDiscovery() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.d, Rank.FIFTH), Color.WHITE, ChessPiece.ROOK);
        // Obstacles
        chessSolver.addChessPiece(new Position(File.d, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.d, Rank.FIRST), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        // Control group
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 9) {
            return true;
        }
        return false;
    }

    public static boolean testBishopDiscovery() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.d, Rank.FIFTH), Color.WHITE, ChessPiece.BISHOP);
        // Obstacles
        chessSolver.addChessPiece(new Position(File.c, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.a, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.PAWN);
        // Control group
        chessSolver.addChessPiece(new Position(File.h, Rank.FIFTH), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 9) {
            return true;
        }
        return false;
    }

    public static boolean testQueenDiscovery() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.d, Rank.FOURTH), Color.WHITE, ChessPiece.QUEEN);
        // Obstacles
        chessSolver.addChessPiece(new Position(File.c, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN); // 1
        chessSolver.addChessPiece(new Position(File.c, Rank.THIRD), Color.BLACK, ChessPiece.PAWN); // 1
        chessSolver.addChessPiece(new Position(File.e, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN); // 1
        chessSolver.addChessPiece(new Position(File.e, Rank.THIRD), Color.BLACK, ChessPiece.PAWN); // 1
        chessSolver.addChessPiece(new Position(File.d, Rank.EIGHTH), Color.WHITE, ChessPiece.PAWN); // 3
        chessSolver.addChessPiece(new Position(File.a, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN); // 2
        chessSolver.addChessPiece(new Position(File.h, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN); // 3
        chessSolver.addChessPiece(new Position(File.d, Rank.FIRST), Color.WHITE, ChessPiece.PAWN); // 2
        // Control group
        chessSolver.addChessPiece(new Position(File.h, Rank.FIFTH), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 14) {
            return true;
        }
        return false;
    }

    public static boolean testKnightDiscovery() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.d, Rank.FOURTH), Color.WHITE, ChessPiece.KNIGHT);
        // Obstacles
        chessSolver.addChessPiece(new Position(File.b, Rank.FIFTH), Color.BLACK, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.f, Rank.FIFTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.c, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        // Control group
        chessSolver.addChessPiece(new Position(File.h, Rank.FIFTH), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 5) {
            return true;
        }
        return false;
    }

    public static boolean testPawnDiscoverySimple1() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.e, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        // Obstacles
        chessSolver.addChessPiece(new Position(File.e, Rank.FOURTH), Color.WHITE, ChessPiece.PAWN);
        // Control group
        chessSolver.addChessPiece(new Position(File.h, Rank.FIFTH), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 1) {
            return true;
        }
        return false;
    }

    public static boolean testPawnDiscoverySimple2() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.e, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        // Obstacles
        chessSolver.addChessPiece(new Position(File.e, Rank.THIRD), Color.WHITE, ChessPiece.PAWN);
        // Control group
        chessSolver.addChessPiece(new Position(File.h, Rank.FIFTH), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean testPawnDiscoveryAttack() {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.addChessPiece(new Position(File.c, Rank.SIXTH), Color.WHITE, ChessPiece.PAWN);
        // Obstacles
        chessSolver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.BLACK, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.d, Rank.SEVENTH), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.c, Rank.SEVENTH), Color.WHITE, ChessPiece.PAWN);
        // Control group
        chessSolver.addChessPiece(new Position(File.h, Rank.FIFTH), Color.WHITE, ChessPiece.KING);
        List<Move> moveList = chessSolver.testMoveGeneration();
        System.out.println(moveList);
        if (moveList.size() == 1) {
            return true;
        }
        return false;
    }
}
