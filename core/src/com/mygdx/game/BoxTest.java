package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;

import static com.mygdx.game.utils.Constants.PPM;

public class BoxTest extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;

//	private boolean DEBUG = false;
	private final float SCALE = 2.0f;

	private OrthographicCamera camera;

	private Box2DDebugRenderer b2dr;
	private World world;
//	private Body player;

	private OrthogonalTiledMapRenderer tmr;
	private TiledMap map;

	@Override
	public void create () {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth() / SCALE, Gdx.graphics.getHeight()/SCALE);

		world = new World(new Vector2(0f, 0f), false);
		b2dr = new Box2DDebugRenderer();

//		player = createBox(8, 10,32, 32, false);
//		createBox(0, 0, 64, 32, true);

		batch = new SpriteBatch();
		img = new Texture("icon.png");

		map = new TmxMapLoader().load("board32.tmx");
		tmr = new OrthogonalTiledMapRenderer(map);

	}


	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime()/SCALE);


		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		b2dr.render(world, camera.combined.scl(PPM));

		batch.begin();
//		batch.draw(img, player.getPosition().x * PPM - (img.getWidth() / 2), player.getPosition().y * PPM - (img.getHeight() / 2) );
		batch.end();

		tmr.render();

//		b2dr.render(world, camera.combined.scl(PPM));
	}

	@Override
	public void resize(int width, int height) {

		camera.setToOrtho(false, Gdx.graphics.getWidth() / SCALE  , Gdx.graphics.getHeight() / SCALE );
	}

	@Override
	public void dispose () {
		world.dispose();
		b2dr.dispose();
		batch.dispose();
		img.dispose();
		map.dispose();
		tmr.dispose();

	}

	public void update(float delta){
		world.step(1 / 60f, 6, 2);
//
		inputUpdate(delta);
		cameraUpdate(delta);
		tmr.setView(camera);

		batch.setProjectionMatrix(camera.combined);
	}

	public void inputUpdate(float delta){
//		int horizontalForce = 0;
//		int verticalForce = 0;

// if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
//			horizontalForce += 1;
//		}
//		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
//			horizontalForce -= 1;
//		}


		/** this is the jump*/
//		if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
//			player.applyForceToCenter(0, 10, false);
//		}

//		if(Gdx.input.isKeyPressed((Input.Keys.DOWN))){
//			verticalForce += 1;
//		}

//		if(Gdx.input.isKeyPressed((Input.Keys.UP))){
//			verticalForce -= 1;
//		}

//		player.setLinearVelocity(player.getLinearVelocity().x, verticalForce * 5);
//		player.setLinearVelocity(horizontalForce * 5, player.getLinearVelocity().y);

	}

	public void cameraUpdate(float delta){
		Vector3 position = camera.position;
//		position.x = player.getPosition().x * PPM;
//		position.y = player.getPosition().y * PPM;
		camera.position.set(position);

		camera.update();
}




//	public Body createBox(int x, int y, int width, int height, boolean isStatic){
//		Body pBody;
//		BodyDef def = new BodyDef();
//
//		if(isStatic)
//			def.type = BodyDef.BodyType.StaticBody;
//		else
//			def.type = BodyDef.BodyType.DynamicBody;
//
//		def.position.set(x / PPM, y / PPM);
//		def.fixedRotation = true;
//		pBody = world.createBody(def);
//
//		PolygonShape shape = new PolygonShape();
//		shape.setAsBox(width / 2 / PPM , height / 2 / PPM );
//
//		pBody.createFixture(shape, 1.0f);
//		shape.dispose();
//
//		return pBody;
//	}


}
