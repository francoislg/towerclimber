package com.alexfr.game;

import com.alexfr.game.characters.Character;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class Camera {
	private OrthographicCamera camera;
	
	public Camera(){
		this(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	public Camera(int width, int height){
		camera = new OrthographicCamera(width, height);
		camera.setToOrtho(true, width, height);
		camera.update();
	}
	
	public void update(){
		camera.update();
	}
	
	public void setSpriteBatchProjection(SpriteBatch batch){
		batch.setProjectionMatrix(camera.combined);
	}
	
	public void renderDebugBox2D(Box2DDebugRenderer debugRenderer, World world){
		debugRenderer.render(world, camera.combined);
	}
	
	public void follow(Character character){
		camera.translate(character.getPosition());
	}
}
