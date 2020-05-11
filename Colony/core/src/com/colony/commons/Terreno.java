package com.colony.commons;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.math.Vector2;

public class Terreno {
	public static final int MARGIN = 10;

	private static Map<String, Boolean> map = new HashMap<String, Boolean>();
	
	public static Vector2 normalize(float x, float y ) {
		int nX = normalize(x);
		int nY = normalize(y);
		return new Vector2(nX,nY);
	}

	public static boolean isFree(float x, float y) {
		String key = getKey(x, y);
		Boolean val = map.get(key);
		if (val == null)
			return true;
		return false;
	}

	public static void free(float x, float y) {
		String key = getKey(x, y);
		map.remove(key);
	}
	public static void alloc(float x, float y) {
		String key = getKey(x, y);
		map.put(key,true);
	}

	private static String getKey(float x, float y) {
		int nX = normalize(x);
		int nY = normalize(y);
		String key = nX + "-" + nY;
		return key;
	}

	public static int normalize(float y) {
		int i = (int) y / MARGIN;

		return i * MARGIN;
	}
//	public static void main(String s[]) {
//		Terreno t = new Terreno();
//		
//		System.out.println(t.normalize( (float) 12.5434));
//		System.out.println(t.normalize( (float) 111.5434));
//	}
}
