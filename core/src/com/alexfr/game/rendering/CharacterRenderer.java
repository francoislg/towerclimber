package com.alexfr.game.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class CharacterRenderer implements Renderer {
    private final Animable character;
    private final Vector2 size;
    private final Vector2 center;
    private final Vector2 imageSize;
    private final Vector2 ratio;
    private final Animator animator;

    public CharacterRenderer(Animable character,
	    CharactersTextureAtlas charactersTextureAtlas) {
	this.character = character;
	size = character.getSizeInPixels();
	imageSize = new Vector2(56, 80);
	Gdx.app.log("CHARACTER", size.x + ":" + size.y);
	center = new Vector2(size.x / 2, size.y / 2);
	Sprite sprite = charactersTextureAtlas.createSprite("droid");
	ratio = new Vector2(size.x * 2 / imageSize.x, size.y * 2 / imageSize.y);
	animator = new Animator(sprite, (int) imageSize.x, (int) imageSize.y);
	animator.createNewAnimation(RenderState.Idle, 0, 3);
	animator.createNewAnimation(RenderState.Walking, 1, 3);
	animator.createNewAnimation(RenderState.Jumping, 2, 3);
    }

    @Override
    public void render(SpriteBatch batch) {
	Vector2 position = character.getPosition();
	animator.update(character);
	TextureRegion currentFrame = animator.getCurrentKeyFrame();
	batch.draw(currentFrame, position.x - center.x, position.y - center.y,
		center.x, center.y, size.x, size.y, ratio.x, ratio.y,
		character.getRotation());
    }
}
