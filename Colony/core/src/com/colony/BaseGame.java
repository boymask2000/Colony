package com.colony;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

public abstract class BaseGame extends Game {
	private static BaseGame game;

	@Override
	public void create() {
		InputMultiplexer im = new InputMultiplexer();
		Gdx.input.setInputProcessor(im);

	}

	public BaseGame() {
		game = this;
	}

	public static void setActiveScreen(BaseScreen s) {
		game.setScreen(s);
	}
}
