package com.alexfr.game.rendering;

import com.alexfr.game.world.GameWorld;
import com.alexfr.game.world.WorldBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameWorldRenderer implements Renderer {
    private GameWorld world;
    private WorldBounds worldBounds;

    public GameWorldRenderer(GameWorld world) {
	this.world = world;
	worldBounds = world.getBounds();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

}
