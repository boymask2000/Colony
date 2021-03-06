package com.colony.buildings;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.enums.Materiale;
import com.colony.enums.TipoElemento;

public class Taglialegna extends CollectorSuArea {
	public Taglialegna(float x, float y, Stage s, BaseActor act) {
		super(x, y, s, act, "Taglialegna");
		tipoElemento = TipoElemento.TAGLIALEGNA;
		prodotto = Materiale.TRONCO;
		setTargetType(TipoElemento.ALBERO);
	}
}
