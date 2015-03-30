package com.alexfr.game.controllers;

import java.util.ArrayList;
import java.util.List;

public class PressableKeysHandler {
    private List<Integer> keycodes;

    public PressableKeysHandler() {
	this.keycodes = new ArrayList<Integer>();
    }

    public void updateKeyDown(Integer keycode) {
	if (!keycodes.contains(keycode)) {
	    keycodes.add(keycode);
	}
    }

    public void updateKeyUp(Integer keycode) {
	if (keycodes.contains(keycode)) {
	    keycodes.remove(keycode);
	}
    }

    public boolean isPressed(Integer keycode) {
	return keycodes.contains(keycode);
    }
}
