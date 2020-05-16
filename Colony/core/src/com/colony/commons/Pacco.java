package com.colony.commons;

import com.colony.buildings.abst.Edificio;

public class Pacco {

	private Edificio partenza;
	private Edificio destinazione;
	private Ordine ordine;

	public Pacco(Edificio partenza, Edificio destinazione, Ordine o) {
		this.partenza=partenza;
		this.destinazione=destinazione;
		this.ordine=o;
		
	}
	public Edificio getPartenza() {
		return partenza;
	}

	public Edificio getDestinazione() {
		return destinazione;
	}

	public Ordine getOrdine() {
		return ordine;
	}
}
