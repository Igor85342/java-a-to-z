package ru.moskalets.models;

import org.junit.Assert;
import org.junit.Test;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

import ru.moskalets.start.*;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;



public class BishopTest{
	
	@Rule
    public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void whenBishopCanMoveReturnWay(){
		
		Cell cellDist = new Cell(4,4);
		Figure bishopTest = new Bishop(new Cell(3,3));
		Cell[] wayResult = {new Cell(4,4)};
		
		Cell[] wayTest = bishopTest.way(cellDist);
		
		Assert.assertThat(wayResult[0].getPositionX(), is(wayTest[0].getPositionX()));
		Assert.assertThat(wayResult[0].getPositionY(), is(wayTest[0].getPositionY()));
	}
	
	@Test
	public void whenBishopCanMoveOneCellReturnWay(){
		
		Cell cellDist = new Cell(2,2);
		Figure bishopTest = new Bishop(new Cell(3,3));
		Cell[] wayResult = {new Cell(2,2)};
		
		Cell[] wayTest = bishopTest.way(cellDist);
		
		Assert.assertThat(wayResult[0].getPositionX(), is(wayTest[0].getPositionX()));
		Assert.assertThat(wayResult[0].getPositionY(), is(wayTest[0].getPositionY()));
	}
	
	@Test
	public void whenBishopCanMoveTwoCellReturnWay(){
		
		Cell cellDist = new Cell(5,5);
		Figure bishopTest = new Bishop(new Cell(3,3));
		Cell[] wayResult = {new Cell(4,4),new Cell(5,5)};
		
		Cell[] wayTest = bishopTest.way(cellDist);
		
		Assert.assertThat(wayResult[0].getPositionX(), is(wayTest[0].getPositionX()));
		Assert.assertThat(wayResult[0].getPositionY(), is(wayTest[0].getPositionY()));
		Assert.assertThat(wayResult[1].getPositionX(), is(wayTest[1].getPositionX()));
		Assert.assertThat(wayResult[1].getPositionY(), is(wayTest[1].getPositionY()));
	}
	
	@Test
	public void whenBishopCanMoveTwoCellMinReturnWay(){
		
		Cell cellDist = new Cell(4,1);
		Figure bishopTest = new Bishop(new Cell(6,3));
		Cell[] wayResult = {new Cell(5,2),new Cell(4,1)};
		
		Cell[] wayTest = bishopTest.way(cellDist);
		
		Assert.assertThat(wayResult[0].getPositionX(), is(wayTest[0].getPositionX()));
		Assert.assertThat(wayResult[0].getPositionY(), is(wayTest[0].getPositionY()));
		Assert.assertThat(wayResult[1].getPositionX(), is(wayTest[1].getPositionX()));
		Assert.assertThat(wayResult[1].getPositionY(), is(wayTest[1].getPositionY()));
	}
	
	@Test
	public void whenFigureNotFoundExceptionTest() throws FigureNotFoundException{
		
		exception.expect(FigureNotFoundException.class);
		exception.expectMessage("A figure cannot make a move.");
		throw new FigureNotFoundException("A figure cannot make a move.");
		
	}
	
}