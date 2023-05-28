import edu.uj.po.interfaces.*;


public class main {
    public static void main(String[] args) {
        ChessSolver chessSolver = new ChessSolver();
        chessSolver.reset();
        chessSolver.addChessPiece(new Position(File.b,Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
        System.out.println("Hello World!");
    }
}
