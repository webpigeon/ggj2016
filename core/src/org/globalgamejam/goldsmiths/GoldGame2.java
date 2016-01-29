package org.globalgamejam.goldsmiths;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.IsometricTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GoldGame2 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TiledMap tiledMap;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		
		tiledMap = new TmxMapLoader().load("test.tmx");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		float unitScale = 1/16f;
		OrthogonalTiledMapRenderer renderer = new OrthogonalTiledMapRenderer(tiledMap, unitScale);
		
		OrthographicCamera camera = new OrthographicCamera();
		camera.setToOrtho(false, 30, 30);
		
		renderer.setView(camera);
		renderer.render();
		
		
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();
	}
}
