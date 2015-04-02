package com.alexfr.game.box2dhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alexfr.game.GameWorld;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

public class CollisionsHandler {
    private Map<Fixture, List<CollisionEvent>> collisions;

    ContactListener contactListener = new ContactListener() {
	@Override
	public void beginContact(Contact contact) {
	    Fixture fixtureA = contact.getFixtureA();
	    if (collisions.containsKey(fixtureA)) {
		for (CollisionEvent collision : collisions.get(fixtureA)) {
		    if (collision.contactIsValid(contact)) {
			collision.beginCollision(contact);
		    }
		}
	    }
	}

	@Override
	public void endContact(Contact contact) {
	    Fixture fixtureA = contact.getFixtureA();
	    if (collisions.containsKey(fixtureA)) {
		for (CollisionEvent collision : collisions.get(fixtureA)) {
		    if (collision.contactIsValid(contact)) {
			collision.endCollision(contact);
		    }
		}
	    }
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
	    Fixture fixtureA = contact.getFixtureA();
	    if (collisions.containsKey(fixtureA)) {
		for (CollisionEvent collision : collisions.get(fixtureA)) {
		    if (collision.contactIsValid(contact)) {
			collision.preSolve(contact);
		    }
		}
	    }
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
	    Fixture fixtureA = contact.getFixtureA();
	    if (collisions.containsKey(fixtureA)) {
		for (CollisionEvent collision : collisions.get(fixtureA)) {
		    if (collision.contactIsValid(contact)) {
			collision.postSolve(contact);
		    }
		}
	    }
	}
    };

    public CollisionsHandler(GameWorld world) {
	collisions = new HashMap<Fixture, List<CollisionEvent>>();
	world.setContactListener(contactListener);
    }

    public void addCollision(CollisionEvent collision, Fixture fixture) {
	if (!collisions.containsKey(fixture)) {
	    collisions.put(fixture, new ArrayList<CollisionEvent>());
	}
	collisions.get(fixture).add(collision);
    }

    public void setCollisionsInWorld(World world) {
	world.setContactListener(contactListener);
    }
}