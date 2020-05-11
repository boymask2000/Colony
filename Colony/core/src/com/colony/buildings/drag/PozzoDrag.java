package com.colony.buildings.drag;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.commons.Anagrafica;
import com.colony.enums.TipoElemento;

public class PozzoDrag extends Draggable {
 

	public PozzoDrag(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.POZZO);
	
	
	}
	public void loadAnimWorking() {
		String animations[] ={ "pozzo/working/frame_00_delay-0.1s.gif" };
		loadAnimationFromFiles(animations, 0.1f, true);
		
	}
	
	@Override
	protected void setFinalEdificio() {
		Anagrafica.createPozzo(getX(), getY(), mainStage);
		
		
	}
	@Override
	public void refreshElement() {
		// TODO Auto-generated method stub
		
	}
	
	
}
