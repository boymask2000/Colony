package com.colony.commons;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.buildings.abst.Edificio;
import com.colony.buildings.actors.BoscaioloActor;
import com.colony.buildings.actors.CampoGranoActor;
import com.colony.buildings.actors.CastelloActor;
import com.colony.buildings.actors.FornaioActor;
import com.colony.buildings.actors.MulinoActor;
import com.colony.buildings.actors.PozzoActor;
import com.colony.buildings.actors.SegheriaActor;
import com.colony.buildings.actors.TaglialegnaActor;
import com.colony.enums.TipoElemento;
import com.colony.fixed.Albero;
import com.colony.fixed.CosaCheCresce;
import com.colony.fixed.Grano;

public class Anagrafica {

	private static List<BaseActor> actors = new ArrayList<>();

	public static Albero createAlbero(float x, float y, Stage stage) {
		Albero p = new Albero(x, y, stage);
		actors.add(p);
		return p;

	}

	public static List<BaseActor> getActorsByType(TipoElemento t) {
		List<BaseActor> out = new ArrayList<>();
		for (BaseActor ed : actors)
			if (ed.getTipoElemento() == t)
				out.add(ed);
		return out;
	}

	public static BaseActor getNearestActor(TipoElemento t, float x, float y) {
		List<BaseActor> out = getActorsByType(t);
		if (out.size() == 0)
			return null;

		BaseActor near = out.get(0);
		float minDist = Utils.calcDist(x, y, near.getX(), near.getY());
		for (BaseActor ed : out) {
			float d = Utils.calcDist(x, y, ed.getX(), ed.getY());
			if (d < minDist) {
				minDist = d;
				near = ed;
			}
		}
		return near;

	}

	public static SegheriaActor createSegheria(float x, float y, Stage mainStage) {
		SegheriaActor p = new SegheriaActor(x, y, mainStage);
		actors.add(p);
		return p;

	}

	public static Grano createGrano(float x, float y, Stage mainStage) {
		Grano p = new Grano(x, y, mainStage);
		actors.add(p);
		return p;

	}

	public static PozzoActor createPozzo(float x, float y, Stage stage) {
		PozzoActor p = new PozzoActor(x, y, stage);
		actors.add(p);
		return p;
	}
	
	public static MulinoActor createMulino(float x, float y, Stage stage) {
		MulinoActor p = new MulinoActor(x, y, stage);
		actors.add(p);
		return p;
		
	}
	public static FornaioActor createFornaio(float x, float y, Stage stage) {
		FornaioActor p = new FornaioActor(x, y, stage);
		actors.add(p);
		return p;
		
	}

	public static TaglialegnaActor createTaglialegna(float x, float y, Stage mainStage) {
		TaglialegnaActor t = new TaglialegnaActor(x, y, mainStage);
		actors.add(t);
		return t;
	}

	public static CampoGranoActor createCampoGrano(float x, float y, Stage mainStage) {
		CampoGranoActor t = new CampoGranoActor(x, y, mainStage);
		actors.add(t);
		return t;

	}

//	public static EdificioSuArea createEdificioSuArea(float x, float y, Stage stage, BaseActor act) {
//		EdificioSuArea p = new EdificioSuArea(x, y, stage, act);
//		// edifici.add(p);
//		return p;
//
//	}

	public static CastelloActor createCastello(float x, float y, Stage mainStage) {
		CastelloActor p = new CastelloActor(x, y, mainStage);
		actors.add(p);
		return p;

	}

	public static BoscaioloActor createBoscaiolo(float x, float y, Stage s) {
		BoscaioloActor p = new BoscaioloActor(x, y, s);
		actors.add(p);
		return p;

	}

	public static void removeActor(BaseActor target) {
		actors.remove(target);

	}

	public static Edificio getActorById(int t) {
		for (BaseActor ed : actors)
			if (ed.getId() == t)
				return ed.getEdificio();
		return null;
	}

	public static CosaCheCresce getNearestAdult(TipoElemento t, float x, float y) {
		List<CosaCheCresce> out = getAdultsByType(t);
		if (out.size() == 0)
			return null;

		CosaCheCresce near = out.get(0);
		float minDist = Utils.calcDist(x, y, near.getX(), near.getY());
		for (CosaCheCresce ed : out) {
			float d = Utils.calcDist(x, y, ed.getX(), ed.getY());
			if (d < minDist) {
				minDist = d;
				near = ed;
			}
		}
		return near;
	}

	public static List<CosaCheCresce> getAdultsByType(TipoElemento t) {
		List<CosaCheCresce> out = new ArrayList<>();
		for (BaseActor ed : actors)
			if (ed.getTipoElemento() == t && ed instanceof CosaCheCresce) {
				CosaCheCresce cosa = (CosaCheCresce) ed;
				if (cosa.isAdult())
					out.add(cosa);
			}
		return out;
	}

	
	

}
