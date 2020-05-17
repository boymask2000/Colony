package com.colony.commons;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Array;
import com.colony.BaseActor;
import com.colony.buildings.Pozzo;
import com.colony.buildings.abst.ElementOnRoad;
import com.colony.enums.TipoElemento;

public class Milestone extends BaseActor {
	private static int IDD = 0;
	int index;
	private Stage stage;

	private ElementOnRoad adiacente = null;

	private Array<TrattoStrada> stradeIN = new Array<>();
	private Array<TrattoStrada> stradeOUT = new Array<>();

	public Milestone(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.MILESTONE);
	
		edificio = new Pozzo(y, y, s, this);
		this.stage = s;
		index = IDD++;
		initLabel();
	}

	public void addAdiacente(ElementOnRoad ed) {
		if (adiacente == null)
			adiacente = ed;
	}

//	public Array<TrattoStrada> getStradeIN() {
//		return stradeIN;
//	}
//
//	public Array<TrattoStrada> getStradeOUT() {
//		return stradeOUT;
//	}



	public boolean addTratto(TrattoStrada t) {
		if (stradeIN.size + stradeOUT.size >= 4)
			return false;
		stradeIN.add(t);
		stradeOUT.add(t);
		t.setMilestoneEnd(this);

		return true;
	}

//	public boolean addTrattoOUT(TrattoStrada t) {
//		if (stradeIN.size + stradeOUT.size >= 4)
//			return false;
//		stradeOUT.add(t);
//		t.setMilestoneStart(this);
//
//		return true;
//	}

	public Stage getStage() {
		return stage;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		ShapeRenderer shapeRenderer = new ShapeRenderer();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(100, 255, 0, 1);
		shapeRenderer.circle(getX(), getY(), 10);
		shapeRenderer.end();

	}

	Label l;

	private void initLabel() {
		BitmapFont font = Utils.getFont();
		LabelStyle labelStyle = new LabelStyle();
		labelStyle.font = font;
		// labelStyle.font = new BitmapFont();
		l = new Label("Starfish v:", labelStyle);
		l.setColor(Color.WHITE);
		l.setPosition(getX() - 10, getY());
		mainStage.addActor(l);

	}

	@Override
	public void act(float dt) {
		super.act(dt);

		l.setText("Label lLabel lLabel lLabel lLabel lLabel l");
	}

	@Override
	public String toString() {

		String s = "Milestone [index=" + getId() + "]";
		if (adiacente != null)
			s += " " + adiacente;
		return s;
	}

	@Override
	public void loadAnimWorking() {
		String animations[] = { "pozzo/working/frame_00_delay-0.1s.gif", "pozzo/working/frame_01_delay-0.1s.gif",
				"pozzo/working/frame_02_delay-0.1s.gif", "pozzo/working/frame_03_delay-0.1s.gif",
				"pozzo/working/frame_04_delay-0.1s.gif", "pozzo/working/frame_05_delay-0.1s.gif",
				"pozzo/working/frame_06_delay-0.1s.gif", "pozzo/working/frame_07_delay-0.1s.gif",
				"pozzo/working/frame_08_delay-0.1s.gif", "pozzo/working/frame_09_delay-0.1s.gif",
				"pozzo/working/frame_10_delay-0.1s.gif" };
		loadAnimationFromFiles(animations, 0.1f, true);

	}

	public void dump() {
		System.out.println(toString());

	}

	public Vector2 getPosition() {
		return new Vector2(getX(), getY());
	
	}
}
