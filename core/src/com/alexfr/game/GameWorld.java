package com.alexfr.game;

import com.alexfr.game.characters.Character;
import com.alexfr.game.controllers.GameController;
import com.alexfr.game.controllers.KeyboardController;
import com.alexfr.game.rendering.CharacterRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.physics.box2d.World;

public class GameWorld {
	SpriteBatch batch;
	Character character;
	CharacterRenderer characterRenderer;
	Camera camera;
	CharactersTextureAtlas charactersTextureAtlas;
	GameController gameController;
	World world;
	
	public GameWorld() {
		Box2D.init();
		world = new World(new Vector2(0, 10), true);
		batch = new SpriteBatch();
		charactersTextureAtlas = new CharactersTextureAtlas();
		character = new Character(world);
		characterRenderer = new CharacterRenderer(character, charactersTextureAtlas);
		gameController = new KeyboardController(character);
		camera = new Camera();
	}
	
	public void render(){
		gameController.update();
		character.update();
		camera.update();
		camera.setSpriteBatchProjection(batch);
		batch.begin();
		characterRenderer.render(batch);
		batch.end();
		world.step(1/60f, 6, 2);
	}
}
