package com.colony;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.buildings.abst.Edificio;
import com.colony.commons.Ordine;
import com.colony.enums.TipoElemento;

public class Carrier extends BaseActor {

	private BaseActor target;
	private Edificio edificioTarget;
	private Ordine ordine;

	public Carrier(float x, float y, Ordine order, Stage s) {
		super(x, y, s, TipoElemento.CARRIER);
		this.ordine = order;
		setSpeed(1);
		loadAnimWorking();
	}

	public void loadAnimWorking() {
		setOrdine();

	}

	public void act(float dt) {
		super.act(dt);

		applyPhysics(dt);
		setAnimationPaused(!isMoving());
		if (getSpeed() > 0)
			setRotation(getMotionAngle());

		if (overlaps(target)) {
	//		System.out.println("arrivo a "+target);
			edificioTarget.handleDelivery(ordine);
			remove();
		}

	//	boundToWorld();

	}

	public void setTarget(Edificio target) {
		edificioTarget = target;

		this.target = target.getActor();

	}

	private void setOrdine() {
		if(ordine==null)return;

		String img = ordine.getMateriale().getImg();

		String[] filenames = { img };
		loadAnimationFromFiles(filenames, 0.1f, true);

	}

	@Override
	public void refreshElement() {
		// TODO Auto-generated method stub

	}

}
