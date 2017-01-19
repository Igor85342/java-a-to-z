package ru.moskalets.models;
import ru.moskalets.start.*;
public abstract class Figure {
	final Cell position;
	
	Figure (Cell position) {
		this.position = position;
	}
	
	public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;
	
	public abstract Figure clone(Cell dist);
}