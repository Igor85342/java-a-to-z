package ru.moskalets.chess.start;

public class OccupiedWayException extends RuntimeException {
	
	public OccupiedWayException(String msg) {
		super(msg);
	}
}