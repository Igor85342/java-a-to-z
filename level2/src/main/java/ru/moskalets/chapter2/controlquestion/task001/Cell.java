package ru.moskalets.chapter2.controlquestion.task001;

public class Cell {
    private int positionX;
    private int positionY;
    public Cell(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
    public int getPositionX() {
        return this.positionX;
    }
    public int getPositionY() {
        return this.positionY;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}