package com.alexfr.game;

import com.alexfr.game.box2dhelper.Conversion;
import com.alexfr.game.characters.Character;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class Camera {
    private OrthographicCamera camera;

    public Camera() {
	this(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public Camera(int width, int height) {
	camera = new OrthographicCamera(width, height);
	camera.setToOrtho(true, width, height);
	camera.zoom = Conversion.worldToPixels(1);
	camera.update();
    }

    public void setPosition(Vector2 position) {
	camera.position.set(position, camera.position.z);
    }

    public void update() {
	camera.update();
    }

    public void setSpriteBatchProjection(SpriteBatch batch) {
	batch.setProjectionMatrix(camera.combined);
    }

    public void renderDebugBox2D(Box2DDebugRenderer debugRenderer, World world) {
	debugRenderer.render(world, camera.combined);
    }

    public void follow(Character character) {
	float lerp = 0.03f;
	Vector2 position = character.getPosition();
	Vector3 camPosition = camera.position;
	camPosition.y += (position.y - camPosition.y) * lerp;
    }

    public Vector3 screenToWorld(float screenX, float screenY) {
	Vector3 worldCoordinates = new Vector3(screenX, screenY, 0);
	return camera.unproject(worldCoordinates);
    }
}
