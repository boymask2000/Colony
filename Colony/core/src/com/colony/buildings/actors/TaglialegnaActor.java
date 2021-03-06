package com.colony.buildings.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.buildings.Taglialegna;
import com.colony.buildings.abst.InfoPanelActor;
import com.colony.buildings.actors.infopanels.InfoPanelCastello;
import com.colony.enums.TipoElemento;

public class TaglialegnaActor extends InfoPanelActor {
 

	public TaglialegnaActor(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.TAGLIALEGNA);
		edificio = new Taglialegna(x, y, s, this);
	
	}
	public void loadAnimWorking() {
		String animations[] ={ "taglialegna.png" };
		loadAnimationFromFiles(animations, 0.1f, true);
		
	}
	
	@Override
	protected void showInfoPanel() {
		new InfoPanelCastello(mainStage, getEdificio());
		
	}
}
