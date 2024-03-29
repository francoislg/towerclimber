package com.alexfr.game.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.alexfr.game.box2dhelper.VectorInWorld;
import com.alexfr.game.constants.Conversion;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class PlatformHandler {

    private final float offsetForNewPlatform = Conversion.pixelsToWorld(300);
    private final float offsetForDeletingPlatform = Conversion.pixelsToWorld(1000);
    private final float distanceBetweenPlatforms = Conversion.pixelsToWorld(10);

    private GameWorld world;
    private Random randomizer;
    private List<Platform> platforms;
    private float topMostPlatformY = offsetForNewPlatform;
    private float bottomMostPlatformY = 0;

    public PlatformHandler(GameWorld world) {
	this(world, world.getRandomizer());
    }

    public PlatformHandler(GameWorld world, Random randomizer) {
	this.world = world;
	this.randomizer = randomizer;
	this.platforms = new ArrayList<Platform>();
	generatePlaform();
    }

    public void generatePlaform() {
	VectorInWorld position = new VectorInWorld(Conversion.worldToPixels(world.getBounds().getRandomNumberInBounds(
		randomizer)), Conversion.worldToPixels(topMostPlatformY - distanceBetweenPlatforms));
	Vector2 size = new Vector2(50, 3);
	Platform platform = new Platform(world, position, size);
	topMostPlatformY = platform.getPosition().y;
	if (platforms.isEmpty()) {
	    bottomMostPlatformY = topMostPlatformY;
	}
	platforms.add(platform);
	Gdx.app.log("Nouvelle plateforme", position.x + "/" + position.y);
    }

    public void update() {
	float topBound = world.getTopBound();
	while (shouldGeneratePlatform(topBound)) {
	    generatePlaform();
	}
	float bottomBound = world.getBottomBound();
	while (shouldDeletePlatform(bottomBound)) {
	    removeLastOne();
	}
    }

    private void removeLastOne() {
	if (!platforms.isEmpty()) {
	    Gdx.app.log("platforms", "DELETING ONE");
	    Platform removed = platforms.remove(0);
	    removed.destroy();
	    if (!platforms.isEmpty()) {
		bottomMostPlatformY = Conversion.worldToPixels(platforms.get(0).getPosition().y);
	    } else {
		Gdx.app.log("platforms", "NO MORE PLATFORMS OMG");
	    }
	}
    }

    private boolean shouldDeletePlatform(float bottomBound) {
	return !platforms.isEmpty() && bottomMostPlatformY > bottomBound + offsetForDeletingPlatform;
    }

    private boolean shouldGeneratePlatform(float topBound) {
	return topMostPlatformY > topBound - offsetForNewPlatform;
    }
}
