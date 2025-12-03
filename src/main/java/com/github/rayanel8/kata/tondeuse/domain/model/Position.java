package com.github.rayanel8.kata.tondeuse.domain.model;

/**
 * Immutable value object representing a coordinate on the lawn grid.
 */
public class Position {
	private final int x;
	private final int y;

	public Position(final int newX, final int newY) {
		x = newX;
		y = newY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}