package com.colony.buildings.abst;

import com.colony.commons.CartinaStradale;
import com.colony.commons.Milestone;
import com.colony.commons.TrattoStrada;
import com.colony.enums.TipoElemento;

public class ElementOnRoad {
	private static int IDD=0;
	private int id=0;
	
	protected float x;
	protected float y;
	protected TipoElemento tipoElemento;
	private TrattoStrada strada;
	private Milestone milestone;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElementOnRoad other = (ElementOnRoad) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public ElementOnRoad() {
		IDD++;
		id=IDD;
	}
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "ElementOnRoad [id=" + id + "]";
	}
	protected void setMilestone() {
		milestone = CartinaStradale.searchNearestMilestone((int)x, (int)y,200000);
		if( milestone!=null)
			milestone.addAdiacente(this);

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
