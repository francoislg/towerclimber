package com.alexfr.game.box2dhelper;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;

public class FixtureBuilder {

	FixtureDef fixtureDef;
	PolygonShape shape;

	public FixtureBuilder() {
		fixtureDef = new FixtureDef();
		shape = new PolygonShape();
	}

	public FixtureBuilder thatIsASensor() {
		fixtureDef.isSensor = true;
		return this;
	}

	public FixtureBuilder withABoxShape(Vector2 size) {
		shape.setAsBox(size.x, size.y);
		fixtureDef.shape = shape;
		return this;
	}

	public FixtureBuilder withABoxShape(Vector2 size, Vector2 offset, float angle) {
		shape.setAsBox(size.x, size.y, offset, angle);
		fixtureDef.shape = shape;
		return this;
	}

	public FixtureBuilder withShape(Shape shape) {
		fixtureDef.shape = shape;
		return this;
	}

	public FixtureBuilder withDensity(float density) {
		fixtureDef.density = density;
		return this;
	}

	public FixtureBuilder withFriction(float friction) {
		fixtureDef.friction = friction;
		return this;
	}

	public Fixture buildIn(Body body) {
		Fixture fixture = body.createFixture(fixtureDef);
		shape.dispose();
		return fixture;
	}
}
