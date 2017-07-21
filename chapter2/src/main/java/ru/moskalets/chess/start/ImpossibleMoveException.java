package ru.moskalets.chess.start;

public class ImpossibleMoveException extends RuntimeException {
	
	public ImpossibleMoveException(String msg) {
		super(msg);
	}
}