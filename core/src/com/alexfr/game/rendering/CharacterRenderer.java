package com.alexfr.game.rendering;

import com.alexfr.game.CharactersTextureAtlas;
import com.alexfr.game.characters.Character;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class CharacterRenderer implements Renderer {
	Sprite sprite;
	Character character;
	
	public CharacterRenderer(Character character, CharactersTextureAtlas charactersTextureAtlas){
		this.character = character;
		sprite = charactersTextureAtlas.createSprite("badlogic");
	}

	@Override
	public void render(SpriteBatch batch) {
		Vector2 position = character.getPosition();
		sprite.setPosition(position.x, position.y);
		sprite.draw(batch);
	}
}
