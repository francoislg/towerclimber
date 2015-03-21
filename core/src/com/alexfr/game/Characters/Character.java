package com.alexfr.game.characters;

import com.alexfr.game.box2dhelper.BodyBuilder;
import com.alexfr.game.box2dhelper.FixtureBuilder;
import com.alexfr.game.controllers.Controllable;
import com.alexfr.game.rendering.Renderable;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

public class Character implements Controllable, Renderable {
	
	private final Vector2 size = new Vector2(250, 250);
	private final Vector2 boxSize = new Vector2(size.x/2, size.y/2);
	private final Vector2 speed = new Vector2(1, 5);
	private final float jumpForce = 10;
	Body body;
	
	Fixture bodyFixture;
	Fixture feetFixture;
	
	public Character(World world) {
        body = new BodyBuilder().thatIsDynamic().buildIn(world);
        bodyFixture = new FixtureBuilder().withABoxShape(boxSize).withDensity(1f).buildIn(body);        
        feetFixture = new FixtureBuilder().thatIsASensor().withABoxShape(new Vector2(boxSize.x, 1), new Vector2(0, boxSize.y), 0).buildIn(body);
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
		float impulse = body.getMass() * jumpForce;
		if(feetFixture.testPoint(5, 1)){
			body.applyLinearImpulse(new Vector2(0, -impulse), body.getWorldCenter(), true);
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
