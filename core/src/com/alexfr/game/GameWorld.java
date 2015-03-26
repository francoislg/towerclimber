package com.alexfr.game;

import java.util.Random;

import com.alexfr.game.box2dhelper.Conversion;
import com.alexfr.game.characters.Character;
import com.alexfr.game.controllers.GameController;
import com.alexfr.game.controllers.KeyboardController;
import com.alexfr.game.rendering.CharacterRenderer;
import com.alexfr.game.rendering.CharactersTextureAtlas;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class GameWorld {
	private SpriteBatch batch;
	private Character character;
	private CharacterRenderer characterRenderer;
	private Camera camera;
	private CharactersTextureAtlas charactersTextureAtlas;
	private GameController gameController;
	private World world;
	private Box2DDebugRenderer debugRenderer;
	private Random seed;
	private PlatformHandler platformHandler;

	public GameWorld() {
		this(true);
	}

	public GameWorld(Boolean debug) {
		Box2D.init();
		seed = new Random();
		Vector2 gravity = new Vector2(0, 100);
		world = new World(gravity, true);
		batch = new SpriteBatch();
		charactersTextureAtlas = new CharactersTextureAtlas();
		character = new Character(world, new Vector2(25, 25));
		characterRenderer = new CharacterRenderer(character, charactersTextureAtlas);
		gameController = new KeyboardController(character);
		platformHandler = new PlatformHandler(world, seed);
		camera = new Camera();
		camera.setPosition(new Vector2(character.getPosition().x, 0));
		debugRenderer = new Box2DDebugRenderer();
	}

	public void render() {
		gameController.update();
		character.update();
		float positionYMeters = character.getPosition().y;
		float topBound = positionYMeters - 500;
		float bottomBound = positionYMeters + 500;
		platformHandler.update(topBound, bottomBound);
		camera.follow(character);
		camera.update();
		camera.setSpriteBatchProjection(batch);
		batch.begin();
		characterRenderer.render(batch);
		batch.end();
		world.step(1 / 60f, 6, 2);
		camera.renderDebugBox2D(debugRenderer, world);
	}
}
