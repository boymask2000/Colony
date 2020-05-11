package com.colony;

public class ColonyGame extends BaseGame{

	@Override
	public void create() {
		super.create();
		setActiveScreen(new LevelScreen());
		
	}

}
