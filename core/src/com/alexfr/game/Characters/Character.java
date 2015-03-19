package com.alexfr.game.Characters;

import com.alexfr.game.VectorUtils;
import com.alexfr.game.controllers.Controllable;
import com.badlogic.gdx.math.Vector2;

public class Character implements Controllable {
	
	private Vector2 position;
	private Vector2 acceleration;
	private final Vector2 speed = new Vector2(0.1f,0.1f);
	private final float jumpSpeed = 5;
	private final Vector2 maximumSpeed = new Vector2(1,5);
	private final Vector2 gravity = new Vector2(0,0.1f);
	
	public Character() {
		position = new Vector2(20,20);
		acceleration = new Vector2(0,0);
	}
	
	public void moveInDirection(Vector2 vector){
		position.add(vector);
	}
	
	public void jump(){
		if(acceleration.y == 0){
			acceleration.add(0, -jumpSpeed);
		}
	}
	
	public Vector2 getPosition(){
		return position;
	}

	@Override
	public void moveLeft() {
		acceleration.add(-speed.x, 0);
	}

	@Override
	public void moveRight() {
		acceleration.add(speed.x, 0);
	}

	@Override
	public void update() {
		acceleration.add(gravity);
		bounceSomewhere();
		VectorUtils.ClampVector(acceleration, maximumSpeed);
		position.add(acceleration);
	}
	
	private void bounceSomewhere(){
		if(position.y > 200 && acceleration.y > 0){
			float whateverFriction = 0.8f;
			acceleration.set(acceleration.x, Math.min(0, whateverFriction-acceleration.y));
		}
	}
}
