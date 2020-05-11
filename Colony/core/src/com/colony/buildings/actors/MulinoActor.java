package com.colony.buildings.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.buildings.Mulino;
import com.colony.buildings.abst.InfoPanelActor;
import com.colony.buildings.actors.infopanels.InfoPanelCastello;
import com.colony.enums.TipoElemento;

public class MulinoActor extends InfoPanelActor {

	public MulinoActor(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.MULINO);

		edificio = new Mulino(x, y, s, this);

	}

	@Override
	protected void loadAnimStopped() {
		String animations[] = { "mulino/stopped/mulino_0.gif"};
		loadAnimationFromFiles(animations, 0.1f, true);
	}
	@Override
	public void loadAnimWorking() {
		String animations[] = {
				"mulino/working/mulino_0.gif",
				"mulino/working/mulino_1.gif",
				"mulino/working/mulino_2.gif",
				"mulino/working/mulino_3.gif"
		};
		loadAnimationFromFiles(animations, 0.1f, true);

	}
	@Override
	protected void showInfoPanel() {
		new InfoPanelCastello(mainStage, getEdificio());
		
	}
}
