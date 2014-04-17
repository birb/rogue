package com.me.hatoband.game;

public class Floor extends Tile{
    
    boolean walkable = true;
    boolean occupied;
    boolean isFloor = true;
   
    public boolean tileIsFloor(){
            return isFloor;
    }

}