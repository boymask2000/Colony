package com.colony.fixed;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.enums.TipoElemento;

public class Albero extends CosaCheCresce {
	private static String animations[] = { //
			"tree/tree_0.png", //
			"tree/tree_1.png", //
			"tree/tree_2.png", //
			"tree/tree_3.png" };
	
	public Albero(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.ALBERO, animations);
		
	}

	
}
