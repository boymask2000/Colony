package com.colony.buildings.making;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.buildings.Pozzo;
import com.colony.buildings.abst.InfoPanelActor;
import com.colony.buildings.actors.infopanels.InfoPanelCastello;
import com.colony.enums.TipoElemento;

public class PozzoMakingActor extends BaseActor {

	public PozzoMakingActor(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.POZZO);

	}

	public void loadAnimWorking() {
		String animations[] = { "pozzo.png" };
		loadAnimationFromFiles(animations, 0.1f, true);

	}
	
}
