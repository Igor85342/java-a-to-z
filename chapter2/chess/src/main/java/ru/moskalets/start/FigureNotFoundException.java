package ru.moskalets.start;

public class FigureNotFoundException extends RuntimeException {
	
	public FigureNotFoundException(String msg) {
		super(msg);
	}
}