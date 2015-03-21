package com.alexfr.game.box2dhelper;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;

public class BodyBuilder {	
	private BodyDef bodyDef;
	
	public BodyBuilder(){
		bodyDef = new BodyDef();
		bodyDef.type = BodyType.StaticBody;
	}
	
	public BodyBuilder thatIsDynamic(){
		bodyDef.type = BodyType.DynamicBody;
		return this;
	}
	
	public BodyBuilder thatIsStatic(){
		bodyDef.type = BodyType.StaticBody;
		return this;
	}
	
	public BodyBuilder thatIsKinematic(){
		bodyDef.type = BodyType.KinematicBody;
		return this;
	}
	
	public Body buildIn(World world){
		return world.createBody(bodyDef);
	}
}
