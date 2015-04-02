package com.alexfr.game.characters;

import com.alexfr.game.GameWorld;
import com.alexfr.game.WorldBounds;
import com.alexfr.game.box2dhelper.BodyBuilder;
import com.alexfr.game.box2dhelper.CollisionsHandler;
import com.alexfr.game.box2dhelper.Conversion;
import com.alexfr.game.box2dhelper.FixtureBuilder;
import com.alexfr.game.box2dhelper.GroundCollisionHandler;
import com.alexfr.game.box2dhelper.PassThroughPlatformsCollisionHandler;
import com.alexfr.game.box2dhelper.VectorInWorld;
import com.alexfr.game.camera.Targetable;
import com.alexfr.game.controllers.Controllable;
import com.alexfr.game.rendering.Animable;
import com.alexfr.game.rendering.RenderState;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;

public class Character implements Controllable, Animable, Targetable {

    private final Vector2 size;
    private final Vector2 speed = new Vector2(1, 5);
    private final float jumpForce = 30f;
    private Body body;
    private Fixture bodyFixture;
    private Fixture feets;
    private GroundCollisionHandler groundCollision;
    private PassThroughPlatformsCollisionHandler passThroughPlaformsCollision;
    private CollisionsHandler collisions;
    private boolean canJump = false;
    private WorldBounds bounds;

    public Character(GameWorld world, Vector2 size) {
	this.size = size;
	this.bounds = world.getBounds();
	Vector2 position = new VectorInWorld(Conversion.worldToPixels(bounds.getMiddle()), 0);
	this.body = new BodyBuilder().thatIsDynamic().atPosition(position).withFixedRotation().buildIn(world);
	Vector2 boxSize = Conversion.halfVector(size);
	this.bodyFixture = new FixtureBuilder().withABoxShape(boxSize).withDensity(1f).buildIn(body);
	this.feets = new FixtureBuilder().thatIsASensor()
		.withABoxShape(new Vector2(boxSize.x * 0.8f, 0.5f), new Vector2(0, boxSize.y), 0).buildIn(body);
	this.collisions = new CollisionsHandler(world);
	this.groundCollision = new GroundCollisionHandler();
	this.passThroughPlaformsCollision = new PassThroughPlatformsCollisionHandler(groundCollision, this);
	this.collisions.addCollision(groundCollision, feets);
	this.collisions.addCollision(passThroughPlaformsCollision, bodyFixture);
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
    public Vector2 getSizeInPixels() {
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
	if (bounds.isOutsideBounds(body.getPosition().x, size.x)) {
	    Vector2 currentVelocity = body.getLinearVelocity();
	    body.setLinearVelocity(-(currentVelocity.x / 2), currentVelocity.y);
	}
    }

    public boolean isFallingDown() {
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
