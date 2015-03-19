package com.alexfr.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Platform {
	
	Body body;
	BodyDef bodyDef;
	
	public Platform(World world, Vector2 position, Vector2 size){
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.StaticBody;
		
		body = world.createBody(bodyDef);
		
		PolygonShape shape = new PolygonShape();
        shape.setAsBox(size.x, size.y);
        
		FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        body.createFixture(fixtureDef);
        body.setTransform(position, 0);
        
        shape.dispose();
	}
}
