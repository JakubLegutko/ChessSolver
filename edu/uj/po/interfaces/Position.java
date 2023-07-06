package edu.uj.po.interfaces;

import java.util.List;

/**
 * Pozycja na planszy
 */
public record Position(File file, Rank rank) {
	
	public String toString() {
		return file.name() + (rank.ordinal()+1);		
	}


}
