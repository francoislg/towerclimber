package com.alexfr.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Character implements ApplicationListener {
	Texture img;
	SpriteBatch batch;
	
	@Override
	public void create() {
		img = new Texture("badlogic.jpg");
		batch = new SpriteBatch();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render() {
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		img.dispose();
		batch.dispose();
	}

}
