package ru.moskalets.chess.start;

public class FigureNotFoundException extends RuntimeException {
	
	public FigureNotFoundException(String msg) {
		super(msg);
	}
}