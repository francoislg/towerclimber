package com.alexfr.game.box2dhelper;

import com.badlogic.gdx.math.Vector2;

public class Conversion {
    private static float metersPerPixels = 3f;
    private static float metersToPixels = 1 / metersPerPixels;
    private static float pixelsToMeters = metersPerPixels;

    public static float metersToPixels(float meters) {
	return meters * metersToPixels;
    }

    public static Vector2 metersToPixels(Vector2 meters) {
	return new Vector2(meters.x * metersToPixels, meters.y * metersToPixels);
    }

    public static float pixelsToMeters(float pixels) {
	return pixels * pixelsToMeters;
    }

    public static Vector2 pixelsToMeters(Vector2 pixels) {
	return new Vector2(pixels.x * pixelsToMeters, pixels.y * pixelsToMeters);
    }
}
