package com.alexfr.game.controllers;

import static com.badlogic.gdx.Gdx.input;
import static com.badlogic.gdx.Input.Keys;

import com.badlogic.gdx.InputProcessor;

public class KeyboardController implements GameController, InputProcessor {
	
	private Controllable controllable;
	private int jumpKey = Keys.UP;
	private int leftKey = Keys.LEFT;
	private int rightKey = Keys.RIGHT;
	
	public KeyboardController(Controllable controllable){
		this.controllable = controllable;
	}
	
	@Override
	public void changeControllable(Controllable controllable) {
		this.controllable = controllable;
	}

	@Override
	public boolean keyDown(int keycode) {
		if(input.isKeyPressed(jumpKey)){
			controllable.jump();
		}
		if(input.isKeyPressed(leftKey)){
			controllable.moveLeft();
		}
		if(input.isKeyPressed(rightKey)){
			controllable.moveRight();
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
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
