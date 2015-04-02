package com.alexfr.game.world;

import java.util.Random;

public class WorldBounds {
    private final float leftBound;
    private final float rightBound;
    private final Random randomizer;

    public WorldBounds(float leftBoundInWorld, float rightBoundInWorld) {
	this.leftBound = leftBoundInWorld;
	this.rightBound = rightBoundInWorld;
	this.randomizer = new Random();
    }

    public boolean isOutsideBounds(float positionX, float sizeX) {
	return positionX < leftBound || positionX + sizeX > rightBound;
    }

    public float getRandomNumberInBounds() {
	return getRandomNumberInBounds(randomizer);
    }

    public float getRandomNumberInBounds(Random randomizer) {
	float range = rightBound - leftBound;
	return leftBound + (randomizer.nextFloat() * range);
    }

    public float getMiddle() {
	return (rightBound - leftBound) / 2;
    }
}
