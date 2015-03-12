package com.alexfr.game;

import com.badlogic.gdx.math.Vector2;

public class Character {
	
	private Vector2 position;
	
	public Character() {
		position = new Vector2(0,0);
	}
	
	public Vector2 getPosition(){
		return position;
	}

	public void dispose() {
		
	}
}
