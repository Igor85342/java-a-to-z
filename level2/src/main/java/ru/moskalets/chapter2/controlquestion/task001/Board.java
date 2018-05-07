package ru.moskalets.chapter2.controlquestion.task001;

import java.util.concurrent.locks.ReentrantLock;


public class Board {
    private final int size;
    private final ReentrantLock[][] lockBoard;
    private int x;
    private int y;
    private Bomberman bomberman;

    public Board(int size, int x, int y, String[] moves) {
        this.size = size;
        this.lockBoard = new ReentrantLock[size][size];
        this.bomberman = new Bomberman(x, y, this.lockBoard, moves, this.size);
    }
    public void boardInitialization() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.lockBoard[i][j] = new ReentrantLock();
            }
        }
    }
    public void init() {
        int stoneX = 6;
        int stoneY = 6;
        boardInitialization();
        Thread bombermanThread = new Thread(this.bomberman);
        Thread stoneThread = new Thread(new Stone(stoneX, stoneY, this.lockBoard));
        bombermanThread.start();
        stoneThread.start();
        try {
            bombermanThread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int getBombermanX() {
        return this.bomberman.getX();
    }
    public int getBombermanY() {
        return this.bomberman.getY();
    }
}
