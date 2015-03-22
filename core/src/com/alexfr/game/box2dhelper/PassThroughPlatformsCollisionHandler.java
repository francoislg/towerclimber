package com.alexfr.game.box2dhelper;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;

public class PassThroughPlatformsCollisionHandler implements CollisionEvent {
	public PassThroughPlatformsCollisionHandler() {

	}

	@Override
	public boolean contactIsValid(Contact contact) {
		return true;
	}

	@Override
	public void beginCollision(Contact contact) {

	}

	@Override
	public void endCollision(Contact contact) {

	}

	@Override
	public void preSolve(Contact contact) {
		Vector2 velocity = contact.getFixtureA().getBody().getLinearVelocity();
		if (velocity.y < 0) {
			contact.setEnabled(false);
		}
	}

	@Override
	public void postSolve(Contact contact) {
	}
}
