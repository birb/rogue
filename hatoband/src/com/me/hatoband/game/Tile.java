package com.me.hatoband.game;


public class Tile {
    
    boolean walkable;
    boolean occupied;
    boolean isWall;
    boolean isFloor;
    boolean isItem;
    boolean isTrap;
   
    public boolean tileIsWall(){
            return isWall;
    }
   
    public boolean tileIsFloor(){
            return isFloor;
    }
   
    public boolean tileIsItem(){
            return isItem;
    }
   
    public boolean tileIsItem(int x, int y){
            return isItem;
    }
   
    boolean tileIsTrap(){
            return isTrap;
    }

}