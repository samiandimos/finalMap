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
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

import static com.mygdx.game.utils.Constants.PPM;

public class BoxTest extends ApplicationAdapter {
	TiledMap tiledMap;
	OrthogonalTiledMapRenderer tMR;
	FillViewport viewport;

	@Override
	public void create () {
		tiledMap = new TmxMapLoader().load("board32.tmx");
		tMR = new OrthogonalTiledMapRenderer(tiledMap);
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, 704, 512 );
		//camera.translate(352,0);
		camera.update();
		viewport = new FillViewport(704,512,camera);
		tMR.setView(camera);
		tMR.render();

	}


	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		tMR.setView((OrthographicCamera) viewport.getCamera());
		tMR.render();

	}



	@Override
	public void dispose () {


	}





}
