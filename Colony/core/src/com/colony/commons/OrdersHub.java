package com.colony.commons;

import java.util.ArrayList;
import java.util.List;

import com.colony.enums.Materiale;

public class OrdersHub {
	private static List<Ordine> ordini = new ArrayList<>();

	public static void addOrder(Ordine o) {
		System.out.println("creato order for "+o.getMateriale());
		ordini.add(o);
	}

	public static Ordine getOrdine(Materiale m) {
	
		Ordine found = null;
		int i = 0;
		for (i = 0; i < ordini.size(); i++) {
			Ordine o = ordini.get(i);

			if (o.getMateriale() == m) {
				found = o;
				break;
			}
		}
		if (found != null) {
			ordini.remove(i);
			return found;
		}
		return null;
	}

}
