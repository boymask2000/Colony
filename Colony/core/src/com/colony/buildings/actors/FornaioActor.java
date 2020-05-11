package com.colony.buildings.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.buildings.Fornaio;
import com.colony.buildings.Mulino;
import com.colony.buildings.abst.InfoPanelActor;
import com.colony.buildings.actors.infopanels.InfoPanelCastello;
import com.colony.enums.TipoElemento;

public class FornaioActor extends InfoPanelActor {

	public FornaioActor(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.FORNAIO);

		edificio = new Fornaio(x, y, s, this);

	}

	@Override
	protected void loadAnimStopped() {
		String animations[] = { "fornaio/working/fornaio.png"};
		loadAnimationFromFiles(animations, 0.1f, true);
	}
	@Override
	public void loadAnimWorking() {
		String animations[] = {
				"fornaio/working/fornaio.png",
				"fornaio/working/fornaio.png",
				"fornaio/working/fornaio.png",
				"fornaio/working/fornaio.png"
		};
		loadAnimationFromFiles(animations, 0.1f, true);

	}
	@Override
	protected void showInfoPanel() {
		new InfoPanelCastello(mainStage, getEdificio());
		
	}
}
