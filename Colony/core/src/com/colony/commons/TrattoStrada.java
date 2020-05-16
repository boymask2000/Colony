package com.colony.commons;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.enums.TipoElemento;

public class TrattoStrada extends BaseActor implements Connection<Milestone> {

	private Vector2 start = new Vector2();
	private Vector2 end = new Vector2();
	private Stage stage;
	private Milestone milestoneStart;
	private Milestone milestoneEnd;

	public TrattoStrada(float x, float y, Stage s) {
		super(x, y, s, TipoElemento.ROAD);
		start.x = x;
		start.y = y;
		this.stage = s;
	}

	public TrattoStrada(Milestone mx, Milestone my, Stage s) {
		super(mx.getX(), mx.getY(), s, TipoElemento.ROAD);
		this.stage = s;
		milestoneStart = mx;
		milestoneEnd = my;
		start.x = mx.getX();
		start.y = mx.getY();
		end.x = my.getX();
		end.y = my.getY();

	}

	// ***********************************************************************************

	public int getLength() {
		return (int) Utils.calcDist(start.x, start.y, end.x, end.y);
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Vector2 getStart() {
		return start;
	}

	public void setStart(Vector2 start) {
		this.start = start;
	}

	public void setEnd(Vector2 end) {
		this.end = end;
	}

	public Vector2 getEnd() {
		return end;
	}

	public void setEnd(float x, float y) {
		end.x = x;
		end.y = y;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);

		ShapeRenderer shapeRenderer = new ShapeRenderer();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(100, 255, 0, 1);
		shapeRenderer.rectLine(start.x, start.y, end.x, end.y, 4);
		shapeRenderer.end();

		// System.out.println(start.x + " " + start.y + " " + end.x + " " + end.y);
	}

	@Override
	public void loadAnimWorking() {
		// TODO Auto-generated method stub

	}

	public void setMilestoneStart(Milestone m) {
		milestoneStart = m;

	}

	public void setMilestoneEnd(Milestone m) {
		milestoneEnd = m;

	}

	@Override
	public float getCost() {
		return Vector2.dst(start.x, start.y, end.x, end.y);
	}

	@Override
	public Milestone getFromNode() {
		return milestoneStart;
	}

	@Override
	public Milestone getToNode() {
		return milestoneEnd;
	}
}
