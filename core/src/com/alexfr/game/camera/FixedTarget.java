package com.alexfr.game.camera;

import com.badlogic.gdx.math.Vector2;

public class FixedTarget implements Targetable {
    private Vector2 position;

    public FixedTarget(Vector2 position) {
	this.position = position;
    }

    @Override
    public Vector2 getPosition() {
	return position;
    }
}
