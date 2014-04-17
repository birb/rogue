package com.me.hatoband.game;

import java.util.LinkedList;

public class Player extends Creature{
    
    int health = 10;
    int xp = 0;
    int level = 1;
    int atk = 1;
    int def = 0;
    public Inventory inventory = new Inventory();
    boolean dead = false;
   
    public int getHp(){
            if (health <= 0)
                    dead = true;
            return health;
    }
   
    public void takeDamage(int dmg){
            health -= dmg;
    }
   
    public void restoreHp(int restore){
            health += restore;
    }
   
    public boolean isDead(){
            return dead;
    }
   
}