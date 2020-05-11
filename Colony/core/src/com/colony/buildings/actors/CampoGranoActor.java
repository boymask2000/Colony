package com.colony.buildings.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.buildings.CampoGrano;
import com.colony.buildings.abst.InfoPanelActor;
import com.colony.buildings.actors.infopanels.InfoPanelCastello;
import com.colony.enums.TipoElemento;

public class CampoGranoActor extends InfoPanelActor {

	public CampoGranoActor(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.CAMPO_GRANO);
		edificio = new CampoGrano(x, y, s, this);

	}

	public void loadAnimWorking() {
		String animations[] = { "covone.png" };
		loadAnimationFromFiles(animations, 0.1f, true);

	}

	@Override
	protected void showInfoPanel() {
		new InfoPanelCastello(mainStage, getEdificio());
		
	}

	
	

}
