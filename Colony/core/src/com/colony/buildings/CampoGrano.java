package com.colony.buildings;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.buildings.abst.Coltivatore;
import com.colony.commons.Anagrafica;
import com.colony.enums.Materiale;
import com.colony.enums.TipoElemento;
import com.colony.fixed.CosaCheCresce;
import com.colony.fixed.Grano;

public class CampoGrano extends Coltivatore{

	public CampoGrano(float x, float y, Stage s, BaseActor act) {
		super(x, y, s, act, "Campo di Grano");
		tipoElemento = TipoElemento.CAMPO_GRANO;

		prodotto = Materiale.FASCIO_GRANO;
	}

	@Override
	protected CosaCheCresce createItem(float posX, float posY) {
		return Anagrafica.createGrano(posX, posY, mainStage);
		
	}

}
