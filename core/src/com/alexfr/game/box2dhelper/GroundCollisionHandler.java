package com.alexfr.game.box2dhelper;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

public class GroundCollisionHandler {
	Fixture collisionFixture;
	int numberOfCollision = 0;
	
	ContactListener groundCollision = new ContactListener() {
		@Override
		public void beginContact(Contact contact) {
			if(contact.getFixtureA().equals(collisionFixture)){
				beginTouchingGround();
			};
		}

		@Override
		public void endContact(Contact contact) {
			if(contact.getFixtureA().equals(collisionFixture)){
				endTouchingGround();
			}
		}

		@Override
		public void preSolve(Contact contact, Manifold oldManifold) {}

		@Override
		public void postSolve(Contact contact, ContactImpulse impulse) {}
    };
	
	public GroundCollisionHandler(Fixture collisionFixture) {
		this.collisionFixture = collisionFixture;
	}
	
	private void beginTouchingGround(){
		numberOfCollision++;
	}
	
	private void endTouchingGround(){
		numberOfCollision--;
	}
	
	public boolean isTouchingGround(){
		return numberOfCollision != 0;
	}
	
	public void setCollisionInWorld(World world){
		world.setContactListener(groundCollision);
	}
}
