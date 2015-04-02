package com.alexfr.game.controllers;

import com.badlogic.gdx.Input.Keys;

public class KeyboardController implements GameController {

    private Controllable controllable;
    private int leftKey = Keys.LEFT;
    private int rightKey = Keys.RIGHT;
    private int jumpKey = Keys.UP;
    private PressableKeysHandler pressableKeys;

    public KeyboardController(Controllable controllable) {
	pressableKeys = new PressableKeysHandler();
	this.controllable = controllable;
    }

    public void update() {
	if (pressableKeys.isPressed(leftKey)) {
	    controllable.moveLeft();
	}
	if (pressableKeys.isPressed(rightKey)) {
	    controllable.moveRight();
	}
	if (pressableKeys.isPressed(jumpKey)) {
	    controllable.jump();
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
