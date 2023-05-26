package edu.uj.po.interfaces;

/**
 * Interfejs (re)konfiguracji planszy do gry.
 */
public interface Setup {
	/**
	 * Przywraca stan planszy do stanu początkowego. W stanie początkowym
	 * plansza jest pusta.
	 */
	public void reset();
	
	/**
	 * Ustawia na podanej pozycji bierkę danego koloru. Zakłada się, że
	 * bierki ustawiane będą zgodnie z regułami gry w szachy.
	 * 
	 * @param position położenie na planszy, w którym umieszczana jest bierka
	 * @param color kolor bierki
	 * @param piece rodzaj bierki
	 */
	public void addChessPiece(Position position, Color color, ChessPiece piece );
}
