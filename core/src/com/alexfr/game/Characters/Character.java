package com.alexfr.game.characters;

import com.alexfr.game.box2dhelper.BodyBuilder;
import com.alexfr.game.box2dhelper.CollisionsHandler;
import com.alexfr.game.box2dhelper.Conversion;
import com.alexfr.game.box2dhelper.FixtureBuilder;
import com.alexfr.game.box2dhelper.GroundCollisionHandler;
import com.alexfr.game.box2dhelper.PassThroughPlatformsCollisionHandler;
import com.alexfr.game.controllers.Controllable;
import com.alexfr.game.rendering.RenderState;
import com.alexfr.game.rendering.Renderable;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

public class Character implements Controllable, Renderable {

	private final Vector2 size;
	private final Vector2 boxSize;
	private final Vector2 speed = new Vector2(1, 5);
	private final float jumpForce = 200;
	private Body body;
	private Fixture bodyFixture;
	private Fixture feets;
	private GroundCollisionHandler groundCollision;
	private PassThroughPlatformsCollisionHandler passThroughPlaformsCollision;
	private CollisionsHandler collisions;
	private boolean canJump = false;

	public Character(World world, Vector2 size) {
		this.size = size;
		this.boxSize = new Vector2(size.x / 2, size.y / 2);
		body = new BodyBuilder().thatIsDynamic().withFixedRotation().buildIn(world);
		bodyFixture = new FixtureBuilder().withABoxShape(boxSize).withDensity(1f).buildIn(body);
		feets = new FixtureBuilder().thatIsASensor().withABoxShape(new Vector2(boxSize.x, Conversion.metersToPixels(1)), new Vector2(0, boxSize.y), 0).buildIn(body);
		collisions = new CollisionsHandler(world);
		groundCollision = new GroundCollisionHandler();
		passThroughPlaformsCollision = new PassThroughPlatformsCollisionHandler(groundCollision);
		collisions.addCollision(groundCollision, feets);
		collisions.addCollision(passThroughPlaformsCollision, bodyFixture);
	}

	@Override
	public Vector2 getPosition() {
		return body.getPosition();
	}

	@Override
	public float getRotation() {
		return (float) Math.toDegrees(body.getAngle());
	}

	@Override
	public Vector2 getSize() {
		return size;
	}

	@Override
	public void jump() {
		if (groundCollision.isTouchingGround() && canJump) {
			float impulse = body.getMass() * jumpForce;
			body.applyLinearImpulse(new Vector2(0, -impulse), body.getWorldCenter(), true);
			canJump = false;
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
		if (groundCollision.isNotTouchingGround() && isFallingDown()) {
			canJump = true;
		}
	}
	
	private boolean isFallingDown(){
		return body.getLinearVelocity().y >= 0.0f;
	}

	@Override
	public boolean isFacingLeft() {
		return body.getLinearVelocity().x < 0;
	}

	@Override
	public RenderState getCurrentState() {
		if (groundCollision.isNotTouchingGround() || !isFallingDown()) {
			return RenderState.Jumping;
		} else {
			float currentSpeed = Math.abs(body.getLinearVelocity().x);
			if (currentSpeed > speed.x / 2) {
				return RenderState.Walking;
			} else {
				return RenderState.Idle;
			}
		}
	}
}
