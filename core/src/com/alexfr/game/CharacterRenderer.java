package com.alexfr.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class CharacterRenderer implements Renderer {
	Texture img;
	Character character;
	
	public CharacterRenderer(Character character){
		this.character = character;
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render(SpriteBatch spriteBatch) {
		Vector2 position = character.getPosition();
		spriteBatch.draw(img, position.x, position.y);
	}
}
