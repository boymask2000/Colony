package com.colony.buildings.abst;

import com.colony.commons.CartinaStradale;
import com.colony.commons.Milestone;
import com.colony.commons.TrattoStrada;
import com.colony.enums.TipoElemento;

public class ElementOnRoad {
	protected float x;
	protected float y;
	protected TipoElemento tipoElemento;
	private TrattoStrada strada;
	private Milestone milestone;
	

	protected void setMilestone() {
		milestone = CartinaStradale.searchNearestMilestone((int)x, (int)y,200000);
//		if (milestone == null)
//			System.out.println("non trovato milestone");
//		else
//			System.out.println(" milestone !");
	}
	
	public Milestone getMilestone() {
		return milestone;
	}

	public TrattoStrada getStrada() {
		return strada;
	}

	public void setStrada(TrattoStrada strada) {
		this.strada = strada;
	}

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
	public TipoElemento getTipoElemento() {
		return tipoElemento;
	}
	
}
