package edu.uj.po.interfaces;

import java.util.Optional;

/**
 * Interfejs programu rozwiązującego zadania szachowe. 
 */
public interface Solver {
	/**
	 * Bierki podanego koloru zaczynają i dają mata (o ile jest to możliwe) w jednym
	 * ruchu.
	 * 
	 * @param color kolor strony wykonującej ruch
	 * @return ruch (o ile istnieje) bierki kończący partię matem.
	 */
	public Optional<Move> findMateInOneMove(Color color);

	/**
	 * Bierki podanego koloru zaczynają i dają pata (o ile jest to możliwe) w jednym
	 * ruchu.
	 * 
	 * @param color kolor strony wykonującej ruch
	 * @return ruch (o ile istnieje) bierki kończący partię patem.
	 */
	public Optional<Move> findStalemateInOneMove(Color color);
}
