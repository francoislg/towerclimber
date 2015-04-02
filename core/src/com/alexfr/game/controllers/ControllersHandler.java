package com.alexfr.game.controllers;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;

public class ControllersHandler {
    private InputMultiplexer inputMultiplexer;
    private List<GameController> controllers;

    public ControllersHandler() {
	this.inputMultiplexer = new InputMultiplexer();
	Gdx.input.setInputProcessor(inputMultiplexer);
	controllers = new ArrayList<GameController>();
    }

    public void add(GameController controller) {
	inputMultiplexer.addProcessor(controller);
	controllers.add(controller);
    }

    public void add(InputProcessor input) {
	inputMultiplexer.addProcessor(input);
    }

    public void remove(GameController controller) {
	inputMultiplexer.removeProcessor(controller);
	controllers.remove(controller);
    }

    public void remove(InputProcessor input) {
	inputMultiplexer.removeProcessor(input);
    }

    public void update() {
	for (GameController controller : controllers) {
	    controller.update();
	}
    }
}
