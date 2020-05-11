package com.colony.fixed;

import java.util.Date;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.enums.TipoElemento;

public class CosaCheCresce extends BaseActor {
	private boolean adult = false;

	private String animationCrescita[];
	private int currentPhase = 0;

	private Date lastCheck;
	private long durataFase = 30000;

	public CosaCheCresce(float x, float y, Stage s, TipoElemento tipo, String[] animations) {

		super(x, y, s, tipo);
		this.animationCrescita = animations;

		lastCheck = new Date();
		loadAnimCrescita();
	}

	public void resetCrescita() {
		currentPhase = 0;
		loadAnimCrescita();
	}

	@Override
	public void act(float dt) {
		super.act(dt);

		Date d = new Date();
		if (d.getTime() - lastCheck.getTime() < durataFase)
			return;
		lastCheck = new Date();

		if (currentPhase < animationCrescita.length - 1)
			currentPhase++;
		loadAnimCrescita();
		adult=false;
		if (currentPhase == animationCrescita.length - 1)
			adult = true;
	}

	public void loadAnimCrescita() {
		if (animationCrescita == null)
			return;
		String an = animationCrescita[currentPhase];
		String s[] = { an };
		loadAnimationFromFiles(s, 0.1f, true);
	}

	@Override
	public void loadAnimWorking() {
	}

	public void setAnimationCrescita(String[] animationCrescita) {
		this.animationCrescita = animationCrescita;
	}

	public boolean isAdult() {
		return adult;
	}

}