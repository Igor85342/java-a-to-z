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

   public boolean move(Cell source, Cell dest) {
        boolean result = false;
        if (dest.getPositionX() >= 0 & dest.getPositionX() < this.size & dest.getPositionY() >= 0 & dest.getPositionY() < this.size) {
            if (source.getPositionX() == dest.getPositionX() | source.getPositionY() == dest.getPositionY()) {
                if (Math.abs(source.getPositionX() - dest.getPositionX()) == 1 | Math.abs(source.getPositionY() - dest.getPositionY()) == 1) {
                    if (!this.lockBoard[dest.getPositionX()][dest.getPositionY()].isLocked()) {
                        result = true;
                    }
                }
            }
        }
       return result;
   }
}
