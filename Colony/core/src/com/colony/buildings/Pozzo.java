package com.colony.buildings;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.buildings.abst.EdificioFabbrica;
import com.colony.enums.Materiale;
import com.colony.enums.TipoElemento;

public class Pozzo extends EdificioFabbrica {
	public Pozzo(float x, float y, Stage s, BaseActor act) {
		super(x, y,s, act, "Pozzo");
		tipoElemento = TipoElemento.POZZO;

		prodotto = Materiale.ACQUA;
	}

	
}
