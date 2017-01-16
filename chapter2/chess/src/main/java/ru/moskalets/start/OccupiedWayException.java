package ru.moskalets.start;

public class OccupiedWayException extends RuntimeException {
	
	public OccupiedWayException(String msg) {
		super(msg);
	}
}