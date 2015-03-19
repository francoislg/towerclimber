package com.alexfr.game.Characters;

import com.alexfr.game.controllers.Controllable;
import com.badlogic.gdx.math.Vector2;

public class Character implements Controllable {
	
	private Vector2 position;
	private float horizontalSpeed = 1;
	
	public Character() {
		position = new Vector2(0,0);
	}
	
	public void moveInDirection(Vector2 vector){
		position.add(vector);
	}
	
	public void jump(){
		
	}
	
	public Vector2 getPosition(){
		return position;
	}

	@Override
	public void moveLeft() {
		position.add(-horizontalSpeed, 0);
	}

	@Override
	public void moveRight() {
		position.add(horizontalSpeed, 0);
	}
}
