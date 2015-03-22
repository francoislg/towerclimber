package com.alexfr.game.rendering;

import com.badlogic.gdx.math.Vector2;

public interface Renderable {
	public Vector2 getPosition();

	public float getRotation();

	public Vector2 getSize();

	public RenderState getCurrentState();

	public boolean isFacingLeft();
}
