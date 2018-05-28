package ru.moskalets.chapter2.controlquestion.task001;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void whenDestIsOutsideBoardReturnFalse() {
        Board board = new Board(3);
        board.boardInitialization();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(3, 3);
        boolean result = board.move(source, dest);
        assertThat(result, is(false));
    }

    @Test
    public void whenDestIsDiagonallyReturnFalse() {
        Board board = new Board(3);
        board.boardInitialization();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(2, 2);
        boolean result = board.move(source, dest);
        assertThat(result, is(false));
    }

    @Test
    public void whenDestIsOutOfOneMoveReturnFalse() {
        Board board = new Board(3);
        board.boardInitialization();
        Cell source = new Cell(0, 0);
        Cell dest = new Cell(0, 2);
        boolean result = board.move(source, dest);
        assertThat(result, is(false));
    }
    @Test
    public void whenDestIsLockedReturnFalse() {
        Board board = new Board(3);
        board.boardInitialization();
        board.getLockBoard()[0][1].lock();
        Cell source = new Cell(0, 0);
        Cell dest = new Cell(0, 1);
        boolean result = board.move(source, dest);
        assertThat(result, is(false));
    }
    @Test
    public void whenInDestCanMoveReturnTrue() {
        Board board = new Board(3);
        board.boardInitialization();
        Cell source = new Cell(0, 0);
        Cell dest = new Cell(0, 1);
        boolean result = board.move(source, dest);
        assertThat(result, is(true));
    }
}