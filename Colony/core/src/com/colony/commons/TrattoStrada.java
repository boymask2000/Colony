package com.colony.commons;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.colony.BaseActor;
import com.colony.enums.TipoElemento;

public class TrattoStrada extends BaseActor{

	private Stage stage;
	private Milestone milestoneStart;
	private Milestone milestoneEnd;

//	public TrattoStrada(Milestone mx, Milestone my, Stage s) {
//		super(mx.getX(), mx.getY(), s, TipoElemento.ROAD);
//		this.stage = s;
//		milestoneStart = mx;
//		milestoneEnd = my;
//
//		milestoneStart.addTrattoOUT(this);
//		milestoneEnd.addTrattoIN(this);
//
//	}

	public TrattoStrada(Milestone mx, Stage s) {
		super(mx.getX(), mx.getY(), s, TipoElemento.ROAD);
		this.stage = s;
		milestoneStart = mx;

	//	milestoneStart.addTratto(this);
		

	}

	

	// ***********************************************************************************
	public float getCost() {
		float x1 = milestoneStart.getX();
		float y1 = milestoneStart.getY();
		float x2 = milestoneEnd.getX();
		float y2 = milestoneEnd.getY();
		return Vector2.dst(x1, y1, x2, y2);
	}

	public int getLength() {
		float x1 = milestoneStart.getX();
		float y1 = milestoneStart.getY();
		float x2 = milestoneEnd.getX();
		float y2 = milestoneEnd.getY();
		return (int) Utils.calcDist(x1, y1, x2, y2);
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Vector2 getStart() {
		return milestoneStart.getPosition();
	}

	public Vector2 getEnd() {
		return milestoneEnd.getPosition();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		if (milestoneStart == null || milestoneEnd == null)
			return;

		float x1 = milestoneStart.getX();
		float y1 = milestoneStart.getY();
		float x2 = milestoneEnd.getX();
		float y2 = milestoneEnd.getY();

		ShapeRenderer shapeRenderer = new ShapeRenderer();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.setColor(100, 255, 0, 1);
		shapeRenderer.rectLine(x1, y1, x2, y2, 4);
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


	public Milestone getMilestoneStart() {
		return milestoneStart;
	}

	public Milestone getMilestoneEnd() {
		return milestoneEnd;
	}

	public void dump() {
	//	System.out.println(milestoneStart.toString() + " -> " + milestoneEnd.toString());

	}

}
