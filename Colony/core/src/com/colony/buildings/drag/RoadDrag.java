package com.colony.buildings.drag;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.commons.CartinaStradale;
import com.colony.commons.Milestone;
import com.colony.commons.TrattoStrada;
import com.colony.enums.TipoElemento;

public class RoadDrag extends Draggable {
	private boolean first = true;
	private TrattoStrada tratto;

	public RoadDrag(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.ROAD);

	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		x = (int) getX();
		y = (int) getY();
		if (button == Input.Buttons.LEFT) {

			if (first) {
				tratto = CartinaStradale.setStart(x, y, null,mainStage);

				first = false;
			} else {

				// first = true;
				CartinaStradale.setEnd(tratto, x, y);

				tratto = CartinaStradale.setStart(x, y, tratto, mainStage);
				// remove();
			}
			return true;
		}
		if (button == Input.Buttons.RIGHT) {
	//		CartinaStradale.removeMilestone(tratto.getMilestoneStart());

			
			InputMultiplexer im = (InputMultiplexer) Gdx.input.getInputProcessor();
			CartinaStradale.remove(tratto);
			im.removeProcessor(this);
		
			remove();
			

			return true;
		}
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
	
		if (!first) {
		
			ShapeRenderer shapeRenderer = new ShapeRenderer();
			shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
			shapeRenderer.setColor(100, 255, 0, 1);
			shapeRenderer.rectLine(tratto.getStart().x, tratto.getStart().y, screenX, screenY, 4);
			shapeRenderer.end();
		}

		return false;
	}

	public void loadAnimWorking() {
		String animations[] = { "street.png" };
		loadAnimationFromFiles(animations, 0.1f, true);

	}

	@Override
	public void refreshElement() {
		// TODO Auto-generated method stub

	}

	@Override
	protected BaseActor setFinalEdificio() {
return this;
	}

}
