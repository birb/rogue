package com.me.hatoband;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputProcessor;
//import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.FPSLogger;
//import com.badlogic.gdx.graphics.GL20;
import com.me.hatoband.screens.MenuScreen;
import com.me.hatoband.screens.OptionsScreen;
import com.me.hatoband.screens.SplashScreen;

public class HatoGame extends Game{
	
	public HatoGame() {
		//super();
	}
	
	public SplashScreen getSplashScreen()
    {
        return new SplashScreen( this );
    }
	
	public MenuScreen getMenuScreen()
	{
		return new MenuScreen( this );
	}
	
	public OptionsScreen getOptionsScreen()
	{
		return new OptionsScreen( this );
	}
 
	// Game methods

    @Override
    public void create()
    {
    	this.setScreen( getSplashScreen() );
    }

    @Override
    public void resize(
        int width,
        int height )
    {
        super.resize( width, height );
        
    }

    @Override
    public void render()
    {
        super.render();

        // output the current FPS
    }

    @Override
    public void pause()
    {
        super.pause();
   
    }

    @Override
    public void resume()
    {
        super.resume();
    }

    @Override
    public void setScreen(
        Screen screen )
    {
        super.setScreen( screen );

    }

    @Override
    public void dispose()
    {
        super.dispose();
    }

}
