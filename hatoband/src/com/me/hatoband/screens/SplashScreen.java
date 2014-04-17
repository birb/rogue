package com.me.hatoband.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.hatoband.HatoGame;

public class SplashScreen extends AbstractScreen {
	private Texture splashTexture;
    private TextureRegion splashTextureRegion;
    
    public SplashScreen(HatoGame hgame){
    	super(hgame);
    	this.game = hgame;
    	
    }
    
    @Override
    public void show()
    {
        super.show();
        
        // load the splash image and create the texture region
        splashTexture = new Texture(Gdx.files.internal("data/title.jpg"));
 
        // we set the linear texture filter to improve the stretching
        splashTexture.setFilter( TextureFilter.Linear, TextureFilter.Linear );
 
        // in the image atlas, our splash image begins at (0,0) at the
        // upper-left corner and has a dimension of 512x301
        splashTextureRegion = new TextureRegion( splashTexture, 0, 0, 512, 350 );
    }
    
 
    @Override
    public void render(
        float delta )
    {
        super.render( delta );
        
        if(Gdx.input.isButtonPressed(Input.Keys.ENTER)){
        	game.setScreen(new MenuScreen(game));
        }
        // we use the SpriteBatch to draw 2D textures (it is defined in our base
        // class: AbstractScreen)
        batch.begin();
 
        // we tell the batch to draw the region starting at (0,0) of the
        // lower-left corner with the size of the screen
        batch.draw( splashTextureRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
 
        // the end method does the drawing
        batch.end();
    }
 
    @Override
    public void dispose()
    {
        super.dispose();
        splashTexture.dispose();
    }
}
