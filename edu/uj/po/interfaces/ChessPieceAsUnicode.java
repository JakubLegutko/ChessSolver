package edu.uj.po.interfaces;

import java.util.Map;

/**
 * Klasa udostępniająca znak reprezentujący bierkę o podanym kolorze.
 */
public class ChessPieceAsUnicode {
	private static final Map<ChessPiece, Character> whiteSymbols = Map.of(ChessPiece.BISHOP, '\u2657', ChessPiece.KING,
			'\u2654', ChessPiece.KNIGHT, '\u2658', ChessPiece.PAWN, '\u2659', ChessPiece.QUEEN, '\u2655',
			ChessPiece.ROOK, '\u2656');
	private static final Map<ChessPiece, Character> blackSymbols = Map.of(ChessPiece.BISHOP, '\u265D', ChessPiece.KING,
			'\u265A', ChessPiece.KNIGHT, '\u265E', ChessPiece.PAWN, '\u265F', ChessPiece.QUEEN, '\u265B',
			ChessPiece.ROOK, '\u265C');
	private static final Map<Color, Map<ChessPiece, Character>> symbols = Map.of(Color.WHITE, whiteSymbols, Color.BLACK,
			blackSymbols);

	/**
	 * Metoda zwraca znak reprezentujący bierkę o podanym kolorze.
	 * 
	 * @param piece bierka
	 * @param color kolor bierki
	 * @return znak reprezentujący bierkę
	 */
	public static Character getSymbol(ChessPiece piece, Color color) {
		return symbols.get(color).get(piece);
	}

	public static void main(String[] args) {
		System.out.println("Biały król     " + getSymbol(ChessPiece.KING, Color.WHITE));
		System.out.println("Czarny skoczek " + getSymbol(ChessPiece.KNIGHT, Color.BLACK));
	}
}
