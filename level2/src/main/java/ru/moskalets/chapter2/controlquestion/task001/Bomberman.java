package ru.moskalets.chapter2.controlquestion.task001;


import java.util.concurrent.locks.ReentrantLock;


public class Bomberman implements Runnable {
   private int x;
   private int y;
   private final ReentrantLock[][] lockBoard;
   private final String[] moves;
   private final int size;
   public Bomberman(int x, int y, ReentrantLock[][] lockBoard, String[] moves, int size) {
       this.x = x;
       this.y = y;
       this.lockBoard = lockBoard;
       this.moves = moves;
       this.size = size;
   }
   @Override
   public void run() {
       this.lockBoard[this.x][this.y].lock();
       System.out.println("Start bomberman " + this.x + " " + this.y);
       int tempX;
       int tempY;
       for (String move : this.moves) {
           tempX = this.x;
           tempY = this.y;
           if (move(move)) {
               if (this.lockBoard[tempX][tempY].isLocked()) {
                   this.lockBoard[tempX][tempY].unlock();
               }
               this.lockBoard[x][y].lock();
               try {
                   Thread.currentThread().sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("Move " + this.x + " " + this.y);
           } else {
               this.x = tempX;
               this.y = tempY;
               System.out.println("The path is blocked!");
               try {
                   Thread.currentThread().sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }
   }
    public boolean move(String command) {
       String UP = "up";
       String DOWN = "down";
       String LEFT = "left";
       String RIGHT = "right";
       boolean flag = false;
        if (UP.equalsIgnoreCase(command)) {
            flag = moveUp(this.size);
        }
        if (DOWN.equalsIgnoreCase(command)) {
            flag = moveDown(this.size);
        }
        if (LEFT.equalsIgnoreCase(command)) {
            flag = moveLeft(this.size);
        }
        if (RIGHT.equalsIgnoreCase(command)) {
            flag = moveRight(this.size);
        }
        if (flag) {
            if (lockBoard[x][y].isLocked()) {
                flag = false;
            }
        }
        return flag;
    }
    public boolean moveDown(int size) {
       boolean flag = false;
       if (this.x >= 0 & this.x <= size) {
           this.x++;
           flag = true;
        }
        return flag;
    }
    public boolean moveUp(int size) {boolean flag = false;
       if (this.x >= 0 & this.x <= size) {
           this.x--;
           flag = true;
       }
       return flag;
    }
    public boolean moveLeft(int size) {
       boolean flag = false;
       if (this.y >= 0 & this.y <= size) {
           this.y--;
           flag = true;
       }
       return flag;
    }
    public boolean moveRight(int size) {
       boolean flag = false;
       if (this.y >= 0 & this.y <= size) {
           this.y++;
           flag = true;
       }
       return flag;
    }
    public int getX() {
       return this.x;
    }
    public int getY() {
       return this.y;
    }
}
