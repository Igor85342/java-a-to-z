package ru.moskalets.chess.models;
import ru.moskalets.chess.start.*;

public class Bishop extends Figure {
	public Bishop (Cell position){
		super(position);	
	}
	
	public  Cell[] way(Cell dist) throws ImpossibleMoveException{
		int thisPositionX = this.position.getPositionX();
		int thisPositionY = this.position.getPositionY();
		int targetPositionX = dist.getPositionX();
		int targetPositionY = dist.getPositionY();
		int stepX = 1;
		int stepY = 1;
		int size = Math.abs(thisPositionX - targetPositionX);
		Cell[] result = new Cell[size];
		if ((Math.abs(thisPositionX - targetPositionX) == Math.abs(thisPositionY - targetPositionY)) & thisPositionX != targetPositionX & thisPositionY != targetPositionY){
			if (thisPositionX > targetPositionX) {
				stepX = -1;
			}
			if (thisPositionY > targetPositionY) {
				stepY = -1;
			}
			int count = Math.abs(thisPositionX - targetPositionX);
			for (int i = 0; i <count; i++){
				thisPositionX = thisPositionX + stepX;
				thisPositionY = thisPositionY + stepY;
				result[i] = new Cell(thisPositionX, thisPositionY);
			}	
		} else{ 
			throw new ImpossibleMoveException("A figure cannot make a move.");
		}
		return result;
	}
	
	public Bishop clone(Cell dist){
		return new Bishop(dist);
	}
}

