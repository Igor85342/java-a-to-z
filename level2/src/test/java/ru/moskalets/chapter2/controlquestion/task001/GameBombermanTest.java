package ru.moskalets.chapter2.controlquestion.task001;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
public class GameBombermanTest {
    @Test
    public void whenBombermanMakesFourMovesAndMeetsStone() {
        Board board = new Board(10);
        board.boardInitialization();
        String[] moves = {"right", "right", "down", "left", "up"};
        Bomberman bomberman = new Bomberman(0, 0, board, moves);
        Stone stone = new Stone(0, 2, board);
        GameBomberman gameBomberman = new GameBomberman(board, bomberman, stone);
        gameBomberman.init();
        assertThat(gameBomberman.getBombermanX(), is(0));
        assertThat(gameBomberman.getBombermanY(), is(0));
    }
}