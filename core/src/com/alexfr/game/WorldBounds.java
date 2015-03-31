package com.alexfr.game;

import java.util.Random;

public class WorldBounds {
    private final float leftBound;
    private final float rightBound;
    private final Random randomizer;

    public WorldBounds(float leftBound, float rightBound) {
	this.leftBound = leftBound;
	this.rightBound = rightBound;
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
}
