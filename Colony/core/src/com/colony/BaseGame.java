package com.colony;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public abstract class BaseGame extends Game {
	private static BaseGame game;

	public static BitmapFont customFont;

	@Override
	public void create() {
		InputMultiplexer im = new InputMultiplexer();
		Gdx.input.setInputProcessor(im);

	
		FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("font1.ttf"));
		FreeTypeFontParameter fontParameters = new FreeTypeFontParameter();
		fontParameters.size = 48;
		fontParameters.color = Color.WHITE;
		fontParameters.borderWidth = 2;
		fontParameters.borderColor = Color.WHITE;
		fontParameters.borderStraight = true;
		fontParameters.minFilter = TextureFilter.Linear;
		fontParameters.magFilter = TextureFilter.Linear;
		customFont = fontGenerator.generateFont(fontParameters);
	}

	public BaseGame() {
		game = this;
	}

	public static void setActiveScreen(BaseScreen s) {
		game.setScreen(s);
	}
}
