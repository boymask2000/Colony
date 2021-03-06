package com.colony.buildings.abst;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.colony.BaseActor;
import com.colony.enums.TipoElemento;

public  abstract class InfoPanelActor extends BaseActor implements InputProcessor{

	public InfoPanelActor(float x, float y, Stage s, TipoElemento tipo) {
		super(x, y, s, tipo);
		init();
	}
	public void init() {

		InputMultiplexer im = (InputMultiplexer) Gdx.input.getInputProcessor();
	

		im.addProcessor(this);
		
		addListener( new ClickListener() {
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		    	
		    	showInfoPanel();
		    }
		} );
		
	}
	
	
	protected abstract void showInfoPanel();
	@Override
	public boolean keyDown(int keycode) {
		//System.out.println("keyDown");
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		//System.out.println("keyUp");
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		//System.out.println("keyTyped");
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		//System.out.println("touchDown");
	
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		//System.out.println("touchUp");
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		//System.out.println("touchDragged");
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
//		System.out.println("mouseMoved");
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
	//	System.out.println("scrolled");
		return false;
	}

}
