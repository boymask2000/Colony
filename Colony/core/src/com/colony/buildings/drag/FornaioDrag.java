package com.colony.buildings.drag;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.commons.Anagrafica;
import com.colony.enums.TipoElemento;

public class FornaioDrag extends Draggable {
 

	public FornaioDrag(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.FORNAIO);
	
	
	}
	public void loadAnimWorking() {
		String animations[] ={ "fornaio/working/fornaio.png" };
		loadAnimationFromFiles(animations, 0.1f, true);
		
	}
	
	@Override
	protected BaseActor setFinalEdificio() {
		return Anagrafica.createFornaio(getX(), getY(), mainStage);
		
		
	}
	@Override
	public void refreshElement() {
		// TODO Auto-generated method stub
		
	}
	
	
}
