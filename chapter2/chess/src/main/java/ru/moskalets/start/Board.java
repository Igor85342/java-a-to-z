package ru.moskalets.start;




import ru.moskalets.models.*;

public class Board {
	
	public Figure[][] boardSize = new Figure[8][8];
	
	public void AddFigure(Figure figure){
		
	}
	
	public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
		boolean result = false;
		int SourcePositionX = source.getPositionX();
		int SourcePositionY = source.getPositionY();
		
		
		
		try {
			
			
		if (boardSize[SourcePositionX][SourcePositionY] == null | SourcePositionX < 0 | SourcePositionX > 7 | SourcePositionY < 0 | SourcePositionY > 7) {
				
				throw new FigureNotFoundException("Figure not found!");
		} else {
			Cell[] wayFigure = boardSize[SourcePositionX][SourcePositionY].way(dist);
			if (wayFigure[0] == null) {
				
				throw new ImpossibleMoveException ("Impossible Move Exception!");
			} else {
				
				result = true;
				for (Cell cellWay : wayFigure) {
					
					if ( cellWay != null) {
						
						int cellWayX = cellWay.getPositionX();
						int cellWayY = cellWay.getPositionY();
						
						if (boardSize[cellWayX][cellWayY] != null) {
							result = false;
							throw new OccupiedWayException ("Occupied Way Exception");
						}
						
						
					} else {
						//
						break;
					}
				}
			}
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
	
	
	
}