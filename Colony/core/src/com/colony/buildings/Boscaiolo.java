package com.colony.buildings;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.enums.Materiale;
import com.colony.enums.TipoElemento;

public class Boscaiolo extends EdificioSuArea {
	public Boscaiolo(float x, float y, Stage s, BaseActor act) {
		super(x, y,s, act, "Boscaiolo");

		tipoElemento = TipoElemento.BOSCAIOLO;

		prodotto = Materiale.TRONCO;
	}

	
}
