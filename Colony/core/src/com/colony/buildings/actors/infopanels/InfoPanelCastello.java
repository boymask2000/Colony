package com.colony.buildings.actors.infopanels;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.buildings.abst.Edificio;

public class InfoPanelCastello extends InfoPanelScreen {

	public InfoPanelCastello(Stage mainStage, Edificio edificio) {
		super(mainStage, edificio);

		showInfo();
		addOk();
	}

}
