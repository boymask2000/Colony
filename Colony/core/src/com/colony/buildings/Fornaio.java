package com.colony.buildings;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.buildings.abst.EdificioFabbrica;
import com.colony.commons.MaterialeNecessario;
import com.colony.enums.Materiale;
import com.colony.enums.TipoElemento;

public class Fornaio extends EdificioFabbrica {
	public Fornaio(float x, float y, Stage s, BaseActor act) {
		super(x, y, s, act, "Fornaio");
		tipoElemento = TipoElemento.FORNAIO;

		prodotto = Materiale.PANE;

		MaterialeNecessario m = new MaterialeNecessario(Materiale.FARINA, 1);
		materiePrimeNecessarie.add(m);
		MaterialeNecessario m1 = new MaterialeNecessario(Materiale.ACQUA, 1);
		materiePrimeNecessarie.add(m1);
	}

}
