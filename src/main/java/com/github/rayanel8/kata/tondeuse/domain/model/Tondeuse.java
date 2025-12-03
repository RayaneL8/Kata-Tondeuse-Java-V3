package com.github.rayanel8.kata.tondeuse.domain.model;

import com.github.rayanel8.kata.tondeuse.domain.enums.Orientation;

/**
 * Represents a mower placed on a {@link Pelouse}, defined by a current
 * {@link Position} and {@link Orientation}.
 * <p>
 * A mower can rotate left or right (changing its orientation) and move forward
 * by one grid unit, as long as the resulting position remains inside the lawn
 * boundaries.
 * </p>
 */
public class Tondeuse {
	private Position position;
	private Orientation orientation;

	public Tondeuse(final Position newPosition, final Orientation newOrientation) {
		position = newPosition;
		orientation = newOrientation;
	}

	public Position getPosition() {
		return position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void rotateLeft() {
		switch (orientation) {
		case N -> orientation = Orientation.W;
		case E -> orientation = Orientation.N;
		case S -> orientation = Orientation.E;
		case W -> orientation = Orientation.S;
		}
	}

	public void rotateRight() {
		switch (orientation) {
		case N -> orientation = Orientation.E;
		case E -> orientation = Orientation.S;
		case S -> orientation = Orientation.W;
		case W -> orientation = Orientation.N;
		}
	}

	public void moveForward(final Pelouse pelouse) {
		Position next = calculateNextPosition();

		if (isInsidePelouse(next, pelouse)) {
			position = next;
		}
	}

	/**
	 * Computes the next theoretical position of the mower based on its current
	 * orientation, without applying any boundary constraint.
	 *
	 * @return the computed next {@link Position}
	 */
	private Position calculateNextPosition() {
		int x = position.getX();
		int y = position.getY();

		switch (orientation) {
		case N -> y++;
		case E -> x++;
		case S -> y--;
		case W -> x--;
		}

		return new Position(x, y);
	}

	/**
	 * Checks whether a given position is inside the lawn limits.
	 *
	 * @param p       the position to validate
	 * @param pelouse the lawn defining the allowed coordinate range
	 * @return {@code true} if the position is inside the lawn, otherwise
	 *         {@code false}
	 */
	private boolean isInsidePelouse(final Position p, final Pelouse pelouse) {
		return p.getX() >= 0 && p.getX() <= pelouse.getMaxX() && p.getY() >= 0 && p.getY() <= pelouse.getMaxY();
	}

}
