package com.colony.commons;

import com.colony.enums.Materiale;

public class Ordine {
	private int idEdificio;
	private Materiale materiale;
	

	public Ordine(int idEdificio, Materiale materiale) {
		this.idEdificio = idEdificio;
		this.materiale = materiale;
	}

	public int getIdEdificio() {
		return idEdificio;
	}

	public void setIdEdificio(int idEdificio) {
		this.idEdificio = idEdificio;
	}

	public Materiale getMateriale() {
		return materiale;
	}

	public void setMateriale(Materiale materiale) {
		this.materiale = materiale;
	}

}