package com.me.hatoband.game;

public class Item extends Tile{
    
    String name;
    boolean isItem = true;
   
    public Item(){
            name = "Item";
    }
   
    public Item(String s){
            name = s;
    }
   
    public String getName(){
            return name;
    }
   
    public String toString(){
            return "Item: " + name;
    }
   
    public boolean tileIsItem(){
            return isItem;
    }
   
    public boolean tileIsItem(int x, int y){
            return isItem;
    }

}