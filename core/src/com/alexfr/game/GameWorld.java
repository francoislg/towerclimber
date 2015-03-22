package com.alexfr.game;

import com.alexfr.game.characters.Character;
import com.alexfr.game.controllers.GameController;
import com.alexfr.game.controllers.KeyboardController;
import com.alexfr.game.rendering.CharacterRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class GameWorld {
	SpriteBatch batch;
	Character character;
	CharacterRenderer characterRenderer;
	Camera camera;
	CharactersTextureAtlas charactersTextureAtlas;
	GameController gameController;
	World world;
	Box2DDebugRenderer debugRenderer;

	public GameWorld() {
		this(true);
	}

	public GameWorld(Boolean debug) {
		Box2D.init();
		Vector2 gravity = new Vector2(0, 100);
		world = new World(gravity, true);
		batch = new SpriteBatch();
		charactersTextureAtlas = new CharactersTextureAtlas();
		character = new Character(world);
		new Platform(world, new Vector2(200, 400), new Vector2(100, 5));
		new Platform(world, new Vector2(300, 300), new Vector2(100, 5));
		characterRenderer = new CharacterRenderer(character, charactersTextureAtlas);
		gameController = new KeyboardController(character);
		camera = new Camera();
		debugRenderer = new Box2DDebugRenderer();
	}

	public void render() {
		gameController.update();
		character.update();
		camera.update();
		camera.setSpriteBatchProjection(batch);
		batch.begin();
		characterRenderer.render(batch);
		batch.end();
		world.step(1 / 60f, 6, 2);
		camera.renderDebugBox2D(debugRenderer, world);
	}
}
