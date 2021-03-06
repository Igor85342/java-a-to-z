package ru.moskalets.chapter2.controlquestion.task001;

public class Bomberman implements Runnable {
   private final Cell position;
   private final Board board;
   private final Cell[] moves;
   private final int size;
   public Bomberman(Cell position, Board board, Cell[] moves) {
       this.position = position;
       this.board = board;
       this.moves = moves;
       this.size = board.getLockBoard().length;
   }
   @Override
   public void run() {
       this.board.getLockBoard()[this.position.getPositionX()][this.position.getPositionY()].lock();
       System.out.println("Start bomberman " + this.position.getPositionX() + " " + this.position.getPositionY());
       for (Cell dest : this.moves) {
                   if (board.move(position, dest)) {
                       this.position.setPositionX(dest.getPositionX());
                       this.position.setPositionY(dest.getPositionY());
                       try {
                           Thread.currentThread().sleep(500);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.println("Move " + dest.getPositionX() + " " + dest.getPositionY());
                   }
       }
   }
   public Cell getPosition() {
       return this.position;
   }
}
