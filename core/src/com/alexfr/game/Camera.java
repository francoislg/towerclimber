package com.alexfr.game;

import com.alexfr.game.Characters.Character;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Camera {
	private OrthographicCamera camera;
	
	public Camera(){
		this(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public Camera(int width, int height){
		camera = new OrthographicCamera(width, height);
		camera.setToOrtho(true, width, height);
		camera.rotate(180);
		camera.translate(-width/2, -height/2);
		camera.update();
	}
	
	public void update(){
		camera.update();
	}
	
	public void setSpriteBatchProjection(SpriteBatch batch){
		batch.setProjectionMatrix(camera.combined);
	}
	
	public void follow(Character character){
		camera.translate(character.getPosition());
	}
}
