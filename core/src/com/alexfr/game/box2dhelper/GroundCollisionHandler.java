package com.alexfr.game.box2dhelper;

import com.badlogic.gdx.physics.box2d.Contact;

public class GroundCollisionHandler implements CollisionEvent {
	int numberOfCollision = 0;

	public GroundCollisionHandler() {

	}

	public boolean isTouchingGround() {
		return numberOfCollision != 0;
	}

	public boolean isNotTouchingGround() {
		return !isTouchingGround();
	}

	@Override
	public void beginCollision(Contact contact) {
		numberOfCollision++;
	}

	@Override
	public void endCollision(Contact contact) {
		numberOfCollision--;
	}

	@Override
	public boolean contactIsValid(Contact contact) {
		return true;
	}

	@Override
	public void preSolve(Contact contact) {
		contact.setEnabled(false);
	}

	@Override
	public void postSolve(Contact contact) {
	}
}
