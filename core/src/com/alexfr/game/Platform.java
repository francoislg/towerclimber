package com.alexfr.game;

import com.alexfr.game.box2dhelper.BodyBuilder;
import com.alexfr.game.box2dhelper.FixtureBuilder;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public class Platform {
	Body body;

	public Platform(World world, Vector2 position, Vector2 size) {
		body = new BodyBuilder().thatIsStatic().atPosition(position).buildIn(world);
		new FixtureBuilder().withABoxShape(size).buildIn(body);
	}
}
