import edu.uj.po.interfaces.*;


public class main {
    public static void main(String[] args) {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.reset();
        chessSolver.addChessPiece(new Position(File.b,Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.b,Rank.FIFTH), Color.WHITE, ChessPiece.ROOK);
        chessSolver.addChessPiece(new Position(File.d,Rank.FIFTH), Color.WHITE, ChessPiece.BISHOP);
        chessSolver.addChessPiece(new Position(File.d,Rank.FOURTH), Color.WHITE, ChessPiece.QUEEN);
        chessSolver.addChessPiece(new Position(File.e,Rank.FIFTH), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.d,Rank.THIRD), Color.WHITE, ChessPiece.KNIGHT);
        System.out.println("Hello World!");
    }
}
