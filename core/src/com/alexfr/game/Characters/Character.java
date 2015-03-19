package com.alexfr.game.characters;

import com.alexfr.game.controllers.Controllable;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Character implements Controllable {
	
	private Vector2 size = new Vector2(50,50);
	private Vector2 speed = new Vector2(1,5);
	Body body;
	
	public Character(World world) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		
		PolygonShape shape = new PolygonShape();
        shape.setAsBox(size.x, size.y);
        
        body = world.createBody(bodyDef);
		
		FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        body.createFixture(fixtureDef);
        
        shape.dispose();
	}
	
	public Vector2 getPosition(){
		return body.getPosition();
	}

	@Override
	public void jump(){
		Vector2 linearVelocity = body.getLinearVelocity();
		if(linearVelocity.y < 5){
			body.setLinearVelocity(linearVelocity.x, linearVelocity.y + speed.y);
		}
	}
	
	@Override
	public void moveLeft() {
		Vector2 linearVelocity = body.getLinearVelocity();
		body.setLinearVelocity(linearVelocity.x - speed.x, linearVelocity.y);
	}

	@Override
	public void moveRight() {
		Vector2 linearVelocity = body.getLinearVelocity();
		body.setLinearVelocity(linearVelocity.x + speed.x, linearVelocity.y);
	}

	@Override
	public void update() {
		
	}
}
