package com.colony.buildings.actors;

import com.badlogic.gdx.ai.pfa.GraphPath;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.buildings.abst.Edificio;
import com.colony.commons.CartinaStradale;
import com.colony.commons.Milestone;
import com.colony.enums.TipoElemento;

public class Transporter extends BaseActor {
	public static final int IDLE = 0;
	public static final int STATUS_DEPOSITO_TO_SOURCE = 1;
	public static final int STATUS_SOURCE_TO_TARGET = 2;
	public static final  int STATUS_TARGET_TO_DEPOSITO = 3;
	public static final  int STATUS_TAPPA = 4;
	public int currentStatus = IDLE;

	private Milestone source;
	private Milestone target;

	private Milestone depositoHome;

	private Milestone currentTarget = null;

	private void moving() {
		if (currentTarget == null)
			return;
		
		switch( currentStatus) {
		case IDLE:break;
		case STATUS_DEPOSITO_TO_SOURCE:
			execMove();
			break;
		case STATUS_SOURCE_TO_TARGET:
			break;
		case STATUS_TARGET_TO_DEPOSITO:
			break;
		case STATUS_TAPPA:
			break;
		}

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
		this.source = sourceEd.getMilestone();
		this.target = targetEd.getMilestone();
		currentStatus = STATUS_DEPOSITO_TO_SOURCE;

		CartinaStradale cartina = new CartinaStradale();
		Milestone next = cartina.findPath(source, target);
		System.out.println("next = " + next);
		currentTarget = next;
		return true;
	}

	public Transporter(Edificio depositoHome, Stage s, TipoElemento tipo) {
		super(depositoHome.getX(), depositoHome.getY(), s, tipo);
		loadAnimWorking();
	}

	public void setDepositoHome(Edificio depositoHome) {
		this.depositoHome = depositoHome.getMilestone();
	}

	@Override
	public void act(float dt) {
		if (currentStatus == IDLE)
			return;

		super.act(dt);

		applyPhysics(dt);
		setAnimationPaused(!isMoving());
		if (getSpeed() > 0)
			setRotation(getMotionAngle());

		moving();
	}

	@Override
	public void loadAnimWorking() {

	}
}