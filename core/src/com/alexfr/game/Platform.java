package com.alexfr.game;

import com.alexfr.game.box2dhelper.BodyBuilder;
import com.alexfr.game.box2dhelper.Conversion;
import com.alexfr.game.box2dhelper.FixtureBuilder;
import com.alexfr.game.box2dhelper.VectorInWorld;
import com.alexfr.game.rendering.Animable;
import com.alexfr.game.rendering.RenderState;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public class Platform implements Animable {
    private Body body;
    private Vector2 size;

    public Platform(World world, VectorInWorld position, Vector2 size) {
	this.body = new BodyBuilder().thatIsStatic().atPosition(position).buildIn(world);
	new FixtureBuilder().withABoxShape(Conversion.halfVector(size)).buildIn(body);
    }

    public void destroy() {
	World bodyWorld = body.getWorld();
	bodyWorld.destroyBody(body);
    }

    @Override
    public Vector2 getPosition() {
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
