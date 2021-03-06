package com.colony.buildings;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.buildings.abst.EdificioFabbrica;
import com.colony.commons.MaterialeNecessario;
import com.colony.enums.Materiale;
import com.colony.enums.TipoElemento;

public class Segheria extends EdificioFabbrica {
	public Segheria(float x, float y, Stage s, BaseActor act) {
		super(x, y, s, act, "Segheria");
		
		tipoElemento = TipoElemento.SEGHERIA;

		prodotto = Materiale.ASSE_LEGNO;

		MaterialeNecessario m = new MaterialeNecessario(Materiale.TRONCO, 1);
		materiePrimeNecessarie.add(m);
	}
}
