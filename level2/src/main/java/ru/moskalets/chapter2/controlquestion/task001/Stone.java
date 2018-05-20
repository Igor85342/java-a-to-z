package ru.moskalets.chapter2.controlquestion.task001;

public class Stone implements Runnable {
    private final int x;
    private final int y;
    private Board board;
    public Stone(int x, int y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
    }
    @Override
    public void run() {
        this.board.getLockBoard()[this.x][this.y].lock();
        System.out.println("Stone is " + this.x + " " + this.y);
    }
}