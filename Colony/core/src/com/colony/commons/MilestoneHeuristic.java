package com.colony.commons;

import com.badlogic.gdx.ai.pfa.Heuristic;
import com.badlogic.gdx.math.Vector2;

public class MilestoneHeuristic implements Heuristic<Milestone> {

	@Override
	public float estimate(Milestone currentCity, Milestone goalCity) {
		return Vector2.dst(currentCity.getX(), currentCity.getY(), goalCity.getX(), goalCity.getY());
	}
}
