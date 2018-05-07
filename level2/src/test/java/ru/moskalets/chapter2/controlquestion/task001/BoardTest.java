package ru.moskalets.chapter2.controlquestion.task001;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class BoardTest {
    @Test
    public void whenBombermanMakesFourMovesAndMeetsStone() {
        String[] moves = {"right","down","left","up"};
        Board board = new Board(9, 5,5, moves);
        board.init();
        assertThat(board.getBombermanX(), is(4));
        assertThat(board.getBombermanY(), is(5));
    }
}