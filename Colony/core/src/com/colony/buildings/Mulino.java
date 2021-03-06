package com.colony.buildings;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.buildings.abst.EdificioFabbrica;
import com.colony.commons.MaterialeNecessario;
import com.colony.enums.Materiale;
import com.colony.enums.TipoElemento;

public class Mulino extends EdificioFabbrica {
	public Mulino(float x, float y, Stage s, BaseActor act) {
		super(x, y, s, act, "Mulino");
		tipoElemento = TipoElemento.MULINO;

		prodotto = Materiale.FARINA;

		MaterialeNecessario m = new MaterialeNecessario(Materiale.FASCIO_GRANO, 1);
		materiePrimeNecessarie.add(m);
	}

}
