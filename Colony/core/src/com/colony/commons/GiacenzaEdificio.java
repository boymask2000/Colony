package com.colony.commons;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.colony.enums.Materiale;

public class GiacenzaEdificio {
	private Map<Materiale, Integer> map = new HashMap<Materiale, Integer>();

	public Map<Materiale, Integer> getAll() {
		return map;
	}
	public void addMateriale(Materiale m) {
		Integer count = map.get(m);
		if (count == null)
			map.put(m, 1);
		else
			map.put(m, count + 1);
	}
	public void addMateriale(Materiale m, int qta) {
		Integer count = map.get(m);
		if (count == null)
			map.put(m, qta);
		else
			map.put(m, count + qta);
	}

	public void removeMateriale(Materiale m) {
		Integer count = map.get(m);
		if (count != null)
			map.put(m, count - 1);
	}
	public void removeMateriale(Materiale m, int qta) {
		Integer count = map.get(m);
		if (count != null)
			map.put(m, count - qta);
	}

	public int getGiacenzaMateriale(Materiale m) {
		Integer count = map.get(m);
		if (count == null)
			return 0;
		return count;
	}
	public void dump() {
		Set<Entry<Materiale, Integer>> s = map.entrySet();
		
		Iterator<Entry<Materiale, Integer>> iter = s.iterator();
		System.out.println("-------------------------------------------");
		while( iter.hasNext()) {
			Entry<Materiale, Integer> n = iter.next();
			System.out.println(n.getKey() + ": "+n.getValue());
		}
		System.out.println("-------------------------------------------");
		
	}

}
