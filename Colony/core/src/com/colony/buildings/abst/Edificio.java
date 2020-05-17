package com.colony.buildings.abst;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.commons.Ordine;
import com.colony.enums.TipoElemento;

public abstract class Edificio extends ElementOnRoad{


	protected Stage mainStage;
	protected BaseActor actor;
	
	private String name;

	public Edificio(float x, float y, Stage s, BaseActor act, String name) {

		this.mainStage = s;
		this.actor = act;

		this.x = x;
		this.y = y;
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public abstract void work();

	
	public BaseActor getActor() {
		return actor;
	}

	public void handleDelivery(Ordine ordine) {

	}

	

}
