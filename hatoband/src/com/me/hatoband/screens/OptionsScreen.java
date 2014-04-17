package com.me.hatoband.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.me.hatoband.HatoGame;

public class OptionsScreen extends AbstractScreen{
	public OptionsScreen(
	        final HatoGame game )
	    {
	        super( game );
	        
	        Skin skin = super.getSkin();
	        
	        final TextButton option1 = new TextButton("Option 1", skin, "default");
	        final TextButton option2 = new TextButton("Option 2", skin, "default");
	        final TextButton option3 = new TextButton("Option 3", skin, "default");
	        final TextButton back = new TextButton("Back", skin, "default");
	        
	        option1.setWidth(200f);
	        option1.setHeight(20f);
	        
	        option2.setWidth(200f);
	        option2.setHeight(20f);
	        
	        option3.setWidth(200f);
	        option3.setHeight(20f);
	        
	        back.setWidth(200f);
	        back.setHeight(20f);
	        
	        
	        option1.setPosition(Gdx.graphics.getWidth()/2 - 100f, Gdx.graphics.getHeight()/2 + 80f);
	        option2.setPosition(Gdx.graphics.getWidth()/2 - 100f, Gdx.graphics.getHeight()/2 + 50f);
	        option3.setPosition(Gdx.graphics.getWidth()/2 - 100f, Gdx.graphics.getHeight()/2 + 20f);
	        back.setPosition(Gdx.graphics.getWidth()/2 - 100f, Gdx.graphics.getHeight()/2 - 10f);
	 
	        option1.addListener(new ClickListener(){
	        	@Override
	        	public void clicked(InputEvent event, float x, float y){
	        		option1.setText("option1 clicked");
	        	}
	        });
	        
	        option2.addListener(new ClickListener(){
	        	@Override
	        	public void clicked(InputEvent event, float x, float y){
	        		option2.setText("option2 clicked");
	        	}
	        });
	        
	        option3.addListener(new ClickListener(){
	        	@Override
	        	public void clicked(InputEvent event, float x, float y){
	        		option3.setText("option3 clicked");
	        	}
	        });
	        
	        back.addListener(new ClickListener(){
	        	@Override
	        	public void clicked(InputEvent event, float x, float y){
	        		game.setScreen(new MenuScreen(game));
	        	}
	        });
	        
	        
	        stage.addActor(option1);
	        stage.addActor(option2);
	        stage.addActor(option3);
	        stage.addActor(back);
	        
	    }
	
		@Override
		public void render(float delta)
		{
			super.render(delta);
			if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
	    	{
	    		game.setScreen(new MenuScreen(game));
	    	}
	    	
		}
	
		@Override
	 	public void dispose()
	    {
	        super.dispose();
	    }

	 

}
