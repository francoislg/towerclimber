package com.alexfr.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class CharactersTextureAtlas {
	private TextureAtlas textureAtlas;
	private Sprite tempSprite;
	private Texture tempTexture;
	
	public CharactersTextureAtlas(){
		tempTexture = new Texture("characters/badlogic.jpg");
		tempSprite = new Sprite(tempTexture);
		tempSprite.flip(false, true);
	}
	
	public Sprite createSprite(String name){
		return tempSprite;
	}
	
	public void dispose(){
		textureAtlas.dispose();
	}
}
