package com.alexfr.game.desktop;

import com.alexfr.game.TowerClimber;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] arg) {
	LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	config.foregroundFPS = 60;
	config.backgroundFPS = 30;
	config.width = 1280;
	config.height = 720;
	new LwjglApplication(new TowerClimber(), config);
    }
}
