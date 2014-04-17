package com.me.hatoband;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		ApplicationListener listener = new HatoGame();
		cfg.title = "hatoband";
		cfg.width = 480;
		cfg.height = 320;
		
		new LwjglApplication(listener, cfg);
	}
}
