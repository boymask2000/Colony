package com.colony;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.colony.buildings.drag.BoscaioloDrag;
import com.colony.buildings.drag.CampoGranoDrag;
import com.colony.buildings.drag.CastelloDrag;
import com.colony.buildings.drag.FornaioDrag;
import com.colony.buildings.drag.MulinoDrag;
import com.colony.buildings.drag.PozzoDrag;
import com.colony.buildings.drag.RoadDrag;
import com.colony.buildings.drag.SegheriaDrag;
import com.colony.buildings.drag.TaglialegnaDrag;

public class LevelScreen extends BaseScreen {
	private static final float DELTACAM = 10;

	private float camX = 0;
	private float camY = 0;

	public void initialize() {

		BaseActor.setWorldBounds(1500, 1500);

		setButtons();
		
	//	TilemapActor tma = new TilemapActor("map.tmx", mainStage);
	}

	private void setButtons() {

		Button castello = createButton("castello.png");
		Button campoGrano = createButton("covone.png");
		Button boscaiolo = createButton("boscaiolo.png");
		Button segheria = createButton("segheria.png");
		Button pozzo = createButton("pozzo/working/frame_00_delay-0.1s.gif");
		Button mulino = createButton("mulino/working/mulino_0.gif");
		Button taglialegna = createButton("taglialegna.png");
		Button road = createButton("street.png");
		Button fornaio = createButton("fornaio/working/fornaio.png");

		Button right = createButton("right.png");
		Button left = createButton("left.png");
		Button up = createButton("up.png");
		Button down = createButton("down.png");

		uiTable.add().expandX().top();
		// uiTable.add(casa);
		uiTable.add(boscaiolo);
		uiTable.add(campoGrano);
		uiTable.row();
		uiTable.add().expandX().top();
		uiTable.add(mulino);
		uiTable.add(fornaio);
		uiTable.row();
		uiTable.add().expandX().top();
		uiTable.add(taglialegna);
		uiTable.add(segheria);
		uiTable.row();
		uiTable.add().expandX().top();
		uiTable.add(pozzo);
		uiTable.add(castello);
		uiTable.row();
		uiTable.add().expandX().top();
		uiTable.add(road);

		uiTable.row();
		uiTable.add().expandX().expandY().bottom();
		uiTable.add(right);
		uiTable.add(left);
		uiTable.row();
		uiTable.add().expandX().expandY().bottom();

		uiTable.add(up);
		uiTable.add(down);
		
		road.addListener((Event e) -> {

			if (!(e instanceof InputEvent) || !((InputEvent) e).getType().equals(Type.touchDown))
				return false;
			new RoadDrag(10, 10, streetStage);

			return false;
		});

		fornaio.addListener((Event e) -> {

			if (!(e instanceof InputEvent) || !((InputEvent) e).getType().equals(Type.touchDown))
				return false;
			new FornaioDrag(10, 10, mainStage);
			System.out.println("mulino");
			return false;
		});
		mulino.addListener((Event e) -> {

			if (!(e instanceof InputEvent) || !((InputEvent) e).getType().equals(Type.touchDown))
				return false;
			new MulinoDrag(10, 10, mainStage);
			System.out.println("mulino");
			return false;
		});
		campoGrano.addListener((Event e) -> {

			if (!(e instanceof InputEvent) || !((InputEvent) e).getType().equals(Type.touchDown))
				return false;
			new CampoGranoDrag(10, 10, mainStage);
			System.out.println("boscaiolo");
			return false;
		});
		boscaiolo.addListener((Event e) -> {

			if (!(e instanceof InputEvent) || !((InputEvent) e).getType().equals(Type.touchDown))
				return false;
			new BoscaioloDrag(10, 10, mainStage);
			System.out.println("boscaiolo");
			return false;
		});
		segheria.addListener((Event e) -> {

			if (!(e instanceof InputEvent) || !((InputEvent) e).getType().equals(Type.touchDown))
				return false;
			new SegheriaDrag(10, 10, mainStage);

			return false;
		});
		taglialegna.addListener((Event e) -> {

			if (!(e instanceof InputEvent) || !((InputEvent) e).getType().equals(Type.touchDown))
				return false;
			new TaglialegnaDrag(10, 10, mainStage);
			System.out.println("taglialegna dtag");
			return false;
		});
		castello.addListener((Event e) -> {

			if (!(e instanceof InputEvent) || !((InputEvent) e).getType().equals(Type.touchDown))
				return false;
			new CastelloDrag(10, 10, mainStage);

			return false;
		});

		pozzo.addListener((Event e) -> {

			if (!(e instanceof InputEvent) || !((InputEvent) e).getType().equals(Type.touchDown))
				return false;

			new PozzoDrag(10, 10, mainStage);

			return false;
		});

		up.addListener((Event e) -> {

			if (!(e instanceof InputEvent) || !((InputEvent) e).getType().equals(Type.touchDown))
				return false;
			camY -= DELTACAM;
			alignCamera();
			System.out.println("up");
			return false;
		});
		down.addListener((Event e) -> {

			if (!(e instanceof InputEvent) || !((InputEvent) e).getType().equals(Type.touchDown))
				return false;
			camY += DELTACAM;
			alignCamera();
			System.out.println("down");
			return false;
		});
		right.addListener((Event e) -> {

			if (!(e instanceof InputEvent) || !((InputEvent) e).getType().equals(Type.touchDown))
				return false;
			camX -= DELTACAM;
			alignCamera();
			System.out.println("right");
			return false;
		});
		left.addListener((Event e) -> {

			if (!(e instanceof InputEvent) || !((InputEvent) e).getType().equals(Type.touchDown))
				return false;
			camX += DELTACAM;
			alignCamera();
			System.out.println("Left");
			return false;
		});
	}

	public void alignCamera() {
		Camera cam = mainStage.getCamera();
		Viewport v = mainStage.getViewport(); // center camera on actor
		cam.position.set(camX, camY, 0); // bound

		cam.update();
		
//		Camera cams = streetStage.getCamera();
//		Viewport vs = streetStage.getViewport(); // center camera on actor
//		cams.position.set(camX, camY, 0); // bound
//
//		cams.update();
	}

	private Button createButton(String img) {
		ButtonStyle buttonStyle = new ButtonStyle();
		Texture buttonTex = new Texture(Gdx.files.internal(img));
		TextureRegion buttonRegion = new TextureRegion(buttonTex);
		buttonStyle.up = new TextureRegionDrawable(buttonRegion);
		Button b = new Button(buttonStyle);
		b.setColor(Color.CYAN);
		return b;
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub

	}
}
