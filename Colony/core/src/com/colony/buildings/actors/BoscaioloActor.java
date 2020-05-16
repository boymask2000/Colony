package com.colony.buildings.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.buildings.Boscaiolo;
import com.colony.buildings.abst.InfoPanelActor;
import com.colony.buildings.actors.infopanels.InfoPanelCastello;
import com.colony.enums.TipoElemento;

public class BoscaioloActor extends InfoPanelActor {

	public BoscaioloActor(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.BOSCAIOLO);
		edificio = new Boscaiolo(x, y, s, this);

	}

	@Override
	public void loadAnimWorking() {
		String animations[] = { "boscaiolo.png" };
		loadAnimationFromFiles(animations, 0.1f, true);

	}

	@Override
	protected void showInfoPanel() {
		new InfoPanelCastello(mainStage, getEdificio());
		
	}

	
	

}
