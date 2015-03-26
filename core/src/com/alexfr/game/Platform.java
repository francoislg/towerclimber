package com.alexfr.game;

import com.alexfr.game.box2dhelper.BodyBuilder;
import com.alexfr.game.box2dhelper.FixtureBuilder;
import com.alexfr.game.rendering.RenderState;
import com.alexfr.game.rendering.Renderable;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public class Platform implements Renderable {
	private Body body;
	private Vector2 size;

	public Platform(World world, Vector2 position, Vector2 size) {
		this.body = new BodyBuilder().thatIsStatic().atPosition(position).buildIn(world);
		new FixtureBuilder().withABoxShape(size).buildIn(body);
	}
	
	public void destroy(){
		World bodyWorld = body.getWorld();
		bodyWorld.destroyBody(body);
	}
	
	@Override
	public Vector2 getPosition(){
		return body.getPosition();
	}

	@Override
	public float getRotation() {
		return 0;
	}

	@Override
	public Vector2 getSizeInPixels() {
		return size;
	}

	@Override
	public RenderState getCurrentState() {
		return RenderState.Idle;
	}

	@Override
	public boolean isFacingLeft() {
		return false;
	}
}
