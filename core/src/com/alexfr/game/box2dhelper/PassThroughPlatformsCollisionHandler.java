package com.alexfr.game.box2dhelper;

import com.badlogic.gdx.physics.box2d.Contact;

public class PassThroughPlatformsCollisionHandler implements CollisionEvent {
    private GroundCollisionHandler groundCollision;
    private Collidable collidable;

    public PassThroughPlatformsCollisionHandler(GroundCollisionHandler groundCollision, Collidable collidable) {
	this.groundCollision = groundCollision;
	this.collidable = collidable;
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
	if (!groundCollision.isTouchingThis(contact.getFixtureB()) || !collidable.isFallingDown()) {
	    contact.setEnabled(false);
	}
    }

    @Override
    public void postSolve(Contact contact) {
    }
}
