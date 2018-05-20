package ru.moskalets.chapter2.controlquestion.task001;

public class GameBomberman {
    private Board board;
    private Bomberman bomberman;
    private Stone stone;
    public GameBomberman(Board board, Bomberman bomberman, Stone stone) {
        this.board = board;
        this.bomberman = bomberman;
        this.stone = stone;
    }
    public void init() {
        Thread bombermanThread = new Thread(this.bomberman);
        Thread stoneThread = new Thread(this.stone);
        bombermanThread.start();
        stoneThread.start();
        try {
            bombermanThread.join();
        } catch (InterruptedException e) {
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