package com.colony.buildings.drag;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.commons.Anagrafica;
import com.colony.enums.TipoElemento;

public class CampoGranoDrag extends Draggable {
 

	public CampoGranoDrag(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.CAMPO_GRANO);
	
	
	}
	public void loadAnimWorking() {
		String animations[] ={ "covone.png" };
		loadAnimationFromFiles(animations, 0.1f, true);
		
	}
	
	@Override
	protected BaseActor setFinalEdificio() {
		return Anagrafica.createCampoGrano(getX(), getY(), mainStage);
		
		
	}
	@Override
	public void refreshElement() {
		// TODO Auto-generated method stub
		
	}
	
	
}
