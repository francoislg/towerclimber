package com.alexfr.game.rendering;

import com.badlogic.gdx.math.Vector2;

public interface Animable {
    public Vector2 getPosition();

    public float getRotation();

    public Vector2 getSizeInPixels();

    public RenderState getCurrentState();

    public boolean isFacingLeft();
}
