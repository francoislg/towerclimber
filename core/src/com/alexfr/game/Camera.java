package com.alexfr.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class Camera {
	private OrthographicCamera camera;
	
	public Camera(){
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
}
