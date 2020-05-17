package com.colony.commons;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Utils {
	private static BitmapFont customFont = null;

	public static float calcDist(float x, float y, float x2, float y2) {
		return (x - x2) * (x - x2) + (y - y2) * (y - y2);
		
	//	return Vector2.dst(x, y, x2, y2);

	}

	

}
