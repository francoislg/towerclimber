package com.alexfr.game;

import static com.badlogic.gdx.Gdx.files;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class CharactersTextureAtlas {
	private TextureAtlas textureAtlas;
	
	public CharactersTextureAtlas(){
		textureAtlas = new TextureAtlas(files.internal("characters.atlas"), true);
	}
	
	public Sprite createSprite(String name){
		return textureAtlas.createSprite(name);
	}
	
	public void dispose(){
		textureAtlas.dispose();
	}
}
