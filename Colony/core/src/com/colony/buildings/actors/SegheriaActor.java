package com.colony.buildings.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.buildings.Segheria;
import com.colony.buildings.abst.InfoPanelActor;
import com.colony.buildings.actors.infopanels.InfoPanelCastello;
import com.colony.enums.TipoElemento;

public class SegheriaActor extends InfoPanelActor {


	public SegheriaActor(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.SEGHERIA);
		edificio = new Segheria(x, y, s, this);
	
	}
	public void loadAnimWorking() {
		String animations[] ={ "segheria.png" };
		loadAnimationFromFiles(animations, 0.1f, true);
		
	}
	@Override
	protected void showInfoPanel() {
		new InfoPanelCastello(mainStage, getEdificio());
		
	}
}
