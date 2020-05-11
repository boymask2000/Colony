package com.colony.enums;

public enum StatoElemento {
	BUILDING, // In fase di costruzione
	WORKING, // operativo normale
	LACKING, // Senza risorse
	STOPPED, // Fermato
	WORKINGON// Qualcuno sta lavorando sull'elemento. Esempio un taglialegna sta tagliando
				// l'albero
}
