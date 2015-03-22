package com.alexfr.game.rendering;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class CharacterRenderer implements Renderer {
	private Sprite sprite;
	private Renderable character;
	private Vector2 size;
	private Vector2 center;

	public CharacterRenderer(Renderable character, CharactersTextureAtlas charactersTextureAtlas) {
		this.character = character;
		size = character.getSize();
		center = new Vector2(size.x / 2, size.y / 2);

		sprite = charactersTextureAtlas.createSprite("badlogic");
		sprite.setSize(size.x, size.y);
		sprite.setOrigin(center.x, center.y);
	}

	@Override
	public void render(SpriteBatch batch) {
		Vector2 position = character.getPosition();
		sprite.setPosition(position.x - center.x, position.y - center.y);
		sprite.setRotation(character.getRotation());
		sprite.draw(batch);
	}
}
