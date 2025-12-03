package com.github.rayanel8.kata.tondeuse.domain.model;

/**
 * Represents the rectangular lawn on which mowers can move. The coordinates
 * range from (0,0) to (maxX,maxY).
 */
public class Pelouse {
	private final int maxX;
	private final int maxY;

	public Pelouse(final int newMaxX, final int newMaxY) {
		maxX = newMaxX;
		maxY = newMaxY;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}
}
