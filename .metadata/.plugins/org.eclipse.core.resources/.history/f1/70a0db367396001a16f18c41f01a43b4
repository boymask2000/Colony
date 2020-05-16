package com.colony.buildings.drag;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.commons.Anagrafica;
import com.colony.enums.TipoElemento;

public class SegheriaDrag extends Draggable {
 

	public SegheriaDrag(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.SEGHERIA);
	
	
	}
	public void loadAnimWorking() {
		String animations[] ={ "segheria.png" };
		loadAnimationFromFiles(animations, 0.1f, true);
		
	}
	
	@Override
	protected void setFinalEdificio() {
		Anagrafica.createSegheria(getX(), getY(), mainStage);
		
		
	}
	@Override
	public void refreshElement() {
		// TODO Auto-generated method stub
		
	}
	
	
}
