package com.colony.buildings.actors;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.buildings.abst.Edificio;
import com.colony.commons.CartinaStradale;
import com.colony.commons.Milestone;
import com.colony.commons.Utils;
import com.colony.enums.TipoElemento;

public class Transporter extends BaseActor {
	private static final int DELTA = 1;

	public static final int IDLE = 0;
	public static final int STATUS_DEPOSITO_TO_SOURCE = 1;
	public static final int STATUS_SOURCE_TO_TARGET = 2;
	public static final int STATUS_TARGET_TO_DEPOSITO = 3;

	public int currentStatus = IDLE;
	public int nextStatus = IDLE;

	private Milestone source;
	private Milestone target;

	private Milestone depositoHome;

	private Milestone currentTarget = null;
	private Milestone current = null;

	int prev = 0;

	private Milestone source0;

	private Milestone target0;

	private void moving() {
		boolean arrivato = false;
		if (currentTarget == null)
			return;

		if (prev != currentStatus) {
			System.out.println("Status = " + currentStatus);
			System.out.println("NextStatus = " + nextStatus);
			prev = currentStatus;
		}

		switch (currentStatus) {
		case IDLE:
			break;
		case STATUS_DEPOSITO_TO_SOURCE:

			arrivato = execMove();
			if (arrivato) {
				
				// current = currentTarget;
				if (current.getId() == source0.getId()) {
					System.out.println("Arrivato a source");
					currentStatus = STATUS_SOURCE_TO_TARGET;

					// target=target0;
					currentTarget = getNext(current, source0);
				} else {
					currentTarget = getNext(current, source0);
//					nextStatus = STATUS_DEPOSITO_TO_SOURCE;
//					currentStatus = STATUS_TAPPA;
				}
			}
			break;
		case STATUS_SOURCE_TO_TARGET:
			if( target0.getId()==depositoHome.getId()) {
				currentStatus = STATUS_TARGET_TO_DEPOSITO;return;
			}
			arrivato = execMove();
			if (arrivato) {
				if (current.getId() == target0.getId()) {
					currentStatus = STATUS_TARGET_TO_DEPOSITO;
//					target=depositoHome;
//					current = currentTarget;
					currentTarget = getNext(current, target0);

				} else {
					currentTarget = getNext(current, target0);
//					nextStatus = STATUS_SOURCE_TO_TARGET;
//					currentStatus = STATUS_TAPPA;
				}
			}

			break;
		case STATUS_TARGET_TO_DEPOSITO:

			arrivato = execMove();
			if (arrivato) {
				if (current.getId() == depositoHome.getId()) {
					currentStatus = IDLE;
				} else {
				
					currentTarget = getNext(current, depositoHome);
				}
			}

			break;

		}

	}

	private Milestone getNext(Milestone from, Milestone to) {
		CartinaStradale cartina = new CartinaStradale();
		return cartina.findPath(from, to);
	}

	public boolean startMission(Edificio sourceEd, Edificio targetEd) {

		if (sourceEd.getMilestone() == null) {
			System.out.println("source non su strada");
			return false;
		}
		if (targetEd.getMilestone() == null) {
			System.out.println("target non su strada");
			return false;
		}
		this.source0 = sourceEd.getMilestone();
		this.target0 = targetEd.getMilestone();
		currentStatus = STATUS_DEPOSITO_TO_SOURCE;
		System.out.println("startMission " + sourceEd + " to " + targetEd);

		this.source = depositoHome;
		this.target = sourceEd.getMilestone();
		CartinaStradale cartina = new CartinaStradale();
		Milestone next = cartina.findPath(source, target);

		current = depositoHome;// sourceEd.getMilestone();
		currentTarget = next;
		// currentTarget.evidenzia();
		System.out.println("startMission next: " + next.toString());
		return true;
	}

	private boolean execMove() {

		float x2 = currentTarget.getX();
		float y2 = currentTarget.getY();

		float nextX = 0;
		float nextY = 0;
		float xx = getX() + getWidth() / 2;
		float yy = getY() + getHeight() / 2;

		float d = Utils.calcDist(xx, yy, x2, y2);
		float d1 = Utils.calcDist(xx + DELTA, yy, x2, y2);
		float d2 = Utils.calcDist(xx, yy + DELTA, x2, y2);
		float d3 = Utils.calcDist(xx - DELTA, yy, x2, y2);
		float d4 = Utils.calcDist(xx, yy - DELTA, x2, y2);
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
			current = currentTarget;
			return true;
		}
		setPosition(nextX, nextY);
		return false;
	}

	public Transporter(Edificio depositoHome, Stage s, TipoElemento tipo) {
		super(depositoHome.getX(), depositoHome.getY(), s, tipo);
		this.depositoHome = depositoHome.getMilestone();
		loadAnimWorking();
	}

	public void setDepositoHome(Edificio depositoHome) {
		this.depositoHome = depositoHome.getMilestone();
	}

	@Override
	public void act(float dt) {
//		if (currentStatus == IDLE)
//			return;

		super.act(dt);

		applyPhysics(dt);
		setAnimationPaused(!isMoving());
		if (getSpeed() > 0)
			setRotation(getMotionAngle());

		moving();
	}

	@Override
	public void loadAnimWorking() {
		String animations[] = { "pozzo/working/frame_00_delay-0.1s.gif", "pozzo/working/frame_01_delay-0.1s.gif",
				"pozzo/working/frame_02_delay-0.1s.gif", "pozzo/working/frame_03_delay-0.1s.gif",
				"pozzo/working/frame_04_delay-0.1s.gif", "pozzo/working/frame_05_delay-0.1s.gif",
				"pozzo/working/frame_06_delay-0.1s.gif", "pozzo/working/frame_07_delay-0.1s.gif",
				"pozzo/working/frame_08_delay-0.1s.gif", "pozzo/working/frame_09_delay-0.1s.gif",
				"pozzo/working/frame_10_delay-0.1s.gif" };
		loadAnimationFromFiles(animations, 0.1f, true);
	}
}
