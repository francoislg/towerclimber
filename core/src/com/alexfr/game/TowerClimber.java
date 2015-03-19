package com.alexfr.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class TowerClimber extends ApplicationAdapter {
	GameWorld gameWorld;
	
	@Override
	public void create () {
		gameWorld = new GameWorld();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameWorld.render();
	}
}
