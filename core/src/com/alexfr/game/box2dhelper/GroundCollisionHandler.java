package com.alexfr.game.box2dhelper;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;

public class GroundCollisionHandler implements CollisionEvent {
    private List<Fixture> listFixtureTouching;

    public GroundCollisionHandler() {
	listFixtureTouching = new ArrayList<Fixture>();
    }

    public boolean isTouchingGround() {
	return listFixtureTouching.size() != 0;
    }

    public boolean isNotTouchingGround() {
	return !isTouchingGround();
    }

    public boolean isTouchingThis(Fixture fixture) {
	return listFixtureTouching.contains(fixture);
    }

    @Override
    public void beginCollision(Contact contact) {
	listFixtureTouching.add(contact.getFixtureB());
    }

    @Override
    public void endCollision(Contact contact) {
	listFixtureTouching.remove(contact.getFixtureB());
    }

    @Override
    public boolean contactIsValid(Contact contact) {
	return true;
    }

    @Override
    public void preSolve(Contact contact) {
    }

    @Override
    public void postSolve(Contact contact) {
    }
}
