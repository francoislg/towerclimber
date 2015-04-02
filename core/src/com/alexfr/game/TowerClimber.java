package com.alexfr.game;

import com.alexfr.game.camera.Camera;
import com.alexfr.game.characters.Character;
import com.alexfr.game.constants.Conversion;
import com.alexfr.game.controllers.ControllersHandler;
import com.alexfr.game.controllers.DebugClick;
import com.alexfr.game.controllers.GameController;
import com.alexfr.game.controllers.KeyboardController;
import com.alexfr.game.rendering.CharacterRenderer;
import com.alexfr.game.rendering.CharactersTextureAtlas;
import com.alexfr.game.world.GameWorld;
import com.alexfr.game.world.PlatformHandler;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class TowerClimber extends ApplicationAdapter {
    private SpriteBatch batch;
    private GameWorld gameWorld;
    private FPSLogger fpsLogger;
    private Camera camera;
    private ControllersHandler controllers;
    private Character character;
    private CharactersTextureAtlas charactersTextureAtlas;
    private CharacterRenderer characterRenderer;
    private PlatformHandler platformHandler;

    @Override
    public void create() {
	gameWorld = new GameWorld();
	charactersTextureAtlas = new CharactersTextureAtlas();
	character = new Character(gameWorld, new Vector2(16, 16));
	characterRenderer = new CharacterRenderer(character, charactersTextureAtlas);
	camera = new Camera();
	camera.setPosition(new Vector2(gameWorld.getBounds().getMiddle(), 0));
	camera.changeTarget(character);
	setUpControllers();
	batch = new SpriteBatch();
	platformHandler = new PlatformHandler(gameWorld);
	fpsLogger = new FPSLogger();
    }

    private void setUpControllers() {
	controllers = new ControllersHandler();
	GameController gameController = new KeyboardController(character);
	controllers.add(gameController);
	DebugClick debugClick = new DebugClick(camera);
	controllers.add(debugClick);
    }

    @Override
    public void render() {
	Gdx.gl.glClearColor(0, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	controllers.update();
	character.update();
	gameWorld.update();
	float positionYWorld = character.getPosition().y;
	float topBound = positionYWorld - Conversion.pixelsToWorld(500);
	float bottomBound = positionYWorld + Conversion.pixelsToWorld(500);
	platformHandler.update(topBound, bottomBound);
	camera.update();
	camera.setSpriteBatchProjection(batch);
	batch.begin();
	characterRenderer.render(batch);
	batch.end();
	gameWorld.renderBox2DDebug(camera);
	fpsLogger.log();
    }
}
