package com.alexfr.game.box2dhelper;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ContactListener;

public interface WorldHandler {
    public Body createBody(BodyDef bodyDef);

    public void setContactListener(ContactListener contactListener);
}
