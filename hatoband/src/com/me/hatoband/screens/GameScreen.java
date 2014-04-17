package com.me.hatoband.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.me.hatoband.HatoGame;
import com.me.hatoband.game.*;

public class GameScreen
extends
    AbstractScreen
{
    private Texture character, wall, floor, item;
    private Sprite charSprite, wallSprite, floorSprite, itemSprite;
    private BitmapFont font;
    private int posX, posY;
    private Tile[][] map = new Tile[30][20];
    private Player player = new Player();
    
	
	public GameScreen(HatoGame game) {
		super(game);
		character = new Texture(Gdx.files.internal("data/walk1.png"));
        charSprite = new Sprite(character);
        wall = new Texture(Gdx.files.internal("data/wall1.png"));
        wallSprite = new Sprite(wall);
        floor = new Texture(Gdx.files.internal("data/floor1.png"));
        floorSprite = new Sprite(floor);
        item = new Texture(Gdx.files.internal("data/chest.png"));
        itemSprite = new Sprite(item);
        font = new BitmapFont();
        font.setColor(Color.RED);
        posX = 1;
        posY = 17;
	    charSprite.setPosition(posX*16, posY*16);
	    
	    
	   
	    for (int i = 0; i < 29; i++){
	        for (int j = 0; j < 19; j++){
	                if (i > 0 && i < 28 && j > 0 && j < 18)
	                        map[i][j] = new Floor();
	                else
	                		map[i][j] = new Wall();
	        }
	    }

	    map[10][13] = new Item("Trap");
	    
	    stage.addListener(new InputListener(){
	    	@Override
        	public boolean keyDown(InputEvent event, int keycode){
        		if(keycode == Keys.DOWN){
        			if (!map[posX][posY-1].tileIsWall()){
                		posY -= 1;
        			}
        		}
        		if (keycode == Keys.UP){
                    if (!map[posX][posY+1].tileIsWall()){
                    	posY += 1;
                    }
                }
        		if (keycode == Keys.LEFT){
                    if (!map[posX-1][posY].tileIsWall()){
                    	posX -= 1;
                    }
        	    }
        		if (keycode == Keys.RIGHT){
        	        if (!map[posX+1][posY].tileIsWall()){
        	        	posX += 1;
        	        }
        	    }
        		if(keycode == Keys.RIGHT || keycode == Keys.LEFT
        		|| keycode == Keys.UP || keycode == Keys.DOWN){
        			if (map[posX][posY].tileIsItem()){
        				player.takeDamage(1);
        			}
        			return true;
        		}

        		else{
        			return false;
        		}
        	}
	    });
	    
	    Gdx.input.setInputProcessor(stage);
	}

    @Override
    public void dispose() {
            batch.dispose();
            character.dispose();
    }

    @Override
    public void pause() {
            // TODO Auto-generated method stub
           
    }

    @Override
    public void render(float delta) {
    	super.render(10f);
       
        //Main game screen when player is not dead
        if (!player.isDead()){
                charSprite.setPosition(posX*16, posY*16);
                batch.begin();
                font.draw(batch, ("Position: " + posX + ", " + posY), 0, 320);
                font.draw(batch, ("Item: " + map[posX][posY].tileIsItem(posX,posY)), 120, 320);
                font.draw(batch, ("HP: " + player.getHp()), 240, 320);
                for (int i = 0; i < 29; i++){
                    for (int j = 0; j < 19; j++){
                            if (map[i][j].tileIsWall()){
                                    wallSprite.setPosition(i*16, j*16);
                                    wallSprite.draw(batch);
                            }
                            else if (map[i][j].tileIsFloor()){
                                    floorSprite.setPosition(i*16, j*16);
                                    floorSprite.draw(batch);
                            }
                            else if (map[i][j].tileIsItem()){
                                    itemSprite.setPosition(i*16, j*16);
                                    itemSprite.draw(batch);
                            }
                    }
                }
                charSprite.draw(batch);
                batch.end();
        }
       
        //Player is dead
        else if (player.isDead()){
            batch.begin();
            font.draw(batch, "Player is dead.", 240, 180);
            batch.end();
        }
        // Process input
        /*
        if (Gdx.input.isKeyPressed(Keys.DOWN)){
        	if (!map[posX][posY-1].tileIsWall())
        		posY -= 1;
        }
        if (Gdx.input.isKeyPressed(Keys.UP)){
            if (!map[posX][posY+1].tileIsWall())
            	posY += 1;
        }
        if (Gdx.input.isKeyPressed(Keys.LEFT)){
            if (!map[posX-1][posY].tileIsWall())
            	posX -= 1;
	    }
	    if (Gdx.input.isKeyPressed(Keys.RIGHT)){
	        if (!map[posX+1][posY].tileIsWall())
	        	posX += 1;
	    }
        */
        
    }



}