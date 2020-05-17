package com.colony.commons;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.DefaultGraphPath;
import com.badlogic.gdx.ai.pfa.GraphPath;
import com.badlogic.gdx.ai.pfa.indexed.IndexedAStarPathFinder;
import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class CartinaStradale {
	private static List<TrattoStrada> strade = new ArrayList<TrattoStrada>();
	private static List<Milestone> mstone = new ArrayList<Milestone>();

	private List<Milestone> bestPath = new ArrayList<Milestone>();

	public Milestone calcPath(//
			List<Milestone> path, //
			Milestone a, //
			Milestone b, //
			int bestCost, //
			int currentCost) {//

		Milestone k = null;
		if (a == null || b == null)
			return null;// path.add(a);
		List<Milestone> nears = getNears(a);
		for (Milestone m : nears) {

			if (path.contains(m))
				continue;

			path.add(m);
			int cost = calcCost(path);
			if (cost >= currentCost)
				continue;
			currentCost = cost;

			if (m == b) {
				k = m;
				bestCost = currentCost + 1;
				setBestPath(path, bestPath);
			} else
				k = calcPath(path, m, b, bestCost, currentCost + 1);

			path.remove(path.size() - 1);

		}
		return k;

	}

	private int calcCost(List<Milestone> path) {

		return path.size();
	}

	private List<Milestone> getNears(Milestone m) {
		List<Milestone> out = new ArrayList<Milestone>();
		for (TrattoStrada t : strade) {
			if (t.getMilestoneEnd() == m)
				out.add(t.getMilestoneStart());
			if (t.getMilestoneStart() == m)
				out.add(t.getMilestoneEnd());
		}
		return out;
	}

	public static void removeMilestone(Milestone m) {
		mstone.remove(m);
		m.remove();
	}

//	public void dump() {
//		for (Milestone m : mstone)
//			m.dump();
//		for (TrattoStrada t : strade)
//			t.dump();
//	}

	private void setBestPath(List<Milestone> path, List<Milestone> bestPath) {
		bestPath.clear();
		for (Milestone m : path)
			bestPath.add(m);

	}

	public Milestone findPath(Milestone a, Milestone b) {
		System.out.println("PATH from:" + a.toString() + "TO " + b.toString());
		// dump();
		List<Milestone> path = new ArrayList<Milestone>();

		Milestone m = calcPath(path, a, b, 1000000, 0);
		if (bestPath.size() > 0) {
			return bestPath.get(0);

		}
		return m;
	}

	public static TrattoStrada setStart(int x, int y, TrattoStrada tratto, Stage mainStage) {
		Milestone m;
		if (tratto != null) {
			m = tratto.getMilestoneEnd();
		} else {
			m = searchMilestone(x, y);
			if (m == null) {
				m = createMilestone(x, y, mainStage);

			}
		}

		TrattoStrada t = new TrattoStrada(m, mainStage);
		strade.add(t);

		return t;
	}

	public static void setEnd(TrattoStrada tratto, int x, int y) {

		Milestone m = searchMilestone(x, y);
		if (m == null) {
			m = createMilestone(x, y, tratto.getStage());

		}

		tratto.setMilestoneEnd(m);

	}

	public static void remove(TrattoStrada tratto) {
		if (tratto == null)
			return;
		strade.remove(tratto);
		tratto.remove();
	}

	public static Milestone createMilestone(int x, int y, Stage mainStage) {
		Milestone m = new Milestone(x, y, mainStage);
		mstone.add(m);

		System.out.println("creato ms. " + m.getId() + " size= " + mstone.size());
		return m;
	}

	public static Milestone searchNearestMilestone(int x, int y, float maxDist) {
		if (mstone.size() == 0)
			return null;
		Milestone best = mstone.get(0);
		Vector2 bestPos = best.getPosition();
		float dist = Utils.calcDist(x, y, bestPos.x, bestPos.y);
		for (Milestone m : mstone) {
			Vector2 vm = m.getPosition();
			float d = Utils.calcDist(x, y, vm.x, vm.y);
			if (d < dist) {
				dist = d;
				bestPos = vm;
				best = m;
			}
		}

		if (dist > maxDist)
			return null;
		return best;

	}

	public static Milestone searchMilestone(int x, int y) {
		return searchNearestMilestone(x, y, 2000);

	}

	public static TrattoStrada getNearestTratto(float x, float y) {
		if (strade.size() == 0)
			return null;
		TrattoStrada bestStrada = strade.get(0);
		int best = 1000000;

		for (TrattoStrada t : strade) {
			int dist = (int) distanzaPuntoStrada(x, y, t);
			if (dist < best) {
				best = dist;
				bestStrada = t;
			}
			if (best < 2000)
				break;
		}
		return bestStrada;
	}

	// Non va bene. Da correggere
	private static float distanzaPuntoStrada(float x, float y, TrattoStrada t) {
		float xStart = t.getStart().x;
		float yStart = t.getStart().y;
		float xEnd = t.getEnd().x;
		float yEnd = t.getEnd().y;

		float d1 = Utils.calcDist(xEnd, yEnd, x, y);
		float d2 = Utils.calcDist(xStart, yStart, x, y);
		if (d1 < d2)
			return d1;

		return d2;
	}
}
