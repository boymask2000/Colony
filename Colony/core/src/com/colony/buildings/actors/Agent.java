package com.colony.buildings.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.commons.NotifyFromAgent;
import com.colony.commons.Utils;
import com.colony.enums.TipoElemento;

public class Agent extends BaseActor {
	private int timeNeeded = 5;

	private boolean andata = true;
	boolean moving = false;
	private float startX;
	private float startY;
	private float endX;
	private float endY;
	private Mission mission;
	private NotifyFromAgent edificioSuArea;
	private static final int DELTA = 1;

	public Agent(float x, float y, Stage s, NotifyFromAgent edificioSuArea) {
		super(x, y, s, TipoElemento.AGENT);
		loadAnimWorking();
		this.edificioSuArea = edificioSuArea;
	}

	public boolean isMoving() {
		return moving;
	}

	public void goMission(float xx, float yy, Mission mission) {
	
		this.mission = mission;
		startX = getX();
		startY = getY();
		endX = xx;
		endY = yy;
		moving = true;
	}

	@Override
	public void act(float dt) {
		if (!moving)
			return;

		super.act(dt);

		applyPhysics(dt);
		setAnimationPaused(!isMoving());
		if (getSpeed() > 0)
			setRotation(getMotionAngle());

		moving();
	}
	private void moving() {
		float nextX = 0;
		float nextY = 0;
		if (andata) {
			float d = Utils.calcDist(getX(), getY(), endX, endY);
			float d1 = Utils.calcDist(getX() + DELTA, getY(), endX, endY);
			float d2 = Utils.calcDist(getX(), getY() + DELTA, endX, endY);
			float d3 = Utils.calcDist(getX() - DELTA, getY(), endX, endY);
			float d4 = Utils.calcDist(getX(), getY() - DELTA, endX, endY);
			if (d1 < d) {
				nextX = getX() + DELTA;
				nextY = getY();
				d = d1;
			}
			if (d2 < d) {
				nextX = getX();
				nextY = getY() + DELTA;
				d = d2;
			}
			if (d3 < d) {
				nextX = getX() - DELTA;
				nextY = getY();
				d = d3;
			}
			if (d4 < d) {
				nextX = getX();
				nextY = getY() - DELTA;
				d = d4;
			}
			if (d < 3 * DELTA) {
				andata = false;
				mission.exec();
			}

		} else {
			float d = Utils.calcDist(getX(), getY(), startX, startY);
			float d1 = Utils.calcDist(getX() + DELTA, getY(), startX, startY);
			float d2 = Utils.calcDist(getX(), getY() + DELTA, startX, startY);
			float d3 = Utils.calcDist(getX() - DELTA, getY(), startX, startY);
			float d4 = Utils.calcDist(getX(), getY() - DELTA, startX, startY);
			if (d1 < d) {
				nextX = getX() + DELTA;
				nextY = getY();
				d = d1;
			}
			if (d2 < d) {
				nextX = getX();
				nextY = getY() + DELTA;
				d = d2;
			}
			if (d3 < d) {
				nextX = getX() - DELTA;
				nextY = getY();
				d = d3;
			}
			if (d4 < d) {
				nextX = getX();
				nextY = getY() - DELTA;
				d = d4;
			}
			if (d < 3 * DELTA) {
				andata = true;
				moving = false;
				setPosition(startX, startY);
				remove();
				edificioSuArea.notifyMissionComplete();
				return;
			}

		}

		setPosition(nextX, nextY);
	//	boundToWorld();

	}

	public void loadAnimWorking() {
		String animations[] = { "b2.png" };
		loadAnimationFromFiles(animations, 0.1f, true);

	}

	

	public int getTimeNeeded() {
		return timeNeeded;
	}

	public void setTimeNeeded(int timeNeeded) {
		this.timeNeeded = timeNeeded;
	}

	@Override
	public void refreshElement() {
		// TODO Auto-generated method stub
		
	}

}
