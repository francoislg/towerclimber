package com.alexfr.game.rendering;

import static com.badlogic.gdx.Gdx.files;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class CharactersTextureAtlas {
    private TextureAtlas textureAtlas;

    public CharactersTextureAtlas() {
	textureAtlas = new TextureAtlas(files.internal("characters.pack"), true);
    }

    public Sprite createSprite(String name) {
	return textureAtlas.createSprite(name);
    }

    public AtlasRegion findRegion(String name) {
	AtlasRegion atlasRegion = textureAtlas.findRegion(name);
	atlasRegion.flip(false, true);
	return atlasRegion;
    }

    public void dispose() {
	textureAtlas.dispose();
    }
}
