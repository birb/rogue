package com.me.hatoband.game;

public class Wall extends Tile{
    
    boolean walkable = false;
    boolean isWall = true;
   
    public boolean tileIsWall(){
            return isWall;
    }

}