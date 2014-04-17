package com.me.hatoband.screens;
 
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.me.hatoband.HatoGame;
 
public class MenuScreen
    extends
        AbstractScreen
{
    public MenuScreen(
        final HatoGame game )
    {
        super( game );
        
        Skin skin = super.getSkin();
        
        final TextButton start = new TextButton("Start Birds", skin, "default");
        final TextButton button = new TextButton("Options", skin, "default");
        
        button.setWidth(200f);
        button.setHeight(40f);
        
        start.setWidth(200f);
        start.setHeight(40f);
        
        button.setPosition(Gdx.graphics.getWidth()/2 - 100f, Gdx.graphics.getHeight()/2);
        start.setPosition(Gdx.graphics.getWidth()/2 - 100f, Gdx.graphics.getHeight()/2 + 50f);
 
        button.addListener(new ClickListener(){
        	@Override
        	public void clicked(InputEvent event, float x, float y){
        		game.setScreen(new OptionsScreen(game));
        	}
        });
        
        start.addListener(new ClickListener(){
        	@Override
        	public void clicked(InputEvent event, float x, float y){
        		game.setScreen(new GameScreen(game));
        	}
        });
        
        stage.addActor(button);
        stage.addActor(start);
        
    }
 
    @Override
    public void show()
    {
    	super.show();
    }
    
    
    @Override
    public void resize(
        int width,
        int height )
    {
        super.resize( width, height );

    }
    
}