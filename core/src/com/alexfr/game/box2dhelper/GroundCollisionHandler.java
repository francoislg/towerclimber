package com.alexfr.game.box2dhelper;

import com.badlogic.gdx.physics.box2d.Contact;

public class GroundCollisionHandler implements CollisionEvent {
	int numberOfCollision = 0;
	
	public GroundCollisionHandler() {
		
	}
	
	public boolean isTouchingGround(){
		return numberOfCollision != 0;
	}
	
	public boolean isNotTouchingGround() {
		return !isTouchingGround();
	}

	@Override
	public void beginCollision(Contact contact) {
		if(contactIsValid(contact)){
			numberOfCollision++;
		}
	}

	@Override
	public void endCollision(Contact contact) {
		if(contactIsValid(contact)){
			numberOfCollision--;
		}
	}
	
	private boolean contactIsValid(Contact contact){
		return true;
	}
}
