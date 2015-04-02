package com.alexfr.game.controllers;

import com.badlogic.gdx.InputProcessor;

public interface GameController extends InputProcessor {
    public void changeControllable(Controllable controllable);

    public void update();
}
