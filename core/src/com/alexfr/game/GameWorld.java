package com.alexfr.game;

import java.util.Random;

import com.alexfr.game.camera.Camera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.World;

public class GameWorld {
    private final float TOTALWIDTHINWORLD = 200;
    private final float TIMESTEP = 1 / 60f;
    private final float SPEEDUP = 5;

    private World world;
    private Random randomizer;
    private WorldBounds worldBounds;
    private float accumulator = 0;

    public GameWorld() {
	Box2D.init();
	randomizer = new Random();
	Vector2 gravity = new Vector2(0, 9.8f);
	world = new World(gravity, true);
	worldBounds = new WorldBounds(0, TOTALWIDTHINWORLD);
    }

    public WorldBounds getBounds() {
	return worldBounds;
    }

    public Random getRandomizer() {
	return randomizer;
    }

    public void update() {
	doPhysicsStep(Gdx.graphics.getDeltaTime() * SPEEDUP);
    }

    private void doPhysicsStep(float deltaTime) {
	float frameTime = Math.min(deltaTime, 0.25f);
	accumulator += frameTime;
	while (accumulator >= TIMESTEP) {
	    world.step(TIMESTEP, 8, 3);
	    accumulator -= TIMESTEP;
	}
    }

    public Body createBody(BodyDef bodyDef) {
	return world.createBody(bodyDef);
    }

    public void setContactListener(ContactListener contactListener) {
	world.setContactListener(contactListener);
    }

    public void renderBox2DDebug(Camera camera) {
	camera.renderDebugBox2D(world);
    }
}
