package com.me.hatoband.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.me.hatoband.HatoGame;

public abstract class AbstractScreen implements Screen{
	protected HatoGame game;
	protected SpriteBatch batch;
	protected Stage stage;
	private Skin skin;
	
	public AbstractScreen(HatoGame game){
		super();
		this.game = game;
		batch = new SpriteBatch();
		stage = new Stage(0, 0, true);
	}
	
	
	@Override
    public void show()
    {
		Gdx.input.setInputProcessor( stage );
    }

    @Override
    public void resize(
        int width,
        int height )
    {
    	stage.setViewport( width, height, true );
    }
    
    protected Skin getSkin()
    {
        if( skin == null ) {
            FileHandle skinFile = Gdx.files.internal( "data/gui/uiskin.json" );
            skin = new Skin( skinFile );
        }
        return skin;
    }

    public void render(float delta)
    {
        // the following code clears the screen with the given RGB color (black)
    	
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        
        stage.act( delta );
        stage.draw();
    }

    @Override
    public void hide()
    {
    	//this.dispose();
    }

    @Override
    public void pause()
    {
    }

    @Override
    public void resume()
    {
    }

    @Override
    public void dispose()
    {
        //if( font != null ) font.dispose();
        if( batch != null ) batch.dispose();
        if( skin != null ) skin.dispose();
    }

	public void create() {
		// TODO Auto-generated method stub
		
	}

	
}
