package ru.moskalets.chapter2.controlquestion.task001;

import java.util.concurrent.locks.ReentrantLock;


public class Board {
    private final int size;
    private final ReentrantLock[][] lockBoard;

    public Board(int size) {
        this.size = size;
        this.lockBoard = new ReentrantLock[size][size];
    }
    public void boardInitialization() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.lockBoard[i][j] = new ReentrantLock();
            }
        }
    }
    public ReentrantLock[][] getLockBoard() {
        return this.lockBoard;
    }

}
