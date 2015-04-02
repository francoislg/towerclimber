package com.alexfr.game;

import java.util.Random;

import com.alexfr.game.camera.Camera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.World;

public class GameWorld {
    private final float TOTALWIDTHINWORLD = 200;

    private World world;
    private Random randomizer;
    private WorldBounds worldBounds;

    public GameWorld() {
	Box2D.init();
	randomizer = new Random();
	Vector2 gravity = new Vector2(0, 10f);
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
	world.step(1 / 15f, 8, 3);
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
