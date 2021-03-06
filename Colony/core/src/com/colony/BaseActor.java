package com.colony;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.colony.buildings.abst.Edificio;
import com.colony.enums.StatoElemento;
import com.colony.enums.TipoElemento;

public abstract class BaseActor extends Actor {
	private static int ID = 0;
	private int id;
	private Animation<TextureRegion> animation;

	private float elapsedTime;
	private boolean animationPaused;

	private Vector2 velocityVec;
	private Vector2 accelerationVec;
	private float acceleration;
	private float maxSpeed;
	private float deceleration;
	private static Rectangle worldBounds;
	private Polygon boundaryPolygon;

	protected TipoElemento tipoElemento;
	protected Edificio edificio;
	protected Stage mainStage;

	private StatoElemento statoElemento;

	public BaseActor(float x, float y) {
		super();
		setPosition(x, y);
		id = ID++;

		animation = null;
		elapsedTime = 0;
		animationPaused = false;
		velocityVec = new Vector2(0, 0);
		accelerationVec = new Vector2(0, 0);
		acceleration = 0;
		maxSpeed = 1000;
		deceleration = 0;

	}

	public BaseActor(float x, float y, Stage s, TipoElemento tipo) {
		this(x, y);
		mainStage = s;
		tipoElemento = tipo;

		s.addActor(this);
		statoElemento = StatoElemento.WORKING;

		loadAnimWorking();
	}

	public void setStatoElemento(StatoElemento statoElemento) {
		this.statoElemento = statoElemento;
		setAnimations();
	}

	private void setAnimations() {
		switch (statoElemento) {
		case BUILDING:
			loadAnimBuilding();
			break;
		case LACKING:
			loadAnimLacking();
			break;
		case STOPPED:
			loadAnimStopped();
			break;
		case WORKING:
			loadAnimWorking();
			break;
		case WORKINGON:
			loadAnimWorkigOn();
			break;
		}

	}

	protected void loadAnimStopped() {
		loadAnimWorking();
	}

	protected void loadAnimWorkigOn() {
		loadAnimWorking();
	}

	protected void loadAnimLacking() {
		loadAnimStopped();
	}

	protected void loadAnimBuilding() {
		loadAnimWorking();
	}

	public abstract void loadAnimWorking();

	public TipoElemento getTipoElemento() {
		return tipoElemento;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public StatoElemento getStatoElemento() {
		return statoElemento;
	}

	public void setBoundaryPolygon(int numSides) {
		float w = getWidth();
		float h = getHeight();
		float[] vertices = new float[2 * numSides];
		for (int i = 0; i < numSides; i++) {
			float angle = i * 6.28f / numSides;
			// x-coordinate
			vertices[2 * i] = w / 2 * MathUtils.cos(angle) + w / 2; // y-coordinate
			vertices[2 * i + 1] = h / 2 * MathUtils.sin(angle) + h / 2;
		}

		boundaryPolygon = new Polygon(vertices);
	}

	public Polygon getBoundaryPolygon() {
		boundaryPolygon.setPosition(getX(), getY());
		boundaryPolygon.setOrigin(getOriginX(), getOriginY());
		boundaryPolygon.setRotation(getRotation());
		boundaryPolygon.setScale(getScaleX(), getScaleY());
		return boundaryPolygon;
	}

	public boolean overlaps(BaseActor other) {
		Polygon poly1 = this.getBoundaryPolygon();
		Polygon poly2 = other.getBoundaryPolygon(); // initial test to improve performance
		if (!poly1.getBoundingRectangle().overlaps(poly2.getBoundingRectangle()))
			return false;
		return Intersector.overlapConvexPolygons(poly1, poly2);
	}

	public static void setWorldBounds(float width, float height) {
		worldBounds = new Rectangle(0, 0, width, height);
	}

	public static void setWorldBounds(BaseActor ba) {
		setWorldBounds(ba.getWidth(), ba.getHeight());
	}

	public void boundToWorld() { // check left edge
		if (getX() < 0)
			setX(0); // check right edge
		if (getX() + getWidth() > worldBounds.width)
			setX(worldBounds.width - getWidth()); // check bottom edge
		if (getY() < 0)
			setY(0); // check top edge
		if (getY() + getHeight() > worldBounds.height)
			setY(worldBounds.height - getHeight());
	}

	public Vector2 getVelocityVec() {
		return velocityVec;
	}

	public void setVelocityVec(Vector2 velocityVec) {
		this.velocityVec = velocityVec;
	}

	public void setVelocityVec(float x, float y) {
		this.velocityVec = new Vector2(x, y);
	}

	public void setAnimation(Animation<TextureRegion> anim) {
		animation = anim;
		TextureRegion tr = animation.getKeyFrame(0);
		float w = tr.getRegionWidth();
		float h = tr.getRegionHeight();
		setSize(w, h);
		setOrigin(w / 2, h / 2);

		if (boundaryPolygon == null)
			setBoundaryRectangle();
	}

	public void setBoundaryRectangle() {
		setBoundaryPolygon(5);
//		float w = getWidth();
//		float h = getHeight();
//		float[] vertices = { 0, 0, w, 0, w, h, 0, h };
//		boundaryPolygon = new Polygon(vertices);
	}

	public void setAnimationPaused(boolean pause) {
		animationPaused = pause;
	}

	@Override
	public void act(float dt) {
		super.act(dt);
		if (!animationPaused)
			elapsedTime += dt;

		if (edificio != null)
			refreshElement();
	}

	public void refreshElement() {
		if (edificio != null)
			if (statoElemento == StatoElemento.WORKING || statoElemento == StatoElemento.LACKING)
				edificio.work();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha); // apply color tint effect
		Color c = getColor();
		batch.setColor(c.r, c.g, c.b, c.a);
		if (animation != null && isVisible())
			batch.draw(animation.getKeyFrame(elapsedTime), getX(), getY(), getOriginX(), getOriginY(), getWidth(),
					getHeight(), getScaleX(), getScaleY(), getRotation());

//		if( edificio !=null && edificio.getStrada()!=null) {
//		ShapeRenderer shapeRenderer = new ShapeRenderer();
//		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//		shapeRenderer.setColor(100, 255, 0, 1);
//		shapeRenderer.rectLine(edificio.getStrada().getStart().x, edificio.getStrada().getStart().y, edificio.getX(), edificio.getY(), 4);
//		shapeRenderer.end();}
		
	}

	public Animation<TextureRegion> loadAnimationFromFiles(String[] fileNames, float frameDuration, boolean loop) {
		int fileCount = fileNames.length;
		Array<TextureRegion> textureArray = new Array<TextureRegion>();
		for (int n = 0; n < fileCount; n++) {
			String fileName = fileNames[n];
			Texture texture = new Texture(Gdx.files.internal(fileName));
			texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
			textureArray.add(new TextureRegion(texture));
		}

		Animation<TextureRegion> anim = new Animation<TextureRegion>(frameDuration, textureArray);
		if (loop)
			anim.setPlayMode(Animation.PlayMode.LOOP);
		else
			anim.setPlayMode(Animation.PlayMode.NORMAL);
		// if (animation == null)
		setAnimation(anim);
		return anim;
	}

	public Animation<TextureRegion> loadAnimationFromSheet(String fileName, int rows, int cols, float frameDuration,
			boolean loop) {
		Texture texture = new Texture(Gdx.files.internal(fileName), true);
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		int frameWidth = texture.getWidth() / cols;
		int frameHeight = texture.getHeight() / rows;
		TextureRegion[][] temp = TextureRegion.split(texture, frameWidth, frameHeight);
		Array<TextureRegion> textureArray = new Array<TextureRegion>();
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < cols; c++)
				textureArray.add(temp[r][c]);
		Animation<TextureRegion> anim = new Animation<TextureRegion>(frameDuration, textureArray);
		if (loop)
			anim.setPlayMode(Animation.PlayMode.LOOP);
		else
			anim.setPlayMode(Animation.PlayMode.NORMAL);
		if (animation == null)
			setAnimation(anim);
		return anim;
	}

	public Animation<TextureRegion> loadTexture(String fileName) {
		String[] fileNames = new String[1];
		fileNames[0] = fileName;
		return loadAnimationFromFiles(fileNames, 1, true);
	}

	public boolean isAnimationFinished() {
		return animation.isAnimationFinished(elapsedTime);
	}

	public void setSpeed(float speed) { // if length is zero, then assume motion angle is zero degrees
		if (velocityVec.len() == 0)
			velocityVec.set(speed, 0);
		else
			velocityVec.setLength(speed);
	}

	public float getSpeed() {
		return velocityVec.len();
	}

	public void setMotionAngle(float angle) {
		velocityVec.setAngle(angle);
	}

	public float getMotionAngle() {
		return velocityVec.angle();
	}

	public boolean isMoving() {
		return (getSpeed() > 0);
	}

	public void setAcceleration(float acc) {
		acceleration = acc;
	}

	public void accelerateAtAngle(float angle) {
		accelerationVec.add(new Vector2(acceleration, 0).setAngle(angle));
	}

	public void accelerateForward() {
		accelerateAtAngle(getRotation());
	}

	public void setMaxSpeed(float ms) {
		maxSpeed = ms;
	}

	public void setDeceleration(float dec) {
		deceleration = dec;
	}

	public void applyPhysics(float dt) { // apply acceleration
		velocityVec.add(accelerationVec.x * dt, accelerationVec.y * dt);
		float speed = getSpeed(); // decrease speed (decelerate) when not accelerating
//		if (accelerationVec.len() == 0)
//			speed -= deceleration * dt; 
		speed = MathUtils.clamp(speed, 0, maxSpeed); // update velocity
		setSpeed(speed); // apply velocity
		moveBy(velocityVec.x * dt, velocityVec.y * dt); // reset acceleration
		accelerationVec.set(0, 0);
	}

	public static List<BaseActor> getList(Stage stage, String className) {
		List<BaseActor> list = new ArrayList<BaseActor>();
		Class theClass = null;
		try {
			theClass = Class.forName(className);
		} catch (Exception error) {
			error.printStackTrace();
		}
		for (Actor a : stage.getActors()) {
			if (theClass.isInstance(a))
				list.add((BaseActor) a);
		}
		return list;
	}

	public static List<BaseActor> getList(Stage stage) {
		List<BaseActor> list = new ArrayList<BaseActor>();

		for (Actor a : stage.getActors()) {

			list.add((BaseActor) a);
		}
		return list;
	}

	public static int count(Stage stage) {
		return getList(stage).size();
	}

	public final int getId() {
		return id;
	}
}
