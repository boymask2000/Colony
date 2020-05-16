package com.colony.buildings.drag;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.commons.Anagrafica;
import com.colony.enums.TipoElemento;

public class MulinoDrag extends Draggable {
 

	public MulinoDrag(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.MULINO);
	
	
	}
	public void loadAnimWorking() {
		String animations[] ={ "mulino/working/mulino_0.gif" };
		loadAnimationFromFiles(animations, 0.1f, true);
		
	}
	
	@Override
	protected BaseActor setFinalEdificio() {
		return Anagrafica.createMulino(getX(), getY(), mainStage);
		
		
	}
	@Override
	public void refreshElement() {
		// TODO Auto-generated method stub
		
	}
	
	
}
