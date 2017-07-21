package ru.moskalets.chess.start;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import ru.moskalets.chess.models.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BoardTest {
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void whenFigureCanMoveReturnTrue(){
		Board board = new Board();
		Cell source = new Cell(2,2);
		Cell dist = new Cell(3,3);
		board.boardSize[source.getPositionX()][source.getPositionY()] =  new Bishop(source);
		boolean result = board.move(source,dist);
		assertTrue(result);
	}
	
	@Test
	public void whenFigureMissingInCellReturnFalse(){
		Board board = new Board();
		Cell source = new Cell(2,2);
		Cell dist = new Cell(3,3);
		boolean result = board.move(source,dist);
		assertFalse(result);
	}
	
	@Test
	public void whenPathOccupiedAnotherPieceReturnFalse(){
		Board board = new Board();
		Cell source = new Cell(2,2);
		Cell dist = new Cell(4,4);
		board.boardSize[source.getPositionX()][source.getPositionY()] =  new Bishop(source);
		board.boardSize[3][3] =  new Bishop(source);
		boolean result = board.move(source,dist);
		assertFalse(result);
	}
	
	@Test
	public void whenFigureNotFoundExceptionTest() throws FigureNotFoundException{
		exception.expect(FigureNotFoundException.class);
		exception.expectMessage("Figure not found!");
		throw new FigureNotFoundException("Figure not found!");
	}
	
	@Test
	public void whenImpossibleMoveExceptionTest() throws ImpossibleMoveException{
		exception.expect(ImpossibleMoveException.class);
		exception.expectMessage("Impossible Move Exception!");
		throw new ImpossibleMoveException("Impossible Move Exception!");
	}
	
	@Test
	public void whenOccupiedWayExceptionTest() throws OccupiedWayException{
		exception.expect(OccupiedWayException.class);
		exception.expectMessage("Occupied Way Exception!");
		throw new OccupiedWayException("Occupied Way Exception!");
	}
}

