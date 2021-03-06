package com.colony.buildings.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.buildings.Castello;
import com.colony.buildings.abst.InfoPanelActor;
import com.colony.buildings.actors.infopanels.InfoPanelCastello;
import com.colony.enums.TipoElemento;

public class CastelloActor extends InfoPanelActor {

	public CastelloActor(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.CASTELLO);
		edificio = new Castello(x, y, s, this);
		loadAnimWorking();
	}

	public void loadAnimWorking() {
		String animations[] = { "castello.png" };
		loadAnimationFromFiles(animations, 0.1f, true);

	}

	@Override
	protected void showInfoPanel() {
		new InfoPanelCastello(mainStage, getEdificio());
		
	}

}
