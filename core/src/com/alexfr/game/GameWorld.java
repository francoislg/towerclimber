package com.alexfr.game;

import com.alexfr.game.characters.Character;
import com.alexfr.game.controllers.GameController;
import com.alexfr.game.controllers.KeyboardController;
import com.alexfr.game.rendering.CharacterRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2D;

public class GameWorld {
	SpriteBatch batch;
	Character character;
	CharacterRenderer characterRenderer;
	Camera camera;
	CharactersTextureAtlas charactersTextureAtlas;
	GameController gameController;
	
	public GameWorld() {
		Box2D.init();
		batch = new SpriteBatch();
		charactersTextureAtlas = new CharactersTextureAtlas();
		character = new Character();
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
	}
}
