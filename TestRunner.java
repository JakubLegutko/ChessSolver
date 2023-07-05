public class TestRunner {

    public void run() {
        System.out.println("Starting tests...");

        // System.out.println("Testing simple move discovery...");
        // assertify(TestSimpleDiscovery.testKingDiscovery(), "King");
        // assertify(TestSimpleDiscovery.testRookDiscovery(), "Rook");
        // assertify(TestSimpleDiscovery.testBishopDiscovery(), "Bishop");
        // assertify(TestSimpleDiscovery.testQueenDiscovery(), "Queen");
        // assertify(TestSimpleDiscovery.testKnightDiscovery(), "Knight");
        // assertify(TestSimpleDiscovery.testPawnDiscoverySimple1(), "Pawn (simple1)");
        // assertify(TestSimpleDiscovery.testPawnDiscoverySimple2(), "Pawn (simple2)");
        // assertify(TestSimpleDiscovery.testPawnDiscoveryAttack(), "Pawn (attack)");
        // System.out.println("Simple move discovery - OK");

        // System.out.println("Testing obstructed move discovery...");
        // assertify(TestObstructedDiscovery.testKingDiscovery(), "King");
        // assertify(TestObstructedDiscovery.testRookDiscovery(), "Rook");
        // assertify(TestObstructedDiscovery.testBishopDiscovery(), "Bishop");
        // assertify(TestObstructedDiscovery.testQueenDiscovery(), "Queen");
        // assertify(TestObstructedDiscovery.testKnightDiscovery(), "Knight");
        // assertify(TestObstructedDiscovery.testPawnDiscoverySimple1(), "Pawn (simple1)");
        // assertify(TestObstructedDiscovery.testPawnDiscoverySimple2(), "Pawn (simple2)");
        // assertify(TestObstructedDiscovery.testPawnDiscoveryAttack(), "Pawn (attack)");
        // System.out.println("Obstructed move discovery - OK");

        // System.out.println("Testing configurations from the pdf...");
        // assertify(TestsFromPdf.case1(), "case1");
        // assertify(TestsFromPdf.case2(), "case2");
        // assertify(TestsFromPdf.case3(), "case3");
        // assertify(TestsFromPdf.case4(), "case4");
        // assertify(TestsFromPdf.case5(), "case5");
        // assertify(TestsFromPdf.case6(), "case6");
        // assertify(TestsFromPdf.case7(), "case7");
        // assertify(TestsFromPdf.case8(), "case8");
        // assertify(TestsFromPdf.case9(), "case9");
        // assertify(TestsFromPdf.case10(), "case10");
        // assertify(TestsFromPdf.case11(), "case11");
        // assertify(TestsFromPdf.case12(), "case12");
        // assertify(TestsFromPdf.case13(), "case13");
        // assertify(TestsFromPdf.case14(), "case14");
        // assertify(TestsFromPdf.case15(), "case15");
        // assertify(TestsFromPdf.case16(), "case16");
        // assertify(TestsFromPdf.case17(), "case17");
        // assertify(TestsFromPdf.case18(), "case18");
        // assertify(TestsFromPdf.caseMateByPromotion(), "casePromotion");
        // System.out.println("Configurations from the pdf - OK");

        // System.out.println("Testing mate search...");
        // assertify(TestMate.case1(), "Case 1");
        // assertify(TestMate.case2(), "Case 2");
        // assertify(TestMate.promotion(), "Promotion");
        // assertify(TestMate.kingDefense(), "King defense");
        // System.out.println("Mate search - OK");

        System.out.println("Testing stalemate search...");
        assertify(TestStalemate.case1(), "Case 1");
        assertify(TestStalemate.case2(), "Case 2");
        assertify(TestStalemate.case3(), "Case 3");
        assertify(TestStalemate.case4(), "Case 4");
        assertify(TestStalemate.case5(), "Case 5");
        assertify(TestStalemate.case6(), "Case 6");
        assertify(TestStalemate.case7(), "Case 7");
        assertify(TestStalemate.case8(), "Case 8");
        assertify(TestStalemate.case9(), "Case 9");
        assertify(TestStalemate.case10(), "Case 10");
        assertify(TestStalemate.case11(), "Case 11");
        System.out.println("Stalemate search - OK");

        System.out.println("Tests finished");
    }

    public static void assertify(boolean condition, String message) {
        if (condition) {
            System.out.println(message + " OK");
            return;
        } else throw new Error(message + " failed!");
    }
}
