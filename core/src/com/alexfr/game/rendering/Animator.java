package com.alexfr.game.rendering;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animator {
    private TextureRegion[][] regions;
    private Map<RenderState, Animation> animations;
    private RenderState currentState = RenderState.Idle;
    private boolean isFlipped = false;
    private float elapsedTime;

    public Animator(Sprite sprite, int width, int height) {
	regions = TextureRegion.split(sprite.getTexture(), width, height);
	for (TextureRegion[] regionsX : regions) {
	    for (TextureRegion region : regionsX) {
		region.flip(false, true);
	    }
	}
	animations = new HashMap<RenderState, Animation>();
    }

    public void createNewAnimation(RenderState state, int lineIndex,
	    int numberOfFrames) {
	TextureRegion[] frames = new TextureRegion[numberOfFrames];
	for (int i = 0; i < numberOfFrames; i++) {
	    frames[i] = regions[lineIndex][i];
	}
	animations.put(state, new Animation(1 / 15f, frames));
    }

    public void update(Renderable renderable) {
	elapsedTime += Gdx.graphics.getDeltaTime();
	isFlipped = renderable.isFacingLeft();
	RenderState state = renderable.getCurrentState();
	if (animations.containsKey(state)) {
	    currentState = state;
	}
    }

    public TextureRegion getCurrentKeyFrame() {
	TextureRegion region = animations.get(currentState).getKeyFrame(
		elapsedTime, true);
	if (isFlipped && !region.isFlipX()) {
	    region.flip(true, false);
	} else if (!isFlipped && region.isFlipX()) {
	    region.flip(true, false);
	}
	return region;
    }
}
