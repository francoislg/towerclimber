package com.alexfr.game.box2dhelper;

import com.badlogic.gdx.math.Vector2;

public class Conversion {
    private static float metersPerPixels = 3f;
    private static float metersToPixels = 1 / metersPerPixels;
    private static float pixelsToMeters = metersPerPixels;

    public static float worldToPixels(float meters) {
	return meters * metersToPixels;
    }

    public static Vector2 worldToPixels(Vector2 meters) {
	return new Vector2(meters.x * metersToPixels, meters.y * metersToPixels);
    }

    public static float pixelsToWorld(float pixels) {
	return pixels * pixelsToMeters;
    }

    public static Vector2 pixelsToWorld(Vector2 pixels) {
	return new Vector2(pixels.x * pixelsToMeters, pixels.y * pixelsToMeters);
    }

    public static Vector2 halfVector(Vector2 vector) {
	return new Vector2(vector.x / 2, vector.y / 2);
    }
}
