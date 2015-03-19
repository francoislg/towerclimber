package com.alexfr.game;

import com.alexfr.game.Characters.Character;
import com.alexfr.game.rendering.CharacterRenderer;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TowerClimber extends ApplicationAdapter {
	SpriteBatch batch;
	Character character;
	CharacterRenderer characterRenderer;
	Camera camera;
	CharactersTextureAtlas charactersTextureAtlas;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		charactersTextureAtlas = new CharactersTextureAtlas();
		character = new Character();
		characterRenderer = new CharacterRenderer(character, charactersTextureAtlas);
		camera = new Camera();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		camera.setSpriteBatchProjection(batch);
		batch.begin();
		characterRenderer.render(batch);
		batch.end();
	}
}
