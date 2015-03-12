package com.alexfr.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TowerClimber extends ApplicationAdapter {
	SpriteBatch spriteBatch;
	Character character;
	CharacterRenderer characterRenderer;
	Camera camera;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		character = new Character();
		characterRenderer = new CharacterRenderer(character);
		camera = new Camera();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		camera.setSpriteBatchProjection(spriteBatch);
		spriteBatch.begin();
		characterRenderer.render(spriteBatch);
		spriteBatch.end();
	}
}
