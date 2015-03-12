package com.alexfr.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class CharactersTextureAtlas {
	private TextureAtlas textureAtlas;
	private Sprite tempSprite;
	private Texture tempTexture;
	
	public CharactersTextureAtlas(){
		tempTexture = new Texture("badlogic");
		tempSprite = new Sprite(tempTexture);
	}
	
	public Sprite createSprite(String name){
		return tempSprite;
		/*Sprite sprite = textureAtlas.createSprite(name);
		sprite.flip(false, true);
		return sprite;*/
	}
	
	public void dispose(){
		textureAtlas.dispose();
	}
}
