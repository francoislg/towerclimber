package com.alexfr.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class CharacterRenderer implements Renderer {
	TextureRegion img;
	Character character;
	
	public CharacterRenderer(Character character){
		this.character = character;
		Texture texture = new Texture("badlogic.jpg");
		img = new TextureRegion(texture, 0, 0, texture.getWidth(), texture.getHeight());
		img.flip(false, true);
	}

	@Override
	public void render(SpriteBatch spriteBatch) {
		Vector2 position = character.getPosition();
		spriteBatch.draw(img, position.x, position.y);
	}
}
