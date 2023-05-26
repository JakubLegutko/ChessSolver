package edu.uj.po.interfaces;

/**
 * Pozycja na planszy
 */
public record Position(File file, Rank rank) {
	
	public String toString() {
		return file.name() + (rank.ordinal()+1);		
	}
	
}
