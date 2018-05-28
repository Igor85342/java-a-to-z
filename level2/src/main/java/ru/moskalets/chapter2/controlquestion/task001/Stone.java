package ru.moskalets.chapter2.controlquestion.task001;

public class Stone implements Runnable {
    private final Cell position;
    private Board board;
    public Stone(Cell position, Board board) {
        this.position = position;
        this.board = board;
    }
    @Override
    public void run() {
        this.board.getLockBoard()[this.position.getPositionX()][this.position.getPositionY()].lock();
        System.out.println("Stone is " + this.position.getPositionX() + " " + this.position.getPositionY());
    }
}