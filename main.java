import edu.uj.po.interfaces.*;


public class main {

        public static void main(String[] args) {
            ChessSolver chessSolver = new ChessSolver();
            var color = Setup_8(chessSolver);
            chessSolver.printBoard();
            chessSolver.findMateInOneMove(color)
                    .ifPresent(System.out::println);
            chessSolver.printBoard();

//        chessSolver.findStalemateInOneMove(color)
//                .ifPresent(System.out::println);
        }


        //Mate: H4-F3
        private static Color Setup_1(ChessSolver chessSolver){
            chessSolver.addChessPiece(new Position(File.h, Rank.FOURTH), Color.BLACK, ChessPiece.KNIGHT);
            chessSolver.addChessPiece(new Position(File.f, Rank.SECOND), Color.BLACK, ChessPiece.KING);
            chessSolver.addChessPiece(new Position(File.g, Rank.SECOND), Color.BLACK, ChessPiece.BISHOP);
            chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.KING);
            return Color.BLACK;
        }

        //Mate: G4-G7 also H6-G7
        private static Color Setup_2(ChessSolver chessSolver){
            chessSolver.addChessPiece(new Position(File.a, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
            chessSolver.addChessPiece(new Position(File.f, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
            chessSolver.reset();
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
            return Color.WHITE;
        }

        //Mate: F7-F1
        private static Color Setup_3(ChessSolver chessSolver){
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
            return Color.BLACK;
        }

        //Mate: F3-F7
        private static Color Setup_4(ChessSolver chessSolver){
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
            return Color.WHITE;
        }

        //Mate: E8-E1
        private static Color Setup_5(ChessSolver chessSolver){
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
            return Color.BLACK;
        }

        //Mate: A8-G8
        private static Color Setup_6(ChessSolver chessSolver){
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
            return Color.WHITE;
        }

        //Mate: A6-F1
        private static Color Setup_7(ChessSolver chessSolver){
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
            return Color.BLACK;
        }

        //Mate: H6-D6
        private static Color Setup_8(ChessSolver chessSolver){
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
            return Color.WHITE;
        }

        //Mate: B3-B1
        //Stalemate: B3-D3
        private static Color Setup_9(ChessSolver chessSolver){
            chessSolver.addChessPiece(new Position(File.f, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
            chessSolver.addChessPiece(new Position(File.g, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
            chessSolver.addChessPiece(new Position(File.h, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
            chessSolver.addChessPiece(new Position(File.b, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
            chessSolver.addChessPiece(new Position(File.e, Rank.FIFTH), Color.BLACK, ChessPiece.KING);
            chessSolver.addChessPiece(new Position(File.b, Rank.THIRD), Color.BLACK, ChessPiece.ROOK);
            chessSolver.addChessPiece(new Position(File.a, Rank.SECOND), Color.BLACK, ChessPiece.QUEEN);
            chessSolver.addChessPiece(new Position(File.c, Rank.FIRST), Color.WHITE, ChessPiece.KING);
            return Color.BLACK;
        }

        //Mate: H2-D6
        private static Color Setup_10(ChessSolver chessSolver) {
            chessSolver.addChessPiece(new Position(File.d, Rank.FOURTH), Color.BLACK, ChessPiece.KING);
            chessSolver.addChessPiece(new Position(File.e, Rank.FOURTH), Color.BLACK, ChessPiece.ROOK);
            chessSolver.addChessPiece(new Position(File.b, Rank.THIRD), Color.WHITE, ChessPiece.KING);
            chessSolver.addChessPiece(new Position(File.d, Rank.SECOND), Color.WHITE, ChessPiece.PAWN);
            chessSolver.addChessPiece(new Position(File.h, Rank.SECOND), Color.WHITE, ChessPiece.QUEEN);
            return Color.WHITE;
        }

        //Mate: F4-C7
        private static Color Setup_11(ChessSolver chessSolver){
            chessSolver.addChessPiece(new Position(File.e, Rank.EIGHTH), Color.BLACK, ChessPiece.BISHOP);
            chessSolver.addChessPiece(new Position(File.d, Rank.SEVENTH), Color.BLACK, ChessPiece.KING);
            chessSolver.addChessPiece(new Position(File.e, Rank.SIXTH), Color.BLACK, ChessPiece.QUEEN);
            chessSolver.addChessPiece(new Position(File.a, Rank.FIFTH), Color.WHITE, ChessPiece.BISHOP);
            chessSolver.addChessPiece(new Position(File.f, Rank.FOURTH), Color.WHITE, ChessPiece.QUEEN);
            chessSolver.addChessPiece(new Position(File.g, Rank.FIRST), Color.WHITE, ChessPiece.KING);
            return Color.WHITE;
        }

        //Mate: C3-A5
        private static Color Setup_12(ChessSolver chessSolver){
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
            return Color.WHITE;
        }

        //Mate: C5-D7
        private static Color Setup_13(ChessSolver chessSolver){
            chessSolver.addChessPiece(new Position(File.d, Rank.EIGHTH), Color.BLACK, ChessPiece.ROOK);
            chessSolver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.BLACK, ChessPiece.PAWN);
            chessSolver.addChessPiece(new Position(File.c, Rank.SEVENTH), Color.BLACK, ChessPiece.KING);
            chessSolver.addChessPiece(new Position(File.d, Rank.SIXTH), Color.BLACK, ChessPiece.PAWN);
            chessSolver.addChessPiece(new Position(File.e, Rank.SIXTH), Color.WHITE, ChessPiece.PAWN);
            chessSolver.addChessPiece(new Position(File.c, Rank.FIFTH), Color.WHITE, ChessPiece.KNIGHT);
            chessSolver.addChessPiece(new Position(File.c, Rank.FIRST), Color.WHITE, ChessPiece.ROOK);
            chessSolver.addChessPiece(new Position(File.h, Rank.FIRST), Color.WHITE, ChessPiece.KING);
            return Color.WHITE;
        }

        //Mate: C3-G7
        private static Color Setup_14(ChessSolver chessSolver){
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
            return Color.WHITE;
        }

        //Mate: E7-H4
        private static Color Setup_15(ChessSolver chessSolver){
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
            return Color.BLACK;
        }

        //Mate: B4-H4
        private static Color Setup_16(ChessSolver chessSolver){
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
            return Color.BLACK;
        }

        //Mate: D4-B4
        private static Color Setup_17(ChessSolver chessSolver){
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
            return Color.BLACK;
        }

        //Mate: D4-B4
        private static Color Setup_18(ChessSolver chessSolver){
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
            return Color.BLACK;
        }
        // Mate A7-A8
    private static Color Setup_promotion(ChessSolver chessSolver){

        chessSolver.addChessPiece(new Position(File.a, Rank.SEVENTH), Color.WHITE, ChessPiece.PAWN);
        chessSolver.addChessPiece(new Position(File.e, Rank.EIGHTH), Color.BLACK, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.a, Rank.FIRST), Color.WHITE, ChessPiece.KING);
        chessSolver.addChessPiece(new Position(File.b, Rank.SEVENTH), Color.WHITE, ChessPiece.ROOK);
        return Color.WHITE;
    }
        //Mate: D5-E6
        private static Color Setup_EnPassantHard(ChessSolver chessSolver){
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
            return Color.WHITE;
        }
    }