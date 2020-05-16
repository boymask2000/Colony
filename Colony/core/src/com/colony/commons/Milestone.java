package com.colony.commons;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.colony.BaseActor;
import com.colony.buildings.Pozzo;
import com.colony.enums.TipoElemento;

public class Milestone extends BaseActor {
	private static int IDD = 0;
	int index;
	private Stage stage;
	private Vector2 position = new Vector2();

	private Array<TrattoStrada> strade = new Array<>();

	

	public Milestone(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.MILESTONE);
		position.x = x;
		position.y = y;
		edificio = new Pozzo(y, y, s, this);
		this.stage = s;
		index = IDD++;
	}

	public Array<TrattoStrada> getStrade() {
		return strade;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Vector2 getPosition() {
		return position;
	}

	public float getX() {
		return position.x;
	}

	public float getY() {
		return position.y;
	}

	public boolean addTratto(TrattoStrada t) {
		if (strade.size >= 4)
			return false;
		strade.add(t);

		return true;

	}

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

		// System.out.println(start.x + " " + start.y + " " + end.x + " " + end.y);
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
}
