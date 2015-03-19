package com.alexfr.game.controllers;

import static com.badlogic.gdx.Gdx.input;
import static com.badlogic.gdx.Input.Keys;

import com.badlogic.gdx.InputProcessor;

public class KeyboardController implements GameController, InputProcessor {
	
	private Controllable controllable;
	private int leftKey = Keys.LEFT;
	private int rightKey = Keys.RIGHT;
	private PressableKeysHandler pressableKeys;
	
	public KeyboardController(Controllable controllable){
		pressableKeys = new PressableKeysHandler();
		input.setInputProcessor(this);
		this.controllable = controllable;
	}
	
	public void update(){
		if(pressableKeys.isPressed(leftKey)){
			controllable.moveLeft();
		}
		if(pressableKeys.isPressed(rightKey)){
			controllable.moveRight();
		}
	}
	
	@Override
	public void changeControllable(Controllable controllable) {
		this.controllable = controllable;
	}

	@Override
	public boolean keyDown(int keycode) {
		pressableKeys.updateKeyDown(keycode);
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		pressableKeys.updateKeyUp(keycode);
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
