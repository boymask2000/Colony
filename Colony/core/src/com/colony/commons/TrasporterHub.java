package com.colony.commons;

import java.util.ArrayList;
import java.util.List;

import com.colony.buildings.abst.Edificio;

public class TrasporterHub {
	
	private static List<Pacco> pacchi = new ArrayList<>();

	public static void createTrasport(Edificio partenza, Edificio destinazione, Ordine o) {

//		System.out.println("Richiesta trasporto " + o.getMateriale() + " da " + partenza.getName() + " a "
//				+ destinazione.getName());
//		
		Pacco p = new Pacco( partenza,  destinazione,  o);
		pacchi.add(p);
	}
	
	public static Pacco getPacco1() {
		if( pacchi.size()==0)return null;
		Pacco p = pacchi.get(pacchi.size()-1);
		pacchi.remove(pacchi.size()-1);
		return p;
	}
	public static Pacco getPacco() {
		if( pacchi.size()==0)return null;
		Pacco p = pacchi.get(0);
		pacchi.remove(0);
		return p;
	}
	public static void setPacco(Pacco p) {
		pacchi.add(p);
	}

}
