package com.colony.buildings.drag;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.colony.BaseActor;
import com.colony.enums.TipoElemento;

public abstract class Draggable extends BaseActor implements InputProcessor {

	private boolean dragging;
	protected Stage mainStage;

	public Draggable(float x, float y, Stage s, TipoElemento t) {
		super(x, y, s, t);
		mainStage = s;

		init();

		loadAnimWorking();
	}

	public Draggable(float x, float y) {
		super(x, y);

		loadAnimWorking();
	}

//	protected abstract void loadAnim();

	protected abstract void setFinalEdificio();

	public boolean isDragging() {
		return dragging;
	}

	public void init() {

		InputMultiplexer im = (InputMultiplexer) Gdx.input.getInputProcessor();
		dragging = true;

		im.addProcessor(this);
	}

	@Override
	public void act(float dt) {
		if (!dragging)
			return;
		super.act(dt);
		float x = Gdx.input.getX();
		float y = Gdx.input.getY();

		Viewport v = mainStage.getViewport();
		Vector2 mousePos = v.unproject(new Vector2(x, y));
		setPosition(mousePos.x, mousePos.y);

		setX(mousePos.x);
		setY(mousePos.y);

	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		if (button == Input.Buttons.LEFT) {
	
			dragging = false;
			InputMultiplexer im = (InputMultiplexer) Gdx.input.getInputProcessor();

			im.removeProcessor(this);
			setFinalEdificio();
			return true;
		}
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}