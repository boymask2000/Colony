package com.colony.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.colony.ColonyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
	
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Title";
		cfg.useGL30 = true;
		cfg.height = 1024;
		cfg.width = 1280;
		
		
		new LwjglApplication(new ColonyGame(), cfg);
	}
}
