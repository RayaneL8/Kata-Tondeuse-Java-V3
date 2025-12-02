package com.github.rayanel8.kata.tondeuse.domain.model;

import com.github.rayanel8.kata.tondeuse.domain.enums.Orientation;

public class Tondeuse {
    private Position position;
    private Orientation orientation;

    public Tondeuse(final Position newPosition, final Orientation newOrientation) {
        position = newPosition;
        orientation = newOrientation;
    }

    public void rotateLeft() {}
    public void rotateRight() {}
    public void moveForward(final Pelouse pelouse) {}

    public Position getPosition() { return position; }
    public void setPosition(final Position newPosition) { position = newPosition; }
    
    public Orientation getOrientation() { return orientation; }
    public void setOrientation(final Orientation newOrientation) { orientation = newOrientation; }
    
}
