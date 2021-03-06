package com.colony.buildings.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.enums.TipoElemento;

public class EdificioSuAreaActor extends BaseActor {

	public EdificioSuAreaActor(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.EDIFICIO_SU_AREA);

	}

	public void loadAnimWorking() {
		String animations[] = { "pozzo.png" };
		loadAnimationFromFiles(animations, 0.1f, true);

	}

	@Override
	public void refreshElement() {
		// TODO Auto-generated method stub

	}

}
