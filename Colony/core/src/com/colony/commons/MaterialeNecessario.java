package com.colony.commons;

import com.colony.enums.Materiale;

public class MaterialeNecessario {
	private Materiale materiale;
	private int num;

	public MaterialeNecessario(Materiale materiale, int num) {

		this.materiale = materiale;
		this.num = num;
	}

	public Materiale getMateriale() {
		return materiale;
	}

	public void setMateriale(Materiale materiale) {
		this.materiale = materiale;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
