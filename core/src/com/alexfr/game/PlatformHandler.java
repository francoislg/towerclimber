package com.alexfr.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.alexfr.game.box2dhelper.Conversion;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class PlatformHandler {

    private final float offsetForNewPlatform = 300;
    private final float offsetForDeletingPlatform = 1000;
    private final float distanceBetweenPlatforms = 50;

    private World world;
    private WorldBounds worldBounds;
    private Random randomizer;
    private List<Platform> platforms;
    private float topMostPlatformY = offsetForNewPlatform;
    private float bottomMostPlatformY = 0;

    public PlatformHandler(World world, WorldBounds worldBounds) {
	this(world, worldBounds, new Random());
    }

    public PlatformHandler(World world, WorldBounds worldBounds,
	    Random randomizer) {
	this.world = world;
	this.worldBounds = worldBounds;
	this.randomizer = randomizer;
	this.platforms = new ArrayList<Platform>();
	generatePlaform();
    }

    public void generatePlaform() {
	Vector2 position = new Vector2(
		worldBounds.getRandomNumberInBounds(randomizer),
		Conversion.pixelsToMeters(topMostPlatformY)
			- distanceBetweenPlatforms);
	Vector2 size = new Vector2(100, 3);
	Platform platform = new Platform(world, position, size);
	topMostPlatformY = platform.getPosition().y;
	if (platforms.isEmpty()) {
	    bottomMostPlatformY = topMostPlatformY;
	}
	platforms.add(platform);
	Gdx.app.log("Nouvelle plateforme", position.x + "/" + position.y);
    }

    public void update(float topBound, float bottomBound) {
	while (shouldGeneratePlatform(topBound)) {
	    generatePlaform();
	}
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
		bottomMostPlatformY = platforms.get(0).getPosition().y;
	    } else {
		Gdx.app.log("platforms", "NO MORE PLATFORMS OMG");
	    }
	}
    }

    private boolean shouldDeletePlatform(float bottomBound) {
	return !platforms.isEmpty()
		&& bottomMostPlatformY > bottomBound
			+ offsetForDeletingPlatform;
    }

    private boolean shouldGeneratePlatform(float topBound) {
	return topMostPlatformY > topBound - offsetForNewPlatform;
    }
}
