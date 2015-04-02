package com.alexfr.game.box2dhelper;

import com.badlogic.gdx.math.Vector2;

public class VectorInWorld extends Vector2 {
    private static final long serialVersionUID = -5848028352627323316L;

    public VectorInWorld(Vector2 vector) {
	this(vector.x, vector.y);
    }

    public VectorInWorld(float x, float y) {
	this.x = Conversion.pixelsToWorld(x);
	this.y = Conversion.pixelsToWorld(y);
    }
}
