package com.alexfr.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.alexfr.game.box2dhelper.Conversion;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class PlatformHandler {
	
	private World world;
	private Random random;
	private List<Platform> platforms;
	private float topMostPlatform = 0;
	private float bottomMostPlatform = 0;
	private final float offsetForNewPlatform = 300;
	private final float offsetForDeletingPlatform = 1000;
	private final float distanceBetweenPlatforms = 80;
	
	public PlatformHandler(World world){
		this(world, new Random());
	}
	
	public PlatformHandler(World world, Random random){
		this.world = world;
		this.random = random;
		this.platforms = new ArrayList<Platform>();
	}
	
	public void generatePlaform(){
		Vector2 position = Conversion.metersToPixels(new Vector2(random.nextInt(300) - 150, topMostPlatform - distanceBetweenPlatforms));
		Vector2 size = Conversion.metersToPixels(new Vector2(100, 1));
		topMostPlatform = position.y;
		if(platforms.isEmpty()){
			bottomMostPlatform = position.y;
		}
		Platform platform = new Platform(world, position, size);
		platforms.add(platform);
		Gdx.app.log("platforms", "NEW ONE");
	}
	
	public void update(float topBound, float bottomBound){
		while(shouldGeneratePlatform(topBound)){
			generatePlaform();
		}
		while(shouldDeletePlatform(bottomBound)){
			removeLastOne();
		}
	}
	
	private void removeLastOne() {
		platforms.remove(0);
		Gdx.app.log("platforms", "DELETING ONE");
	}

	private boolean shouldDeletePlatform(float bottomBound) {
		return bottomMostPlatform < bottomBound + offsetForDeletingPlatform;
	}

	private boolean shouldGeneratePlatform(float topBound){
		return topMostPlatform > topBound - offsetForNewPlatform;
	}
}
