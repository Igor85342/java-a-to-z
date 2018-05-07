package ru.moskalets.chapter2.controlquestion.task001;

import java.util.concurrent.locks.ReentrantLock;

public class Stone implements Runnable {
    private final int x;
    private final int y;
    private final ReentrantLock[][] lockBoard;
    public Stone(int x, int y, ReentrantLock[][] lockBoard) {
        this.x = x;
        this.y = y;
        this.lockBoard = lockBoard;
    }
    @Override
    public void run() {
        this.lockBoard[this.x][this.y].lock();
        System.out.println("Stone is " + this.x + " " + this.y);
    }
}