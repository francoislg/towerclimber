package com.alexfr.game.box2dhelper;

import com.alexfr.game.characters.Character;
import com.badlogic.gdx.physics.box2d.Contact;

public class PassThroughPlatformsCollisionHandler implements CollisionEvent {
    private GroundCollisionHandler groundCollision;
    private Character character;

    public PassThroughPlatformsCollisionHandler(GroundCollisionHandler groundCollision, Character character) {
	this.groundCollision = groundCollision;
	this.character = character;
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
	if (!groundCollision.isTouchingThis(contact.getFixtureB()) || !character.isFallingDown()) {
	    contact.setEnabled(false);
	}
    }

    @Override
    public void postSolve(Contact contact) {
    }
}
