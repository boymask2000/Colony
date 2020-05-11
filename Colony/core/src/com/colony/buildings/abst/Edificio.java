package com.colony.buildings.abst;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.commons.Ordine;
import com.colony.enums.TipoElemento;

public abstract class Edificio {

	protected int id;
	protected float x;
	protected float y;
	protected Stage mainStage;
	protected BaseActor actor;
	protected TipoElemento tipoElemento;
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

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getId() {
		return id;
	}

	public BaseActor getActor() {
		return actor;
	}

	public void handleDelivery(Ordine ordine) {

	}

	public TipoElemento getTipoElemento() {
		return tipoElemento;
	}

}