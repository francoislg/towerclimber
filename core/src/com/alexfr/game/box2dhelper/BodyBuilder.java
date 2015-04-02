package com.alexfr.game.box2dhelper;

import com.alexfr.game.GameWorld;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class BodyBuilder {
    private BodyDef bodyDef;
    private Vector2 position;
    private float angle;

    public BodyBuilder() {
	bodyDef = new BodyDef();
	bodyDef.type = BodyType.StaticBody;
	position = new Vector2(0, 0);
	angle = 0;
    }

    public BodyBuilder thatIsDynamic() {
	bodyDef.type = BodyType.DynamicBody;
	return this;
    }

    public BodyBuilder thatIsStatic() {
	bodyDef.type = BodyType.StaticBody;
	return this;
    }

    public BodyBuilder thatIsKinematic() {
	bodyDef.type = BodyType.KinematicBody;
	return this;
    }

    public BodyBuilder withFixedRotation() {
	bodyDef.fixedRotation = true;
	return this;
    }

    public BodyBuilder atPosition(Vector2 position) {
	this.position = position;
	return this;
    }

    public BodyBuilder atAngle(float angle) {
	this.angle = angle;
	return this;
    }

    public Body buildIn(GameWorld world) {
	Body body = world.createBody(bodyDef);
	body.setTransform(position, angle);
	return body;
    }
}
