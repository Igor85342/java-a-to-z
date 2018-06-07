package ru.moskalets.chapter2.controlquestion.task001;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
public class GameBombermanTest {
    @Test
    public void whenBombermanMakesFourMovesAndMeetsStone() {
        Board board = new Board(10);
        board.boardInitialization();
        Cell[] moves = {new Cell(1, 0), new Cell(1, 1), new Cell(2, 0), new Cell(2, 1)};
        Bomberman bomberman = new Bomberman(new Cell(0, 0), board, moves);
        Stone stone = new Stone(new Cell(1, 1), board);
        GameBomberman gameBomberman = new GameBomberman(board, bomberman, stone);
        gameBomberman.init();
        assertThat(gameBomberman.getBombermanX(), is(2));
        assertThat(gameBomberman.getBombermanY(), is(1));
    }
}