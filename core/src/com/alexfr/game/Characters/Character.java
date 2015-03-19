package com.alexfr.game.characters;

import com.alexfr.game.controllers.Controllable;
import com.alexfr.game.rendering.Renderable;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Character implements Controllable, Renderable {
	
	private Vector2 size = new Vector2(50, 50);
	private Vector2 speed = new Vector2(1, 5);
	Body body;
	
	public Character(World world) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		
        body = world.createBody(bodyDef);
		
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(size.x/2, size.y/2);
        
		FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        body.createFixture(fixtureDef);
        
        shape.dispose();
	}
	
	@Override
	public Vector2 getPosition(){
		return body.getPosition();
	}
	
	@Override
	public float getRotation(){
		return (float)Math.toDegrees(body.getAngle());
	}
	
	@Override
	public Vector2 getSize(){
		return size;
	}

	@Override
	public void jump(){
		float impulse = body.getMass() * 10;
		body.applyLinearImpulse(new Vector2(0, -impulse), body.getWorldCenter(), true);
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
