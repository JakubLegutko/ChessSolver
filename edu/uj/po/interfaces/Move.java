package edu.uj.po.interfaces;

/**
 * Ruch bierki.
 */
public record Move(Position initialPosition, Position finalPosition) {
	
	/**
	 * Notacja oparta na współrzędnych
	 */
	public String toString() {
		return initialPosition.toString().toUpperCase() + "-" + finalPosition.toString().toUpperCase();
	}
}
