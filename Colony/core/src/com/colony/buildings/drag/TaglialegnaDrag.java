package com.colony.buildings.drag;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.buildings.actors.TaglialegnaActor;
import com.colony.commons.Anagrafica;
import com.colony.enums.TipoElemento;

public class TaglialegnaDrag extends Draggable {
 

	public TaglialegnaDrag(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.TAGLIALEGNA);
	
	
	}
	public void loadAnimWorking() {
		String animations[] ={ "taglialegna.png" };
		loadAnimationFromFiles(animations, 0.1f, true);
		
	}
	
	@Override
	protected BaseActor setFinalEdificio() {
		return Anagrafica.createTaglialegna(getX(), getY(), mainStage);
		
		
	}
	@Override
	public void refreshElement() {
		// TODO Auto-generated method stub
		
	}
	
	
}
