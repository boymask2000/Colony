package com.colony.enums;

public enum Materiale {
	ACQUA("acqua.png"), //
	TRONCO("tronco.png"), //
	ASSE_LEGNO("asse.png") //
, FASCIO_GRANO("covone.png"), 
FARINA("covone.png"), PANE("covone.png")
	;

	private final String img;

	public String getImg() {
		return img;
	}

	private Materiale(String img) {
		this.img = img;
	}

}
