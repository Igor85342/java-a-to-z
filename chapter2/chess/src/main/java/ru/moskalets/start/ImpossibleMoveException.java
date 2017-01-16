package ru.moskalets.start;

public class ImpossibleMoveException extends RuntimeException {
	
	public ImpossibleMoveException(String msg) {
		super(msg);
	}
}