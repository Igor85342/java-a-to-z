package ru.moskalets.chess.start;
import ru.moskalets.chess.models.*;

public class Board {
	public Figure[][] boardSize = new Figure[8][8];
	
	public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
		boolean result = false;
		int sourcePositionX = source.getPositionX();
		int sourcePositionY = source.getPositionY();
		try {	
			if (boardSize[sourcePositionX][sourcePositionY] == null | sourcePositionX < 0 | sourcePositionX > 7 | sourcePositionY < 0 | sourcePositionY > 7) {
				throw new FigureNotFoundException("Figure not found!");
			} else {
				Cell[] wayFigure = boardSize[sourcePositionX][sourcePositionY].way(dist);
				if (wayFigure[0] == null) {			
					throw new ImpossibleMoveException ("Impossible Move Exception!");
				} else {
					result = true;
					if (isFreeWay(wayFigure)) {
						result = true;
					} else {
						result = false;
						throw new OccupiedWayException ("Occupied Way Exception");
					}
				}
			}	
			if (result) {
				boardSize[dist.getPositionX()][dist.getPositionY()] = boardSize[source.getPositionX()][source.getPositionY()].clone(dist);
			}		
		} catch (ImpossibleMoveException e) {
			System.out.println(e.getMessage());
		}	
		catch (OccupiedWayException e) {
			System.out.println(e.getMessage());
		}	
		catch (FigureNotFoundException e) {
			System.out.println(e.getMessage());
		}	
		return result;	
	}
	
	public boolean isFreeWay(Cell[] wayFigure){
		boolean result = true;
		for (Cell cellWay : wayFigure) {		
			if ( cellWay != null) {		
				int cellWayX = cellWay.getPositionX();
				int cellWayY = cellWay.getPositionY();		
				if (boardSize[cellWayX][cellWayY] != null) {
					result = false;
				}				
			} else {
				break;
			}
		}
		return result;
	}
}