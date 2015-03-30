package com.alexfr.game.box2dhelper;

import com.badlogic.gdx.physics.box2d.Contact;

public interface CollisionEvent {
    public boolean contactIsValid(Contact contact);

    public void beginCollision(Contact contact);

    public void endCollision(Contact contact);

    public void preSolve(Contact contact);

    public void postSolve(Contact contact);
}
