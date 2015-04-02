package com.alexfr.game.controllers;

import com.alexfr.game.Camera;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

public class DebugClick implements InputProcessor {
    Camera camera;

    public DebugClick(Camera camera) {
	this.camera = camera;
    }

    @Override
    public boolean keyDown(int keycode) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean keyUp(int keycode) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean keyTyped(char character) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	if (button == Input.Buttons.LEFT) {
	    Vector3 inWorld = camera.screenToWorld(screenX, screenY);
	    Gdx.app.log("IN WORLD CLICK", inWorld.x + "/" + inWorld.y);
	    return true;
	}
	return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean scrolled(int amount) {
	// TODO Auto-generated method stub
	return false;
    }

}
