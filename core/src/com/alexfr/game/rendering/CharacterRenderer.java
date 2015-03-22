package com.alexfr.game.rendering;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class CharacterRenderer implements Renderer {
	private Renderable character;
	private Vector2 size;
	private Vector2 center;
	private Animator animator;

	public CharacterRenderer(Renderable character, CharactersTextureAtlas charactersTextureAtlas) {
		this.character = character;
		size = character.getSize();
		center = new Vector2(size.x / 2, size.y / 2);

		Sprite sprite = charactersTextureAtlas.createSprite("droid");
		animator = new Animator(sprite, 56, 80);
		animator.createNewAnimation(RenderState.Idle, 0, 3);
		animator.createNewAnimation(RenderState.Walking, 1, 3);
		animator.createNewAnimation(RenderState.Jumping, 2, 3);
	}

	@Override
	public void render(SpriteBatch batch) {
		Vector2 position = character.getPosition();
		animator.update(character);
		TextureRegion currentFrame = animator.getCurrentKeyFrame();
		batch.draw(currentFrame, position.x - center.x, position.y - center.y, center.x, center.y, size.x, size.y, 1, 1, character.getRotation());
	}
}
