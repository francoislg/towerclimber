package com.alexfr.game.box2dhelper;

import com.badlogic.gdx.physics.box2d.Contact;

public class PassThroughPlatformsCollisionHandler implements CollisionEvent {
    private GroundCollisionHandler groundCollision;

    public PassThroughPlatformsCollisionHandler(
	    GroundCollisionHandler groundCollision) {
	this.groundCollision = groundCollision;
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
	if (!groundCollision.isTouchingThis(contact.getFixtureB())) {
	    contact.setEnabled(false);
	}
    }

    @Override
    public void postSolve(Contact contact) {
    }
}
